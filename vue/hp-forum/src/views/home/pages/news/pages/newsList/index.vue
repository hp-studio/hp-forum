<template>
    <div class="news-newsList">
        <NewsFilter></NewsFilter>
        <NewsTab></NewsTab>
    </div>
</template>

<script>
    import NewsTab from "./components/NewsTab";
    import NewsFilter from "../../components/NewsFilter";

    export default {
        name: "news-newsList",
        components: {NewsTab, NewsFilter},

    };
</script>

<style lang="scss" scoped>
    .news-newsList {

    }
</style>
