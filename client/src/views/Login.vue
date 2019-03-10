<template>
  <div class="login">
    <LoginForm/>
  </div>
</template>

<style scope>
login {
  max-width: 500px;
  background: black;
}
</style>

<script>
import LoginForm from "@/components/LoginForm.vue";

export default {
  name: "login",
  components: {
    LoginForm
  }
};
</script>
