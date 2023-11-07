<template>
  <div class="card shadow-sm">
    <router-link :to="'/productdetail/' + products.prdid">
      <div class="img" :style="{ backgroundImage: `url(${products.imgpath})` }"></div>
    </router-link>
    <div class="card-body">
      <p class="card-text">
        <span>상품이름 : {{ products.prdname }}</span>
      </p>
      <p>
        <span>상품가격 : {{ lib.getNumberFormatted(products.prdprice) }}원</span>
      </p>
    </div>
  </div>
</template>

<script>
import lib from "@/scripts/lib";

export default {
  name: "Card",
  props: {
    products: Object,
  },
  setup() {
    return { lib };
  },
};
</script>

<style scoped>
.card {
  display: flex;
  flex-direction: column;
  margin: 10px;
  border: 1px solid #e0e0e0;
  background: #fff;
  border-radius: 5px;
  transition: transform 0.2s;
  box-shadow: 0 1px 3px rgba(0, 0, 0, 0.12), 0 1px 2px rgba(0, 0, 0, 0.24);
}

.card:hover {
  transform: translateY(-5px);
}

.img {
  width: 100%;
  height: 250px;
  background-size: cover;
  background-position: center;
  border-top-left-radius: 5px;
  border-top-right-radius: 5px;
}

.card-body {
  padding: 1rem;
  text-align: right;
}

.card-text {
  font-weight: 600;
  font-size: 18px;
}

.card-text span {
  display: block;
}

/* 추가적인 스타일링을 원하는 대로 적용할 수 있습니다. */
</style>
