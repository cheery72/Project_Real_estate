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
        
        }
    },
    
    computed:{
        ...mapState(["apt"]),
    },

    methods: {
      addBookmark(){
        var bookmark = this.apt.aptCode;
        console.log(bookmark);
        
        console.log(this.user);
        // http
        //   .post('/bookmark', {
        //     userSeq: this.getUserSeq,
        //     dealNo: bookmark,
        //   })
        //   .then(({ data }) => {
        //     console.log('insertBookmark!!!!!!');
        //     console.log(data);
        //     if (data.result == 'login') {
        //       router.push('/login');
        //     }
        //     this
        //   .$alertify
        //    .success("관심매물이 등록되었습니다.");
        //   })
        //   .catch((error) => {
        //     console.log(error);
        //   });
      }
    },
}
</script>

<style>

</style>