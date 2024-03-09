import React, { useState } from "react";
import { Navbar, NavbarBrand, NavbarToggler } from "reactstrap";
import { Link } from "react-router-dom";

const AppNavbar = () => {
  const [isOpen, setIsOpen] = useState(false);

  return (
    <Navbar color="dark" dark expand="md">
      <NavbarBrand tag={Link} to="/myprojects">
        <h1>DevFlow</h1>
      </NavbarBrand>
      <NavbarToggler
        onClick={() => {
          setIsOpen(!isOpen);
        }}
      />
    </Navbar>
  );
};

export default AppNavbar;
