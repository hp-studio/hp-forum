<template>
    <div class="home">
        <HomeMenu></HomeMenu>
        <router-view/>
        <HomeFooter></HomeFooter>
    </div>
</template>

<script>
    import HomeMenu from "./components/HomeMenu";
    import HomeFooter from "./components/HomeFooter";

    export default {
        name: "home",
        components: {HomeMenu, HomeFooter}
    };
</script>

<style lang="scss" scoped>
    .home {
        width: 100%;
        height: 100%;
        overflow: auto;
    }
</style>
