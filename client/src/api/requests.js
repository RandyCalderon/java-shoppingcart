import axios from 'axios';

module.exports = {
  fetchProducts() {
    axios
      .get('http://localhost:2019/products')
      .then(res => (this.products = res.data))
      .catch(err => err.message);
  },
};
