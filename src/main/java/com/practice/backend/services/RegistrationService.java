package com.practice.backend.services;

import com.practice.backend.models.UserInfo;
import com.practice.backend.models.requestEntities.RegistrationRequest;
import com.practice.backend.models.responseEntities.RegistrationResponse;
import com.practice.backend.repositories.UserInfoRepository;
import com.practice.backend.repositories.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class RegistrationService {

    private final TokenRepository tokenRepository;
    private final UserInfoRepository userInfoRepository;

    private final JwtTokenProviderService jwtTokenProviderService;

    private final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]+$";
    private final String PHONE_NUMBER_PATTERN = "^\\+\\d{11}$";

    @Autowired
    public RegistrationService(TokenRepository tokenRepository, UserInfoRepository userInfoRepository, JwtTokenProviderService jwtTokenProviderService) {
        this.tokenRepository = tokenRepository;
        this.userInfoRepository = userInfoRepository;
        this.jwtTokenProviderService = jwtTokenProviderService;
    }

    public RegistrationResponse userRegistration(RegistrationRequest request) {

        if (userInfoRepository.existsByUsername(request.getUsername())) {
            if (emailValidation(request.getEmail())) {
                if (phoneNumberValidator(request.getPhoneNumber())) {
                    UserInfo userInfo = new UserInfo();
                    userInfo.setUsername(request.getUsername());
                    userInfo.setPassword(request.getPassword());
                    userInfo.setEmail(request.getEmail());
                    userInfo.setFirstName(request.getFirstName());
                    userInfo.setSecondName(request.getSecondName());
                    userInfo.setPhoneNumber(request.getPhoneNumber());

                    userInfoRepository.save(userInfo);

                    return new RegistrationResponse(true, "It was perfect", jwtTokenProviderService.generateToken(userInfo.getUsername()));
                } else {
                    return new RegistrationResponse(false, "The phone number is incorrect.");
                }
            } else {
                return new RegistrationResponse(false, "The email is incorrect.");
            }
        }
        return new RegistrationResponse(false, "User exists.");
    }

    private boolean emailValidation(String email) {
        return Pattern.compile(EMAIL_PATTERN).matcher(email).matches();
    }

    private boolean phoneNumberValidator(String phoneNumber) {
        return Pattern.compile(PHONE_NUMBER_PATTERN).matcher(phoneNumber).matches();
    }
}
