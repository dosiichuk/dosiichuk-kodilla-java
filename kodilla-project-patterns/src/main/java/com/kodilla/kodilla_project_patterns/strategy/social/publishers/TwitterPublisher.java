package com.kodilla.kodilla_project_patterns.strategy.social.publishers;

public final class TwitterPublisher implements SocialPublisher {

    @Override
    public String publish() {
        return "Publishing on Twitter";
    }
}
