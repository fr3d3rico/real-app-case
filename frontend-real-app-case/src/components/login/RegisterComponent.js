import React, { Component } from "react";

import axios from "axios";

class RegisterComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      useremail: "",
      fullname: "",
      token: "",
      password: "",
      message: null
    };
  }

  handleRegister = () => {
    const postData = {
      email: this.state.useremail,
      password: this.state.password
    };
    axios.post("/api/auth/register", postData).then(response => {
      console.log(response);
    });
  };

  handleSubmit = event => {
    event.preventDefault();
  };

  handleChange = event => {
    this.setState({
      [event.target.name]: event.target.value
    });
  };

  render() {
    return (
      <div className="row justify-content-center">
        <form onSubmit={this.handleSubmit}>
          <div className="form-group">
            <label htmlFor="email">Email address</label>
            <input
              type="fullname"
              className="form-control"
              id="fullname"
              name="fullname"
              placeholder="Name"
              value={this.state.fullname}
              onChange={this.handleChange.bind(this)}
            />
          </div>

          <div className="form-group">
            <label htmlFor="email">Email address</label>
            <input
              type="useremail"
              className="form-control"
              id="useremail"
              name="useremail"
              placeholder="name@example.com"
              value={this.state.useremail}
              onChange={this.handleChange.bind(this)}
            />
          </div>

          <div className="form-group">
            <label htmlFor="email">Email address</label>
            <input
              type="password"
              className="form-control"
              id="password"
              name="password"
              placeholder="Password"
              value={this.state.password}
              onChange={this.handleChange.bind(this)}
            />
          </div>

          <div className="form-group">
            <button
              id="logInButton"
              type="button"
              className="btn btn-primary"
              onClick={this.registerHandle}
            >
              Register
            </button>
            <button
              id="resetButton"
              type="reset"
              className="btn btn-outline-info"
              onClick={this.handleReset}
            >
              Reset
            </button>
          </div>
        </form>
      </div>
    );
  }
}

export default RegisterComponent;
