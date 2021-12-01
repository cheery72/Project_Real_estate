<template>
    <div>
        <div>
            <div v-for="(item, index) in commentList" :key="index">
                <comment-list-row :comment="item" :cidx="index" />
            </div>
        </div>
    </div>
</template>

<script>
import { mapState } from "vuex";
import CommentListRow from "@/components/board/CommentListRow.vue";

const commentStore = "commentStore";

export default {
    data() {
        return {};
    },
    computed: {
        ...mapState(commentStore, ["commentList"]),
    },
    components: {
        CommentListRow,
    },
};
</script>

<style></style>
