INSERT INTO POSTS (USER_ID, BODY) VALUES
(1, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.'),
(2, 'Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.'),
(3, 'Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.');

UPDATE POSTS SET BODY = 'To delete' WHERE ID = 5;

DELETE FROM POSTS WHERE ID = 5;

SELECT COUNT(*) AS POST_COUNT, USERS.FIRSTNAME, USERS.LASTNAME FROM POSTS
JOIN USERS ON POSTS.USER_ID = USERS.ID 
GROUP BY USER_ID HAVING POST_COUNT > 1;
