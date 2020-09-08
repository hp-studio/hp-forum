<template>
    <div class="home-index">
        <home-index-carousel></home-index-carousel>
        <home-index-subjects></home-index-subjects>
        <Divider/>
        <home-index-posts></home-index-posts>
    </div>
</template>

<script>
    import Carousel from "./components/Carousel"
    import Subject from "./components/Subjects"
    import Post from "./components/Posts"

    export default {
        name: "home-index",
        components: {
            "home-index-carousel": Carousel,
            "home-index-subjects": Subject,
            "home-index-posts": Post
        },

    };
</script>

<style lang="scss" scoped>
    .home-index {

    }
</style>
