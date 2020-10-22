package com.pp.personalprojectmanagement.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Employee {

    //both annotations for employeeid
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long employeeId;
    private String firstName;
    private String lastName;
    private String email;

    //Lazy fetch type means that project will be loaded but Employees will be loaded only when 
    //called for, these are parameters for the children to know how to react to the parent
    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, 
    fetch=FetchType.LAZY)
    @JoinTable(name="project_employee", 
    joinColumns = @JoinColumn(name="employee_id"),
    inverseJoinColumns = @JoinColumn(name="project_id")
    )
    private List<Project> projects;

    public Employee(){

    }

    public Employee(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    
    public long getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Project> getProjects() {
        return this.projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }


}
