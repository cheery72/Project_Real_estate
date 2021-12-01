<template>
  <div>
    {{apt}}
<!-- 
    <button v-if="show" @click="addBookmark">북마크추가</button>
    <button v-else @click="deleteBookmark">북마크취소</button> -->

    <button @click="addBookmark" :value="apt">북마크</button>
  </div>
</template>

<script>
import {mapState} from "vuex";

export default {
    data() {
        return {

        }
    },
    
    computed:{
        ...mapState(["apt"]),
    },

    methods: {
      ...mapActions(["detailBookmark"]),
       addBookmark(){
         this.detailBookmark(this.apt);
       }
      
     }




}
</script>

<style>

</style>