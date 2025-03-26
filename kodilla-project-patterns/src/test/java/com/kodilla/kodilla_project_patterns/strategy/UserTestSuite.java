package com.kodilla.kodilla_project_patterns.strategy;

import com.kodilla.kodilla_project_patterns.strategy.social.Millenials;
import com.kodilla.kodilla_project_patterns.strategy.social.User;
import com.kodilla.kodilla_project_patterns.strategy.social.YGeneration;
import com.kodilla.kodilla_project_patterns.strategy.social.ZGeneration;
import com.kodilla.kodilla_project_patterns.strategy.social.publishers.SnapchatPublisher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {
        //Given
        User millenial = new Millenials("John");
        User yGeneration = new YGeneration("Susy");
        User zGeneration = new ZGeneration("Mikey");

        //When
        String postByMillenialUser = millenial.publish();
        String postByYGenerationUser = yGeneration.publish();
        String postByZGenerationUser = zGeneration.publish();

        //Then
        assertEquals("Publishing on Facebook", postByMillenialUser);
        assertEquals("Publishing on Twitter", postByYGenerationUser);
        assertEquals("Publishing on Snapchat", postByZGenerationUser);
    }

    @Test
    void testIndividualSharingStrategies() {
        //Given
        User individualUser = new Millenials("Pete");

        //When
        String individualUserPostBeforeChangingPublisher = individualUser.publish();
        individualUser.setSocialPublisher(new SnapchatPublisher());
        String individualUserPostAfterChangingPublisher = individualUser.publish();

        //Then
        assertEquals("Publishing on Facebook", individualUserPostBeforeChangingPublisher);
        assertEquals("Publishing on Snapchat", individualUserPostAfterChangingPublisher);
    }
}
