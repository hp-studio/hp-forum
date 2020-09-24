<template>
    <Button class="backupBtn" type="primary" @click="backup">返回</Button>
</template>

<script>
    export default {
        methods: {
            //  返回默认页
            backup() {
                this.$router.push({name: 'news'});
            }
        },
    };
</script>

<style lang="scss" scoped>
    .backupBtn {

    }
</style>
