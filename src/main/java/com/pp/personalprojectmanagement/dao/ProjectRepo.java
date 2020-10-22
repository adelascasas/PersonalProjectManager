package com.pp.personalprojectmanagement.dao;

import org.springframework.data.repository.CrudRepository;
import com.pp.personalprojectmanagement.entities.Project;
import java.util.List;


public interface ProjectRepo extends CrudRepository<Project, Long>{
    //mechanism to access data in the database
    //crud repository
    @Override
    public List <Project> findAll();
}
