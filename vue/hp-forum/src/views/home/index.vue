<template>
  <div class="home">
    <home-menu></home-menu>
    <router-view />
  </div>
</template>

<script>
import HomeMenu from "./components/HomeMenu";

export default {
  name: "home",
  components: { "home-menu": HomeMenu }
};
</script>

<style lang="scss" scoped>
.home {
  width: 100%;
  height: 100%;
  overflow: auto;
}
</style>
