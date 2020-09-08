<template>
    <div class="home-index-subjects">
        专题列表
        <Row>
            <Col :xs="24" :sm="8" v-for="item in 3" :key="item">
                <div class="home-index-subjects-subject home-index-subjects-subject-hot">
                    <div style="width:100%;height: 100px;background: cornflowerblue"></div>ColHot</div>
            </Col>
            <Col :xs="24" :sm="8" :lg="4" v-for="item in subjectList" :key="item">
                <div class="home-index-subjects-subject">Col</div>
            </Col>
        </Row>
    </div>
</template>

<script>
    export default {
        name: "home-index-subjects",
        data() {
            return {
                subjectList: 7
            }
        }
    }
</script>

<style lang="scss" scoped>
    .home-index-subjects {
        padding: .5rem;

        .home-index-subjects-subject {
            padding: .5rem;
            margin: .5rem;
            border: 1px solid #eee;
            border-radius: 6px;
            cursor: pointer;
            transition: all .3s ease-in-out;
        }

        .home-index-subjects-subject:hover {
            box-shadow: 2px 2px 2px rgba(0, 0, 0, .1)


        }

        .home-index-subjects-subject-hot {

        }
    }
</style>