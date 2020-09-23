<template>
    <div class="noticeList">
        noticeList
        <div class="body" v-for="(notice) in notices">
            <div class="title">
                <a class="link"><h2>{{notice.title}}</h2></a>
            </div>
            <div class="addDate">
                <h2>{{notice.addDate}}</h2>
            </div>
        </div>

        <div class="control">
            <Page :current.sync="page" :total="total" :page-size="limit" @on-change="getNotices" simple/>
        </div>
    </div>
</template>

<script>
    export default {
        name: "noticeList",
        data() {
            return {
                notices: [{id: '', title: '', addDate: ''}],
                page: 1,
                limit: 3,
                total: 0
            }
        },
        methods: {
            getNotices() {
                this.$axios({
                    method: 'get',
                    url: 'http://localhost:8900/forum/notice/getNotices',
                    params: {
                        page: this.page,
                        limit: this.limit
                    },
                    data: this.notices,
                    responseType: 'json'
                }).then(response => {
                    let data = response.data;
                    console.log(data);
                    this.notices = data.data.records;
                    this.total = data.data.total;
                })
            }
        },
        mounted() {
            this.getNotices();
        }
    }
</script>

<style lang="scss" scoped>
    .noticeList {
        .body {
            text-align: center;
            margin: 20px auto;
            width: 800px;
        }

        .body:hover {
            background-color: rgba(0, 0, 0, 0.3);
        }

        .control {
            display: flex;
            justify-content: center;
        }
    }
</style>
