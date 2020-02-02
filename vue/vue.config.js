
module.exports = {
    publicPath: './',
    devServer: {
        proxy: 'http://localhost:8081/springboot',
    },
    configureWebpack: {
        devtool: 'source-map'
    }
}