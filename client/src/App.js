import React from "react";
import "./App.css";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import ProjectEdit from "./ProjectEdit";
import ProjectList from "./ProjectList";

const App = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<ProjectList />} />
        <Route path="/project/:id" element={<ProjectEdit />} />
      </Routes>
    </Router>
  );
};

export default App;
