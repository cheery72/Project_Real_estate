<template>
    <div>
        <b-container class="bv-example-row text-center">
            <div class="home">
                <b-row>
                    <b-col>
                        <apt-search-bar></apt-search-bar>
                    </b-col>
                </b-row>
            </div>
        </b-container>
        <kakao-map />
    </div>
</template>

<script>
import KakaoMap from "@/components/KakaoMap.vue";
import AptSearchBar from "@/components/apt/AptSearchBar.vue";

export default {
    name: "AptMap",

    data() {
        return {};
    },
    components: {
        KakaoMap,
        AptSearchBar,
    },
};
</script>

<style></style>
