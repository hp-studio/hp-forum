<template>
    <div class="noticePage">
        noticePage
        <div class="sep title">
            <div>{{notice.title}}</div>
            <div class="close" v-on:click="close">
                <Icon type="md-power"/>
            </div>
        </div>
        <div class="sep info">
            <div>{{notice.addDate}}</div>
        </div>
        <div class="sep content">
            <div>{{notice.text}}</div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "noticePage",
        data() {
            return {
                notice: {title: '', addDate: '', text: ''}
            }
        },
        methods: {
            getNotice() {
                this.$axios({
                    method: 'get',
                    url: 'http://localhost:8900/forum/notice/getNotice',
                    params: {
                        // id: this.id
                    },
                    data: this.notice,
                    responseType: 'json'
                }).then(response => {
                    let data = response.data;
                    console.log(data)
                    this.notice = data.data;
                })
            },
            close() {
                this.$emit('close',false);
            }

        },
        mounted() {
            this.getNotice();
        }
    }
</script>

<style lang="scss" scoped>
    .noticePage {
        display: flex;
        flex-direction: column;
        align-items: center;

        .title {
            font-size: 3rem;
        }

        .info {
            text-align: center;
            border-bottom: 1px solid gray;
            border-top: 1px solid gray;
            width: 600px;
            /*margin: 0 auto;*/
        }

        .sep {
            margin-bottom: 20px;
        }

        .content {

        }
    }
</style>
