package com.kodilla.testing.forum.tdd;

import com.kodilla.testing.forum.ForumComment;
import com.kodilla.testing.forum.ForumPost;
import com.kodilla.testing.forum.ForumUser;
import org.junit.jupiter.api.*;


@DisplayName("TDD: Forum test suite")
public class ForumTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Nested
    @DisplayName("Tests for posts")
    class TestPosts {

        @DisplayName("Getting a post by index should return the same post that was added")
        @Test
        void testGetPost() {
            // Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost forumPost = new ForumPost("Hello everyone, this is my first contribution here!", "mrsmith");
            forumUser.addPost("Hello everyone, this is my first contribution here!", "mrsmith");

            // When
            ForumPost retrievedPost = forumUser.getPost(0);

            // Then
            Assertions.assertEquals(forumPost, retrievedPost);
        }

        @DisplayName("After adding a post, the number of posts of a given user should be equal to 1")
        @Test
        void testAddPost() {
            // Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");

            // When
            forumUser.addPost("Hello everyone, this is my first contribution here!", "mrsmith");

            // Then
            Assertions.assertEquals(1, forumUser.getPostsQuantity());
        }

        @DisplayName("Removal of an existing post should return true and the number of posts of a given user should be equal to 0")
        @Test
        void testRemovePost() {
            // Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost forumPost = new ForumPost("Hello everyone, this is my first contribution here!", "mrsmith");
            forumUser.addPost(forumPost.getPostBody(), forumPost.getAuthor());

            // When
            boolean result = forumUser.removePost(forumPost);

            // Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, forumUser.getPostsQuantity());
        }
    }

    @Nested
    @DisplayName("Tests for comments")
    class TestComments {

        @DisplayName("After adding a comment, the number of comments of a given user should be equal to 1")
        @Test
        void testAddComment() {
            // Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost forumPost = new ForumPost("Hello everyone, this is my first contribution here!", "mrsmith");

            // When
            forumUser.addComment(forumPost, "mrsmith", "Thank you for all the warm welcome!");

            // Then
            Assertions.assertEquals(1, forumUser.getCommentsQuantity());
        }


        @DisplayName("Getting a comment by index should return the same comment that was added")
        @Test
        void testGetComment() {
            // Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost forumPost = new ForumPost("Hello everyone, this is my first contribution here!", "mrsmith");
            ForumComment forumComment = new ForumComment(forumPost, "Thank you for all the warm welcome!", "mrsmith");
            forumUser.addComment(forumPost, forumComment.getAuthor(), forumComment.getCommentBody());

            // When
            ForumComment retrievedComment = forumUser.getComment(0);

            // Then
            Assertions.assertEquals(forumComment, retrievedComment);
        }

        @DisplayName("An attempt to remove a non-existing comment should return false")
        @Test
        void testRemoveCommentNonExisting() {
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost forumPost = new ForumPost("Hello everyone, this is my first contribution here!", "mrsmith");
            ForumComment forumComment = new ForumComment(forumPost, "Thank you for all the warm welcome!", "mrsmith");

            //When
            boolean result = forumUser.removeComment(forumComment);

            //Then
            Assertions.assertFalse(result);
        }

        @DisplayName("Removal of an existing comment should return true and the number of comments of a given user should be equal to 0")
        @Test
        void testRemoveComment() {
            // Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost forumPost = new ForumPost("Hello everyone, this is my first contribution here!", "mrsmith");
            ForumComment forumComment = new ForumComment(forumPost, "Thank you for all the warm welcome!", "mrsmith");
            forumUser.addComment(forumPost, forumComment.getAuthor(), forumComment.getCommentBody());

            // When
            boolean result = forumUser.removeComment(forumComment);

            // Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, forumUser.getCommentsQuantity());
        }
    }

}
