<template>
    <div class="index">
        <Carousel></Carousel>
        <Divider/>
        <Topics></Topics>
        <Divider/>
        <Posts></Posts>
    </div>
</template>

<script>
    import Carousel from "./components/Carousel"
    import Topics from "./components/Topics"
    import Posts from "./components/Posts"

    export default {
        name: "home-index",
        components: {
            Carousel,
            Topics,
            Posts
        },

    };
</script>

<style lang="scss" scoped>
    .index {

    }
</style>
