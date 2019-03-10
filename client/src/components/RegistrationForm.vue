<template>
  <a-form id="wrapper" :form="form" @submit="postUser">
    <a-form-item label="Email">
      <a-input
        v-model="email"
        v-decorator="[
          'email',
          {rules: [{ required: true, message: 'Please input your email' }]}
        ]"
        placeholder="Email"
      />
    </a-form-item>
    <a-form-item label="Password">
      <a-input
        v-model="password"
        v-decorator="[
          'password',
          {rules: [{ required: true, message: 'Please input your password' }]}
        ]"
        placeholder="Password"
      />
    </a-form-item>
    <a-form-item label="Verify Password">
      <a-input
        v-model="password2"
        v-decorator="[
      'verify password',{rules: [{ required: true, message: 'Please verify your password'}]}
      ]"
        placeholder="Verify Password"
      />
    </a-form-item>
    <a-button type="primary" @click="check" htmlType="submit">Submit</a-button>
  </a-form>
</template>

<style scoped>
#wrapper {
  max-width: 350px;
  margin: 0 auto;
}
</style>

<script>
import axios from "axios";

export default {
  name: "registrationform",
  data() {
    return {
      email: "",
      password: "",
      pasword2: "",
      form: this.$form.createForm(this)
    };
  },
  methods: {
    check() {
      this.form.validateFields(err => {
        if (!err) {
          console.info("success");
        }
      });
    },
    handleSelectChange(value) {
      this.form.setFieldsValue({
        email: this.email,
        password: this.password,
        password2: this.password2
      });
    },
    postUser() {
      if (this.password != this.password2) {
        alert("Password don't match");
      } else if (this.email.length < 14) {
        alert("Please provide a valid email");
      } else {
        axios
          .post("http://localhost:2019/users", {
            email: this.email,
            password: this.password,
            role: "USER"
          })
          .then(res => {})
          .catch(err => err.message);
      }
    }
  }
};
</script>
