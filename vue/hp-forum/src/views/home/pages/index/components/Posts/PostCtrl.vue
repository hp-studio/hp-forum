<template>
    <div class="postCtrl">
        <ButtonGroup size="large">
            <Button type="primary">
                精华帖
            </Button>
            <Button type="primary" @click="createPostForm('add',{topic:topic})">
                发帖
                <Icon type="ios-arrow-forward"></Icon>
            </Button>
        </ButtonGroup>
        <Modal
                width="80%"
                v-model="showPostForm"
                :title="{add:'发帖',edit:'编辑帖子'}[postForm.type]"
                @on-ok="submitPostForm"
                @on-cancel="closePostForm">
            <Form :model="postForm.data" :label-width="80">
                <FormItem label="标题">
                    <Input v-model="postForm.data.title" placeholder="请输入帖子标题"></Input>
                </FormItem>
                <FormItem label="所属话题">
                    <Select v-model="postForm.data.topic" filterable>
                        <Option v-for="item in topicList" :key="item.id" :value="item.id">{{item.title}}</Option>
                    </Select>
                </FormItem>
                <FormItem label="主楼内容">
                    <quill-editor
                            ref="myQuillEditor"
                            v-model="postForm.data.content"
                            :options="editorOption"
                    />
<!--                    <Input type="textarea" :autosize="{minRows: 4}" v-model="postForm.data.content" placeholder="请输入"></Input>-->
                </FormItem>
            </Form>
        </Modal>
    </div>
</template>

<script>
    import postMixins from "../../../../../../mixins/post";

    export default {
        props: {
            topic: Object
        },
        mixins: [postMixins]
    };
</script>

<style lang="scss" scoped>
    .postCtrl {
        text-align: right;
        padding: 1rem .5rem;
    }
</style>