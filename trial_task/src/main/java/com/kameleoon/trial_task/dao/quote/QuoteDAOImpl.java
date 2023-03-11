package com.kameleoon.trial_task.dao.quote;

import com.kameleoon.trial_task.entity.Quote;
import com.kameleoon.trial_task.entity.User;
import com.kameleoon.trial_task.entity.Vote;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Repository
public class QuoteDAOImpl implements QuoteDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Quote> getAllQuotes() {
        Session session = entityManager.unwrap(Session.class);

        Query<Quote> query = session.createQuery("from Quote", Quote.class);

        return query.getResultList();
    }

    @Override
    public Quote getQuote(long id) {
        Session session = entityManager.unwrap(Session.class);

        return session.get(Quote.class, id);
    }

    @Override
    public Quote getRandomQuote() {
        Session session = entityManager.unwrap(Session.class);

        long count = (long) session.createQuery("select count(q) from Quote q").getSingleResult();
        if (count == 0) return null;
        Random random = new Random();
        long bits, val, id;
        Quote quote = null;

        do {
            bits = (random.nextLong() << 1) >>> 1;
            val = bits % count;
            id = val + 1;
        } while ((bits-val+(count-1) < 0L) || ((quote = session.get(Quote.class, id)) == null));

        return quote;
    }

    @Override
    public List<Quote> getTop10Quotes() {
        Session session = entityManager.unwrap(Session.class);

        Query<Quote> query = session.createQuery("from Quote q order by q.vote.score desc");
        query.setMaxResults(10);

        return query.getResultList();
    }

    @Override
    public List<Quote> getWorse10Quotes() {
        Session session = entityManager.unwrap(Session.class);

        Query<Quote> query = session.createQuery("from Quote q order by q.vote.score asc");
        query.setMaxResults(10);

        return query.getResultList();
    }

    @Override
    @Transactional
    public void saveQuote(Quote quote, long userId) {
        Session session = entityManager.unwrap(Session.class);

        Timestamp date = new Timestamp(new Date().getTime());
        Vote vote = new Vote();
        vote.setScore(0);
        vote.setGraph("0=" + date);
        quote.setDate(date);
        quote.setVote(vote);
        session.get(User.class, userId).addQuoteToUser(quote);
        session.saveOrUpdate(quote);
    }

    @Override
    @Transactional
    public Quote updateQuote(Quote quote, long id) {
        Session session = entityManager.unwrap(Session.class);

        Quote updatedQoute = session.get(Quote.class, id);
        updatedQoute.setContent(quote.getContent());
        updatedQoute.setDate(new Timestamp(new Date().getTime()));
        session.saveOrUpdate(updatedQoute);

        return updatedQoute;
    }

    @Override
    @Transactional
    public void deleteQuote(long id) {
        Session session = entityManager.unwrap(Session.class);

        Query<Quote> query = session.createQuery("delete from Quote q where q.id =: quoteId");
        query.setParameter("quoteId", id);
        query.executeUpdate();
    }

    @Override
    @Transactional
    public Quote upvoteOrDownvoteQuoteById(long id, int vote) {
        Session session = entityManager.unwrap(Session.class);

        Quote quote = session.get(Quote.class, id);
        long newScore = quote.getVote().getScore() + vote;
        quote.getVote().setScore(newScore);

        StringBuilder stringBuilder = new StringBuilder();
        String newGraph = stringBuilder
                .append(quote.getVote().getGraph())
                .append(";")
                .append(newScore)
                .append("=")
                .append(new Timestamp(new Date().getTime()))
                .toString();
        quote.getVote().setGraph(newGraph);

        session.saveOrUpdate(quote);

        return quote;
    }
}
