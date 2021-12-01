<template>
  <b-tr>
    <b-td>{{ bookmark_apt_name}}</b-td>
    console.log("아파트이름",bookmark_apt_name);
    <!-- <b-td>{{ hit }}</b-td>
    <b-td>{{ userid }}</b-td>
    <b-td>{{ regtime }}</b-td> -->
  </b-tr>
</template>

<script>
// import moment from "moment";

export default {
  name: "BoardListRow",
  props: {
    bookmark_id: Number,
    bookmark_user_id: String,
    bookmark_apt_name: String,
    bookmark_apt_dongname: String,
    bookmark_apt_floor: Number,
    bookmark_apt_price: String,
    bookmark_apt_lat: String,
    bookmark_apt_lng: String,

  },
  computed: {
    // changeDateFormat() {
    //   return moment(new Date(this.regtime)).format("YY.MM.DD hh:mm:ss");
    // },
  },
};
</script>

<style></style>
