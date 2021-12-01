<template>

<b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <b-alert show><h3>내 관심지역</h3></b-alert>
      </b-col>
    </b-row>

  <div>
    
       <b-table-simple responsive>
           <b-thead>
        <b-tr>
          <b-th>아파트이름</b-th>
          <b-th>first</b-th>
          <b-th>last</b-th>
           <b-th>아파트이름</b-th>
          <b-th>first</b-th>
          <b-th>last</b-th>
           <b-th>아파트이름</b-th>
          <b-th>first</b-th>
        </b-tr>
      </b-thead>

    <book-mark-list-row
        v-for="(bookmark, index) in bookmarks"
        :key="index"
        v-bind="bookmark"
    />

       </b-table-simple>
  </b-container>
</template>

<script>
import BookMarkListRow from "@/components/user/BookMarkListRow.vue";
//import {mapState} from "vuex";

export default {
    name: "MemberMyBookmark",
    data() {
        return {
            // bookmarks: []
        }
    },
    components: {
         BookMarkListRow,
     },
     computed:{
         //...mapState(["memberStore/bookmarks"]),
        bookmarks(){
            return this.$store.state.memberStore.bookmarks
        }
     },
    created() {

        this.$store.dispatch("memberStore/getBookmarkList")
        //  this.bookmarkList();
    },
    methods: {
    
     }
    
}

    


</script>

<style>

</style>