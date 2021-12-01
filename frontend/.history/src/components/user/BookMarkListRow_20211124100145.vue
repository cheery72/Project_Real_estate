<template>
  <b-tr>
    
    <b-td>아파트코드 : {{aptCode}}</b-td>
    <b-td>아파트이름 : {{aptName}}</b-td>
    <b-td>아파트연도 : {{buildYear}}</b-td>
    <b-td>아파트동 : {{dongName}}</b-td>
    <b-td>아파트지번 : {{jibun}}</b-td>
    <b-td>아파트위도 : {{lat}}</b-td>
    <b-td>아파트경도 : {{lng}}</b-td>
    <b-td>유저아이디 : {{userid}}</b-td>

   <button @click="deleteBookmark">북마크삭제</button> 
    <!-- <b-td>{{ regtime }}</b-td> -->
  </b-tr>
</template>

<script>
// import moment from "moment";

import http from "@/js/http-common";
import jwt_decode from "jwt-decode";

export default {
    data(){
        return{
            bookmarks:[],
        }
    },
  name: "BookMarkListRow",
  props: {
    aptCode: Number,
    aptName: String,
    buildYear: Number,
    dongName: String,
    jibun: String,
    lat: String,
    lng: String,
    userid: String,
  },
  
  computed: {
      bookmarks(){
          return this.$store.state.bookmarks;
      }
  },

  methods: {

      deleteBookmark(){


            let decode_token = jwt_decode(sessionStorage.getItem("access-token"));
            const userid= decode_token.userid;
            const aptCode=this.aptCode;

            http.delete(`/bookmark/list/${userid}/${aptCode}`).then(({ data }) => {
                
            
                console.log("반환data");
                console.log(data);
            // this.bookmark.splice(index,1);

                this.$store.dispatch("getBookmark");
                
            });
      },
            bookmarkListm(){
                 let decode_token = jwt_decode(sessionStorage.getItem("access-token"));
                  const userid= decode_token.userid;

             http.get(`/bookmark/list/${userid}`).then(({ data }) => {
                 this.bookmarks = data;
                  console.log("북마크조회 결과", this.bookmarks);
                  console.log("북마크조회 리스트 출력", this.bookmarks.result);
           });
        },
            

   
     },
    
}

</script>

<style></style>
