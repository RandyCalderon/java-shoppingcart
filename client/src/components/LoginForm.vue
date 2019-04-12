<template>
  <a-form id="wrapper" :form="form" @submit="loginUser">
    <a-form-item label="Email">
      <a-input
        v-decorator="[
        'email',
        {rules: [{ required: true, message: 'Please input your email'}]}
      ]"
        placeholder="Email"
        autocomplete="username email"
      />
    </a-form-item>
    <a-form-item>
      <a-input
        v-decorator="[
      'password',
      {initialValue: '', rules: [{ required: true, message: 'Please input your password'}]}
      ]"
        type="password"
        autocomplete="password"
        placeholder="Password"
      />
    </a-form-item>
    <a-button type="primary" htmlType="submit">Login</a-button>
  </a-form>
</template>

<style>
#wrapper {
  max-width: 350px;
  margin: 0 auto;
}
</style>