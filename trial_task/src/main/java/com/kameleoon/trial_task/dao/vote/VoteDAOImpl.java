package com.kameleoon.trial_task.dao.vote;

import com.kameleoon.trial_task.entity.Vote;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class VoteDAOImpl implements VoteDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Vote getVote(long id) {
        Session session = entityManager.unwrap(Session.class);

        return session.get(Vote.class, id);
    }

    @Override
    public void saveVote(Vote vote) {
        Session session = entityManager.unwrap(Session.class);

        session.saveOrUpdate(vote);
    }
}
