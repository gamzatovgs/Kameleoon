package com.kameleoon.trial_task.service.vote;

import com.kameleoon.trial_task.dao.vote.VoteDAO;
import com.kameleoon.trial_task.entity.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteServiceImpl implements VoteService {
    @Autowired
    private VoteDAO voteDAO;

    @Override
    public Vote getVote(long id) {
        return voteDAO.getVote(id);
    }

    @Override
    public void saveVote(Vote vote) {
        voteDAO.saveVote(vote);
    }
}
