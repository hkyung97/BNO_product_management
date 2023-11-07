<template>
  <div class="home">
    <div class="album py-5 bg-body-tertiary">
      <div class="container d-flex justify-content-between align-items-center">
        <h1 class="mb-0">제품 목록</h1>
      </div>
      &nbsp;
      <div class="container">
        <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
          <div class="col" v-for="(products , idx) in state.products" :key="idx">
            <Card1 :products="products"/>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import Card1 from "@/components/Card1.vue"
import { reactive } from 'vue';

export default {
  name : "ProductList",
  components : {Card1},
  props : {
    products : Array,
  },

  setup() {
    const state = reactive({
      // selectedProduct : null,
    });

    const selectProduct = (products) =>{
      state.selectedProduct = products;
    };

    axios.get("/api/products").then(({data}) => {
      state.products = data;
    })

     return { state, selectProduct };
  }
}
</script>

<style scoped>
.container {
  margin-top: 5%;
}
</style>