import Vue from "vue";
import Vuex from "vuex";
//引入modules
import user from "./modules/user";

Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    user
  }
});
