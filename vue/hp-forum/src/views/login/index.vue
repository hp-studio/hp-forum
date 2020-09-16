<template>
    <div class="parent">
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
    .parent {
        height: 100%;
    }
</style>