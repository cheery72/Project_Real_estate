<template>
    <div>
        <b-form-input
            v-model="text"
            placeholder="댓글을 입력해주세요."
            @keyup.enter="regist"
        ></b-form-input>
    </div>
</template>

<script>
import { mapActions } from "vuex";

const commentStore = "commentStore";

export default {
    props: ["rbno"],
    data() {
        return {
            text: "",
        };
    },
    methods: {
        ...mapActions(commentStore, ["regComment"]),
        regist() {
            if (this.text)
                this.regComment({ bno: this.rbno, comments: this.text });
        },
    },
};
</script>

<style></style>
