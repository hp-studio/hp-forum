import Vue from "vue";
import VueRouter from "vue-router";
Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    redirect: "/home"
  },
  {
    path: "/home",
    name: "home",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ "../views/home"),
    children: [
      {
        path: "",
        name: "home-index",
        component: () => import("../views/home/pages/index/"),
        meta: {
          homeMenuName: "home-index"
        }
      },
      {
        path: "news",
        name: "home-news",
        component: () => import("../views/home/pages/news/"),
        meta: {
          homeMenuName: "home-news"
        }
      },
      {
        path: "notice",
        name: "home-notice",
        component: () => import("../views/home/pages/notice/"),
        meta: {
          homeMenuName: "home-notice"
        }
      }
    ]
  }
];

const router = new VueRouter({
  routes
});

export default router;
