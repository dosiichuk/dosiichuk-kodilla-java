package com.kodilla.kodilla_hibernate.tasklists.dao;

import com.kodilla.kodilla_hibernate.task.Task;
import com.kodilla.kodilla_hibernate.task.TaskFinancialDetails;
import com.kodilla.kodilla_hibernate.tasklist.TaskList;
import com.kodilla.kodilla_hibernate.tasklist.dao.TaskListDao;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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

    @Test
    void testTaskListDaoSaveWithTasks() {
        //Given
        Task task = new Task("Test: Learn Hibernate", 14);
        Task task2 = new Task("Test: Write some entities", 3);
        TaskFinancialDetails tfd = new TaskFinancialDetails(new BigDecimal(20), false);
        TaskFinancialDetails tfd2 = new TaskFinancialDetails(new BigDecimal(10), false);
        task.setTaskFinancialDetails(tfd);
        task2.setTaskFinancialDetails(tfd2);
        TaskList taskList = new TaskList(TASK_LIST_NAME, "ToDo tasks");
        taskList.getTasks().add(task);
        taskList.getTasks().add(task2);
        task.setTaskList(taskList);
        task2.setTaskList(taskList);

        //When
        taskListDao.save(taskList);
        int id = taskList.getId();

        //Then
        assertNotEquals(0, id);

        //CleanUp
        taskListDao.deleteById(id);
    }

}
