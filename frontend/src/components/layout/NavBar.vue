<template>
    <div>
        <nav class="navbar navbar-expand-sm navbar-light">
            <b-navbar-brand href="#"></b-navbar-brand>

            <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

            <b-collapse id="nav-collapse" is-nav>
                <b-navbar-nav>
                    <b-nav-item href="#"
                        ><router-link
                            :to="{ name: 'MainBody' }"
                            class="link"
                            style="color: black"
                            ><img
                                src="@/assets/hhouse.png"
                                width="40px"
                                height="40px"
                            />
                            Happy House</router-link
                        ></b-nav-item
                    >
                </b-navbar-nav>

                <!-- Right aligned nav items -->
                <b-navbar-nav class="ml-auto" v-if="userInfo">
                    <b-nav-item class="align-self-center"
                        ><b-avatar
                            variant="primary"
                            v-text="
                                userInfo
                                    ? userInfo.userId.charAt(0).toUpperCase()
                                    : ''
                            "
                        ></b-avatar
                        >{{ userInfo.userName }}({{ userInfo.userId }})님
                        환영합니다.</b-nav-item
                    >
                    <b-nav-item class="align-self-center"
                        ><router-link
                            :to="{ name: 'AptMap' }"
                            class="nav-link align-self-center"
                            >아파트 검색</router-link
                        ></b-nav-item
                    >
                    <b-nav-item class="align-self-center"
                        ><router-link
                            :to="{ name: 'MyPage' }"
                            class="nav-link align-self-center"
                            >내정보보기</router-link
                        ></b-nav-item
                    >
                    <b-nav-item href="#" class="link align-self-center"
                        ><router-link
                            :to="{ name: 'MyBookmark' }"
                            class="nav-link"
                            >내관심지역</router-link
                        ></b-nav-item
                    >
                    <b-nav-item
                        class="nav-link align-self-center"
                        @click.prevent="onClickLogout"
                        >로그아웃</b-nav-item
                    >
                </b-navbar-nav>

                <!-- Right aligned nav items -->
                <b-navbar-nav class="ml-auto" v-else>
                    <b-nav-item href="#"
                        ><router-link :to="{ name: 'SignIn' }" class="nav-link"
                            >로그인</router-link
                        ></b-nav-item
                    >

                    <b-nav-item href="#"
                        ><router-link :to="{ name: 'SignUp' }" class="nav-link"
                            >회원가입</router-link
                        ></b-nav-item
                    >
                </b-navbar-nav>
            </b-collapse>
        </nav>
    </div>
</template>

<script>
import { mapState, mapMutations } from "vuex";

const memberStore = "memberStore";

export default {
    name: "NavBar",
    computed: {
        ...mapState(memberStore, ["isLogin", "userInfo"]),
    },
    methods: {
        ...mapMutations(memberStore, ["SET_IS_LOGIN", "SET_USER_INFO"]),
        onClickLogout() {
            this.SET_IS_LOGIN(false);
            this.SET_USER_INFO(null);
            sessionStorage.removeItem("access-token");  
            if (this.$route.path != "/")
                this.$router.push({ name: "MainBody" });
        },
    },
};
</script>

<style>
a {
    color: black;
}
</style>
