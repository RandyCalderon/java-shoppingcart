<template>
  <div>
    <div id="suppliers" v-for="supplier in suppliers" :key="supplier.supplierid">
      <h3>{{ supplier.suppliername}}</h3>
      <span>{{ supplier.productname }}</span>
      <span>{{ supplier.quantity }}</span>
    </div>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "supplier",
  data() {
    return {
      suppliers: null
    };
  },
  mounted() {
    axios
      .get("http://localhost:2019/suppliers")
      .then(res => (this.suppliers = res.data))
      .catch(err => {
        err.message;
      });
  }
};
</script>