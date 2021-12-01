<template>
<button>ff</button>

  
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
