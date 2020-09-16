<template>
    <div class="login">
        <div class="parent">
            <div class="title">
                <div class="body"><h3>憨批论坛</h3></div>
                <div class="body sign"><h4 class="signWord">账号登录</h4></div>
            </div>
            <Form ref="user" :model="user" :rules="userValidate">
                <FormItem prop="user">
                    <Input type="text" v-model="user.id" placeholder="账号" style="width: 300px">
                        <Icon type="md-contact" slot="prepend"/>
                    </Input>
                </FormItem>
                <FormItem prop="password">
                    <Input type="password" v-model="user.password" placeholder="密码" style="width: 300px "
                           :autofocus="this.focusPwd">
                        <Icon type="md-lock" slot="prepend"/>
                    </Input>
                </FormItem>
                <FormItem prop="remember" class="remember">
                    <Checkbox v-model="remember">记住密码</Checkbox>
                </FormItem>
                <FormItem>
                    <Button type="primary" @click="login('user')" style="width: 300px">登录</Button>
                </FormItem>
            </Form>
            <div class="title">
                <div class="body sign"><h4 class="signWord">第三方登录</h4></div>
                <div class="body thirdLogin">
                    <Icon type="ios-chatbubbles" size="50" color="green" @click="wechatLogin"/>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "LoginWindow",
        data() {
            return {
                user: {id: "", password: ""},
                remember: false,
                focusPwd: false,
                userValidate: {
                    id: [
                        {required: true, message: '账号不能为空', trigger: 'blur'}
                    ],
                    password: [
                        {required: true, message: '密码不能为空', trigger: 'blur'}
                    ],
                }
            }
        },
        methods: {
            login(user) {
                this.$refs[user].validate((valid) => {
                    if (valid) {
                        this.$Message.success('Success!');
                    } else {
                        this.$Message.error('Fail!');
                    }
                })

                this.$axios({
                    method: 'post',
                    url: 'http://localhost:8900/login',
                    data: this.user,
                    responseType: 'json'
                }).then(response => {
                    let data = response.data;
                    if (data.code == 1) {
                        return alert(data.msg);
                    }
                    //token本地存储
                    localStorage.setItem("token", data.data);
                    this.rememberOperating(this.remember);
                    this.$router.replace({name: "home-index"})
                }).catch(exception => {
                    console.log(exception)
                });
            },
            wechatLogin() {
                alert("微信登录");
            },

            // 记住密码处理
            rememberOperating(remember) {
                if (remember) {
                    localStorage.setItem("id", this.user.id);
                    localStorage.setItem("password", this.user.password);
                    localStorage.setItem("remember", this.remember);
                } else {
                    localStorage.removeItem("id");
                    localStorage.removeItem("password");
                    localStorage.removeItem("remember");
                }
            }
        },
        mounted() {
            let remember = localStorage.getItem("remember");
            if (null != remember) {
                this.remember = true;
                this.user.id = localStorage.getItem("id");
                this.user.password = localStorage.getItem("password");
                this.focusPwd = true;
            }
        }
    }
</script>

<style lang="scss" scoped>
    .login {
        width: 100%;
        height: 100%;
        /*配合子级的绝对定位*/
        position: relative;
        /*cover将背景图片比例扩张*/
        background: url("bg.jpg") center/cover no-repeat;

        .parent {
            width: 360px;
            /*绝对定位调整整个登录框的位置*/
            position: absolute;
            left: 64%;
            top: 26%;
            /*背景颜色白色透明*/
            background-color: rgba(255, 255, 255, .2);
            /*上下内边距0 左右内边距30px*/
            padding: 0 30px;


            .title .body {
                /*字体颜色*/
                color: blanchedalmond;
                /*居中*/
                text-align: center;
                /*下边距*/
                margin-bottom: 10px;
            }

            /*加中线*/
            .title .sign .signWord:before, .title .sign .signWord:after {
                content: ''; /*CSS伪类用法*/
                position: absolute; /*定位背景横线的位置*/
                /*top: 13%;*/
                background: blanchedalmond; /*宽和高做出来的背景横线*/
                width: 36%;
                height: 2px;
                line-height: 16px;
            }

            /*加中线*/
            .title .sign .signWord:before {
                left: 0%;
            }

            /*加中线*/
            .title .sign .signWord:after {
                right: 0%;
            }

            /*第三方登录鼠标移过去变小手*/
            .thirdLogin:hover {
                cursor: pointer;
            }

            /*表单输入框的下边距*/
            .ivu-form-item {
                margin-bottom: 10px;
            }
        }
    }
</style>