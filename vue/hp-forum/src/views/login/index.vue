<template>
    <div class="login">
        <LoginWindow></LoginWindow>
    </div>
</template>

<script>
    import LoginWindow from "./components/LoginWindow";
    export default {
        name: "login",
        components:{LoginWindow}
    }
</script>

<style scoped>
    .login {
        height: 100%;
        background: url("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1600272364591&di=a10acdde9e861f1f637c1cadb4722d73&imgtype=0&src=http%3A%2F%2Fimgfs.oppo.cn%2Fdata%2Fattachment%2Fforum%2F201407%2F27%2F232217lttjpqqsctlts688.jpg") no-repeat;
        background-size: 100% 100%;
    }
</style>