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
}
