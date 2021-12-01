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
    userid: String,
  },
  computed: {
  
    // changeDateFormat() {
    //   return moment(new Date(this.regtime)).format("YY.MM.DD hh:mm:ss");
    // },
  },

  methods: {

      deleteBookmark(){
           let decode_token = jwt_decode(sessionStorage.getItem("access-token"));
            const userid= decode_token.userid;
           
            const params = { accesstoken: decode_token.userid };

             console.log(params);

           const aptCode=this.aptCode;

    http.delete(`/bookmark/list/${userid,aptCode}`).then(({ data }) => {
        this.bookmarks = data;
        console.log("북마크출력", this.bookmarks);
        console.log("북마크 리스트 출력", this.bookmarks.result);
    });
   
    },
    
     },
    
  },
};
</script>

<style></style>
