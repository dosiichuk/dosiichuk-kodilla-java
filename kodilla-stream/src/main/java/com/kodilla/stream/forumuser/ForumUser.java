package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    private final int id;
    private final String username;
    private final char gender;
    private final LocalDate dateOfBirth;
    private final int numPosts;

    public ForumUser(final int id, final String username, final char gender, final LocalDate dateOfBirth, final int numPosts) {
        this.id = id;
        this.username = username;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.numPosts = numPosts;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public char getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getNumPosts() {
        return numPosts;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", gender=" + gender +
                ", dateOfBirth=" + dateOfBirth +
                ", numPosts=" + numPosts +
                '}';
    }
}
