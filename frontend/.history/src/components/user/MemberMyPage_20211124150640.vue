<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <b-alert variant="secondary" show
          ><h3>회원정보</h3>
         </b-alert
        >
      </b-col>
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
