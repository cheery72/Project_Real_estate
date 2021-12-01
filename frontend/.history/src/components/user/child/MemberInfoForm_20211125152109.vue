<template>
  <b-row>
    <b-col></b-col>
    <div class="col-lg-10 col-xl-12 mx-auto">
      <h2 class="display-4">회원정보</h2>
      <p class="text-muted mb-4">
        하나의 아이디로 다양한 서비스를 이용해 보세요.
      </p>
    </div>
    <b-col cols="8">
      <b-card class="text-center mt-3" style="max-width: 40rem" align="left">
        <b-form class="text-left">
          <b-form-group
            id="userid-group"
            label="아이디:"
            label-for="userid"
            description=""
          >
            <b-form-input
              id="userid"
              :disabled="true"
              v-model="user.userid"
              type="text"
              required
            ></b-form-input>
          </b-form-group>

          <b-form-group
            id="userpwd-group"
            label="비밀번호:"
            label-for="userpwd"
            description=""
          >
            <b-form-input
              id="userpwd"
              :disabled="viewMode"
              v-model="user.userpwd"
              type="text"
              required
            ></b-form-input>
          </b-form-group>

          <b-form-group
            id="username-group"
            label="이름:"
            label-for="username"
            description=""
          >
            <b-form-input
              id="username"
              :disabled="viewMode"
              v-model="user.username"
              type="text"
              required
            ></b-form-input>
          </b-form-group>

          <b-form-group
            id="userAddress-group"
            label="이메일:"
            label-for="email"
            description=""
          >
            <b-form-input
              id="userAddress"
              :disabled="viewMode"
              v-model="user.email"
              type="text"
              required
            ></b-form-input>
          </b-form-group>

          <div v-if="this.viewMode">
            <b-button variant="primary" class="m-1" @click="changeMode"
              >수정하기
            </b-button>
            <b-button variant="danger" class="m-1" @click="deleteMember"
              >삭제
            </b-button>
          </div>
          <div v-else>
            <b-button variant="primary" class="m-1" @click="modifyMember"
              >확인
            </b-button>
            <b-button variant="danger" class="m-1" @click="changeMode"
              >취소
            </b-button>
          </div>
        </b-form>
      </b-card>
    </b-col>
    <b-col></b-col>
  </b-row>
</template>

<script>
import { mapState, mapMutations } from "vuex";
import { modifyInfo, deleteInfo } from "@/api/member";
const memberStore = "memberStore";

export default {
  name: "MemberInfoForm",
  data() {
    return {
      user: {
        userid: "",
        userpwd: "",
        username: "",
        email: "",
      },
      viewMode: false,
    };
  },
  props: {},
  computed: {
    ...mapState(memberStore, ["userInfo"]),
  },
  created() {
    this.viewMode = true;
    this.user = this.userInfo;
    console.log(this.user);
    console.log(this.user.userid);
    console.log(this.user.userpwd);
  },
  methods: {
    ...mapMutations(memberStore, ["SET_IS_LOGIN", "SET_USER_INFO"]),
    changeMode() {
      if (this.viewMode) {
        this.viewMode = false;
      } else {
        //this.viewMode = true;
        this.$router.push({ name: "Home" });
      }
    },
    modifyMember() {
      modifyInfo(
        this.user,
        ({ data }) => {
          let msg = "수정 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "수정이 완료되었습니다.";
          }
          alert(msg);
          this.moveHome();
        },
        (error) => {
          console.log(error);
        }
      );
    },
    deleteMember() {
      deleteInfo(
        this.user,
        ({ data }) => {
          let msg = "탈퇴 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "탈퇴가 완료되었습니다.";
            this.SET_IS_LOGIN(false);
            this.SET_USER_INFO(null);
            sessionStorage.removeItem("access-token");
          }
          alert(msg);
          this.moveHome();
        },
        (error) => {
          console.log(error);
        }
      );
    },
    moveHome() {
      this.$router.push({ name: "Home" });
    },
  },
};
</script>

<style></style>
