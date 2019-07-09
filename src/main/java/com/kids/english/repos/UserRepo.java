package com.kids.english.repos;

/*
 * created by ellen
 * created on 04.05.2019
 * class created for project english
 */

import com.kids.english.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
       User findByUsername(String username);
       User findByActivationCode(String code);
}

