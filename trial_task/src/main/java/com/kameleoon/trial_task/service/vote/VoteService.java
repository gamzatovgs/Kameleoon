package com.kameleoon.trial_task.service.vote;

import com.kameleoon.trial_task.entity.Vote;

import java.util.List;

public interface VoteService {
    public Vote getVote(long id);

    public void saveVote(Vote vote);
}
