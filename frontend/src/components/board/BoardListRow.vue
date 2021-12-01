<template>
    <div>
        <div v-if="check">
            <div @click="change">
                <b-card :title="board.userId">
                    <div>
                        <b-card-text>
                            {{ board.content }}
                            <br />
                            <br />
                            <div style="float: right">
                                {{ board.regdate }}
                            </div>
                        </b-card-text>
                    </div>
                </b-card>
            </div>
            <b-modal id="modal-1" hide-footer :title="board.userid">
                <p class="my-4">{{ board.content }}</p>
                <comment-write :rbno="board.bno" />
                <comment-list />
            </b-modal>
            <b-button v-b-modal.modal-1 style="float: right"
                >댓글 확인</b-button
            >
            <br />
            <br />
        </div>
        <div v-else>
            <b-form-input
                v-model="text"
                :placeholder="board.content"
            ></b-form-input>
            <b-button @click="modify(board.bno, idx)">수정하기</b-button>
            <b-button @click="del(board.bno, idx)">삭제하기</b-button>
        </div>
        <!-- <b-button @click="gComment(board.bno)">댓글 보기</b-button> -->
    </div>
</template>

<script>
import { mapState, mapActions } from "vuex";
import CommentWrite from "@/components/board/CommentWrite.vue";
import CommentList from "@/components/board/CommentList.vue";

const boardStore = "boardStore";
const commentStore = "commentStore";

export default {
    props: ["board", "idx"],
    data() {
        return {
            check: true,
            text: "",
        };
    },
    watch: {},
    components: {
        CommentWrite,
        CommentList,
    },
    computed: {
        ...mapState(["apt"]),
    },

    methods: {
        ...mapActions(boardStore, ["modiBoard", "delBoard"]),
        ...mapActions(commentStore, ["getComment"]),
        change() {
            this.check = false;
        },
        modify(bno, idx) {
            if (this.text)
                this.modiBoard({
                    bno: bno,
                    aptCode: this.apt.aptCode,
                    content: this.text,
                    idx: idx,
                });
            this.check = true;
        },
        del(bno, idx) {
            this.delBoard({ bno: bno, idx: idx });
            this.check = true;
        },
        gComment(bno) {
            console.log(bno);
            this.getComment(bno);
        },
    },
};
</script>

<style></style>
