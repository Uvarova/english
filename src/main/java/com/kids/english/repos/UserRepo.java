package com.kids.english.repos;

import com.kids.english.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
        User findByUsername(String username);
}

