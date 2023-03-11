package com.kameleoon.trial_task.controller;

import com.kameleoon.trial_task.entity.Quote;
import com.kameleoon.trial_task.service.quote.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class QuoteRESTController {
    @Autowired
    private QuoteService quoteService;

    @GetMapping("/quotes")
    public List<Quote> getAllQuotes() {
        return quoteService.getAllQuotes();
    }

    @GetMapping("/quotes/{id}")
    public Quote getQuoteById(@PathVariable long id) {
        return quoteService.getQuote(id);
    }

    @GetMapping("/quotes/random")
    public Quote getRandomQuote() {
        return quoteService.getRandomQuote();
    }

    @GetMapping("/quotes/top10")
    public List<Quote> getTop10Quotes() {
        return quoteService.getTop10Quotes();
    }

    @GetMapping("/quotes/worse10")
    public List<Quote> getWorse10Quotes() {
        return quoteService.getWorse10Quotes();
    }

    @PostMapping("/quotes/{userId}")
    public Quote createQuote(@RequestBody Quote quote, @PathVariable long userId) {
        quoteService.saveQuote(quote, userId);

        return quote;
    }

    @PatchMapping("/quotes/{id}")
    public Quote updateQuote(@RequestBody Quote quote, @PathVariable long id) {
        return quoteService.updateQuote(quote, id);
    }

    @DeleteMapping("/quotes/{id}")
    public void deleteQuoteById(@PathVariable long id) {
        quoteService.deleteQuote(id);
    }

    @GetMapping("/quotes/upvote{id}")
    public Quote upvoteQuoteById(@PathVariable long id) {
        return quoteService.upvoteOrDownvoteQuoteById(id, 1);
    }

    @GetMapping("/quotes/downvote{id}")
    public Quote downvoteQuoteById(@PathVariable long id) {
        return quoteService.upvoteOrDownvoteQuoteById(id, -1);
    }
}
