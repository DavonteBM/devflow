import React, { useEffect, useState } from "react";
import { Button, Container, Table } from "reactstrap";
import AppNavbar from "./AppNavbar";
import { Link } from "react-router-dom";
import Footer from "./Footer";

const ProjectList = () => {
  const [projects, setProjects] = useState([]);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    setLoading(true);

    fetch("https://df-latest.onrender.com/api/projects")
      .then((response) => response.json())
      .then((data) => {
        setProjects(data);
        setLoading(false);
      });
  }, []);

  const remove = async (id) => {
    await fetch(`https://df-latest.onrender.com/api/project/${id}`, {
      method: "DELETE",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
    }).then(() => {
      let updatedProjects = [...projects].filter((i) => i.id !== id);
      setProjects(updatedProjects);
    });
  };

  if (loading) {
    return <p>Page Is Loading...</p>;
  }

  const projectList = projects.map((project) => {
    return (
      <tr key={project.id}>
        <td>{project.projectName}</td>
        <td>{project.projectDescription}</td>
        <td>{project.clientFirstName}</td>
        <td>{project.projectDueDate}</td>
        <td>{project.projectType}</td>
        <td>{project.projectExpense}</td>
        <td>{project.projectPrice}</td>
        <td>{project.isProjectInProgress}</td>
        <td>
          <Button
            size="sm"
            color="success"
            tag={Link}
            to={"/project/" + project.id}
          >
            Edit/View
          </Button>{" "}
          <Button size="sm" color="danger" onClick={() => remove(project.id)}>
            Delete
          </Button>
        </td>
      </tr>
    );
  });

  return (
    <div>
      <AppNavbar />
      <Container fluid>
        <div className="float-end">
          <Button size="lg" color="primary" tag={Link} to="/project/new">
            Add Project
          </Button>
        </div>
        <h2>My Projects</h2>
        <Table className="mt-4">
          <thead>
            <tr>
              <th width="15%">Project Name</th>
              <th width="10%">Description</th>
              <th width="10%">Client</th>
              <th width="10%">Due Date</th>
              <th width="10%">Type</th>
              <th width="10%">Expense</th>
              <th width="10%">Price</th>
              <th width="10%">Complete?</th>
              <th width="15%">Actions</th>
            </tr>
          </thead>
          <tbody>{projectList}</tbody>
        </Table>
      </Container>
      <Footer />
    </div>
  );
};

export default ProjectList;
