import React, { Component } from "react";
import { Link } from "react-router-dom";

import axios from "axios";

class LoginComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      useremail: "",
      token: "",
      password: "",
      message: null
    };
  }

  login = () => {
    const postData = {
      email: this.state.useremail,
      password: this.state.password
    };

    const self = this;

    axios
      .post("/api/auth/login", postData)
      .then(response => {
        this.setState(
          {
            useremail: response.data.email,
            token: response.data.token,
            fullname: response.data.fullname,
            password: "",
            message: response.data.message
          },
          () => {
            // console.log(this.state);
            this.props.history.replace("/dashboard");
          }
        );
      })
      .catch(function(error) {
        console.log(error.response.data);
        self.setState({ message: error.response.data.message });
      });
  };

  handleReset = () => {
    this.setState({
      useremail: "",
      password: "",
      token: "",
      errorMessage: null,
      message: null
    });
  };

  handleSubmit = event => {
    event.preventDefault();
  };

  handleClick = () => {
    console.log(this.state);
  };

  handleChange = event => {
    this.setState({
      [event.target.name]: event.target.value
    });
  };

  render() {
    return (
      <div className="row justify-content-center">
        {this.state.message}
        <Link to="/register">Register</Link>
        <hr />
        <form onSubmit={this.handleSubmit}>
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
            <label htmlFor="password">Password</label>
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
              onClick={this.login}
            >
              Log-in
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

export default LoginComponent;
