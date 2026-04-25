package com.casedairy.backend.repository;

import com.casedairy.backend.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
    Project findByProjectName(String projectName);
    List<Project> findByProjectCode(String projectCode);}