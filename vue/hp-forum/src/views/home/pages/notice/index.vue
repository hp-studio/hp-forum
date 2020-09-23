<template>
    <div class="home-notice">
        <NoticeList></NoticeList>
    </div>
</template>

<script>
    import NoticeList from "./components/NoticeList";

    export default {
        components: {NoticeList},
        name: "home-notice"
    };
</script>

<style lang="scss" scoped></style>
