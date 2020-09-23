import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
//引入AXIOS
import axios from "axios";
// 引入IView
import ViewUI from "view-design";
import "view-design/dist/styles/iview.css";
// 引入富文本编辑器
import VueQuillEditor from 'vue-quill-editor';
import 'quill/dist/quill.core.css'; // import styles
import 'quill/dist/quill.snow.css'; // for snow theme
import 'quill/dist/quill.bubble.css'; // for bubble theme
//注册axios（待封装）
Vue.prototype.$axios = axios;

// 引入工具类
import utils from "./utils";

Vue.prototype.$utils = utils;
//全剧注册alert方法
Vue.prototype.$alert = utils.alert;

Vue.use(ViewUI);

Vue.use(VueQuillEditor, /* { default global options } */);

Vue.config.productionTip = false;

new Vue({
    router,
    store,
    render: h => h(App)
}).$mount("#app");
