package com.kodilla.kodilla_hibernate.manytomany.dao;

import com.kodilla.kodilla_hibernate.manytomany.Company;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public interface CompanyDao extends CrudRepository<Company, Integer> {
    List<Company> retrieveCompaniesBynamePrefix(@Param("PREFIX") String prefix);
}
