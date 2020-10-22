package com.pp.personalprojectmanagement.controllers;

import java.util.List;

import com.pp.personalprojectmanagement.dao.EmployeeRepo;
import com.pp.personalprojectmanagement.dao.ProjectRepo;
import com.pp.personalprojectmanagement.entities.Employee;
import com.pp.personalprojectmanagement.entities.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/employees")
@Controller
public class EmployeeController {
    
    @Autowired
    EmployeeRepo repo;

    @Autowired
    ProjectRepo proRepo;

    @GetMapping()
    public String getEmployees(Model model){
        List<Employee> employs = repo.findAll();
        model.addAttribute("employees", employs);
        return "employees/employees";
    }

    @GetMapping("/new")
    public String newEmployee(Model model){
        List<Project> projects = proRepo.findAll();
        model.addAttribute("theProjects", projects);
        model.addAttribute("employee", new Employee());
        return "employees/addEmployee";
    }

    @PostMapping("/save")
    public String saveEmployee(Employee employee, Model model){
        repo.save(employee);
        return "redirect:/employees/new";
    }

}
