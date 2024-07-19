package com.backend.UniversityVotingSystem.SERVICES;

import com.backend.UniversityVotingSystem.MODEL.*;
import com.backend.UniversityVotingSystem.REPOSITORY.*;
import com.backend.UniversityVotingSystem.CONTROLLER.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    public Optional<Candidate> getCandidateById(Long id) {
        return candidateRepository.findById(id);
    }

    public Candidate createCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    public Optional<Candidate> updateCandidate(Long id, Candidate candidateDetails) {
        return candidateRepository.findById(id).map(candidate -> {
            candidate.setFullName(candidateDetails.getFullName());
            candidate.setRegistrationNumber(candidateDetails.getRegistrationNumber());
            candidate.setCourse(candidateDetails.getCourse());
            candidate.setYearOfStudy(candidateDetails.getYearOfStudy());
            candidate.setPosition(candidateDetails.getPosition());
            candidate.setReason(candidateDetails.getReason());
            return candidateRepository.save(candidate);
        });
    }

    public boolean deleteCandidate(Long id) {
        return candidateRepository.findById(id).map(candidate -> {
            candidateRepository.delete(candidate);
            return true;
        }).orElse(false);
    }
}
