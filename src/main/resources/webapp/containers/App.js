import React, { Component } from 'react'
import Home from './Home'
import Signup from './Signup'

export default class App extends Component {
  constructor(props) {
    super(props)
    this.state = { route: window.location.hash.substr(1) }
  }

  componentDidMount() {
    window.addEventListener('hashchange', () => {
      this.setState({
          route: window.location.hash.substr(1)
      })
    })
  }

  render() {
    var Child
    switch (this.state.route) {
        case "home":
            Child = Home
            break
        case "signup":
            Child = Signup
            break
        default:
            Child = Home
    }
    return (<Child/>);
  }
}
