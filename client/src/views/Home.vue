<template>
  <div class="home">
    <h1>Products</h1>
    <Product/>
  </div>
</template>

<script>
// @ is an alias to /src
import Product from "@/components/Product.vue";

export default {
  name: "home",
  components: {
    Product
  }
};
</script>
