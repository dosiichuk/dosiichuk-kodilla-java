package com.kodilla.kodilla_project_patterns.strategy.social;

import com.kodilla.kodilla_project_patterns.strategy.social.publishers.FacebookPublisher;

public final class Millenials extends User {

    public Millenials(String name) {
        super(name);
        setSocialPublisher(new FacebookPublisher());
    }
}
