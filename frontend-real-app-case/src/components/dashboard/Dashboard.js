import React, { Component } from "react";

class DashboardComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      useremail: "",
      token: "",
      password: "",
      message: null
    };
  }

  render() {
    return (
      <div>
        DashboardComponent
      </div>
    );
  }
}

export default DashboardComponent;
