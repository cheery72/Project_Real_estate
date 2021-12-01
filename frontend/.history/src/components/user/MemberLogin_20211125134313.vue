<template>
  <nav
    id="navbarExample"
    class="navbar navbar-expand-lg fixed-top navbar-light"
    aria-label="Main navigation"
  >
    <div class="container">
      <a class="navbar-brand logo-text" href="#">Jassa</a>

      <button
        class="navbar-toggler p-0 border-0"
        type="button"
        id="navbarSideCollapse"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>

      <div
        class="navbar-collapse offcanvas-collapse"
        id="navbarsExampleDefault"
      >
        <ul class="navbar-nav ms-auto navbar-nav-scroll">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="#header"
              >Home</a
            >
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#services">Services</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#details">Details</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#features">Features</a>
          </li>
          <li class="nav-item dropdown">
            <a
              class="nav-link dropdown-toggle"
              href="#"
              id="dropdown01"
              data-bs-toggle="dropdown"
              aria-expanded="false"
              >Drop</a
            >
            <ul class="dropdown-menu" aria-labelledby="dropdown01">
              <li><a class="dropdown-item" href="#">Article Details</a></li>
              <li><div class="dropdown-divider"></div></li>
              <li><a class="dropdown-item" href="#">Terms Conditions</a></li>
              <li><div class="dropdown-divider"></div></li>
              <li><a class="dropdown-item" href="#">Privacy Policy</a></li>
            </ul>
          </li>
        </ul>
        <span class="nav-item">
          <a class="btn-solid-sm" href="#contact">Get quote</a>
        </span>
      </div>
    </div>
  </nav>
</template>
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
