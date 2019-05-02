import React, { Component } from "react";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import Login from "./components/login/LoginComponent";
import Dashboard from "./components/dashboard/Dashboard";
import Register from "./components/login/RegisterComponent";

class App extends Component {
  render() {
    return (
      <div className="container">
        <header />
        <Router>
          <Switch>
            <Route exact path="/" component={Login} />
            <Route exact path="/register" component={Register} />
            <Route path="/dashboard" component={Dashboard} />
          </Switch>
        </Router>
      </div>
    );
  }
}

export default App;
