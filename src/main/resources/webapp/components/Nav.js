import React, { Component } from 'react'

export default class Nav extends Component {
  render() {
    return (
      <nav className="navbar navbar-fixed-top">
        <div className="container">
          <div className="navbar-header">
            <button type="button" className="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span className="sr-only">Toggle navigation</span>
              <span className="icon-bar"></span>
              <span className="icon-bar"></span>
              <span className="icon-bar"></span>
            </button>
            <a className="navbar-brand" href="/">A.MU.GO.NA</a>
          </div>
          <div id="navbar" className="collapse navbar-collapse">
            <ul className="nav navbar-nav">
              <li className="active"><a href="/">Home</a></li>
              <li><a href="#about">About</a></li>
              <li><a href="#contact">Contact</a></li>
            </ul>
            <ul className="nav navbar-nav navbar-right">
              <li className="btn-group">
                <button type="button" className="btn btn-success navbar-btn">Sign up</button>
                <button type="button" className="btn btn-default navbar-btn">Sign in</button>
              </li>
            </ul>
          </div>
        </div>
      </nav>
    )
  }
}
