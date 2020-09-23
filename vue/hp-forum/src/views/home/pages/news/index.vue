<template>
    <div class="home-news">
        <NewsFilter></NewsFilter>
        <router-view></router-view>
    </div>
</template>
<script>
    import NewsFilter from "./components/NewsFilter";


    export default {
        name: "home-news",
        components: {NewsFilter}
    };
</script>

<style lang="scss" scoped>
    .home-news {

    }
</style>
