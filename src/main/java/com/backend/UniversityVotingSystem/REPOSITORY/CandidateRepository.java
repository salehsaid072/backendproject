package com.backend.UniversityVotingSystem.REPOSITORY;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.UniversityVotingSystem.MODEL.*;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}

