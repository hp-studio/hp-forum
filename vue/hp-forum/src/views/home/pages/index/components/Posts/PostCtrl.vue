<template>
    <div class="postCtrl">
        <ButtonGroup size="large">
            <Button type="primary">
                精华帖
            </Button>
            <Button type="primary" @click="$refs['PostEditForm'].open('add',{topic:topic})">
                发帖
                <Icon type="ios-arrow-forward"></Icon>
            </Button>
        </ButtonGroup>
        <PostEditForm ref="PostEditForm"></PostEditForm>
    </div>
</template>

<script>
    import PostEditForm from "./PostEditForm";

    export default {
        components: {PostEditForm},
        props: {
            topic: Object
        },
        data() {
            return {
                showPostForm: false
            };
        },

    };
</script>

<style lang="scss" scoped>
    .postCtrl {
        text-align: right;
        padding: 1rem .5rem;
    }
</style>