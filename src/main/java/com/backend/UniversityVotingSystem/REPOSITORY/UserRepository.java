package com.backend.UniversityVotingSystem.REPOSITORY;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.UniversityVotingSystem.MODEL.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

