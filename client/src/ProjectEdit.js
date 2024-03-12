import React, { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
import { Button, Container, Form, FormGroup, Input, Label } from "reactstrap";
import AppNavbar from "./AppNavbar";

const ProjectEdit = () => {
  const initialFormState = {
    projectName: "",
    projectDescription: "",
    projectDeveloper: "",
    projectDueDate: "",
    projectType: "",
    projectTechStack: "",
    projectNotes: "",
    projectExpense: "",
    projectPrice: "",
    projectLessons: "",
    isProjectComplete: "",

    clientFirstName: "",
    clientLastName: "",
    clientPhoneNumber: "",
    clientEmail: "",
    clientCompany: "",
  };
  const [project, setProject] = useState(initialFormState);
  const navigate = useNavigate();
  const { id } = useParams();

  useEffect(() => {
    if (id !== "new") {
      fetch(`https://df-latest.onrender.com/api/project/${id}`)
        .then((response) => response.json())
        .then((data) => setProject(data));
    }
  }, [id, setProject]);

  const handleChange = (event) => {
    const { name, value } = event.target;

    setProject({ ...project, [name]: value });
  };

  const handleSubmit = async (event) => {
    event.preventDefault();

    await fetch(
      `https://df-latest.onrender.com/api/project${
        project.id ? `/${project.id}` : ""
      }`,
      {
        method: project.id ? "PUT" : "POST",
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json",
        },
        body: JSON.stringify(project),
      }
    );
    setProject(initialFormState);
    navigate("/");
  };

  const title = (
    <h2>
      {project.id
        ? `Edit Project: "${project.projectName}"`
        : "Create New Project"}
    </h2>
  );

  return (
    <div>
      <AppNavbar />
      <Container>
        {title}
        <Form onSubmit={handleSubmit}>
          <div className="row">
            <FormGroup className="col-md-4 mb-3">
              <Label for="projectName">Project Name*</Label>
              <Input
                type="text"
                name="projectName"
                id="projectName"
                value={project.projectName || ""}
                onChange={handleChange}
                autoComplete="address-level1"
              />
            </FormGroup>
            <FormGroup className="col-md-5 mb-5">
              <Label for="projectDescription">Project Description*</Label>
              <Input
                type="text"
                name="projectDescription"
                id="projectDescription"
                value={project.projectDescription || ""}
                onChange={handleChange}
                autoComplete="address-level1"
              />
            </FormGroup>
            <FormGroup className="col-md-3 mb-3">
              <Label for="projectDeveloper">Project Developer*</Label>
              <Input
                type="text"
                name="projectDeveloper"
                id="projectDeveloper"
                value={project.projectDeveloper || ""}
                onChange={handleChange}
                autoComplete="address-level1"
              />
            </FormGroup>
          </div>

          <div className="row">
            <FormGroup className="col-md-4 mb-3">
              <Label for="projectType">Project Type</Label>
              <Input
                type="text"
                name="projectType"
                id="projectType"
                value={project.projectType || ""}
                onChange={handleChange}
                autoComplete="address-level1"
              />
            </FormGroup>
            <FormGroup className="col-md-5 mb-5">
              <Label for="projectTechStack">Project Tech Stack</Label>
              <Input
                type="text"
                name="projectTechStack"
                id="projectTechStack"
                value={project.projectTechStack || ""}
                onChange={handleChange}
                autoComplete="address-level1"
              />
            </FormGroup>
            <FormGroup className="col-md-3 mb-3">
              <Label for="projectLessons">Project Lessons</Label>
              <Input
                type="text"
                name="projectLessons"
                id="projectLessons"
                value={project.projectLessons || ""}
                onChange={handleChange}
                autoComplete="address-level1"
              />
            </FormGroup>
          </div>

          <div className="row">
            <FormGroup className="col-md-3 mb-3">
              <Label for="projectExpense">Project Expense</Label>
              <Input
                type="text"
                name="projectExpense"
                id="projectExpense"
                value={project.projectExpense || ""}
                onChange={handleChange}
                autoComplete="address-level1"
              />
            </FormGroup>
            <FormGroup className="col-md-3 mb-5">
              <Label for="projectPrice">Project Price</Label>
              <Input
                type="text"
                name="projectPrice"
                id="projectPrice"
                value={project.projectPrice || ""}
                onChange={handleChange}
                autoComplete="address-level1"
              />
            </FormGroup>
            <FormGroup className="col-md-3 mb-5">
              <Label for="projectDueDate">Project Due Date</Label>
              <Input
                type="text"
                name="projectDueDate"
                id="projectDueDate"
                value={project.projectDueDate || ""}
                onChange={handleChange}
                autoComplete="address-level1"
              />
            </FormGroup>
            <FormGroup className="col-md-3 mb-5">
              <Label for="isProjectComplete">Project Complete?</Label>
              <Input
                type="text"
                name="isProjectComplete"
                id="isProjectComplete"
                value={project.isProjectComplete || ""}
                onChange={handleChange}
                autoComplete="address-level1"
              />
            </FormGroup>
          </div>

          <div className="row">
            <FormGroup className="col-md-3 mb-5">
              <Label for="clientFirstName">Client First Name*</Label>
              <Input
                type="text"
                name="clientFirstName"
                id="clientFirstName"
                value={project.clientFirstName || ""}
                onChange={handleChange}
                autoComplete="address-level1"
              />
            </FormGroup>
            <FormGroup className="col-md-2 mb-5">
              <Label for="clientLastName">Client Last Name</Label>
              <Input
                type="text"
                name="clientLastName"
                id="clientLastName"
                value={project.clientLastName || ""}
                onChange={handleChange}
                autoComplete="address-level1"
              />
            </FormGroup>
            <FormGroup className="col-md-2 mb-5">
              <Label for="clientPhoneNumber">Client Phone Number</Label>
              <Input
                type="text"
                name="clientPhoneNumber"
                id="clientPhoneNumber"
                value={project.clientPhoneNumber || ""}
                onChange={handleChange}
                autoComplete="address-level1"
              />
            </FormGroup>
            <FormGroup className="col-md-2 mb-5">
              <Label for="clientEmail">Client Email</Label>
              <Input
                type="text"
                name="clientEmail"
                id="clientEmail"
                value={project.clientEmail || ""}
                onChange={handleChange}
                autoComplete="address-level1"
              />
            </FormGroup>
            <FormGroup className="col-md-3 mb-5">
              <Label for="clientCompany">Client Company</Label>
              <Input
                type="text"
                name="clientCompany"
                id="clientCompany"
                value={project.clientCompany || ""}
                onChange={handleChange}
                autoComplete="address-level1"
              />
            </FormGroup>
          </div>

          <FormGroup>
            <Label for="projectNotes"> Notes</Label>
            <Input
              type="text"
              name="projectNotes"
              id="projectNotes"
              value={project.projectNotes || ""}
              onChange={handleChange}
              autoComplete="address-level1"
            />
          </FormGroup>
          <FormGroup>
            <Button color="success" type="submit">
              Save
            </Button>{" "}
            <Button color="secondary" tag={Link} to="/">
              Cancel
            </Button>
          </FormGroup>
        </Form>
      </Container>
    </div>
  );
};

export default ProjectEdit;
