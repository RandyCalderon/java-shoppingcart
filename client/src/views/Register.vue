<template>
  <div>
    <h1>Create Account</h1>
    <RegistrationForm/>
  </div>
</template>

<script>
import RegistrationForm from "@/components/RegistrationForm.vue";
export default {
  name: "register",
  components: {
    RegistrationForm
  }
};
</script>
