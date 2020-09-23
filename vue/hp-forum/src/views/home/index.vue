<template>
    <div class="home">
        <HomeMenu></HomeMenu>
        <router-view class="content"/>
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
        //使用弹性盒子解决footer置底问题
        display: flex;
        //将轴改为纵轴
        flex-direction: column;
        .content{
            flex: auto;
        }
        .footer{
            flex: auto;
        }
    }
</style>
