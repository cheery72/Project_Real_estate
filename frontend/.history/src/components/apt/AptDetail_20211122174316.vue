<template>
  <div>
    {{apt}}
<!-- 
    <button v-if="show" @click="addBookmark">북마크추가</button>
    <button v-else @click="deleteBookmark">북마크취소</button> -->
    <button @click="addBookmark" :value="apt">관심아파트등록</button>
  </div>
</template>

<script>
import {mapState, mapMutations} from "vuex";

const memberStore = "memberStore";

export default {
    data() {
        return {
        
        }
    },
    
    computed:{
        ...mapState(["apt"]),
    },

    methods: {
      ...mapMutations(memberStore,["SET_BOOKMARK_LIST"]),
      addBookmark(){
        this.SET_BOOKMARK_LIST(this.apt);
      }
    },
}
</script>

<style>

</style>