<template>
    <div class="posts">
        帖子列表
        <PostCtrl :topic="topic"></PostCtrl>
        <div v-for="item in postList" class="posts-post" :key="item">
            Col
        </div>
        <div class="posts-post post-nextPage">下一页</div>
    </div>
</template>

<script>
    import PostCtrl from "./PostCtrl"

    export default {
        props: {
            topic:Object
        },
        components: {
            PostCtrl},
        data() {
            return {
                postList: 7
            }
        }
    }
</script>

<style lang="scss" scoped>
    .posts {
        padding: .5rem;

        .posts-post {
            padding: .5rem;
            margin: .5rem;
            border: 1px solid #eee;
            border-radius: 6px;
            cursor: pointer;
            transition: all .3s ease-in-out;
        }

        .posts-post:hover {
            box-shadow: 2px 2px 2px rgba(0, 0, 0, .1)
        }
        .post-nextPage{
            text-align: center;
        }
    }
</style>