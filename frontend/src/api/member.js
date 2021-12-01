import { apiInstance } from "./index.js";

const api = apiInstance();

async function login(user, success, fail) {
    await api
        .post(`/user/login`, JSON.stringify(user))
        .then(success)
        .catch(fail);
}

async function findById(userid, success, fail) {
    api.defaults.headers["access-token"] =
        sessionStorage.getItem("access-token");
    await api.get(`/user/info/${userid}`).then(success).catch(fail);
}
//회원가입
async function joinMember(user, success, fail) {
    await api
        .post(`/user/join`, JSON.stringify(user))
        .then(success)
        .catch(fail);
} 

//아이디체크
async function checkId(userid, success, fail) {
    await api.get(`/user/idCheck/${userid}`).then(success).catch(fail);
}

//수정
async function modifyInfo(user, success, fail) {
    api.defaults.headers["access-token"] =
        sessionStorage.getItem("access-token");
    await api
        .put(`/user/${user.userId}`, JSON.stringify(user))
        .then(success)
        .catch(fail);
}

//삭제
async function deleteInfo(user, success, fail) {
    api.defaults.headers["access-token"] =
        sessionStorage.getItem("access-token");
    await api.delete(`/user/${user.userId}`).then(success).catch(fail);
}

export { login, findById, modifyInfo, deleteInfo, joinMember, checkId };
