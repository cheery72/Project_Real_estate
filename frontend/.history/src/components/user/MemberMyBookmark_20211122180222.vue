<template>
  <div>
    
      어어어어어....내 관심아파트
    {{bookmarks}}
<!-- 
    <button v-if="show" @click="addBookmark">북마크추가</button>
    <button v-else @click="deleteBookmark">북마크취소</button> -->

 
  </div>
</template>

<script>
import {mapState,mapActions} from "vuex";

const memberStore = "memberStore";

export default {
    name: "MemberMyBookmark",
    data() {
        return {

        }
    },
    computed:{
        ...mapState(memberStore,["bookmark","bookmarks"]),
        ...mapActions(memberStore,["getBookmark"]),
    },
    method: {
        addBookmark(){
            if(this.bookmark) this.getBookmark(this.bookmark);
        },
        deleteBookmark(){
            if(this.bookmark) this.delBookmark(this.bookmark);
        },
    }

}
</script>

<style>

</style>