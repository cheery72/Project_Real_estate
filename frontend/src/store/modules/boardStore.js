import http from "@/js/http-common.js";
import jwt_decode from "jwt-decode";

const boardStore = {
    namespaced: true,
    state: {
        boardList: [],
    },
    getters: {},
    mutations: {
        SET_BOARD_REGST(state, board) {
            state.boardList.push(board);
        },
        SET_BOARD_LIST(state, board) {
            state.boardList = board;
        },
        SET_BOARD_MODIFY(state, board) {
            state.boardList[board.idx].content = board.content;
        },
        SET_BOARD_DELETE(state, idx) {
            state.boardList.splice(idx, 1);
        },
    },
    actions: {
        regBoard({ commit }, param) {
            let decode_token = jwt_decode(
                sessionStorage.getItem("access-token")
            );
            const userid = decode_token.userid;

            const params = {
                userId: userid,
                aptCode: param.aptCode,
                content: param.text,
            };
            http.post(`/board/register`, params)
                .then((response) => {
                    commit("SET_BOARD_REGST", response.data);
                    alert("추가되었습니다.");
                })
                .catch((error) => {
                    console.log(error);
                });
        },
        getBoard({ commit }, param) {
            http.get(`/board/list/${param.aptCode}`)
                .then((response) => {
                    commit("SET_BOARD_LIST", response.data);
                })
                .catch((error) => {
                    console.log(error);
                });
        },
        modiBoard({ commit }, param) {
            let decode_token = jwt_decode(
                sessionStorage.getItem("access-token")
            );
            const userid = decode_token.userid;
            const params = {
                bno: param.bno,
                aptCode: param.aptCode,
                userId: userid,
                content: param.content,
                idx: param.idx,
            };
            http.put(`/board/modify`, params)
                .then((response) => {
                    console.log("성공", response);
                    commit("SET_BOARD_MODIFY", params);
                    alert("수정되었습니다.");
                })
                .catch((error) => {
                    console.log("에러", error);
                });
        },
        delBoard({ commit }, param) {
            let decode_token = jwt_decode(
                sessionStorage.getItem("access-token")
            );
            const userid = decode_token.userid;

            const params = {
                userId: userid,
                bno: param.bno,
            };

            http.delete(`/board/del/`, params)
                .then((response) => {
                    console.log(response.data);
                    commit("SET_BOARD_DELETE", param.idx);
                    alert("삭제되었습니다.");
                })
                .catch((error) => {
                    console.log(error);
                });
        },
    },
};

export default boardStore;
