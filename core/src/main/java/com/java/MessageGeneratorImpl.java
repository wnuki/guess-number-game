package com.java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class MessageGeneratorImpl implements MessageGenerator {

    private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    @Autowired
    private Game game;
    private int guessCount = 10;

    @PostConstruct
    public void getValue() {
        log.info("Game = {}", game);
    }

    @Override
    public String getMainMessage() {
        return "Main message";
    }

    @Override
    public String getResultMessage() {
        return "Result message";
    }
}
