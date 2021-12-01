<template>
    <div>
        <b-card title="아파트 상세정보" sub-title="">
            <b-card-text>
                아파트명: {{ apt.aptName }}
                <br />
                주소: {{ apt.sidoName }}
                {{ apt.dongName }}
                {{ apt.gugunName }}
                <br />
                건축년도: {{ apt.buildYear }}
                <br />
                매매가: {{ apt.recentPrice }}
                <br />
                CCTV 개수: {{ cctvCount }}
            </b-card-text>
            <b-button variant="light" @click="addBookmark" :value="apt"
                >관심아파트등록</b-button
            >
        </b-card>
    </div>
</template>

<script>
import { mapState, mapActions } from "vuex";
const memberStore = "memberStore";
const alertStore = "alertStore";

export default {
    props: ["count"],
    data() {
        return {};
    },

    computed: {
        ...mapState(["apt", "cctvCount"]),
    },

    methods: {
        // ...mapMutations(memberStore,["SET_BOOKMARK_LIST"]),
        ...mapActions(memberStore, ["getBookmark"]),
        ...mapActions(alertStore, ["openAlertDialog"]),

        addBookmark() {
            this.getBookmark(this.apt);
            alert("즐겨찾기에 등록되었습니다.");
        },
    },
};
</script>

<style></style>
