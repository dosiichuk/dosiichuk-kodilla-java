package com.kodilla.kodilla_project_patterns.strategy.social.publishers;

public sealed interface SocialPublisher permits FacebookPublisher, TwitterPublisher, SnapchatPublisher {

    public String publish();
}
