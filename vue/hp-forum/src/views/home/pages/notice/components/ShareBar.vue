<template>
    <div class="shareBar">
        <div class="title">
            分享
        </div>
        <div class="bars">
            <div class="bar" @click="share('微信分享')">
                <img src="@/assets/wx.png" alt="">
            </div>
            <div class="bar" @click="share('QQ分享')">
                <img src="@/assets/qq.png" alt="">
            </div>
            <div class="bar" @click="share('微博分享')">
                <img src="@/assets/wb.png" alt="">
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "ShareBar",
        methods: {
            share(msg) {
                alert(msg);
            }
        }
    }
</script>

<style lang="scss" scoped>
    .shareBar {
        .title {
            text-align: center;
            border-top: 1px solid black;
            border-bottom: 1px solid black;
            margin-bottom: 10%;
        }

        .bars {
            .bar {
                width: 50px;
                height: 50px;
                margin-bottom: 40%;
                border-radius: 50%;

                img {
                    width: 50px;
                    height: 50px;
                }
            }

            .bar:hover {
                cursor: pointer;
                box-shadow: 5px 10px 5px black;
            }

        }
    }
</style>
