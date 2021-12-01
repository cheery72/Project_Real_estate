<template>
    <b-row class="mt-4 mb-4 text-center">
        <b-col class="sm-3">
            <b-form-select
                v-model="sidoCode"
                :options="sidos"
                @change="gugunList"
            ></b-form-select>
        </b-col>

        <b-col class="sm-3">
            <b-form-select
                v-model="gugunCode"
                :options="guguns"
                @change="dongList"
            ></b-form-select>
        </b-col>

        <b-col class="sm-3">
            <b-form-select
                v-model="dongCode"
                :options="dongs"
                @change="[searchApt(), cctvList(), schoolList()]"
            ></b-form-select>
        </b-col>
    </b-row>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";

export default {
    name: "AptSearchBar",
    data() {
        return {
            sidoCode: null,
            gugunCode: null,
            dongCode: null,
        };
    },
    computed: {
        ...mapState(["sidos", "guguns", "dongs", "apts", "dongName"]),
    },
    created() {
        this.CLEAR_SIDO_LIST();
        this.getSido();
    },
    methods: {
        ...mapActions([
            "getSido",
            "getGugun",
            "getDong",
            "getAptList",
            "getCctvList",
            "getSchoolList",
        ]),
        ...mapMutations([
            "CLEAR_SIDO_LIST",
            "CLEAR_GUGUN_LIST",
            "CLEAR_DONG_LIST",
            "CLEAR_APT_LIST",
        ]),

        gugunList() {
            this.CLEAR_SIDO_LIST();
            this.gugunCode = null;
            if (this.sidoCode) this.getGugun(this.sidoCode);
        },
        dongList() {
            if (this.gugunCode) this.getDong(this.gugunCode);
            this.CLEAR_DONG_LIST();
        },
        searchApt() {
            if (this.dongCode[0]) this.getAptList(this.dongCode[0]);
        },
        cctvList() {
            this.getCctvList(this.dongCode[1]);
        },
        schoolList() {
            this.getSchoolList(this.dongCode[1]);
        },
    },
};
</script>

<style></style>
