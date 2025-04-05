package com.kodilla.kodilla_hibernate.tasklists.dao;

import com.kodilla.kodilla_hibernate.tasklist.TaskList;
import com.kodilla.kodilla_hibernate.tasklist.dao.TaskListDao;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskListsDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;

    private static final String TASK_LIST_NAME = "List 1";
    private static final String TASK_LIST_DESCRIPTION = "List description";

    @Test
    void testFindTaskListsByName() {
        //Given
        TaskList taskList = new TaskList(TASK_LIST_NAME, TASK_LIST_DESCRIPTION);

        //When
        taskListDao.save(taskList);
        String taskListName = taskList.getListName();
        int taskListId = taskList.getId();
        List<TaskList> taskListList = taskListDao.findByListName(taskListName);

        //Then
        assertEquals(1, taskListList.size());
        assertEquals(taskListList.get(0).getListName(), taskListName);

        taskListDao.deleteById(taskListId);

    }

}
