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
                //如果有默认路由 则忽略父路由的name
                name: "index",
                //用于懒加载路由提高性能
                component: () => import("../views/home/pages/index/"),
                meta: {
                    //用于识别顶部导航归属关系
                    homeMenuName: "index"
                }
            },
            {
                path: "news",
                //用于懒加载路由提高性能
                component: () => import("../views/home/pages/news/"),
                children: [
                    {
                        path: "",
                        name: "news",
                        component: () => import("../views/home/pages/news/pages/newsList"),
                        meta: {
                            //用于识别顶部导航归属关系
                            homeMenuName: "news"
                        },
                    },
                    {
                        path: "search",
                        name: "news-search",
                        component: () => import("../views/home/pages/news/pages/newsSearch"),
                        meta: {
                            //用于识别顶部导航归属关系
                            homeMenuName: "news"
                        },
                    },
                    {
                        path: "detail",
                        name: "news-detail",
                        component: () => import("../views/home/pages/news/pages/newsDetail"),
                        meta: {
                            //用于识别顶部导航归属关系
                            homeMenuName: "news"
                        },
                    },
                ]
            },
            {
                path: "notice/",
                //用于懒加载路由提高性能
                component: () => import("../views/home/pages/notice/"),
                children: [
                    {
                        path: "",
                        //如果有默认路由 则忽略父路由的name
                        name: "notice",
                        //用于懒加载路由提高性能
                        component: () => import("../views/home/pages/notice/pages/noticeList"),
                        meta: {
                            //用于识别顶部导航归属关系
                            homeMenuName: "notice"
                        },
                    },
                    {
                        path: "noticePage",
                        name: "noticePage",
                        //用于懒加载路由提高性能
                        component: () => import("../views/home/pages/notice/pages/noticePage"),
                        meta: {
                            //用于识别顶部导航归属关系
                            homeMenuName: "notice"
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
//修复路由重复点击报错的问题
const originalPush = VueRouter.prototype.push;
VueRouter.prototype.push = function push(location) {
    return originalPush.call(this, location).catch(err => err);
};

const router = new VueRouter({
    routes
});


export default router;
