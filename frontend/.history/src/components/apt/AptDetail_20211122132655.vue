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


     selectApt($event){
        var no = $event.target.getAttribute('value');
        this.detailApt(no);
      }



       /*북마크(관심매물 추가)*/
    // addBookmark($event) {
    //   var no = $event.target.getAttribute('value');
    //   console.log(no);
     
    //   // let house = {
    //   //           city: this.city,
    //   //           gugun: this.gugun,
    //   //           id: this.userInfo.id,
    //   //           no: this.no,
    //   //           dong: this.dong,
    //   //           aptName: this.aptName,
    //   //           code: this.code,
    //   //           buildYear: this.buildYear,
    //   //           jibun: this.jibun,
    //   //           lat: this.lat,
    //   //           lng: this.lng,
    //   //       };
    //         this.$store.dispatch("addBookmarkList", no);
    //         // this.$store.dispatch("getBookmarkList", this.userInfo.id);
    //         this.show = false;
    
    // }


}
</script>

<style>

</style>