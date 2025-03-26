package com.kodilla.kodilla_project_patterns.strategy.social.publishers;

public final class FacebookPublisher implements SocialPublisher{

    @Override
    public String publish() {
        return "Publishing on Facebook";
    }
}
