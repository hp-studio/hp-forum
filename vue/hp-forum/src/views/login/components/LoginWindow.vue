<template>
    <div class="loginWindow">
        <div class="parent">
            <div class="title">
                <div class="body"><h3>憨批论坛</h3></div>
                <div class="body lineWord">
                    <div class="line"></div>
                    <div class="word">账号登录</div>
                    <div class="line"></div>
                </div>
            </div>
            <Form ref="user" :model="user" :rules="userValidate">
                <FormItem prop="id">
                    <Input type="text" v-model="user.id" placeholder="账号" style="width: 300px">
                        <Icon type="md-contact" slot="prepend"/>
                    </Input>
                </FormItem>
                <FormItem prop="password">
                    <Input ref="password" type="password" v-model="user.password" @on-enter="login"
                           placeholder="密码" style="width: 300px">
                        <Icon type="md-lock" slot="prepend"/>
                    </Input>
                </FormItem>
                <FormItem prop="remember" class="remember">
                    <Checkbox v-model="remember">记住密码</Checkbox>
                </FormItem>
                <FormItem>
                    <Button type="primary" @click="login" style="width: 300px">登录</Button>
                </FormItem>
            </Form>
            <div class="title">
                <div class="body lineWord">
                    <div class="line"></div>
                    <div class="word">第三方登录</div>
                    <div class="line"></div>
                </div>
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
                userValidate: {
                    id: [
                        {required: true, message: '账号不能为空', trigger: 'blur'}
                    ],
                    password: [
                        {required: true, message: '密码不能为空', trigger: 'blur'},
                        {required: true, type: 'string', min: 6, message: '密码至少6位', trigger: 'blur'}
                    ]
                }
            };
        },
        methods: {
            login() {
                var dataCheck = false;
                this.$refs.user.validate((valid) => {
                    if (valid) {
                        dataCheck = true;
                        this.$Message.success('Success!');
                    } else {
                        this.$Message.error('Fail!');
                    }
                });
                if (true == dataCheck) {
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
                        this.$router.replace({name: "home-index"});
                    }).catch(exception => {
                        console.log(exception);
                    });
                }
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
        created() {

        },
        mounted() {
            let remember = localStorage.getItem("remember");
            if (null != remember) {
                this.remember = true;
                this.user.id = localStorage.getItem("id");
                this.user.password = localStorage.getItem("password");
                this.$refs.password.focus();
            }
        }
    };
</script>

<style lang="scss" scoped>
    .loginWindow {
        width: 100%;
        height: 100%;
        /*background: url("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1600272364591&di=a10acdde9e861f1f637c1cadb4722d73&imgtype=0&src=http%3A%2F%2Fimgfs.oppo.cn%2Fdata%2Fattachment%2Fforum%2F201407%2F27%2F232217lttjpqqsctlts688.jpg") no-repeat;*/
        /*background-size: 100% 100%;*/

        .parent {
            width: 360px;
            /*根据窗口定位*/
            position: fixed;
            right: 15%;
            /*//垂直居中*/
            top: 50%;
            transform: translateY(-50%);
            /*背景颜色白色透明*/
            background-color: rgba(255, 255, 255, .7);
            /*上下内边距0 左右内边距30px*/
            padding: 10px 30px;
            border-radius: 10px;

            .title {
                .body {
                    /*字体颜色*/
                    color: #000;
                    /*居中*/
                    text-align: center;
                    /*下边距*/
                    margin-bottom: 10px;
                }

                .lineWord {
                    display: flex;
                    align-items: center;
                    /*padding: 1rem 0;*/
                    .line {
                        height: 2px;
                        background-color: #000;
                        flex: 1;
                    }
                    .word {
                        margin: 0 10px;
                    }
                }

                /*第三方登录鼠标移过去变小手*/
                .thirdLogin:hover {
                    cursor: pointer;
                }
            }

        }
    }
</style>