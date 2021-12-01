<template>
  <b-row class="mb-1">
    <b-col style="text-align: left">
      <b-form @submit="onSubmit" @reset="onReset">
        <b-form-group
          id="userid-group"
          label="아이디:"
          label-for="userid"
          description=""
        >
          <b-form-input
            id="userid"
            v-model="user.userid"
            type="text"
            required
            placeholder="아이디 입력"
            @keyup="idCheck"
          ></b-form-input>
          <div id="idresult" class="mt-1">{{ idresult }}</div>
        </b-form-group>

        <b-form-group
          id="userpwd-group"
          label="비밀번호:"
          label-for="userpwd"
          description=""
        >
          <b-form-input
            id="userpwd"
            @keyup="validPw"
            v-model="user.userpwd"
            type="text"
            required
            placeholder="비밀번호 입력"
          ></b-form-input>
          <div>{{ validcheck }}</div>
        </b-form-group>

        <b-form-group id="userpwd-group" label="비밀번호 확인:" description="">
          <b-form-input
            id="user_pass_ck"
            type="password"
            required
            @keyup="checkPw"
            v-model="user.userpwd_ck"
            label-for="userpwd_ck"
            placeholder="비밀번호 확인"
          ></b-form-input>
          <div>{{ pwcheck }}</div>
        </b-form-group>

        <b-form-group
          id="username-group"
          label="이름:"
          label-for="username"
          description=""
        >
          <b-form-input
            id="userName"
            v-model="user.username"
            type="text"
            required
            placeholder="이름 입력"
          ></b-form-input>
        </b-form-group>

        <b-form-group
          id="email-group"
          label="이메일:"
          label-for="email"
          description=""
        >
          <b-form-input
            id="userAddress"
            v-model="user.email"
            type="text"
            required
            placeholder="이메일 입력"
          ></b-form-input>
        </b-form-group>

        <b-button type="submit" variant="primary" class="m-1"
          >회원가입
        </b-button>
        <b-button type="reset" variant="danger" class="m-1">초기화</b-button>
      </b-form>
    </b-col>
  </b-row>
</template>

<script>
import { joinMember, checkId } from "@/api/member";
export default {
  name: "MemberJoinForm",
  data() {
    return {
      user: {
        userid: "",
        userpwd: "",
        userpwd_ck: "",
        username: "",
        email: "",
      },
      idresult: "",
      validcheck: "", //비밀번호 유효성
      pwcheck: "", //비밀번호 체크
    };
  },
  props: {},
  created() {},
  methods: {
    //비밀번호 validation체크
    validPw() {
      var reg =
        /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;
      var pw = this.user.userpwd;

      if (false === reg.test(pw)) {
        this.validcheck =
          "비밀번호는 8자 이상이어야 하며, 숫자/대문자/소문자/특수문자를 모두 포함해야 합니다.";
      } else {
        console.log("통과");
        this.validcheck = "유효합니다.";
      }
    },
    //비밀번호 체크
    checkPw() {
      if (this.user.userpwd != this.user.userpwd_ck) {
        console.log("체크실패");
        this.pwcheck = "위 비밀번호와 다릅니다.";
      } else {
        console.log("체크성공");
        this.pwcheck = "위 비밀번호와 동일합니다.";
      }
    },
    onSubmit(event) {
      event.preventDefault();
      this.registerMember();
    },
    onReset(event) {
      event.preventDefault();
      this.user.userid = "";
      this.user.userpwd = "";
      this.user.username = "";
      this.user.email = "";
    },
    idCheck() {
      checkId(
        this.user.userid,
        ({ data }) => {
          let cnt = data.idcount;
          if (cnt == 0) {
            this.idresult = this.user.userid + "는 사용 가능합니다.";
          } else {
            this.idresult = this.user.userid + "는 사용할 수 없습니다.";
          }
        },
        (error) => {
          console.log(error);
        }
      );
    },
    registerMember() {
      joinMember(
        this.user,
        ({ data }) => {
          let msg = "회원가입 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "회원가입이 완료되었습니다.";
          }
          alert(msg);
          this.$router.push({ name: "SignIn" });
        },
        (error) => {
          console.log(error);
        }
      );
    },
  },
};
</script>

<style></style>
