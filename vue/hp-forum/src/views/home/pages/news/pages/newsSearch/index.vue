<template>
    <div class="news-search">
        <div class="newsList">
            <div v-for="item in newsList" :key="item.id" class="list-items">{{item.title}}</div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "newsSearch",
        data() {
            return {
                newsList: [
                    {
                        id: 1,
                        title: "科技改变生活",
                        content: "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusantium aliquam aperiam assumenda at autem consequuntur, cumque dolorum esse est et ex harum illum iusto laboriosam laudantium modi officiis pariatur perferendis perspiciatis porro possimus praesentium provident quae quas quia quisquam quod quos recusandae sapiente sit soluta tenetur unde vitae. Consequatur debitis distinctio dolores eligendi ipsum mollitia nesciunt possimus quasi quisquam tempore. Dicta minus nihil nulla quam quo. Deserunt dicta eaque iure modi molestias perspiciatis quis repellat, repellendus rerum voluptatum. Animi commodi, dolorem eius eligendi eos eum eveniet excepturi exercitationem ipsam minima mollitia natus nihil perferendis porro quisquam reiciendis repellat rerum voluptas.\n",
                    },
                    {
                        id: 2,
                        title: "科技改变生活",
                        content: "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusantium aliquam aperiam assumenda at autem consequuntur, cumque dolorum esse est et ex harum illum iusto laboriosam laudantium modi officiis pariatur perferendis perspiciatis porro possimus praesentium provident quae quas quia quisquam quod quos recusandae sapiente sit soluta tenetur unde vitae. Consequatur debitis distinctio dolores eligendi ipsum mollitia nesciunt possimus quasi quisquam tempore. Dicta minus nihil nulla quam quo. Deserunt dicta eaque iure modi molestias perspiciatis quis repellat, repellendus rerum voluptatum. Animi commodi, dolorem eius eligendi eos eum eveniet excepturi exercitationem ipsam minima mollitia natus nihil perferendis porro quisquam reiciendis repellat rerum voluptas.\n",
                    },
                    {
                        id: 3,
                        title: "科技改变生活",
                        content: "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusantium aliquam aperiam assumenda at autem consequuntur, cumque dolorum esse est et ex harum illum iusto laboriosam laudantium modi officiis pariatur perferendis perspiciatis porro possimus praesentium provident quae quas quia quisquam quod quos recusandae sapiente sit soluta tenetur unde vitae. Consequatur debitis distinctio dolores eligendi ipsum mollitia nesciunt possimus quasi quisquam tempore. Dicta minus nihil nulla quam quo. Deserunt dicta eaque iure modi molestias perspiciatis quis repellat, repellendus rerum voluptatum. Animi commodi, dolorem eius eligendi eos eum eveniet excepturi exercitationem ipsam minima mollitia natus nihil perferendis porro quisquam reiciendis repellat rerum voluptas.\n",
                    },
                    {
                        id: 4,
                        title: "科技改变生活",
                        content: "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusantium aliquam aperiam assumenda at autem consequuntur, cumque dolorum esse est et ex harum illum iusto laboriosam laudantium modi officiis pariatur perferendis perspiciatis porro possimus praesentium provident quae quas quia quisquam quod quos recusandae sapiente sit soluta tenetur unde vitae. Consequatur debitis distinctio dolores eligendi ipsum mollitia nesciunt possimus quasi quisquam tempore. Dicta minus nihil nulla quam quo. Deserunt dicta eaque iure modi molestias perspiciatis quis repellat, repellendus rerum voluptatum. Animi commodi, dolorem eius eligendi eos eum eveniet excepturi exercitationem ipsam minima mollitia natus nihil perferendis porro quisquam reiciendis repellat rerum voluptas.\n",
                    },
                    {
                        id: 5,
                        title: "科技改变生活",
                        content: "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusantium aliquam aperiam assumenda at autem consequuntur, cumque dolorum esse est et ex harum illum iusto laboriosam laudantium modi officiis pariatur perferendis perspiciatis porro possimus praesentium provident quae quas quia quisquam quod quos recusandae sapiente sit soluta tenetur unde vitae. Consequatur debitis distinctio dolores eligendi ipsum mollitia nesciunt possimus quasi quisquam tempore. Dicta minus nihil nulla quam quo. Deserunt dicta eaque iure modi molestias perspiciatis quis repellat, repellendus rerum voluptatum. Animi commodi, dolorem eius eligendi eos eum eveniet excepturi exercitationem ipsam minima mollitia natus nihil perferendis porro quisquam reiciendis repellat rerum voluptas.\n",
                    },
                    {
                        id: 6,
                        title: "科技改变生活",
                        content: "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusantium aliquam aperiam assumenda at autem consequuntur, cumque dolorum esse est et ex harum illum iusto laboriosam laudantium modi officiis pariatur perferendis perspiciatis porro possimus praesentium provident quae quas quia quisquam quod quos recusandae sapiente sit soluta tenetur unde vitae. Consequatur debitis distinctio dolores eligendi ipsum mollitia nesciunt possimus quasi quisquam tempore. Dicta minus nihil nulla quam quo. Deserunt dicta eaque iure modi molestias perspiciatis quis repellat, repellendus rerum voluptatum. Animi commodi, dolorem eius eligendi eos eum eveniet excepturi exercitationem ipsam minima mollitia natus nihil perferendis porro quisquam reiciendis repellat rerum voluptas.\n",
                    },
                ]
            };
        },
    };
</script>

<style lang="scss" scoped>

</style>
