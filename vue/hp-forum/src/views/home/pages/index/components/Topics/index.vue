<template>
    <div class="topics">
        专题列表
        <TopicCtrl></TopicCtrl>
        <Row>
            <Col :xs="24" :sm="8" v-for="item in 3" :key="item">
                <div class="topics-topic topics-topic-hot">
                    <div style="width:100%;height: 100px;background: cornflowerblue"></div>ColHot</div>
            </Col>
            <Col :xs="24" :sm="8" :lg="4" v-for="item in topicList" :key="item">
                <div class="topics-topic">Col</div>
            </Col>
        </Row>
    </div>
</template>

<script>
    import TopicCtrl from "./TopicCtrl"
    export default {
        components:{TopicCtrl},
        data() {
            return {
                topicList: 7
            }
        }
    }
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