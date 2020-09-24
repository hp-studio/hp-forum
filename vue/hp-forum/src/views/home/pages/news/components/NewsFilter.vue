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
        mounted() {
            this.word = this.$route.query.word || "";
            //  监听路由匹配搜索条件
            this.$router.beforeEach((to, from, next) => {
                // ...
                this.word = to.query.word;
                next();
            });
        },
        methods: {
            //获取搜索结果
            getSearchData() {
                console.log(this.word);
            },
            // 监听搜索
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
        margin: 0 auto;
        padding: 2rem;
    }
</style>
