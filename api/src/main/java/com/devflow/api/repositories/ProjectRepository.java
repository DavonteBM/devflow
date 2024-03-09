package com.devflow.api.repositories;

import com.devflow.api.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository <Project, Long> {
}
