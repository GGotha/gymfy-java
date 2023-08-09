package com.gotha.gymfy.repository;

import com.gotha.gymfy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, String> {

    @Query("from User u where u.email=:email")
    User findUserByEmail(@Param("email") String email);
}
