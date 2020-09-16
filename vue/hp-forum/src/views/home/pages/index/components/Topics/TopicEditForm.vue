<template>
    <Modal
            width="80%"
            v-model="isShow"
            :title="{add:'新建话题',edit:'编辑话题'}[topicForm.type]"
            @on-ok="submitTopicForm"
            @on-cancel="closeTopicForm">
        <Form :model="topicForm.data" :label-width="80">
            <FormItem label="标题">
                <Input v-model="topicForm.data.title" placeholder="请输入话题标题"></Input>
            </FormItem>
            <FormItem label="话题内容">
                <quill-editor
                        ref="myQuillEditor"
                        v-model="topicForm.data.content"
                        :options="editorOption"
                />
                <!--                    <Input type="textarea" :autosize="{minRows: 4}" v-model="topicForm.data.content" placeholder="请输入"></Input>-->
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
                topicForm: {
                    type: "add",
                    data: {
                        title: "",
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
            // 创建话题编辑表单
            open(type, data) {
                this.topicForm = {
                    type: type,
                    data: {
                        ...{
                            title: "",
                            content: ""
                        }, data
                    }
                };
                this.$nextTick(() => {
                    this.isShow = true;
                });

            },
            //关闭话题编辑表单
            closeTopicForm() {
                this.isShow = false;
            },
            // 提交话题编辑表单
            submitTopicForm() {
                console.log(this.topicForm);
            }
        },
    };
</script>

<style lang="scss" scoped>

</style>