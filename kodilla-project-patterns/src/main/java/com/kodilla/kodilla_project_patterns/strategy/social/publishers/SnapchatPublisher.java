package com.kodilla.kodilla_project_patterns.strategy.social.publishers;

public final class SnapchatPublisher implements SocialPublisher {

    @Override
    public String publish() {
        return "Publishing on Snapchat";
    }
}
