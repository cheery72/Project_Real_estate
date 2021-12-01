<template>
    <div>
        <div v-if="check">
            <br />
            <div @click="change">
                <b-card>
                    {{ comment.comment_userid }}
                    {{ comment.comments }}
                    {{ comment.comment_likes }}
                    {{ comment.comment_regdate }}
                </b-card>
            </div>
        </div>
        <div v-else>
            <b-form-input v-model="text" :placeholder="comment.comments"></b-form-input>
            <b-button @click="modify(comment.rno, cidx)">수정하기</b-button>
            <b-button @click="del(comment.rno, cidx)">삭제하기</b-button>
        </div>
    </div>
</template>

<script>
import { mapState, mapActions } from "vuex";

const commentStore = "commentStore";

export default {
    props: ["comment", "cidx"],
    data() {
        return {
            check: true,
            text: "",
        };
    },
    computed: {
        ...mapState(["bno"]),
    },

    methods: {
        ...mapActions(commentStore, ["modiComment", "delComment"]),
        change() {
            this.check = false;
        },
        modify(rno, cidx) {
            if (this.text)
                this.modiComment({ rno: rno, comments: this.text, idx: cidx });
            this.check = true;
        },
        del(rno, cidx) {
            this.delComment({ rno: rno, idx: cidx });
            this.check = true;
        },
    },
};
</script>

<style></style>
