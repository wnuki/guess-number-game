package com.java.console;

import com.java.AppConfig;
import com.java.MessageGenerator;
import com.java.NumberGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Guess the number game");

        ConfigurableApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);

        NumberGenerator numberGenerator
                = context.getBean(NumberGenerator.class);

        MessageGenerator messageGenerator
                = context.getBean(MessageGenerator.class);

        log.info("getMainMessage = {}", messageGenerator.getMainMessage());
        log.info("getResultMessage = {}", messageGenerator.getResultMessage());

        int number = numberGenerator.next();
        log.info("number: {}", number);

        context.close();
    }
}
