<template>
  <div class="container-fluid">
    <div class="row py-5 mt-4 align-items-center">
      <!-- For Demo Purpose -->
      <div class="col-md-6 pr-lg-5 mb-5 mb-md-0">
        <img
          src="@/assets/interior.jpg"
          alt=""
          class="img-fluid mb-3 d-none d-md-block"
        />
      </div>

      <!-- Registeration Form -->
      <div class="col-md-6 col-lg-6 ml-auto register bg-light">
        <form>
          <div class="row d-flex align-items-center py-5">
            <div class="col-lg-10 col-xl-12 mx-auto">
              <h2 class="display-4">회원정보</h2>
              <p class="text-muted mb-4">
                가입하신 해피하우스 회원 정보입니다.<br />
                개인정보, 비밀번호를 변경하실 수 있습니다.
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
                  <img
                    src="@/assets/id.jpg"
                    class="fa fa-envelope text-muted"
                  />
                </span>
              </div>
              <input
                id="userid"
                :disabled="true"
                v-model="user.userid"
                type="text"
                required
                class="form-control border-left-0 border-md"
              />
            </div>
            <div id="idresult" class="mx-auto">{{ idresult }}</div>
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
                  <img
                    width="25px"
                    src="@/assets/password.jpg"
                    class="fa fa-envelope text-muted"
                  />
                </span>
              </div>
              <input
                id="userpwd"
                :disabled="viewMode"
                v-model="user.userpwd"
                type="text"
                required
                class="form-control border-left-0 border-md"
              />
            </div>
            <div class="mx-auto">{{ validcheck }}</div>

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
                  <img
                    width="25px"
                    src="@/assets/username.jpg"
                    class="fa fa-envelope text-muted"
                  />
                </span>
              </div>
              <input
                id="username"
                :disabled="viewMode"
                v-model="user.username"
                type="text"
                required
                class="form-control border-left-0 border-md"
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
                  <img
                    width="25px"
                    src="@/assets/email2.jpg"
                    class="fa fa-envelope text-muted"
                  />
                </span>
              </div>
              <input
                id="userAddress"
                :disabled="viewMode"
                v-model="user.email"
                type="text"
                required
                class="form-control border-left-0 border-md"
              />
            </div>

            <!-- Submit Button -->
            <div class="form-group col-lg-12 mx-auto mb-0">
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
            </div>

            <!-- Already Registered -->
            <div class="text-center w-100"></div>
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
