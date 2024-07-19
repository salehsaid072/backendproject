package com.backend.UniversityVotingSystem.SERVICES;

import com.backend.UniversityVotingSystem.MODEL.Vote;
import com.backend.UniversityVotingSystem.REPOSITORY.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;

    public List<Vote> getAllVotes() {
        return voteRepository.findAll();
    }

    public Optional<Vote> getVoteById(Long id) {
        return voteRepository.findById(id);
    }

    public Vote createVote(Vote vote) {
        return voteRepository.save(vote);
    }

    public Optional<Vote> updateVote(Long id, Vote voteDetails) {
        return voteRepository.findById(id).map(vote -> {
            vote.setUser(voteDetails.getUser());
            vote.setCandidate(voteDetails.getCandidate());
            return voteRepository.save(vote);
        });
    }

    public boolean deleteVote(Long id) {
        return voteRepository.findById(id).map(vote -> {
            voteRepository.delete(vote);
            return true;
        }).orElse(false);
    }
}
