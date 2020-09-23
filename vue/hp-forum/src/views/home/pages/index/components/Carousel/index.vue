<template>
    <div class="carousel">
        <Carousel autoplay v-model="activeItem" loop>
            <CarouselItem>
                <div class="carousel-item">1</div>
            </CarouselItem>
            <CarouselItem>
                <div class="carousel-item">2</div>
            </CarouselItem>
            <CarouselItem>
                <div class="carousel-item">3</div>
            </CarouselItem>
            <CarouselItem>
                <div class="carousel-item">4</div>
            </CarouselItem>
        </Carousel>
    </div>

</template>

<script>
    export default {
        data() {
            return {
                activeItem: 0
            }
        }
    }
</script>

<style lang="scss" scoped>
    .carousel {
        /*margin:1rem;*/
        .carousel-item {
            cursor: pointer;
            height: 200px;
            background: pink
        }
    }

</style>
