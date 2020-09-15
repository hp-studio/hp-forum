<template>
    <div class="topics">
        专题列表
        <TopicCtrl></TopicCtrl>
        <Row>
            <Col :xs="24" :sm="8" v-for="item in topicList.slice(0,3)" :key="item.title">
                <div class="topics-topic topics-topic-hot">
                    <div style="width:100%;height: 100px;background: cornflowerblue"></div>
                    {{item.title}}
                </div>
            </Col>
            <Col :xs="24" :sm="8" :lg="4" v-for="item in topicList.slice(3)" :key="item.title">
                <div class="topics-topic">{{item.title}}</div>
            </Col>
        </Row>
    </div>
</template>

<script>
    import TopicCtrl from "./TopicCtrl";

    export default {
        components: {TopicCtrl},
        data() {
            return {
                topicList: [
                    {title: "1"},
                    {title: "2"},
                    {title: "3"},
                    {title: "4"},
                    {title: "5"},
                    {title: "6"},
                    {title: "7"},
                    {title: "8"},
                    {title: "9"}
                ]
            };
        }
    };
</script>

<style lang="scss" scoped>
    .topics {
        padding: .5rem;

        .topics-topic {
            padding: .5rem;
            margin: .5rem;
            border: 1px solid #eee;
            border-radius: 6px;
            cursor: pointer;
            transition: all .3s ease-in-out;
        }

        .topics-topic:hover {
            box-shadow: 2px 2px 2px rgba(0, 0, 0, .1)


        }

        .topics-topic-hot {

        }
    }
</style>