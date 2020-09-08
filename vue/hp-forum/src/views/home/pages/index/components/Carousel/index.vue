<template>
    <Carousel autoplay v-model="activeItem" loop>
        <CarouselItem>
            <div class="demo-carousel">1</div>
        </CarouselItem>
        <CarouselItem>
            <div class="demo-carousel">2</div>
        </CarouselItem>
        <CarouselItem>
            <div class="demo-carousel">3</div>
        </CarouselItem>
        <CarouselItem>
            <div class="demo-carousel">4</div>
        </CarouselItem>
    </Carousel>
</template>

<script>
    export default {
        name: "home-index-carousel",
        data() {
            return {
                activeItem: 0
            }
        }
    }
</script>

<style lang="scss" scoped>
    .demo-carousel {
        height: 200px;
        background: pink
    }
</style>