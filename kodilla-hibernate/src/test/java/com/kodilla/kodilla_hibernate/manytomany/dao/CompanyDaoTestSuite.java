package com.kodilla.kodilla_hibernate.manytomany.dao;

import com.kodilla.kodilla_hibernate.manytomany.Company;
import com.kodilla.kodilla_hibernate.manytomany.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class CompanyDaoTestSuite {

    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void testSaveManyToMany() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        assertNotEquals(0, softwareMachineId);
        assertNotEquals(0, dataMaestersId);
        assertNotEquals(0, greyMatterId);

        //CleanUp
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMaestersId);
            companyDao.deleteById(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }

    }

    @Test
    void testRetrieveEmployeesByLastname() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaSmith = new Employee("Linda", "Smith");

        //When
        employeeDao.save(johnSmith);
        employeeDao.save(stephanieClarckson);
        employeeDao.save(lindaSmith);
        List<Employee> employeeList = employeeDao.retrieveEmployeesByLastname("Smith");
        //Then
        assertEquals(2, employeeList.size());

        //CleanUp
        try {
            employeeDao.delete(johnSmith);
            employeeDao.delete(stephanieClarckson);
            employeeDao.delete(lindaSmith);
        } catch (Exception e) {
            //do nothing
        }

    }

    @Test
    void testRetrieveCompaniesByPrefix() {
        //Given
        Company company1 = new Company("Company1");
        Company company2 = new Company("Abc");
        Company company3 = new Company("Abchfodjfv");

        //When
        companyDao.save(company1);
        companyDao.save(company2);
        companyDao.save(company3);
        List<Company> companiesRetrivedByPrefix = companyDao.retrieveCompaniesBynamePrefix("Abc");
        //Then
        assertEquals(2, companiesRetrivedByPrefix.size());

        //CleanUp
        try {
            companyDao.delete(company1);
            companyDao.delete(company2);
            companyDao.delete(company3);
        } catch (Exception e) {
            //do nothing
        }

    }
}
