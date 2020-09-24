<template>
    <div class="posts">
        帖子列表
        <PostCtrl :topic="topic"></PostCtrl>
        <div v-for="item in postList" class="list-items" :key="item">
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

        .post-nextPage{
            text-align: center;
        }
    }
</style>
