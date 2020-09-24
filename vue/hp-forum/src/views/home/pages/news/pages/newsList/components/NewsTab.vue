<template>
    <Tabs :value="newsData[0].title">
        <TabPane v-for="item in newsData" :key="item.title" :label="item.title" :name="item.title">
            <div class="news-tab">
                <div class="news-cardList">
                    <Card v-for="item1 in item.news.slice().splice(0,3)" class="list-items news-card" :key="item1.id"
                          :to="cardGoNewsDetailFuncObj(item1.id)">
                        <p slot="title">{{item1.title}}</p>
                        <p>Content of card</p>
                        <p>Content of card</p>
                        <p>Content of card</p>
                    </Card>
                </div>

                <div v-for="item1 in item.news.slice().splice(3)" class="list-items" :key="item1.id"
                     @click="goNewsDetail(item1.id)">{{item1.title}}
                </div>

            </div>

        </TabPane>
    </Tabs>
</template>

<script>
    import {newsMixins} from "@/mixins";

    export default {
        name: "NewsTab",
        mixins: [newsMixins],
        methods: {
            test() {
                console.log("test");
            }
        },
        data() {
            return {
                newsData: [
                    {
                        title: "科技",
                        news: [{
                            id: 1,
                            title: "科技改变生活",
                            content: "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusantium aliquam aperiam assumenda at autem consequuntur, cumque dolorum esse est et ex harum illum iusto laboriosam laudantium modi officiis pariatur perferendis perspiciatis porro possimus praesentium provident quae quas quia quisquam quod quos recusandae sapiente sit soluta tenetur unde vitae. Consequatur debitis distinctio dolores eligendi ipsum mollitia nesciunt possimus quasi quisquam tempore. Dicta minus nihil nulla quam quo. Deserunt dicta eaque iure modi molestias perspiciatis quis repellat, repellendus rerum voluptatum. Animi commodi, dolorem eius eligendi eos eum eveniet excepturi exercitationem ipsam minima mollitia natus nihil perferendis porro quisquam reiciendis repellat rerum voluptas.\n",
                        }]
                    },
                    {
                        title: "军事",
                        news: []
                    },
                    {
                        title: "生活",
                        news: [
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
                    }
                ]
            };
        },
    };
</script>

<style lang="scss" scoped>
    .news-tab {
        padding: 0 1rem;

        .news-cardList {
            display: flex;

            .news-card {
                display: inline-block;
                flex: 1
            }
        }


    }

</style>
