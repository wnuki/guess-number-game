package com.java;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@AllArgsConstructor
@Component
public class MessageGeneratorImpl implements MessageGenerator {

    private final Game game;

    @PostConstruct
    public void init() {
        log.info("Game = {}", game);
    }

    @Override
    public String getMainMessage() {
        return "Number is between " +
                game.getSmallest() +
                " and " +
                game.getBiggest() +
                ". Can you guess it?";
    }

    @Override
    public String getResultMessage() {
        if (game.isGameWon()) {
            return "You guessed it! The number was " + game.getNumber();
        } else if (game.isGameLost()) {
            return "You lost. The number was " + game.getNumber();
        } else if (!game.isValidNumberRange()) {
            return "Invalid number range!";
        } else if (game.getRemainingGuesses() == game.getGuessCount()) {
            return "What is your first guess?";
        } else {
            String direction = "Lower";
            if (game.getGuess() < game.getNumber()) {
                direction = "Higher";
            }
            String guess = game.getRemainingGuesses() == 1 ? "guess" : "guesses";

            return direction + "! You have " + game.getRemainingGuesses() +
                    " " + guess + " left";
        }
    }
}
