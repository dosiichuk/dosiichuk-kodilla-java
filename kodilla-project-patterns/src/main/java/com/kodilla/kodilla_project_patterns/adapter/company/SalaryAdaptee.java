package com.kodilla.kodilla_project_patterns.adapter.company;

import com.kodilla.kodilla_project_patterns.adapter.company.newhrsystem.CompanySalaryProcessor;
import com.kodilla.kodilla_project_patterns.adapter.company.newhrsystem.Employee;
import com.kodilla.kodilla_project_patterns.adapter.company.newhrsystem.SalaryProcessor;

import java.math.BigDecimal;
import java.util.List;

public class SalaryAdaptee implements SalaryProcessor {

    private List<Employee> employees;

    @Override
    public BigDecimal calculateSalaries(List<Employee> employees) {
        this.employees = employees;
        CompanySalaryProcessor theProcessor = new CompanySalaryProcessor();
        return theProcessor.calculateSalaries(employees);
    }
}
