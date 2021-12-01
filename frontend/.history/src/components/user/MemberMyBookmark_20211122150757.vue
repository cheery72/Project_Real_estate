<template>
  <div>
    {{apt}}
<!-- 
    <button v-if="show" @click="addBookmark">북마크추가</button>
    <button v-else @click="deleteBookmark">북마크취소</button> -->

    <button>북마크</button>
  </div>
</template>

<script>
import {mapState} from "vuex";

export default {
    name: "MemberMyBookmark",
    data() {
        return {

        }
    },
    computed:{
        ...mapState(["apt"]),
    },



}
</script>

<style>

</style>