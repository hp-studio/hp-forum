<template>
    <div class="home-menu" :class="{'home-menu-hasShadow':hasShadow}">
        <div class="home-menu-item home-menu-logo">
            hp-forum

        </div>
        <Menu
                mode="horizontal"
                style="flex:1"
                :active-name="activeName"
                @on-select="handleMenuSelect"
        >
            <MenuItem name="index">
                <Icon type="ios-home"/>
                首页
            </MenuItem>
            <MenuItem name="news">
                <Icon type="ios-paper"/>
                新闻
            </MenuItem>
            <MenuItem name="notice">
                <Icon type="ios-megaphone"/>
                公告
            </MenuItem>
        </Menu>
        <div class="home-menu-item">
            <Input
                    search
                    placeholder="请输入搜索内容"
                    v-model="searchWord"
                    @on-search="handleSearch(searchWord)"
            />
        </div>
        <div class="home-menu-item home-menu-self">
            <!--      判断用户是否登陆-->
            <template v-if="$store.state.user.userStat">
                <Button
                        title="消息"
                        class="home-menu-self-item"
                        shape="circle"
                        icon="ios-chatboxes"
                ></Button>
                <Avatar
                        title="个人设置"
                        class="home-menu-self-item home-menu-self-avatar"
                        src="https://i.loli.net/2017/08/21/599a521472424.jpg"
                />
            </template>
            <Avatar
                    title="请登录"
                    v-else
                    class="home-menu-self-item home-menu-self-avatar"
                    icon="ios-person"
            />
        </div>
    </div>
</template>

<script>
    export default {
        name: "HomeMenu",
        props: {
            hasShadow: {
                default: false
            },
        },
        data() {
            return {
                activeName: this.$route.meta.homeMenuName,
                searchWord: ""
            };
        },

        mounted() {
            //  监听路由
            this.$router.beforeEach((to, from, next) => {
                // ...
                console.log(to.meta.homeMenuName);
                this.activeName = to.meta.homeMenuName || "";
                next();
            });
        },
        methods: {
            // 监听导航点击
            handleMenuSelect(MenuItemName) {
                if (MenuItemName !== this.activeName) {
                    this.$router.push({
                        name: MenuItemName
                    });
                }
            },
            // 搜索
            handleSearch(searchWord) {
                console.log("搜索中，搜索内容为：" + searchWord);
            }
        }
    };
</script>

<style lang="scss" scoped>
    .home-menu {
        height: 60px;
        display: flex;
        align-items: center;
        position: relative;
        z-index: 1;
        transition: all .3s ease-in-out;

        .home-menu-item {
            height: 60px;
            line-height: 60px;
            display: inline-block;
            border-bottom: 1px solid #dcdee2;
        }

        .home-menu-logo {
            width: 200px;
            text-align: center;
            font-family: fantasy;
        }

        .home-menu-self {
            padding: 0 1rem;

            .home-menu-self-avatar {
                border: 1px solid transparent;
                transition: all 0.3s ease-in-out;
            }

            .home-menu-self-avatar:hover {
                cursor: pointer;
                border-color: #57a3f3;
            }
        }

        .home-menu-self-item {
            margin: 0 10px;
        }
    }

    .home-menu-hasShadow {
        box-shadow: 2px 2px 10px rgba(0, 0, 0, .5)
    }
</style>
