<template>
  <b-tr>
    <b-td>{{ aptCode }}</b-td>
    <b-td>{{ aptName }}</b-td>
    <b-td>{{ buildYear }}</b-td>
    <b-td>{{ dongName }}</b-td>
    <b-td>{{ jibun }}</b-td>
    <b-td>{{ lat }}</b-td>
    <b-td>{{ lng }}</b-td>
    <!-- <b-td>유저아이디 : {{userid}}</b-td> -->

    <b-td>
      <img
        src="@/assets/delete.png"
        @click="deleteBookmark"
        width="25px"
        height="25px"
      />
    </b-td>
    <!-- <button @click="deleteBookmark">삭제</button>  -->
  </b-tr>
</template>

<script>
// import moment from "moment";

import http from "@/js/http-common";
import jwt_decode from "jwt-decode";

export default {
  name: "BookMarkListRow",
  props: {
    aptCode: Number,
    aptName: String,
    buildYear: Number,
    dongName: String,
    jibun: String,
    lat: String,
    lng: String,
    //userid: String,
  },

  computed: {
    //...mapState(["memberStore/bookmarks"]),
    bookmarks() {
      return this.$store.state.memberStore.bookmarks;
    },
  },

  methods: {
    deleteBookmark() {
      let decode_token = jwt_decode(sessionStorage.getItem("access-token"));
      const userid = decode_token.userid;
      const aptCode = this.aptCode;

      http.delete(`/bookmark/list/${userid}/${aptCode}`).then(({ data }) => {
        console.log("반환data");
        console.log(data);
        // this.bookmark.splice(index,1);
        this.$store.dispatch("memberStore/getBookmarkList");
      });
    },
  },
};
</script>

<style></style>
