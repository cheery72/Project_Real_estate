<template>

 <div class="container-fluid">
   <br>
   <br>
    <div class="row no-gutter">
        <!-- The image half -->
        <div class="col-md-6 d-none d-md-flex bg-image"></div>


        <!-- The content half -->
        <div class="col-md-6 bg-light">
            <div class="login d-flex align-items-center py-5">

                <!-- Demo content-->
                <div class="container">
                    <div class="row">
                        <div class="col-lg-10 col-xl-7 mx-auto">
                            <h2 class="display-4">login page</h2>
                            <p class="text-muted mb-4">가입하신 회원정보로 로그인해주세요</p>
                            <form>

                              <b-alert show variant="danger" v-if="isLoginError"
              >아이디 또는 비밀번호를 확인하세요.</b-alert>
                                <div class="form-group mb-3" label-for="userid">
                                    <inputid="userid"
                v-model="user.userid"
                required
                placeholder="아이디 입력...."
                @keyup.enter="confirm">
                                </div>
                                <div class="form-group mb-3" label="비밀번호:" label-for="userpwd">
                                    <input type="password"
                id="userpwd"
                v-model="user.userpwd"
                required
                placeholder="비밀번호 입력...."
                @keyup.enter="confirm">
                                </div>
                                <div class="custom-control custom-checkbox mb-2">
                                    <input id="customCheck1" type="checkbox" checked class="custom-control-input">
                                    <!-- <label for="customCheck1" class="custom-control-label">Remember password</label> -->
                                </div>
                                <button type="button"
              variant="primary"
              class="m-1"
              @click="confirm">Sign in</button>
                            
                            </form>
                        </div>
                    </div>
                </div><!-- End -->

            </div>
        </div><!-- End -->

    </div>
</div>
</template>
<style>
.login,
.image {
  min-height: 70vh;
}

.bg-image {
  /* //background-image: url('https://therichpost.com/wp-content/uploads/2021/02/login-split.jpg'); */
  background-image: url("../../assets/apartment.jpg");
  background-size: cover;
  background-position: center center;
}
</style>



<script>
import { mapState, mapActions } from "vuex";

const memberStore = "memberStore";

export default {
  name: "MemberLogin",
  data() {
    return {
      user: {
        userid: null,
        userpwd: null,
      },
    };
  },
  computed: {
    ...mapState(memberStore, ["isLogin", "isLoginError"]),
  },
  methods: {
    ...mapActions(memberStore, ["userConfirm", "getUserInfo"]),
    async confirm() {
      await this.userConfirm(this.user);
      let token = sessionStorage.getItem("access-token");
      if (this.isLogin) {
        await this.getUserInfo(token);
        this.$router.push({ name: "Home" });
      }
    },
    movePage() {
      this.$router.push({ name: "SignUp" });
    },
  },
};
</script>

<style></style>
