<template>
    <Modal
            width="80%"
            v-model="isShow"
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
</template>

<script>
    export default {
        data() {
            return {
                isShow:false,
                topicList: [],
                postForm: {
                    type: "add",
                    data: {
                        title: "",
                        topic: null,
                        content: ""
                    }
                },
                editorOption: {
                    placeholder: "请输入"
                }
            };
        },
        mounted() {
            this.getTopicList();
        },
        methods: {
            //  获取话题列表
            getTopicList() {
                this.topicList = [
                    {id:1,title:'test'},
                    {id:2,title:'test2'},
                    {id:3,title:'test3'},
                ];
            },
            // 创建帖子编辑表单
            open(type, data) {
                this.postForm = {
                    type: type,
                    data: {
                        ...{
                            title: "",
                            topic: null,
                            content: ""
                        }, data
                    }
                };
                this.$nextTick(() => {
                    this.isShow = true;
                });

            },
            //关闭帖子编辑表单
            closePostForm() {
                this.isShow = false;
            },
            // 提交帖子编辑表单
            submitPostForm() {
                console.log(this.postForm);
            }
        },
    };
</script>

<style lang="scss" scoped>

</style>