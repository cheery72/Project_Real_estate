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
import {mapState, mapActions} from "vuex";

export default {
    data() {
        return {
        
        }
    },
    
    computed:{
        ...mapState(["apt"]),
    },

    methods: {
      ...mapMutations(["SET_BOOKMARK_LIST],),
      addBookmark(){
        
      }
    },
}
</script>

<style>

</style>