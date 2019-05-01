import React, { Component } from "react";

import axios from "axios";

class LoginComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      email: '',
      password: '',
      errorMessage: null
    };
  }

  login = () => {
    const post = {
      email: this.state.email,
      password: this.state.password
    };
    axios.post("/api/auth/login", post).then(response => {
      console.log(response);
    });
  };

  register = () => {
    const post = {
      email: this.state.email,
      password: this.state.password
    };
    axios.post("/api/auth/register", post).then(response => {
      console.log(response);
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
        <form onSubmit={this.handleSubmit}>
          <div className="form-group">
            <label htmlFor="email">Email address</label>
            <input
              type="email"
              className="form-control"
              id="email"
              name="email"
              placeholder="name@example.com"
              value={this.state.email}
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
            <button id="resetButton" type="reset" className="btn btn-outline-info">
              Reset
            </button>
          </div>
        </form>
      </div>
    );
  }
}

export default LoginComponent;
