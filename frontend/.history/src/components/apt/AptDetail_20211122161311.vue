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
import {mapState} from "vuex";

export default {
    data() {
        return {
            bookmarkItems: []
        }
    },
    
    computed:{
        ...mapState(["apt"]),
    },

    methods: {
      addBookmark(){
        if(localStorage.length>0){
          for(var i=0; i<localStorage.length; i++){
            // this.bookmarkItems.push(localStorage.key(i));
            localStorage.setItem(this.bookmarkItems, this.value);
            console.log(localStorage.getItem("bookmarkItems"));

          }
        }
      }
    },


}
</script>

<style>

</style>