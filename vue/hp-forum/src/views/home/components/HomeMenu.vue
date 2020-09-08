<template>
  <div class="home-menu">
    <div class="home-menu-item home-menu-logo">
      hp-forum
    </div>
    <Menu
      mode="horizontal"
      style="flex:1"
      :active-name="activeName"
      @on-select="onMenuSelected"
    >
      <MenuItem name="home-index">
        <Icon type="ios-home" />
        首页
      </MenuItem>
      <MenuItem name="home-news">
        <Icon type="ios-paper" />
        新闻
      </MenuItem>
      <MenuItem name="home-notice">
        <Icon type="ios-megaphone" />
        公告
      </MenuItem>
    </Menu>
    <div class="home-menu-item">
      <Input search placeholder="请输入搜索内容" />
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
  data() {
    return {
      activeName: this.$route.meta.homeMenuName
    };
  },
  mounted() {
    //  监听路由
    this.$router.beforeEach((to, from, next) => {
      // ...
      this.activeName = to.meta.homeMenuName || "";
      next();
    });
  },
  methods: {
    // 监听导航点击
    onMenuSelected(MenuItemName) {
      if (MenuItemName !== this.activeName) {
        this.$router.push({
          name: MenuItemName
        });
      }
    }
  }
};
</script>

<style lang="scss" scoped>
.home-menu {
  display: flex;
  align-items: center;

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
</style>
