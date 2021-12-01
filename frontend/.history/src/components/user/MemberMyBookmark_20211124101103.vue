<template>
  <div>
    
      어어어어어....내 관심아파트


    <book-mark-list-row
        v-for="(bookmark, index) in bookmarks.result"
        :key="index"
        v-bind="bookmark"
    />

  </div>
</template>

<script>
import BookMarkListRow from "@/components/user/BookMarkListRow.vue";


import http from "@/js/http-common";
import jwt_decode from "jwt-decode";
import { mapState, mapActions } from 'vuex';

// const memberStore = "memberStore";

export default {
    name: "MemberMyBookmark",
    data() {
        return {
            bookmarks: []
        }
    },
    components: {
         BookMarkListRow,
     },
     computed:{
         ...mapState(["bookmarks"]),
     },
    created() {

        

        this.bookmarkList();
        let decode_token = jwt_decode(sessionStorage.getItem("access-token"));
        const userid= decode_token.userid;

        http.get(`/bookmark/list/${userid}`).then(({ data }) => {
            this.bookmarks = data;
            console.log("북마크조회 결과", this.bookmarks);
            console.log("북마크조회 리스트 출력", this.bookmarks.result);
    });
   
    },
    methods: {
        ...mapActions(["getBookmark"]),
        bookmarkList(){
            this.getBookmark();
        },

        

    },

    // function bookmarkListm(){
                
    //     let decode_token = jwt_decode(sessionStorage.getItem("access-token"));
    //     const userid= decode_token.userid;

    //     http.get(`/bookmark/list/${userid}`).then(({ data }) => {
    //         this.bookmarks = data;
    //         console.log("북마크조회 결과", this.bookmarks);
    //         console.log("북마크조회 리스트 출력", this.bookmarks.result);
    //        });
    // }
    

}
</script>

<style>

</style>