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
        var bookmark = $event.target.getAttribute('value');
        console.log(bookmark);
      // const axios = require('axios');
      // axios
      //   .get(`${MY_SERVER_HOST}attention/bookmark/${this.fetchedUserId}/${no}`)
      //   .then((response) => {
      //     console.log(response);
      //     if (response.data == 'Allow') {
      //       axios
      //         .post(
      //           `${MY_SERVER_HOST}attention/bookmark/${this.fetchedUserId}/${no}`
      //         )
      //         .then(() => {
      //           this.makeAddBockMarkSuccessToast();
      //         })
      //         .catch(() => {
      //           this.makeAddBookMarkServerFailToast();
      //         });
      //     } else {
      //       this.makeAddBookMarkFailToast();
      //     }
      //   })
      //   .catch(() => {
      //     this.makeAddBookMarkServerFailToast();
      //   });
      }
    },


}
</script>

<style>

</style>