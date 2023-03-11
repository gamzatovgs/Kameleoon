package com.kameleoon.trial_task.dao.user;

import com.kameleoon.trial_task.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        Session session = entityManager.unwrap(Session.class);

        Query<User> query = session.createQuery("from User", User.class);

        return query.getResultList();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        Session session = entityManager.unwrap(Session.class);

        user.setDate(new Timestamp(new Date().getTime()));
        session.saveOrUpdate(user);
    }
}
