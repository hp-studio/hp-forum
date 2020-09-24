const path = require('path');

function resolve(dir) {
    return path.join(__dirname, dir);
}

module.exports = {
    lintOnSave: false,
    configureWebpack: {
        resolve: {
            alias: {
                "@": resolve("src"),
                "@i": resolve("src/api"),
                "@c": resolve("src/components"),
                "@a": resolve("src/assets"),
                "@s": resolve("src/styles"),
                "@u": resolve("src/utils"),
                "@v": resolve("src/views")
            }
        }
    }
};
