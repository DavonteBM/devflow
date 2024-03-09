package com.devflow.api.models;


import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor

@Builder
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "ProjectName", nullable = false)
    private String projectName;
    @Column(name = "ProjectDescription", nullable = false)
    private String projectDescription;
    @Column(name = "ProjectDeveloper", nullable = false)
    private String projectDeveloper;
    @Column(name = "ProjectType")
    private String projectType;
    @Column(name = "ProjectTechStack")
    private String projectTechStack;
    @Column(name = "ProjectNotes")
    private String projectNotes;
    @Column(name = "ProjectLessons")
    private String projectLessons;
    @Column(name = "ProjectExpense")
    private String projectExpense;
    @Column(name = "ProjectPrice")
    private String projectPrice;
    @Column(name = "ProjectDueDate")
    private String projectDueDate;
    @Column(name = "IsProjectInProgress")
    private String isProjectInProgress = "false";

    @Column(name = "ClientFirstName", nullable = false)
    private String clientFirstName;
    @Column(name = "ClientLastName")
    private String clientLastName;
    @Column(name = "ClientPhoneNumber")
    private String clientPhoneNumber;
    @Column(name = "ClientEmail")
    private String clientEmail;
    @Column(name = "ClientCompany")
    private String clientCompany;

    public Project() {}

    public Project(String projectName, String projectDescription, String projectDeveloper, String projectType, String projectTechStack, String projectNotes, String projectLessons, String projectExpense, String projectPrice, String projectDueDate, String isProjectInProgress,  String clientFirstName, String clientLastName, String clientPhoneNumber, String clientEmail, String clientCompany) {
        super();
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.projectDeveloper = projectDeveloper;
        this.projectType = projectType;
        this.projectTechStack = projectTechStack;
        this.projectNotes = projectNotes;
        this.projectLessons = projectLessons;
        this.projectExpense = projectExpense;
        this.projectPrice = projectPrice;
        this.projectDueDate = projectDueDate;
        this.isProjectInProgress = isProjectInProgress;
        this.clientFirstName = clientFirstName;
        this.clientLastName = clientLastName;
        this.clientPhoneNumber = clientPhoneNumber;
        this.clientEmail = clientEmail;
        this.clientCompany = clientCompany;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getProjectDeveloper() {
        return projectDeveloper;
    }

    public void setProjectDeveloper(String projectDeveloper) {
        this.projectDeveloper = projectDeveloper;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getProjectTechStack() {
        return projectTechStack;
    }

    public void setProjectTechStack(String projectTechStack) {
        this.projectTechStack = projectTechStack;
    }

    public String getProjectNotes() {
        return projectNotes;
    }

    public void setProjectNotes(String projectNotes) {
        this.projectNotes = projectNotes;
    }

    public String getProjectLessons() {
        return projectLessons;
    }

    public void setProjectLessons(String projectLessons) {
        this.projectLessons = projectLessons;
    }

    public String getProjectExpense() {
        return projectExpense;
    }

    public void setProjectExpense(String projectExpense) {
        this.projectExpense = projectExpense;
    }

    public String getProjectPrice() {
        return projectPrice;
    }

    public void setProjectPrice(String projectPrice) {
        this.projectPrice = projectPrice;
    }

    public String getProjectDueDate() {
        return projectDueDate;
    }

    public void setProjectDueDate(String projectDueDate) {
        this.projectDueDate = projectDueDate;
    }

    public String getIsProjectInProgress() {
        return isProjectInProgress;
    }

    public void setProjectInProgress(String projectInProgress) {
        isProjectInProgress = projectInProgress;
    }

    public String getClientFirstName() {
        return clientFirstName;
    }

    public void setClientFirstName(String clientFirstName) {
        this.clientFirstName = clientFirstName;
    }

    public String getClientLastName() {
        return clientLastName;
    }

    public void setClientLastName(String clientLastName) {
        this.clientLastName = clientLastName;
    }

    public String getClientPhoneNumber() {
        return clientPhoneNumber;
    }

    public void setClientPhoneNumber(String clientPhoneNumber) {
        this.clientPhoneNumber = clientPhoneNumber;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getClientCompany() {
        return clientCompany;
    }

    public void setClientCompany(String clientCompany) {
        this.clientCompany = clientCompany;
    }
}
