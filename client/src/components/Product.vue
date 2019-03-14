<template>
  <div id="wrapper">
    <div id="products" v-for="product in products" :key="product.productid">
      <h3>{{ product.productname }}</h3>
      <p>{{ product.description }}</p>
      <span>{{ product.price }}</span>
    </div>
  </div>
</template>

<style scoped>
#wrapper {
  display: flex;
  max-width: 800px;
  font-size: 20px;
  justify-content: space-evenly;
  flex-wrap: wrap;
  margin: 0 auto;
}

#products {
  width: 250px;
  display: flex;
  flex-direction: column;
  padding-bottom: 35px;
}
</style>

<script>
import axios from "axios";
export default {
  name: "product",
  data() {
    return {
      products: null
    };
  },
  mounted() {
    axios
      .get("http://localhost:2019/products")
      .then(res => (this.products = res.data))
      .catch(err => err.message);
  }
};
</script>
