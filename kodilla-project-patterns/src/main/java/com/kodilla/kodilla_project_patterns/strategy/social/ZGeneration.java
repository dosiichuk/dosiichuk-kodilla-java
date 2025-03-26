package com.kodilla.kodilla_project_patterns.strategy.social;

import com.kodilla.kodilla_project_patterns.strategy.social.publishers.SnapchatPublisher;

public final class ZGeneration extends User {

    public ZGeneration(String name) {
        super(name);
        setSocialPublisher(new SnapchatPublisher());
    }
}
