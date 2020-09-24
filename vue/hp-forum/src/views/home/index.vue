<template>
    <div class="home">
        <HomeMenu :hasShadow="contentScrollTop"></HomeMenu>
        <div ref="HOME-CONTENT" style="overflow:auto;height: calc(100% - 60px);">
            <router-view style="min-height: calc(100% - 40px);"/>
            <HomeFooter></HomeFooter>
        </div>
    </div>
</template>

<script>
    import HomeMenu from "./components/HomeMenu";
    import HomeFooter from "./components/HomeFooter";

    export default {
        name: "home",
        components: {HomeMenu, HomeFooter},
        data() {
            return {
                contentScrollTop: 0
            };
        },
        mounted() {
            this.addScrollLinstener();
        },
        beforeDestroy() {
            this.removeScrollListener();
        },
        methods: {
            //  设置滚动条监听器，坚挺滚动条位置。
            addScrollLinstener() {
                this.$refs['HOME-CONTENT'].addEventListener('scroll', this.onScroll);
            },
            //  正在滚动时的回调函数
            onScroll(e) {
                this.contentScrollTop = e.target.scrollTop;
            },
            //  移除滚动条监听器
            removeScrollListener() {
                console.log("移除监听器");
                this.$refs['HOME-CONTENT'].removeEventListener('scroll', this.onScroll);
            }
        }
    };
</script>

<style lang="scss" scoped>
    .home {
        width: 100%;
        height: 100%;

        .home-content {

            overflow: auto;
        }
    }
</style>
