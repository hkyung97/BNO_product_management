<template>
  <div class="container">
    <div class="Rectangle1">
      <div>
        <div class="title">상품 정보 수정</div>
        &nbsp;
        <div class="button">
          <button class="register-button" @click="updateProduct">수정완료</button>
        </div>
      </div>
      &nbsp;
      <div class="Rectangle6">
        <img :src="product1 ? product1.imgpath : '/loading.gif'" alt="Product Image" style="max-width: 100%; max-height: 100%;" />
      </div>
      <div class="body-container1" v-if="product1">
        <div class="row">
          <div class="subtitle">
            <span>상품식별자</span>
            &nbsp;
            <!-- <div class="Rectangle4"> -->
              {{ product1.prdid }}
            <!-- </div> -->
          </div>
          <div class="subtitle">
            <span>회사식별자</span>
            &nbsp;
            <!-- <div class="Rectangle4"> -->
              {{ product1.cmpid }}
            <!-- </div> -->
          </div>
          <div class="subtitle">
            <span>상품이름</span>
            <input v-model="product1.prdname" class="Rectangle4" />
          </div>
          <div class="subtitle">
            <span>상품가격</span>
            <input v-model="product1.prdprice" class="Rectangle4" />
          </div>
        </div>
      </div>
      &nbsp;
      <div class="subtitle1" v-if="product1">
        <span>상품내용</span>
        &nbsp;
          <textarea v-model="product1.prddes" class="Rectangle8" />
      </div>
      <div class="loading" v-else>
        데이터를 불러오는 중...
      </div>
    </div>
  </div>
</template>


<script setup>
// import lib from "@/scripts/lib";
import axios from 'axios';
import { ref, onMounted } from 'vue'; // ref 추가
import { useRoute, useRouter } from 'vue-router';

const route = useRoute();
const router = useRouter();
const prdid = route.params.prdid;
const product1 = ref(null); // ref로 데이터 상태 정의

const fetchData = async () => {
  try {
    const response = await axios.get(`/api/products/${prdid}`);
    product1.value = response.data;
  } catch (error) {
    console.error('데이터를 불러오는 중 에러 발생:', error);
  }
};

const updateProduct = async () => {
  try {
    // product1 객체에 있는 정보로 업데이트 요청을 생성
    const updatedProduct = {
      prdid: product1.value.prdid,
      cmpid: product1.value.cmpid,
      prdname: product1.value.prdname,
      prdprice: product1.value.prdprice,
      prddes: product1.value.prddes,
    };

    // PUT 또는 PATCH 요청을 보내어 상품 정보를 업데이트
    await axios.put(`/api/products/${prdid}`, updatedProduct);

    // 업데이트 성공 시 메시지 표시 또는 리다이렉트 등의 작업 수행
    router.push(`/product/${prdid}`);
  } catch (error) {
    console.error('상품 업데이트 중 에러 발생:', error);
  }
};

onMounted(() => {
  fetchData();
});
</script>


<style scoped>
.container {
  display: flex;
  flex-direction: row;
  align-items: center; /* 요소들을 수직 가운데로 정렬 */
}

.row {
  margin: 0 auto; /* 가로 가운데 정렬을 위한 margin 속성 */
  justify-content: center; /* 가로 방향 가운데 정렬 */
  margin-right: -100px; /* 오른쪽으로 10px 이동 */
}

.body-container {
  
  width: 50%;
  margin: 0 auto; /* 가로 가운데 정렬을 위한 margin 속성 */
  justify-content: center; /* 가로 방향 가운데 정렬 */
  align-items: center; /* 세로 방향 가운데 정렬 */
  
}


.body-container1 {
    justify-content: center;
    width: 90%;
}


.Rectangle4 {
  width : 50%;
  margin-top: -45px; /* 위로 10px 올립니다. */
  background: #fefefe;
  border: 2px #0b4ef9 solid;
  margin-left: 30px; /* 위로 10px 올립니다. */
  text-align: center;
}

.Rectangle1 {
  width: 900px;
  height: 1200px;
  background: #fefefe;
  border: 2px #0b4ef9 solid;
  margin-top: 5%; /* 위쪽 여백 추가 */
  margin-left: 17%; /* 왼쪽 여백 추가 */
}

.title {
  width: 50%;
  font-size: 32px; /* 제목 텍스트 크기를 32px로 변경 */
  font-family: Inter;
  font-weight: 400;
  word-wrap: break-word;
  color: #000000;
  text-align: left; /* 텍스트 왼쪽 정렬 추가 */
  font-weight: bold;
  margin-left: 10px; /* 왼쪽 여백을 10px로 설정 */
  margin-top: 10px; /* 위쪽 여백을 10px로 설정 */
}

.subtitle {
  width: 50%;
  font-size: 24px;
  color: #000000;
  text-align: right;
  margin-top: 5%;
  text-align: left; /* 왼쪽 정렬로 변경 */
  
}

.subtitle1 {
  font-size: 24px;
  font-family: Inter;
  word-wrap: break-word;
  color: #000000;
  text-align: left;
  display: flex;
  flex-direction: column;
  direction: ltr;
 
  margin-left: 10px; /* 왼쪽 여백을 10px로 설정 */
  margin-top: 10px; /* 위쪽 여백을 10px로 설정 */
}

.Rectangle8 {
  width: 90%;
  height: 450px;
  background: #fefefe;
  border: 2px #0b4ef9 solid;
  margin: 0 auto; /* 가로 가운데 정렬을 위한 margin 속성 */
  justify-content: center; /* 가로 방향 가운데 정렬 */
  margin-bottom: 50px; /* 위쪽 여백을 10px로 설정 */
  
}

.Rectangle6 {
  width: 80%;
  height: 300px;
  margin: 0 auto; /* 수평 가운데 정렬을 위해 margin을 설정합니다. */
  background: #fefefe;
  border: 2px #0b4ef9 solid;
  display: flex; /* 내용을 가운데 정렬하기 위해 flexbox를 사용합니다. */
  justify-content: center; /* 내용을 수평 가운데로 정렬합니다. */
  align-items: center; /* 내용을 수직 가운데로 정렬합니다. */
}

.button {
   text-align: right; /* 내용을 오른쪽 정렬합니다. */
   margin-right: 10px; /* 오른쪽 여백을 10px로 설정합니다. */
}

.register-button {
  width: 100px;
  height: 48px;
  background: #0a4efa;
  border-radius: 30px;
  color: #fefefe;
  font-size: 20px;
  margin-right: 10%; /* 오른쪽 여백을 10px로 설정합니다. */
}

.register-button:hover, .register-button1:hover {
  font-size: 130%;
  font-weight: bold; /* 텍스트 굵게 설정 */
}

</style>
