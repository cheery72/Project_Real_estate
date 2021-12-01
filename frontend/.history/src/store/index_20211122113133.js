import Vue from "vue";
import Vuex from "vuex";
import http from "@/js/http-common.js";
import createPersistedState from "vuex-persistedstate";
import memberStore from "@/store/modules/memberStore.js";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    sidos: [{ value: null, text: "선택하세요" }],
    guguns: [{ value: null, text: "선택하세요" }],
    dongs: [{ value: null, text: "선택하세요" }],
    apts: [],
    apt: null,
    positions: [],
    cctvs: [],
    dongName: null,
    subways: [],
    schools: [],
  },
  mutations: {
    // 시도 리스트
    SET_SIDO_LIST(state, sidos) {
      sidos.forEach((sido) => {
        state.sidos.push({ value: sido.sidoCode, text: sido.sidoName });
      });
    },
    CLEAR_SIDO_LIST(state) {
      state.guguns = [{ value: null, text: "선택하세요" }];
    },
    // 구군 리스트
    SET_GUGUN_LIST(state, guguns) {
      guguns.forEach((gugun) => {
        state.guguns.push({ value: gugun.gugunCode, text: gugun.gugunName });
      });
    },
    CLEAR_GUGUN_LIST(state) {
      state.guguns = [{ value: null, text: "선택하세요" }];
    },
    // 동 리스트
    SET_DONG_LIST(state, dongs) {
      dongs.forEach((dong) => {
        state.dongs.push({
          value: [dong.dongCode, dong.dongName],
          text: dong.dongName,
        });
      });
    },
    CLEAR_DONG_LIST(state) {
      state.dongs = [{ value: null, text: "선택하세요" }];
    },
    // 해당 구,동 아파트 리스트
    SET_APT_LIST(state, apts) {
      state.apts = apts;
      state.dongName = apts[0].dongName;
    },
    CLEAR_APT_LIST(state) {
      state.positions = [];
    },
    // 아파트 선택시 세부사항
    SET_DETAIL_APT(state, apt) {
      state.apt = apt;
    },
    // cctv 정보
    SET_CCTV_LIST(state, cctv) {
      state.cctvs = cctv;
    },
    // 지하철 정보
    SET_SUBWAY_LIST(state, subway) {
      state.subways = subway;
    },
    // 학교 정보
    SET_SCHOOL_LIST(state, school) {
      state.schools = school;
    },
  },
  actions: {
    // 셀렉트바 시도 가져오기
    getSido({ commit }) {
      http
        .get(`/apt/sido`)
        .then((response) => {
          commit("SET_SIDO_LIST", response.data);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    getGugun({ commit }, sidoCode) {
      const params = { sido: sidoCode };
      http
        .get(`/apt/gugun`, { params })
        .then((response) => {
          commit("SET_GUGUN_LIST", response.data);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    getDong({ commit }, gugunCode) {
      const params = { gugun: gugunCode };
      http
        .get(`/apt/dongname`, { params })
        .then((response) => {
          commit("SET_DONG_LIST", response.data);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    getAptList({ commit }, dongCode) {
      const params = { dong: dongCode };
      http
        .get(`/apt/aptinfo`, { params })
        .then((response) => {
          commit("SET_APT_LIST", response.data);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    getCctvList({ commit }, dongName) {
      const params = { dong: dongName };
      http
        .get(`/cctv/cctvinfo`, { params })
        .then((response) => {
          commit("SET_CCTV_LIST", response.data);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    getSubwayList({ commit }) {
      http
        .get(`/subway/subwayinfo`)
        .then((response) => {
          commit("SET_SUBWAY_LIST", response.data);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    getSchoolList({ commit }, dongName) {
      const params = { dong: dongName };
      http
        .get(`/school/schoolinfo`, { params })
        .then((response) => {
          commit("SET_SCHOOL_LIST", response.data);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    // getAptList({ commit }, gugunCode) {
    //   const SERVICE_KEY = process.env.VUE_APP_GONG_API_KEY;
    //   const SERVICE_URL =
    //     "http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev";
    //   const params = {
    //     LAWD_CD: gugunCode,
    //     DEAL_YMD: "202110",
    //     serviceKey: decodeURIComponent(SERVICE_KEY),
    //   };
    //   http
    //     .get(SERVICE_URL, { params })
    //     .then((response) => {
    //       // console.log(commit, response);
    //       commit("SET_APT_LIST", response.data.response.body.items.item);
    //     })
    //     .catch((error) => {
    //       console.log(error);
    //     });
    // },
    // detailHouse(house) {
    //   // 나중에 house 일련번호를 이용하여 API 호출
    //   this.commit("SET_DETAIL_APT", house);
    // },
  },
  modules: { memberStore },
  plugins: [
    createPersistedState({
      // 브라우저 종료시 제거하기 위해 localStorage가 아닌 sessionStorage로 변경. (default: localStorage)
      storage: sessionStorage,
    }),
  ],
});