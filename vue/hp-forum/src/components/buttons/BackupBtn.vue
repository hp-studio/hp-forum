<template>
    <Button class="backupBtn" type="primary" @click="backup">{{title}}</Button>
</template>

<script>
    export default {
        props: {
            //按钮名称
            title: {
                type: String,
                default: "返回"
            },
            //指定返回目标 不然就返回上一步
            target: {
                type: String,
                default: ""
            }
        },
        methods: {
            //  返回
            backup() {
                if (this.target) {
                    this.$router.push({
                        name: this.target
                    });
                    return;
                }
                this.$router.go(-1);
            }
        },
    };
</script>

<style lang="scss" scoped>
    .backupBtn {

    }
</style>
