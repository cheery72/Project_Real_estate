import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";

import Member from "@/views/Member.vue";
import MemberJoin from "@/components/user/MemberJoin.vue";
import MemberLogin from "@/components/user/MemberLogin.vue";

import MemberMyPage from "@/components/user/MemberMyPage.vue";

import store from "@/store/index.js";

// https://router.vuejs.org/kr/guide/advanced/navigation-guards.html
const onlyAuthUser = async (to, from, next) => {
  //어디로 갈건지, 이전, 다음페이지
  // console.log(store);
  const checkUserInfo = store.getters["memberStore/checkUserInfo"]; //checkUserInfo의 리턴값을 가져와라
  const getUserInfo = store._actions["memberStore/getUserInfo"]; //getUserInfo의 리턴값을 가져와라
  let token = sessionStorage.getItem("access-token");
  if (checkUserInfo == null && token) {
    await getUserInfo(token); //서버에 가서 정상적인 토큰인지 검사해라 .. 여기서 정상적인사람이면 서버가 UserInfo를 준다.
  }
  if (checkUserInfo === null) {
    //서버에 갔다왔는데도 null이면...
    alert("로그인이 필요한 페이지입니다..");
    // next({ name: "SignIn" });
    router.push({ name: "SignIn" });
  } else {
    //정상적인 사람이니까 다음페이지로 갈수 있도록 적용(밑에 beforeEnter붙은 것들)
    console.log("로그인 했다.");
    next();
  }
};


Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/user",
    name: "Member",
    component: Member,
    children: [
      {
        path: "singin",
        name: "SignIn",
        component: MemberLogin,
      },
      {
        path: "singup",
        name: "SignUp",
        component: MemberJoin,
      },
      {
        path: "mypage",
        name: "MyPage",
        beforeEnter: onlyAuthUser,
        component: MemberMyPage,
      },
    ],
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;