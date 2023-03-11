package com.kameleoon.trial_task.service.quote;

import com.kameleoon.trial_task.entity.Quote;

import java.util.List;

public interface QuoteService {
    public List<Quote> getAllQuotes();

    public Quote getQuote(long id);

    public Quote getRandomQuote();

    public List<Quote> getTop10Quotes();

    public List<Quote> getWorse10Quotes();

    public void saveQuote(Quote quote, long userId);

    public Quote updateQuote(Quote quote, long id);

    public void deleteQuote(long id);

    public Quote upvoteOrDownvoteQuoteById(long id, int vote);
}
