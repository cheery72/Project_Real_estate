<template>
    <div>
        <member-badge></member-badge>
        <b-form-textarea
            v-model="text"
            placeholder="내용을 입력해주세요."
        ></b-form-textarea>
        <b-button @click="regist" style="display: block; float: right"
            >등록하기</b-button
        >
        <br />
        <br />
    </div>
</template>

<script>
import MemberBadge from "@/components/board/MemberBadge.vue";
import { mapState, mapActions } from "vuex";

const boardStore = "boardStore";

export default {
    data() {
        return {
            text: "",
        };
    },
    computed: {
        ...mapState(["apt"]),
    },
    components: {
        MemberBadge,
    },
    methods: {
        ...mapActions(boardStore, ["regBoard"]),
        regist() {
            if (this.text) {
                this.regBoard({ aptCode: this.apt.aptCode, text: this.text });
                this.text = "";
            }
        },
    },
};
</script>

<style></style>
