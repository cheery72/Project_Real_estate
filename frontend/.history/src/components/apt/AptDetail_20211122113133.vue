<template>
  <div>
    {{apt}}
  </div>
</template>

<script>
import {mapState} from "vuex";

export default {
    data() {
        return {

        }
    },
    computed:{
        ...mapState(["apt"]),
    },
}
</script>

<style>

</style>