<template>
    <div class="home-index-posts">
        帖子列表
        <div v-for="item in postList" :key="item">
            <div class="home-index-posts-post">Col</div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "home-index-posts",
        data() {
            return {
                postList: 7
            }
        }
    }
</script>

<style lang="scss" scoped>
    .home-index-posts {
        padding: .5rem;

        .home-index-posts-post {
            padding: .5rem;
            margin: .5rem;
            border: 1px solid #eee;
            border-radius: 6px;
            cursor: pointer;
            transition: all .3s ease-in-out;
        }

        .home-index-posts-post:hover {
            box-shadow: 2px 2px 2px rgba(0, 0, 0, .1)


        }
    }
</style>