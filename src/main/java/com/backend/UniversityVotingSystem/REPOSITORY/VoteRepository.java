package com.backend.UniversityVotingSystem.REPOSITORY;

import com.backend.UniversityVotingSystem.MODEL.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Long> {
}

