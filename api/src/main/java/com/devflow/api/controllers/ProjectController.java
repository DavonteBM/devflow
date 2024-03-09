package com.devflow.api.controllers;

import com.devflow.api.models.Project;
import com.devflow.api.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProjectController {
    @Autowired
    private ProjectRepository projectRepository;

    //Get All Projects
    @GetMapping("/projects")
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    //Get Specific Projects with ID
    @GetMapping("/project/{id}")
    public ResponseEntity<?> getProjectById(@PathVariable Long id) {
        Optional<Project> project = projectRepository.findById(id);
        return project.map (response -> ResponseEntity.ok().body(response))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //Create A Project
    @PostMapping("/project")
    public Project createProject(@RequestBody Project project) {
        return projectRepository.save(project);
    }

    //Update A Project
    @PutMapping("/project/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable("id") long id, @RequestBody Project project) {
        Optional<Project> projectData = projectRepository.findById(id);

        if (projectData.isPresent()) {
            Project _project = projectData.get();
            _project.setProjectName(project.getProjectName());
            _project.setProjectDescription(project.getProjectDescription());
            _project.setProjectDeveloper(project.getProjectDeveloper());
            _project.setProjectType(project.getProjectType());
            _project.setProjectTechStack(project.getProjectTechStack());
            _project.setProjectNotes(project.getProjectNotes());
            _project.setProjectLessons(project.getProjectLessons());
            _project.setProjectExpense(project.getProjectExpense());
            _project.setProjectPrice(project.getProjectPrice());
            _project.setProjectDueDate(project.getProjectDueDate());
            _project.setProjectInProgress(project.getIsProjectInProgress());
            _project.setClientFirstName(project.getClientFirstName());
            _project.setClientLastName(project.getClientLastName());
            _project.setClientPhoneNumber(project.getClientPhoneNumber());
            _project.setClientEmail(project.getClientEmail());
            _project.setClientCompany(project.getClientCompany());

            return new ResponseEntity<>(projectRepository.save(_project), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Delete A Project
    @DeleteMapping("/project/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable Long id) {
        projectRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
