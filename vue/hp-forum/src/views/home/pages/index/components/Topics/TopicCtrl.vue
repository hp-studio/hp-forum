<template>
    <div class="postCtrl">
        <ButtonGroup size="large">
            <Button type="primary">
                热门话题
            </Button>
            <Button type="primary" @click="$refs['TopicEditForm'].open('add')">
                新建话题
                <Icon type="ios-arrow-forward"></Icon>
            </Button>
        </ButtonGroup>
        <TopicEditForm ref="TopicEditForm"></TopicEditForm>
    </div>
</template>

<script>
    import TopicEditForm from "./TopicEditForm";

    export default {
        components: {TopicEditForm}
    };
</script>

<style lang="scss" scoped>
    .postCtrl {
        text-align: right;
        padding: 1rem .5rem;
    }
</style>