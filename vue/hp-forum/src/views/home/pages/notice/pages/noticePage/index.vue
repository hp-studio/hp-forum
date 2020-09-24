<template>
    <div class="noticePage">
        <div class="sep title">
            <div>{{notice.title}}</div>
        </div>
        <div class="sep info">
            <div>{{notice.addDate}}</div>
        </div>
        <div class="sep content">
            <ShareBar></ShareBar>
            <div class="text">{{notice.text}}</div>
        </div>
    </div>
</template>

<script>
    import ShareBar from "../../components/ShareBar";

    export default {
        components: {ShareBar},
        name: "noticePage",
        data() {
            return {
                notice: {title: '', addDate: '', text: ''}
            }
        },
        methods: {
            getNotice(id) {
                this.$axios({
                    method: 'get',
                    url: 'http://localhost:8900/forum/notice/getNotice',
                    params: {
                        id: id
                    },
                    data: this.notice,
                    responseType: 'json'
                }).then(response => {
                    let data = response.data;
                    console.log(data)
                    this.notice = data.data;
                })
            }
        },
        mounted() {
            console.log(this.$route.query.id)
            this.getNotice(this.$route.query.id);
        }
    }
</script>

<style lang="scss" scoped>

    .noticePage {
        //使用弹性盒子来做居中
        display: flex;
        //将轴改为纵轴
        flex-direction: column;
        //纵轴居中
        align-items: center;

        .title {
            //将标题调大
            font-size: 3rem;
            //字体加粗
            font-weight: bold;
        }

        .info {
            //居中
            text-align: center;
            //上边框线
            border-bottom: 1px solid gray;
            //下边框线
            border-top: 1px solid gray;
            //给一个宽度 不让宽度100% 清晰显示上边框线和下边框线
            width: 600px;
        }

        .sep {
            //每个盒子都有一个下外边距
            margin-bottom: 20px;
        }

        .content {
            width: 100%;
            display: flex;
            justify-content: right;
            .text{
                margin: 0 auto;
                //首字符缩进2个字符
                text-indent: 2rem;
                width: 800px;
            }
            .shareBar {
                margin: 50px 0 0 50px;
            }
        }
    }

</style>
