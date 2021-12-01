<template>
    <div>
        <b-carousel
            id="carousel-1"
            v-model="slide"
            :interval="2000"
            controls
            indicators
            background="#ababab"
            img-width="1024"
            img-height="480"
            style="text-shadow: 1px 1px 2px #333"
            @sliding-start="onSlideStart()"
            @sliding-end="onSlideEnd()"
        >
            <div v-for="image in images" :key="image.imageUrl">
                <b-carousel-slide :img-src="image.imagUrl"></b-carousel-slide>
            </div>
        </b-carousel>
    </div>
</template>

<script>
export default {
    data() {
        return {
            slide: 0,
            sliding: null,
            images: [
                {
                    imagUrl: require("../assets/1.jpg"),
                },
                {
                    imagUrl: require("../assets/2.jpg"),
                },
                {
                    imagUrl: require("../assets/3.jpg"),
                },
                {
                    imagUrl: require("../assets/4.jpg"),
                },
            ],
        };
    },
    methods: {
        onSlideStart() {
            this.sliding = true;
        },
        onSlideEnd() {
            this.sliding = false;
        },
    },
};
</script>
