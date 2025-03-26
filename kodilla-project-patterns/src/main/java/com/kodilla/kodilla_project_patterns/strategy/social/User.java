package com.kodilla.kodilla_project_patterns.strategy.social;

import com.kodilla.kodilla_project_patterns.strategy.social.publishers.SocialPublisher;

public sealed class User permits Millenials, YGeneration, ZGeneration {

    private final String name;
    protected SocialPublisher socialPublisher;

    public User(String name) {
        this.name = name;
    }

    public String publish() {
        return socialPublisher.publish();
    }

    public String getName() {
        return name;
    }

    public void setSocialPublisher(SocialPublisher socialPublisher) {
        this.socialPublisher = socialPublisher;
    }
}
