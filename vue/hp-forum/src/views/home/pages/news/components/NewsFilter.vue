<template>
    <div class="news-filter">
        <Input search v-model="word" placeholder="请输入搜索内容" @on-search="handleSearchNews"/>
    </div>
</template>

<script>
    export default {
        name: "NewsFilter",
        data() {
            return {
                word: ""
            };
        },
        methods: {
            handleSearchNews() {
                if (this.word === "") {
                    this.$alert({
                        type: 'warning',
                        title: '提示',
                        content: '请输入搜索内容'
                    });
                    return false;
                }
                this.$router.push({
                    name: "news-search",
                    query: {
                        word: this.word
                    }
                });
            }
        }
    };
</script>

<style lang="scss" scoped>
    .news-filter {
        width: 50rem;
        margin: 2rem auto;
    }
</style>
