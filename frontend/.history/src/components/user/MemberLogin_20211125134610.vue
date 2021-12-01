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

    <header id="header" class="header">
      <div class="container">
        <div class="row">
          <div class="col-lg-6 col-xl-5">
            <div class="text-container">
              <h1 class="h1-large">Find influencers for your products</h1>
              <p class="p-large">
                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut
                dignissim, neque ut ultrices sollicitudin
              </p>
              <a class="btn-solid-lg" href="#services">Offered services</a>
            </div>
          </div>
          <div class="col-lg-6 col-xl-7">
            <div class="image-container">
              <img
                class="img-fluid"
                src="assets/images/header-image.png"
                alt="alternative"
              />
            </div>
          </div>
        </div>
      </div>
    </header>

    <div id="services" class="cards-1 bg-gray">
      <div class="container">
        <div class="row">
          <div class="col-lg-12">
            <h2>Explore our services</h2>
          </div>
        </div>
        <div class="row">
          <div class="col-lg-12">
            <div class="card">
              <div class="card-icon">
                <span class="fas fa-headphones-alt"></span>
              </div>
              <div class="card-body">
                <h5 class="card-title">Analyse your product</h5>
                <p>
                  Et blandit nisl libero at arcu. Donec ac lectus sed tellus
                  mollis viverra. Nullam pharetra ante at nunc elementum
                </p>
                <a class="read-more no-line" href="#"
                  >Learn more <span class="fas fa-long-arrow-alt-right"></span
                ></a>
              </div>
            </div>

            <div class="card">
              <div class="card-icon red">
                <span class="far fa-clipboard"></span>
              </div>
              <div class="card-body">
                <h5 class="card-title">Evaluate opportunities</h5>
                <p>
                  Vulputate nibh feugiat. Morbi pellent diam nec libero lacinia,
                  sed ultrices velit scelerisque. Nunc placerat justo sem
                </p>
                <a class="read-more no-line" href="#"
                  >Learn more <span class="fas fa-long-arrow-alt-right"></span
                ></a>
              </div>
            </div>

            <div class="card">
              <div class="card-icon green">
                <span class="far fa-comments"></span>
              </div>
              <div class="card-body">
                <h5 class="card-title">Find the influencers</h5>
                <p>
                  Ety suscipit metus sollicitudin euqu isq imperdiet nibh nec
                  magna tincidunt, nec pala vehicula neque sodales verum
                </p>
                <a class="read-more no-line" href="#"
                  >Learn more <span class="fas fa-long-arrow-alt-right"></span
                ></a>
              </div>
            </div>
          </div>
        </div>
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
