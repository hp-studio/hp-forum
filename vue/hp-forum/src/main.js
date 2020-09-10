import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";

// 引入IView
import ViewUI from "view-design";
import "view-design/dist/styles/iview.css";
Vue.use(ViewUI);

// 引入富文本编辑器
import VueQuillEditor from 'vue-quill-editor'
import 'quill/dist/quill.core.css' // import styles
import 'quill/dist/quill.snow.css' // for snow theme
import 'quill/dist/quill.bubble.css' // for bubble theme
Vue.use(VueQuillEditor, /* { default global options } */)

Vue.config.productionTip = false;

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount("#app");
