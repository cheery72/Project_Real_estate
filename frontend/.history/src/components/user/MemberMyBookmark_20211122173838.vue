<template>
  <div>

      어어어어어....내 관심아파트
    {{apt}}
<!-- 
    <button v-if="show" @click="addBookmark">북마크추가</button>
    <button v-else @click="deleteBookmark">북마크취소</button> -->

 
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
        ...mapState(["bookmark"]),
    },

}
</script>

<style>

</style>