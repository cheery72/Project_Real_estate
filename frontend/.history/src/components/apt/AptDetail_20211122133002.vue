<template>
  <div>
    {{apt}}

    <button v-if="show" @click="addBookmark">북마크추가</button>
    <button v-else @click="deleteBookmark">북마크취소</button>
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


    //  selectApt($event){
    //     var no = $event.target.getAttribute('value');
    //     this.detailApt(no);
    //   }



}
</script>

<style>

</style>