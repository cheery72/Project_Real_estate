import jwt_decode from "jwt-decode";
import { login } from "@/api/member.js";
import { findById } from "@/api/member";
import http from "@/js/http-common.js";

const storage = window.sessionStorage;

const memberStore = {
  namespaced: true,
  state: {
    isLogin: false,
    isLoginError: false,
    userInfo: null,
    bookmark: [],
    bookmarks: [],
  },
  getters: {
    checkUserInfo: function (state) {
      return state.userInfo;
    },
  },
  mutations: {
    SET_IS_LOGIN: (state, isLogin) => {
      state.isLogin = isLogin;
    },
    SET_IS_LOGIN_ERROR: (state, isLoginError) => {
      state.isLoginError = isLoginError;
    },
    SET_USER_INFO: (state, userInfo) => {
      state.isLogin = true;
      state.userInfo = userInfo;
    },
    SET_BOOKMARK_LIST(state, apt){
      // 배열에 추가
      state.bookmark = apt;
    },
    SET_BOOKMARK_INFO(state, mark){
      state.bookmarks = mark;
    }
  },
  actions: {
    async userConfirm({ commit }, user) {
      await login(
        user,
        (response) => {
          if (response.data.message === "success") {
            let token = response.data["access-token"];
            commit("SET_IS_LOGIN", true);
            commit("SET_IS_LOGIN_ERROR", false);
            sessionStorage.setItem("access-token", token);
          } else {
            commit("SET_IS_LOGIN", false);
            commit("SET_IS_LOGIN_ERROR", true);
          }
        },
        () => {}
      );
    },
    getUserInfo({ commit }, token) {
      let decode_token = jwt_decode(token);
      findById(
        decode_token.userid,
        (response) => {
          if (response.data.message === "success") {
            commit("SET_USER_INFO", response.data.userInfo);
          } else {
            console.log("유저 정보 없음!!");
          }
        },
        (error) => {
          console.log(error);
        }
      );
    },
    getBookmark({ commit }, mark) {//등록
      // console.log(Storage.getUserInfo);
      console.log(Storage.getItem("access-token"));
      const params = { bookmark: mark, Headers: {"Authorization": Storage.getItem("access-token")}};
      console.log(params);
      console.log(mark);
      http
      .post(`/bookmark/register`, {params})
      .then((response) => {
        console.log("response출력");
        console.log(response.data);
        commit("SET_BOOKMARK_INFO", response.data);
      }).catch((error) => {
        console.log("에러출력");
        console.log(error);
      })
    }
  },
};

export default memberStore;
