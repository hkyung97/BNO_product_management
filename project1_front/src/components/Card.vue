<template>
  <div class="card shadow-sm">
    <router-link :to="'/product/' + products.prdid"> <!-- 클릭 시 상품 상세 페이지로 이동 -->
    <span class="img" :style="{backgroundImage: `url(${products.imgpath})`}"/> <!--이미지가 다를 수 있기에 맞춰주기-->
    </router-link>
    <div class="card-body">
      <p class="card-text">
        <!-- &nbsp; -> 공백 -->
        <span>상품ID : {{ products.prdid }}</span>
      </p>
      <p>
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
    products : Object
  },
  setup(){

    return {lib}
  }
}
</script>

<style scoped>
.card .img {
  display: inline-block;
  width: 100%;
  height: 250px;
  background-size: cover;
  background-position: center;
}

.card-body p {
  text-align: right; /* p 태그 안에 있는 내용을 오른쪽 정렬 */
}

</style>