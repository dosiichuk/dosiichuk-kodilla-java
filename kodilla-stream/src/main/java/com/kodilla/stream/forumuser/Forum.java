package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {

    public final static List<ForumUser> getForumUsers() {
        final List<ForumUser> theListofForumUsers = new ArrayList<>();
        theListofForumUsers.add(new ForumUser(1, "User1", 'M', LocalDate.of(2000, 1, 1), 0));
        theListofForumUsers.add(new ForumUser(2, "User2", 'F', LocalDate.of(1998, 2, 2), 0));
        theListofForumUsers.add(new ForumUser(3, "User3", 'M', LocalDate.of(2005, 3, 3), 30));
        theListofForumUsers.add(new ForumUser(4, "User4", 'F', LocalDate.of(2003, 4, 4), 40));
        theListofForumUsers.add(new ForumUser(5, "User5", 'M', LocalDate.of(2001, 5, 5), 50));
        theListofForumUsers.add(new ForumUser(6, "User6", 'F', LocalDate.of(1999, 6, 6), 60));
        theListofForumUsers.add(new ForumUser(7, "User7", 'M', LocalDate.of(2004, 7, 7), 70));
        theListofForumUsers.add(new ForumUser(8, "User8", 'F', LocalDate.of(2002, 8, 8), 80));
        theListofForumUsers.add(new ForumUser(9, "User9", 'M', LocalDate.of(2006, 9, 9), 90));
        theListofForumUsers.add(new ForumUser(10, "User10", 'F', LocalDate.of(1997, 10, 10), 100));
        return new ArrayList<>(theListofForumUsers);
    }
}
