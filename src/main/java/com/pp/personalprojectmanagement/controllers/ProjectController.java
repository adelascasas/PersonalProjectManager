package com.pp.personalprojectmanagement.controllers;

import java.util.List;

import com.pp.personalprojectmanagement.dao.EmployeeRepo;
import com.pp.personalprojectmanagement.dao.ProjectRepo;
import com.pp.personalprojectmanagement.entities.Employee;
import com.pp.personalprojectmanagement.entities.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/projects")
public class ProjectController {
    
    //up to spring container to inject a instance, 
    //an autocreated instance
    @Autowired
    ProjectRepo proRepo;

    @Autowired
    EmployeeRepo empRepo;

    @GetMapping()
    public String getProjects(Model model){
        List<Project> projects= proRepo.findAll();
        model.addAttribute("projects", projects);
        return "projects/projects";
    }

    @GetMapping("/new")
    public String showProjectForm(Model model){
        model.addAttribute("project", new Project());
        List<Employee> employees = empRepo.findAll();
        model.addAttribute("theEmployees", employees);
        return "projects/addproject";
    }

    @PostMapping("/save")
    public String saveProject(Project project, Model model){
        //this should handle saving to the database
        proRepo.save(project);
        //use to prevent duplicate submissions
        return "redirect:/projects/new";
    }

}
