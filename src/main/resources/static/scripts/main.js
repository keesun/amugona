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
        );
    }
});

var Home = React.createClass({
    render: function() {
        return (
            <div>
                <Nav/>
                <div className="container">
                    <div className="starter-template">
                        <h1>Home Page</h1>
                        <p className="lead">
                            Use this document as a way to quickly start any new project.
                            <br/> All you get is this text and a mostly barebones HTML document.
                        </p>
                    </div>
                </div>
            </div>
        );
    }
});

var Singup = React.createClass({
    render: function() {
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
            })
        })
    },

    render: function() {
        var Child;
        switch (this.state.route) {
            case "home": Child = Home; break;
            case "signup": Child = Singup; break;
            default: Child = Home;
        }

        return (<Child/>);
    }
});

React.render(<App/>, document.body);
