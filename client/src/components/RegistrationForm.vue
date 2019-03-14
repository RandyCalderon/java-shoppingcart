<template>
  <a-form id="wrapper" :form="form" @submit="postUser">
    <a-form-item label="Email">
      <a-input
        v-decorator="[
          'email',
          {rules: [{ required: true, message: 'Please input your email' }]}
        ]"
        placeholder="Email"
        autocomplete="username email"
      />
    </a-form-item>
    <a-form-item label="Password">
      <a-input
        v-decorator="[
          'password',
          {initialValue: '', rules: [{ required: true, message: 'Please input your password' }]}
        ]"
        type="password"
        autocomplete="new-password"
        placeholder="Password"
      />
    </a-form-item>
    <a-form-item label="Verify Password">
      <a-input
        v-decorator="[
      'password2',{initialValue: '', rules: [{ required: true, message: 'Please verify your password'}]}
      ]"
        type="password"
        autocomplete="new-password"
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
    handleSelectChange() {
      this.form.setFieldsValue({
        email: this.email,
        password: this.password,
        password2: this.password2
      });
    },
    postUser() {
      if (
        this.form.getFieldValue("password") !=
        this.form.getFieldValue("password2")
      ) {
        alert("Passwords do not match");
      } else {
        // fix issues with chrome console logs and catching error
        // Promise for routerpush
        let loginPush = Promise.resolve(this.$router.push("/login"));
        axios
          .post("http://localhost:2019/users", {
            email: this.form.getFieldValue("email"),
            password: this.form.getFieldValue("password"),
            role: "USER"
          })
          .then(res => {
            alert("You account has been made, you will be redirected to login");
            res(loginPush);
          })
          .catch(err => {
            console.log(err);
            err.message;
          });
      }
    }
  }
};
</script>
