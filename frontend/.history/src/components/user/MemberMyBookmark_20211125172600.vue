<template>
  <b-container class="bv-example-row mt-3">
    <div>
      <b-jumbotron>
        <template #header>내 관심 주택</template>

        <template #lead>
          This is a simple hero unit, a simple jumbotron-style component for
          calling extra attention to featured content or information.
        </template>

        <hr class="my-4" />

        <p>
          It uses utility classes for typography and spacing to space content
          out within the larger container.
        </p>

        <b-button variant="primary" href="#">Do Something</b-button>
        <b-button variant="success" href="#">Do Something Else</b-button>
      </b-jumbotron>
    </div>

    <!-- <b-row>
      <b-col>
        <b-alert show><h3>내 관심 주택</h3></b-alert>
      </b-col>
    </b-row> -->

    <b-row>
      <b-col>
        <b-table-simple hover responsive>
          <b-thead head-variant="info">
            <b-tr>
              <b-th>주택코드</b-th>
              <b-th>주택명</b-th>
              <b-th>건축년도</b-th>
              <b-th>동이름</b-th>
              <b-th>지번</b-th>
              <b-th>위도</b-th>
              <b-th>경도</b-th>
              <b-th>취소</b-th>
            </b-tr>
          </b-thead>
          <tbody>
            <!-- 하위 component인 ListRow에 데이터 전달(props) -->
            <book-mark-list-row
              v-for="(bookmark, index) in bookmarks"
              :key="index"
              v-bind="bookmark"
            />
          </tbody>
        </b-table-simple>
      </b-col>
      <!-- <b-col v-else class="text-center">도서 목록이 없습니다.</b-col> -->
    </b-row>
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
    };
  },
  components: {
    BookMarkListRow,
  },
  computed: {
    //...mapState(["memberStore/bookmarks"]),
    bookmarks() {
      return this.$store.state.memberStore.bookmarks;
    },
  },
  created() {
    this.$store.dispatch("memberStore/getBookmarkList");
    //  this.bookmarkList();
  },
  methods: {},
};
</script>

<style></style>
