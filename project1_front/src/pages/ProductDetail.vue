<template>
  <div class="container">
    <div class="col" v-for="(product1 , idx) in state.product1" :key="idx">
    
    <div class="Rectangle1">
      <div>
        <div class="title">상품 상세</div>
        &nbsp;
        <div class = "button">
          <button class="register-button" @click="prdEdit">수정</button>&nbsp;
          <button class="register-button1" @click="prdDelete">삭제</button>
        </div>
      </div>
    &nbsp;
    <div class="Rectangle6">
      <img :src="product1.imgpath" alt="Product Image" style="max-width: 100%; max-height: 100%;"/>
    </div>

      <div class="body-container1">
        <div class="row">
          <div class="subtitle">
            <span>상품식별자</span>
            <div class="Rectangle4">
              {{product1.prdid}}
            </div>
          </div>
        
        
          <div class="subtitle">
            <span>회사식별자</span>
            <div class="Rectangle4">
              {{ product1.cmpid }}
            </div>
          </div>
       
        
          <div class="subtitle">
            <span>상품이름</span>
            <div class="Rectangle4">
              {{ product1.prdname }}
            </div>
          </div>
        
        
          <div class="subtitle">
            <span>상품가격</span>
            <div class="Rectangle4">
              {{ lib.getNumberFormatted(product1.prdprice) }}원
            </div>
          </div>
        </div>
      </div>

      
        <div class="subtitle1">
          <span>상품내용</span>
          &nbsp;
          <div class="Rectangle8">
            {{ product1.prddes }}
          </div>
        </div>

      </div>
    </div>
  </div>
  
</template>

<script>
import lib from "@/scripts/lib";
import axios from 'axios';
import { reactive } from 'vue';

export default {
  name : "ProductDetail",
  // props : {
  //   product1 : Object
  // },
  data() {
    return {
      product1: {
        imgpath : null,
        prdid: "",
        cmpid: "",
        prdname: "",
        prdprice: "",
        prddes: ""
      },
       
    };
  },
  
  setup(){

    const state = reactive({
      product1 : null,
    })

    
    axios.get('/api/products/${prdid}').then(({data}) =>{
      state.product1 = data;
    })
    
    
    return { state, lib }
  }
}
</script>
<style scoped>
.container {
  display: flex;
  flex-direction: row;
  align-items: center; /* 요소들을 수직 가운데로 정렬 */
}

.row {
right: 20%;
  margin: 0 auto; /* 가로 가운데 정렬을 위한 margin 속성 */
  justify-content: center; /* 가로 방향 가운데 정렬 */
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
  margin-left: 180px; /* 위로 10px 올립니다. */
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
  margin-top: 50px; /* 위쪽 여백을 10px로 설정 */
}

.Rectangle8 {
  width: 90%;
  height: 450px;
  background: #fefefe;
  border: 2px #0b4ef9 solid;
  margin: 0 auto; /* 가로 가운데 정렬을 위한 margin 속성 */
  justify-content: center; /* 가로 방향 가운데 정렬 */
  
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
  
}

.register-button1 {
  width: 100px;
  height: 48px;
  background: #f10404;
  border-radius: 30px;
  color: #fefefe;
  font-size: 20px;
}

.register-button:hover, .register-button1:hover {
  font-size: 130%;
  font-weight: bold; /* 텍스트 굵게 설정 */
}

</style>
