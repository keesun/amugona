var path = require('path'),
    webpack = require('webpack');

module.exports = {
    devtool: 'cheap-module-eval-source-map',
    entry: './main.js',
    output: {
        path: path.join(__dirname, '../static/scripts'),
        filename: 'bundle.js'
    },
    resolve: {
        extensions: ['', '.js']
    },
    module: {
        loaders: [
            {test: /\.js$/, loader: 'babel', exclude: /node_modules/},
            {test: /\.css$/, loader: 'style!css'}
        ]
    }
};
