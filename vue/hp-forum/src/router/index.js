import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);

const routes = [
    {
        path: "/",
        //进入默认路由后跳转至默认页面
        redirect: "/home"
    },
    {
        path: "/home",
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        //用于懒加载路由提高性能
        component: () => import(/* webpackChunkName: "about" */ "../views/home"),
        children: [
            {
                path: "",
                name: "home-index",
                //用于懒加载路由提高性能
                component: () => import("../views/home/pages/index/"),
                meta: {
                    //用于识别顶部导航归属关系
                    homeMenuName: "home-index"
                }
            },
            {
                path: "news",
                name: "home-news",
                //用于懒加载路由提高性能
                component: () => import("../views/home/pages/news/"),
                meta: {
                    //用于识别顶部导航归属关系
                    homeMenuName: "home-news"
                }
            },
            {
                path: "notice/",
                //用于懒加载路由提高性能
                component: () => import("../views/home/pages/notice/"),
                meta: {
                    //用于识别顶部导航归属关系
                    homeMenuName: "home-notice"
                },
                children: [
                    {
                        path: "",
                        //如果有默认路由 则忽略父路由的name
                        name: "home-notice",
                        //用于懒加载路由提高性能
                        component: () => import("../views/home/pages/notice/pages/noticeList"),
                        meta: {
                            //用于识别顶部导航归属关系
                            homeMenuName: "home-notice"
                        },
                    },
                    {
                        path: "noticePage",
                        name: "home-notice-noticePage",
                        //用于懒加载路由提高性能
                        component: () => import("../views/home/pages/notice/pages/noticePage"),
                        meta: {
                            //用于识别顶部导航归属关系
                            homeMenuName: "home-notice"
                        },
                    }
                ]
            }
        ]
    },
    {
        path: "/login",
        name: "login",
        //用于懒加载路由提高性能
        component: () => import("../views/login")
    }
];

const router = new VueRouter({
    routes
});

export default router;
