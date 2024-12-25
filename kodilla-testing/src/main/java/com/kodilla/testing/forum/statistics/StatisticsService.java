package com.kodilla.testing.forum.statistics;

import java.util.List;

public class StatisticsService {

    private Statistics statistics;
    private int numUsers;
    private int numPosts;
    private int numComments;
    private double avgNumPostsPerUser;
    private double avgNumCommentsPerUser;
    private double avgNumCommentsPerPost;

    public StatisticsService(Statistics statistics) {
        this.statistics = statistics;
    }

    public void calculateAvgStatistics() {
        List<String> usersNames = statistics.usersNames();
        numUsers = usersNames.size();
        numPosts = statistics.postsCount();
        numComments = statistics.commentsCount();
        avgNumPostsPerUser = numUsers == 0 ? 0 : (double) numPosts / numUsers;
        avgNumCommentsPerUser = numComments == 0 ? 0 : (double) numComments / numUsers;
        avgNumCommentsPerPost = numPosts == 0 ? 0 : (double) numComments / numPosts;
    }

    public void showStatistics() {
        System.out.println("Number of users: " + numUsers);
        System.out.println("Number of posts: " + numPosts);
        System.out.println("Number of comments: " + numComments);
        System.out.println("Average number of posts per user: " + avgNumPostsPerUser);
        System.out.println("Average number of comments per user: " + avgNumCommentsPerUser);
        System.out.println("Average number of comments per post: " + avgNumCommentsPerPost);
    }

    public int getNumUsers() {
        return numUsers;
    }

    public int getNumPosts() {
        return numPosts;
    }

    public int getNumComments() {
        return numComments;
    }

    public double getAvgNumPostsPerUser() {
        return avgNumPostsPerUser;
    }

    public double getAvgNumCommentsPerUser() {
        return avgNumCommentsPerUser;
    }

    public double getAvgNumCommentsPerPost() {
        return avgNumCommentsPerPost;
    }
}
