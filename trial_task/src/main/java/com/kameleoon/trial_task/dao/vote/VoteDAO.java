package com.kameleoon.trial_task.dao.vote;

import com.kameleoon.trial_task.entity.Vote;

public interface VoteDAO {
    public Vote getVote(long id);

    public void saveVote(Vote vote);
}
