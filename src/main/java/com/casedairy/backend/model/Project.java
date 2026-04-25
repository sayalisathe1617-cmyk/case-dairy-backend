package com.casedairy.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "client_id")
    private Integer clientId;

    // 🔥 ADD THIS (for list display)
    @Column(name = "client_name")
    private String clientName;

    // 🔥 ADD THIS (for list display)
    @Column(name = "location")
    private String location;

    @Column(name = "project_name")
    private String projectName;

    // 🔥 IMPORTANT: NH CODE mapping
    @Column(name = "nh_code")
    private String projectCode;

    @Column(name = "project_package")
    private String projectPackage;

    // 🔹 GETTERS & SETTERS

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectPackage() {
        return projectPackage;
    }

    public void setProjectPackage(String projectPackage) {
        this.projectPackage = projectPackage;
    }
}