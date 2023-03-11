package com.kameleoon.trial_task.service.quote;

import com.kameleoon.trial_task.dao.quote.QuoteDAO;
import com.kameleoon.trial_task.entity.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteServiceImpl implements QuoteService {
    @Autowired
    private QuoteDAO quoteDAO;

    @Override
    public List<Quote> getAllQuotes() {
        return quoteDAO.getAllQuotes();
    }

    @Override
    public Quote getQuote(long id) {
        return quoteDAO.getQuote(id);
    }

    @Override
    public Quote getRandomQuote() {
        return quoteDAO.getRandomQuote();
    }

    @Override
    public List<Quote> getTop10Quotes() {
        return quoteDAO.getTop10Quotes();
    }

    @Override
    public List<Quote> getWorse10Quotes() {
        return quoteDAO.getWorse10Quotes();
    }

    @Override
    public void saveQuote(Quote quote, long userId) {
        quoteDAO.saveQuote(quote, userId);
    }

    @Override
    public Quote updateQuote(Quote quote, long id) {
        return quoteDAO.updateQuote(quote, id);
    }

    @Override
    public void deleteQuote(long id) {
        quoteDAO.deleteQuote(id);
    }

    @Override
    public Quote upvoteOrDownvoteQuoteById(long id, int vote) {
        return quoteDAO.upvoteOrDownvoteQuoteById(id, vote);
    }
}
