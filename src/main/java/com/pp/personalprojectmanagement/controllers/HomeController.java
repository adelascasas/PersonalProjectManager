package com.pp.personalprojectmanagement.controllers;

import com.pp.personalprojectmanagement.dao.EmployeeRepo;
import com.pp.personalprojectmanagement.dao.ProjectRepo;
import com.pp.personalprojectmanagement.entities.Employee;
import com.pp.personalprojectmanagement.entities.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    
    @Autowired
    ProjectRepo projectRepo;

    @Autowired
    EmployeeRepo employeeRepo;

    @GetMapping("/")
    public String getHome(Model model){
       List<Project> projects=  projectRepo.findAll();
       List<Employee> employees =  employeeRepo.findAll();
        model.addAttribute("projects", projects);
        model.addAttribute("employees", employees);
        return "main/home";
    }
}
