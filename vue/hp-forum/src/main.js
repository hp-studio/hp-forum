import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";

//  注册axios（待封装）
import axios from "axios";

Vue.prototype.$axios = axios;
//  全局注册工具类
import utils from "./utils";

Vue.prototype.$utils = utils;
//  全局注册alert方法
Vue.prototype.$alert = utils.alert;
//  注册全局组件
import {BackupBtn} from "./components";

Vue.component('BackupBtn', BackupBtn);

//注册iViewUI
import ViewUI from "view-design";
import "view-design/dist/styles/iview.css";

Vue.use(ViewUI);

//注册富文本编辑器
import VueQuillEditor from 'vue-quill-editor';
import 'quill/dist/quill.core.css'; // import styles
import 'quill/dist/quill.snow.css'; // for snow theme
import 'quill/dist/quill.bubble.css'; // for bubble theme
Vue.use(VueQuillEditor, /* { default global options } */);

Vue.config.productionTip = false;

new Vue({
    router,
    store,
    render: h => h(App)
}).$mount("#app");
