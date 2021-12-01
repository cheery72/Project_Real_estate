<template>
  <div class="container-fluid">
    <div class="row py-5 mt-4 align-items-center">
      <!-- For Demo Purpose -->
      <div class="col-md-6 pr-lg-5 mb-5 mb-md-0">
        <img
          src="https://bootstrapious.com/i/snippets/sn-registeration/illustration.svg"
          alt=""
          class="img-fluid mb-3 d-none d-md-block"
        />
      </div>

      <!-- Registeration Form -->
      <div class="col-md-6 col-lg-6 ml-auto register bg-light">
        <form @submit="onSubmit" @reset="onReset">
          <div class="row d-flex align-items-center py-5">
            <div class="col-lg-10 col-xl-7 mx-auto">
              <h2 class="display-4">회원가입</h2>
              <p class="text-muted mb-4">
                하나의 아이디로 다양한 서비스를 이용해 보세요.
              </p>
            </div>
            <!--아이디 -->
            <div class="input-group col-lg-12 mb-4">
              <div
                id="userid-group"
                label="아이디:"
                label-for="userid"
                description=""
                class="input-group-prepend"
              >
                <span
                  class="
                    input-group-text
                    bg-white
                    px-4
                    border-md border-right-0
                  "
                >
                  <i class="fa fa-envelope text-muted"></i>
                </span>
              </div>
              <input
                id="userid"
                v-model="user.userid"
                type="text"
                required
                placeholder="아이디 입력"
                @keyup="idCheck"
                class="form-control bg-white border-left-0 border-md"
              />
            </div>
            <div id="idresult" class="mt-1">{{ idresult }}</div>

            <!--비밀번호-->
            <div class="input-group col-lg-12 mb-4">
              <div
                id="userpwd-group"
                label="비밀번호:"
                label-for="userpwd"
                description=""
                class="input-group-prepend"
              >
                <span
                  class="
                    input-group-text
                    bg-white
                    px-4
                    border-md border-right-0
                  "
                >
                  <i class="fa fa-envelope text-muted"></i>
                </span>
              </div>
              <input
                id="userpwd"
                @keyup="validPw"
                v-model="user.userpwd"
                type="text"
                required
                placeholder="비밀번호 입력"
                class="form-control bg-white border-left-0 border-md"
              />
            </div>
            <div>{{ validcheck }}</div>

            <!--비밀번호 확인-->
            <div class="input-group col-lg-12 mb-4">
              <div
                id="userpwd-group"
                label="비밀번호 확인:"
                description=""
                class="input-group-prepend"
              >
                <span
                  class="
                    input-group-text
                    bg-white
                    px-4
                    border-md border-right-0
                  "
                >
                  <i class="fa fa-envelope text-muted"></i>
                </span>
              </div>
              <input
                id="user_pass_ck"
                type="password"
                required
                @keyup="checkPw"
                v-model="user.userpwd_ck"
                label-for="userpwd_ck"
                placeholder="비밀번호 확인"
                class="form-control bg-white border-left-0 border-md"
              />
            </div>
            <div>{{ pwcheck }}</div>

            <!--이름 확인-->
            <div class="input-group col-lg-12 mb-4">
              <div
                id="username-group"
                label="이름:"
                label-for="username"
                description=""
                class="input-group-prepend"
              >
                <span
                  class="
                    input-group-text
                    bg-white
                    px-4
                    border-md border-right-0
                  "
                >
                  <i class="fa fa-envelope text-muted"></i>
                </span>
              </div>
              <input
                id="userName"
                v-model="user.username"
                type="text"
                required
                placeholder="이름 입력"
                class="form-control bg-white border-left-0 border-md"
              />
            </div>

            <!-- Email Address -->
            <div class="input-group col-lg-12 mb-4">
              <div
                id="email-group"
                label="이메일:"
                label-for="email"
                description=""
                class="input-group-prepend"
              >
                <span
                  class="
                    input-group-text
                    bg-white
                    px-4
                    border-md border-right-0
                  "
                >
                  <i class="fa fa-envelope text-muted"></i>
                </span>
              </div>
              <input
                id="userAddress"
                v-model="user.email"
                type="text"
                required
                placeholder="이메일 입력"
                class="form-control bg-white border-left-0 border-md"
              />
            </div>

            <!-- Submit Button -->
            <div class="form-group col-lg-12 mx-auto mb-0">
              <b-button
                type="submit"
                variant="primary"
                class="btn btn-primary btn-block py-2"
                >회원가입
              </b-button>
              <b-button type="reset" class="btn btn-primary btn-block py-2"
                >초기화</b-button
              >
            </div>

            <!-- Already Registered -->
            <div class="text-center w-100">
              <p class="text-muted font-weight-bold">
                Already Registered?
                <a href="#" class="text-primary ml-2">Login</a>
              </p>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>
<style>
.register,
.image {
  min-height: 70vh;
}

.border-md {
  border-width: 2px;
}

.btn-facebook {
  background: #405d9d;
  border: none;
}

.btn-facebook:hover,
.btn-facebook:focus {
  background: #314879;
}

.btn-twitter {
  background: #42aeec;
  border: none;
}

.btn-twitter:hover,
.btn-twitter:focus {
  background: #1799e4;
}

body {
  min-height: 100vh;
}

.form-control:not(select) {
  padding: 1.5rem 0.5rem;
}

select.form-control {
  height: 52px;
  padding-left: 0.5rem;
}

.form-control::placeholder {
  color: #ccc;
  font-weight: bold;
  font-size: 0.9rem;
}
.form-control:focus {
  box-shadow: none;
}
</style>

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
