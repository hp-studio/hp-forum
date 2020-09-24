// 定义一个混入对象
export const newsMixins = {

    mounted() {
    },
    methods: {
        //从卡片跳转新闻详情页
        cardGoNewsDetailFuncObj(newsId) {
            return {name: 'news-detail', query: {newsId}};
        },
        //跳转至新闻详情页
        goNewsDetail(newsId) {
            if (!newsId) {
                this.$alert({
                    type: 'error',
                    title: '错误',
                    content: '获取新闻ID失败，请联系管理员。'
                });
                return false;
            }
            this.$router.push({
                name: "news-detail",
                query: {
                    newsId
                }
            });
        }
    }
};
