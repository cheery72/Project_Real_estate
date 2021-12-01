<template>
  <div>
    
      어어어어어....내 관심아파트
{{bookmarks}}

    <book-mark-list-row
        v-for="(bookmark, index) in bookmarks"
        :key="index"
        v-bind="bookmark"
    />

  </div>
</template>

<script>
import BookMarkListRow from "@/components/user/BookMarkListRow.vue";
import {mapState} from "vuex";

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
            console.log(this.$store)
            return this.$store.state["memberStore/bookmarks"]
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