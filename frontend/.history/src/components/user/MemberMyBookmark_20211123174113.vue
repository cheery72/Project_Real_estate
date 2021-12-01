<template>
  <div>
    
      어어어어어....내 관심아파트


    
<!-- 
    <button v-if="show" @click="addBookmark">북마크추가</button>
    <button v-else @click="deleteBookmark">북마크취소</button> -->

 
  </div>
</template>

<script>
import http from "@/js/http-common";
import jwt_decode from "jwt-decode";

// const memberStore = "memberStore";

export default {
    name: "MemberMyBookmark",
    data() {
        return {
            bookmarks: []
        }
    },
    created() {


    let decode_token = jwt_decode(sessionStorage.getItem("access-token"));
      console.log("디코드아이디22"+decode_token.userid);
     

    http.get(`/bookmark/list`).then(({ data }) => {
      this.bookmarks = data;
        console.log("나와??", this.bookmarks);
        console.log("나와22??", this.bookmarks.result);
    });
    },
    

}
</script>

<style>

</style>