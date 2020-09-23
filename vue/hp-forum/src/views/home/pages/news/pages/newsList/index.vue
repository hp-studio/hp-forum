<template>
    <div class="news-newsList">
        <NewsTab></NewsTab>
    </div>
</template>

<script>
    import NewsTab from "./components/NewsTab";

    export default {
        name: "news-newsList",
        components: { NewsTab},

    };
</script>

<style lang="scss" scoped>
    .news-newsList {

    }
</style>
