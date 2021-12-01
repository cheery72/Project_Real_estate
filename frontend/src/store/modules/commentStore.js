import http from "@/js/http-common.js";
import jwt_decode from "jwt-decode";

const commentStore = {
    namespaced: true,
    state: {
        commentList: [],
    },
    getters: {},
    mutations: {
        SET_COMMENT_REGST(state, comment) {
            state.commentList.push(comment);
        },
        SET_COMMENT_LIST(state, comment) {
            state.commentList = comment;
        },
        SET_COMMENT_MODIFY(state, comment) {
            state.commentList[comment.idx].comments = comment.comments;
        },
        SET_COMMENT_DELETE(state, idx) {
            state.commentList.splice(idx, 1);
        },
    },
    actions: {
        regComment({ commit }, param) {
            let decode_token = jwt_decode(
                sessionStorage.getItem("access-token")
            );
            const userid = decode_token.userid;

            const params = {
                userId: userid,
                bno: param.bno,
                comments: param.comments,
            };

            http.post(`/comment/register`, params)
                .then((response) => {
                    commit("SET_COMMENT_REGST", response.data);
                })
                .catch((error) => {
                    console.log(error);
                });
        },
        getComment({ commit }, param) {
            const params = {
                bno: param,
            };
            http.get(`/comment/list`, { params })
                .then((response) => {
                    commit("SET_COMMENT_LIST", response.data);
                })
                .catch((error) => {
                    console.log(error);
                });
        },
        modiComment({ commit }, param) {
            let decode_token = jwt_decode(
                sessionStorage.getItem("access-token")
            );
            const userid = decode_token.userid;
            const params = {
                rno: param.rno,
                userId: userid,
                comments: param.comments,
                idx: param.idx,
            };
            http.put(`/comment/modify`, params)
                .then((response) => {
                    console.log(response.data);
                    commit("SET_COMMENT_MODIFY", params);
                    alert("수정되었습니다.");
                })
                .catch((error) => {
                    console.log(error);
                });
        },
        delComment({ commit }, param) {
            let decode_token = jwt_decode(
                sessionStorage.getItem("access-token")
            );
            const userid = decode_token.userid;
            const params = {
                userId: userid,
                rno: param.rno,
            };
            http.delete(`/comment/del`, params)
                .then((response) => {
                    console.log(response.data);
                    commit("SET_COMMENT_DELETE", param.idx);
                    alert("삭제되었습니다.");
                })
                .catch((error) => {
                    console.log(error);
                });
        },
    },
};

export default commentStore;
