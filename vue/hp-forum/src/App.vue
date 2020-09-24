<template>
    <div id="app">
        <router-view/>
    </div>
</template>
<script>
    export default {
        name: "App",
        mounted() {
        }
    };
</script>
<style lang="scss">
    /*引入全局样式*/
    @import "./style/index.scss";

    #app {
        width: 100vw;
        height: 100vh;
    }
</style>
