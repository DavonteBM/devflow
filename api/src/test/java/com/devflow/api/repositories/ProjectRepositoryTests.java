package com.devflow.api.repositories;

import com.devflow.api.models.Project;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.NoSuchElementException;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProjectRepositoryTests {

    @Autowired
    private ProjectRepository projectRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    @DisplayName("Testing Save Project Repository")
    public void saveProjectTest(){
        //Given
        Project project = Project.builder()
                .projectName("Test Save repository")
                .projectDescription("Testing save repository")
                .projectDeveloper("Davonte")
                .projectType("testAPI")
                .projectTechStack("Spring Boot")
                .projectPrice("0.00")
                .projectExpense("0.00")
                .projectNotes("testAPI")
                .projectLessons("testAPI")
                .projectDueDate("N/A")
                .isProjectInProgress("true")
                .clientFirstName("test")
                .clientLastName("testing")
                .clientEmail("test@gmail.com")
                .clientPhoneNumber("223-422-2934")
                .clientCompany("Test Inc")
                .build();

        //When
        projectRepository.save(project);

        //Then
        Assertions.assertThat(project.getId()).isGreaterThan(0);
        Assertions.assertThat(project.getProjectName()).isEqualTo("Test Save repository");
    }

    @Test
    @Order(2)
    @Rollback(value = false)
    @DisplayName("Testing get all Project Repository")
    public void getAllProjectTest(){
        //When
        List<Project> project = projectRepository.findAll();

        //Then
        Assertions.assertThat(project.size()).isGreaterThan(0);

    }

    @Test
    @Order(3)
    @Rollback(value = false)
    @DisplayName("Testing get Project by Id Repository")
    public void getProjectbyIdTest(){
        //When
        Project project = projectRepository.findById(3L).get();

        //Then
        Assertions.assertThat(project.getId()).isEqualTo(3L);

    }

    @Test
    @Order(4)
    @Rollback(value = false)
    @DisplayName("Testing Update Project Repository")
    public void updateProjectTest(){

        //Given
        Project project = projectRepository.findById(3L).get();

        project.setProjectName("This Name Has been updated");
        project.setProjectDescription("This Has been updated");
        project.setProjectDeveloper("This Has been updated");
        project.setProjectType("This Has been updated");
        project.setProjectTechStack("This Has been updated");
        project.setProjectPrice("This Has been updated");
        project.setProjectExpense("This Has been updated");
        project.setProjectNotes("This Has been updated");
        project.setProjectLessons("This Has been updated");
        project.setProjectDueDate("This Has been updated");
        project.setProjectInProgress("This Has been updated");
        project.setClientFirstName("This Has been updated");
        project.setClientLastName("This Has been updated");
        project.setClientPhoneNumber("This Has been updated");
        project.setClientCompany("This Has been updated");
        project.setClientEmail("This Has been updated");

        //When
        Project projectUpdate =  projectRepository.save(project);

        //Then
        Assertions.assertThat(projectUpdate.getProjectName()).isEqualTo("This Name Has been updated");
        Assertions.assertThat(projectUpdate.getProjectDescription()).isEqualTo("This Has been updated");
        Assertions.assertThat(projectUpdate.getProjectDeveloper()).isEqualTo("This Has been updated");
        Assertions.assertThat(projectUpdate.getProjectType()).isEqualTo("This Has been updated");
        Assertions.assertThat(projectUpdate.getProjectTechStack()).isEqualTo("This Has been updated");
        Assertions.assertThat(projectUpdate.getProjectPrice()).isEqualTo("This Has been updated");
        Assertions.assertThat(projectUpdate.getProjectExpense()).isEqualTo("This Has been updated");
        Assertions.assertThat(projectUpdate.getProjectNotes()).isEqualTo("This Has been updated");
        Assertions.assertThat(projectUpdate.getProjectLessons()).isEqualTo("This Has been updated");
        Assertions.assertThat(projectUpdate.getProjectDueDate()).isEqualTo("This Has been updated");
        Assertions.assertThat(projectUpdate.getIsProjectInProgress()).isEqualTo("This Has been updated");
        Assertions.assertThat(projectUpdate.getClientFirstName()).isEqualTo("This Has been updated");
        Assertions.assertThat(projectUpdate.getClientLastName()).isEqualTo("This Has been updated");
        Assertions.assertThat(projectUpdate.getClientEmail()).isEqualTo("This Has been updated");
        Assertions.assertThat(projectUpdate.getClientPhoneNumber()).isEqualTo("This Has been updated");
        Assertions.assertThat(projectUpdate.getClientCompany()).isEqualTo("This Has been updated");
    }


    @Test
    @Order(5)
    @Rollback(value = false)
    @DisplayName("Testing Delete Project by Id Repository")
    public void deleteProjectbyIdTest(){
        //Given
        Project project = projectRepository.findById(3L).get();

        //When
        try {
            projectRepository.delete(project);
            Project project1 = projectRepository.findById(3L).get();

        } catch (NoSuchElementException e) {
            //Then
            Assertions.assertThat(e.getMessage());

        }


    }
}