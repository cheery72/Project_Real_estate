<template>
    <b-container class="bv-example-row mt-3">
        <b-row>
        </b-row>
        <member-info-form />
    </b-container>
</template>

<script>
import MemberInfoForm from "./child/MemberInfoForm.vue";
export default {
    name: "MemberMyPage",
    components: {
        MemberInfoForm,
    },
};
</script>

<style></style>
