package com.kodilla.kodilla_hibernate.manytomany.dao;

import com.kodilla.kodilla_hibernate.manytomany.Employee;
import com.kodilla.kodilla_hibernate.task.Task;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer> {
    @Query
    List<Employee> retrieveEmployeesByLastname(@Param("LASTNAME") String lastname);
}
