package com.practice.backend.repositories;

import com.practice.backend.models.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    @Query("SELECT COUNT(ui) FROM UserInfo ui WHERE ui.username = :username")
    Long findByUsername(@Param("username") String username);

    boolean existsByUsername(@Param("username") String username);

    @Query("SELECT u FROM UserInfo u WHERE u.username = :username AND u.password = :password")
    UserInfo findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
