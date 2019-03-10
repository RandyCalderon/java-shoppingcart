<template>
  <a-form id="wrapper" :form="form">
    <a-form-item label="Email">
      <a-input
        v-decorator="[
          'email',
          {rules: [{ required: true, message: 'Please input your email' }]}
        ]"
        placeholder="Email"
      />
    </a-form-item>
    <a-form-item label="Password">
      <a-input
        v-decorator="[
          'password',
          {rules: [{ required: true, message: 'Please input your password' }]}
        ]"
        placeholder="Password"
      />
    </a-form-item>
    <a-button type="primary" @click="check">Submit</a-button>
  </a-form>
</template>

<style scoped>
#wrapper {
  max-width: 350px;
  margin: 0 auto;
}
</style>

<script>
export default {
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
    }
  }
};
</script>
