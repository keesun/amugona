import React, { Component } from 'react'
import Nav from '../components/Nav'

export default class Signup extends Component {
  render() {
    return (
      <div>
        <Nav/>
        <div className="container">
          <div className="starter-template">
            <h1>Sign-up Page</h1>
            <p className="lead">
            Use this document as a way to quickly start any new project.
              <br/> All you get is this text and a mostly barebones HTML document.
            </p>
          </div>
        </div>
      </div>
    )
  }
}
