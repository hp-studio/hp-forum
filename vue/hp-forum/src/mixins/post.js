let postMixins = {

    data() {
        return {
            showPostForm: false,
            topicList: [],
            postForm: {
                type: "add",
                data: {
                    title: "",
                    topic: null,
                    content: ""
                }
            },
            editorOption:{
placeholder:"请输入"
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
        createPostForm(type, data) {
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
                this.showPostForm = true;
            });

        },
        //关闭帖子编辑表单
        closePostForm() {
            this.showPostForm = false;
        },
        // 提交帖子编辑表单
        submitPostForm() {
            console.log(this.postForm);
        }
    },
};
export default postMixins;