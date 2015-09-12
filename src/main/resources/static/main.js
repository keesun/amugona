var Nav = React.createClass({
    render: function() {
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
                        <a className="navbar-brand" href="/">Amogona</a>
                    </div>
                    <div id="navbar" className="collapse navbar-collapse">
                        <ul className="nav navbar-nav">
                            <li className="active"><a href="#">Home</a></li>
                            <li><a href="#about">About</a></li>
                            <li><a href="#contact">Contact</a></li>
                        </ul>
                        <ul className="nav navbar-nav navbar-right">
                            <li><a href="#">Sign up</a></li>
                            <li><a href="#about">Sign in</a></li>
                        </ul>
                    </div>{/* .nav-collapse */}
                </div>
            </nav>
        );
    }
});

var Main = React.createClass({
    render: function() {
        return (
            <div>
                <Nav/>
                <div className="container">
                    <div className="starter-template">
                        <h1>Bootstrap starter template</h1>
                        <p className="lead">
                            Use this document as a way to quickly start any new project.<br/>
                            All you get is this text and a mostly barebones HTML document.
                        </p>
                    </div>
                </div>{/* .container */}
            </div>
        );
    }
});

var Signup = React.createClass({
    render: function() {
        return (
            <div>
                <Nav/>
                <div className="container">
                    <div className="starter-template">
                        <h1>Sign up</h1>
                    </div>
                </div>{/* .container */}
            </div>
        );
    }
});

var App = React.createClass({
    getInitialState: function() {
        return {
            route: window.location.hash.substr(1)
        }
    },

    componentDidMount: function() {
        window.addEventListener('hashchange', () => {
            this.setState({
                route: window.location.hash.substr(1)
            });
        })
},

render: function() {
    var Child;
    switch (this.state.route) {
        case 'main': Child = Main; break;
        case 'signup': Child = Signup; break;
        default: Child = Main;
    }
    return (<Child/>);
}
});

React.render(<App/>, document.body);
