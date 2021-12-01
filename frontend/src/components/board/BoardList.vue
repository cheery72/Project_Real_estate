<template>
    <div>
        <div v-if="check">
            <div v-for="(item, index) in boardList" :key="index">
                <board-list-row :board="item" :idx="index" />
            </div>
        </div>
    </div>
</template>

<script>
import { mapState, mapActions } from "vuex";
import BoardListRow from "@/components/board/BoardListRow.vue";

const boardStore = "boardStore";

export default {
    data() {
        return {
            check: true,
        };
    },
    watch: {
        apt(info) {
            this.check = true;
            this.getBoard(info);
        },
    },
    computed: {
        ...mapState(["apt"]),
        ...mapState(boardStore, ["boardList"]),
    },
    components: {
        BoardListRow,
    },
    methods: {
        ...mapActions(boardStore, ["getBoard"]),
    },
};
</script>

<style></style>
