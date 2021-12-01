<template>
  <div>
    
      어어어어어....내 관심아파트

   <button @click="addBookmark2">북마크조회</button>
    
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


   
    },
    methods: {
        addBookmark2(){
    let decode_token = jwt_decode(sessionStorage.getItem("access-token"));
     // console.log("디코드아이디22"+decode_token.userid);

    //   let userid=decode_token.userid;
    //   console.log("userid"+userid);
    const userid= decode_token.userid;
     console.log("userid"+userid);
     
    const params = { accesstoken: decode_token.userid };

console.log(params);


    http.get(`/bookmark/list`, userid).then(({ data }) => {
        this.bookmarks = data;
        console.log("북마크출력", this.bookmarks);
        console.log("북마크 리스트 출력", this.bookmarks.result);
    });
        }
    },
    

}
</script>

<style>

</style>