package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StatisticsServiceTestSuite {

    @Mock
    private Statistics statisticsMock;
    private StatisticsService statisticsService;

    @Nested
    @DisplayName("Testing calculateAvgStatistics() method of the StatisticsService class")
    class testCalculateAvgStatistics {
        private List<String> usersNamesWith100Users;
        private List<String> usersNamesWithZeroUsers;
        private static final int NUM_POSTS_120 = 120;
        private static final int NUM_POSTS_40 = 40;
        private static final int NUM_POSTS_1000 = 1000;
        private static final int NUM_COMMENTS_60 = 60;
        private static final int NUM_USERS_100 = 100;
        private static final double POSTS_PER_USER_100_120 = 1.20;
        private static final double POSTS_PER_USER_100_1000 = 10.0;
        private static final double POSTS_PER_USER_100_40 = 0.40;
        private static final double COMMENTS_PER_USER_100_60 = 0.60;
        private static final double COMMENTS_PER_POST_60_120 = 0.50;
        private static final double COMMENTS_PER_POST_60_40 = 1.50;
        private static final double COMMENTS_PER_POST_60_1000 = 0.060;

        @BeforeEach
        void beforeEach() {
            statisticsService = new StatisticsService(statisticsMock);
            usersNamesWithZeroUsers = new ArrayList<>();
            usersNamesWith100Users = new ArrayList<>();
            for (int i=0; i<100; i++) {
                String userName = "User" + i;
                usersNamesWith100Users.add(userName);
            }
        }

        @Test
        void testCalculateAvgStatisticsWithZeroPosts() {
            //Given
            when(statisticsMock.postsCount()).thenReturn(0);
            when(statisticsMock.commentsCount()).thenReturn(0);
            when(statisticsMock.usersNames()).thenReturn(usersNamesWith100Users);

            //When
            statisticsService.calculateAvgStatistics();

            //Then
            assertEquals(0, statisticsService.getNumPosts());
            assertEquals(0, statisticsService.getNumComments());
            assertEquals(NUM_USERS_100, statisticsService.getNumUsers());
            assertEquals(0, statisticsService.getAvgNumPostsPerUser());
            assertEquals(0, statisticsService.getAvgNumCommentsPerUser());
            assertEquals(0, statisticsService.getAvgNumCommentsPerPost());
        }

        @Test
        void testCalculateAvgStatisticsWith1000Posts() {
            //Given
            when(statisticsMock.postsCount()).thenReturn(NUM_POSTS_1000);
            when(statisticsMock.commentsCount()).thenReturn(0);
            when(statisticsMock.usersNames()).thenReturn(usersNamesWith100Users);

            //When
            statisticsService.calculateAvgStatistics();

            //Then
            assertEquals(NUM_POSTS_1000, statisticsService.getNumPosts());
            assertEquals(0, statisticsService.getNumComments());
            assertEquals(NUM_USERS_100, statisticsService.getNumUsers());
            assertEquals(POSTS_PER_USER_100_1000, statisticsService.getAvgNumPostsPerUser());
            assertEquals(0, statisticsService.getAvgNumCommentsPerUser());
            assertEquals(0, statisticsService.getAvgNumCommentsPerPost());
        }

        @Test
        void testCalculateAvgStatisticsWithZeroComments() {
            //Given
            when(statisticsMock.postsCount()).thenReturn(NUM_POSTS_120);
            when(statisticsMock.commentsCount()).thenReturn(0);
            when(statisticsMock.usersNames()).thenReturn(usersNamesWith100Users);

            //When
            statisticsService.calculateAvgStatistics();

            //Then
            assertEquals(NUM_POSTS_120, statisticsService.getNumPosts());
            assertEquals(0, statisticsService.getNumComments());
            assertEquals(NUM_USERS_100, statisticsService.getNumUsers());
            assertEquals(POSTS_PER_USER_100_120, statisticsService.getAvgNumPostsPerUser());
            assertEquals(0, statisticsService.getAvgNumCommentsPerUser());
            assertEquals(0, statisticsService.getAvgNumCommentsPerPost());
        }

        @Test
        void testCalculateAvgStatisticsWithNumCommentsLowerThanNumPosts() {
            //Given
            when(statisticsMock.postsCount()).thenReturn(NUM_POSTS_120);
            when(statisticsMock.commentsCount()).thenReturn(NUM_COMMENTS_60);
            when(statisticsMock.usersNames()).thenReturn(usersNamesWith100Users);

            //When
            statisticsService.calculateAvgStatistics();

            //Then
            assertEquals(NUM_POSTS_120, statisticsService.getNumPosts());
            assertEquals(NUM_COMMENTS_60, statisticsService.getNumComments());
            assertEquals(NUM_USERS_100, statisticsService.getNumUsers());
            assertEquals(POSTS_PER_USER_100_120, statisticsService.getAvgNumPostsPerUser());
            assertEquals(COMMENTS_PER_USER_100_60, statisticsService.getAvgNumCommentsPerUser());
            assertEquals(COMMENTS_PER_POST_60_120, statisticsService.getAvgNumCommentsPerPost());
        }

        @Test
        void testCalculateAvgStatisticsWithNumCommentsHigherThanNumPosts() {
            //Given
            when(statisticsMock.postsCount()).thenReturn(NUM_POSTS_40);
            when(statisticsMock.commentsCount()).thenReturn(NUM_COMMENTS_60);
            when(statisticsMock.usersNames()).thenReturn(usersNamesWith100Users);

            //When
            statisticsService.calculateAvgStatistics();

            //Then
            assertEquals(NUM_POSTS_40, statisticsService.getNumPosts());
            assertEquals(NUM_COMMENTS_60, statisticsService.getNumComments());
            assertEquals(NUM_USERS_100, statisticsService.getNumUsers());
            assertEquals(POSTS_PER_USER_100_40, statisticsService.getAvgNumPostsPerUser());
            assertEquals(COMMENTS_PER_USER_100_60, statisticsService.getAvgNumCommentsPerUser());
            assertEquals(COMMENTS_PER_POST_60_40, statisticsService.getAvgNumCommentsPerPost());
        }

        @Test
        void testCalculateAvgStatisticsWithNumUsersEqualToZero() {
            //Given
            when(statisticsMock.postsCount()).thenReturn(0);
            when(statisticsMock.commentsCount()).thenReturn(0);
            when(statisticsMock.usersNames()).thenReturn(usersNamesWithZeroUsers);

            //When
            statisticsService.calculateAvgStatistics();

            //Then
            assertEquals(0, statisticsService.getNumPosts());
            assertEquals(0, statisticsService.getNumComments());
            assertEquals(0, statisticsService.getNumUsers());
            assertEquals(0, statisticsService.getAvgNumPostsPerUser());
            assertEquals(0, statisticsService.getAvgNumCommentsPerUser());
            assertEquals(0, statisticsService.getAvgNumCommentsPerPost());
        }

        @Test
        void testCalculateAvgStatisticsWithNumUsersEqualTo100() {
            //Given
            when(statisticsMock.postsCount()).thenReturn(NUM_POSTS_1000);
            when(statisticsMock.commentsCount()).thenReturn(NUM_COMMENTS_60);
            when(statisticsMock.usersNames()).thenReturn(usersNamesWith100Users);

            //When
            statisticsService.calculateAvgStatistics();

            //Then
            assertEquals(NUM_POSTS_1000, statisticsService.getNumPosts());
            assertEquals(NUM_COMMENTS_60, statisticsService.getNumComments());
            assertEquals(NUM_USERS_100, statisticsService.getNumUsers());
            assertEquals(POSTS_PER_USER_100_1000, statisticsService.getAvgNumPostsPerUser());
            assertEquals(COMMENTS_PER_USER_100_60, statisticsService.getAvgNumCommentsPerUser());
            assertEquals(COMMENTS_PER_POST_60_1000, statisticsService.getAvgNumCommentsPerPost());
        }
    }
}
