package com.kodilla.kodilla_project_patterns.strategy.social;

import com.kodilla.kodilla_project_patterns.strategy.social.publishers.TwitterPublisher;

public final class YGeneration extends User {

    public YGeneration(String name) {
        super(name);
        setSocialPublisher(new TwitterPublisher());
    }
}
