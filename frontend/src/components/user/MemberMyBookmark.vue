<template>
    <b-container class="bv-example-row mt-3">
        <br />
        <br />
        <div class="card">
            <div class="card-header">
                <h4>내 관심 주택</h4>
                <span>관심있는 주택을 저장하여 빠르게 조회할 수 있습니다.</span>
            </div>
            <div class="card-block">
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
            </div>
        </div>
    </b-container>
</template>

<script>
import BookMarkListRow from "@/components/user/BookMarkListRow.vue";

export default {
    name: "MemberMyBookmark",
    data() {
        return {
        };
    },
    components: {
        BookMarkListRow,
    },
    computed: {
        bookmarks() {
            return this.$store.state.memberStore.bookmarks;
        },
    },
    created() {
        this.$store.dispatch("memberStore/getBookmarkList");
    },
    methods: {},
};
</script>

<style>
.jumbotron {
    background-color: rgb(162, 216, 238);
}
</style>
