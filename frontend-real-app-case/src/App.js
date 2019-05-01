import React, { Component } from "react";
import Login from './components/login/LoginComponent';

class App extends Component {
  render() {
    return (
      <div className="container">
        <header />
        <Login />
      </div>
    );
  }
}

export default App;
