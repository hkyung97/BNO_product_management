<template>
  <div class="container">
    <div class="Rectangle1">
      <div>
        <div class="title">상품등록</div>
        <button class="register-button" @click="submitForm">등록하기</button>
      </div>

      <form @submit.prevent="addProduct">
        <div class="body-container">
          <div class="Rectangle6">
            <div class="add-photo-button" @click="openFileInput"></div>
            <input
              type="file"
              ref="fileInput"
              class="file-input"
              @change="handleFileUpload"
            />
            <!-- 추가: 이미지 미리보기 -->
            <img v-if="product.imgpath" :src="product.imgpath" alt="Product Preview" />
          </div>

          <div class="body-container1">
            <div class="row">
              <div class="subtitle">
                <span>상품식별자</span>
                <input
                  type="text"
                  class="Rectangle2"
                  v-model="product.prdid"
                  placeholder="상품식별자를 입력하세요( ex : prd00000 )"
                />
              </div>
            </div>
            <div class="row">
              <div class="subtitle">
                <span>회사식별자</span>
                <select class="Rectangle4" v-model="product.cmpid">
                  <option value="">-- 회사 식별자 선택 --</option>
                  <option value="cmp00001">비앤오소프트</option>
                  <option value="cmp00002">롯데정보통신</option>
                </select>
              </div>
            </div>
            <div class="row">
              <div class="subtitle">
                상품이름
                <input
                  type="text"
                  class="Rectangle5"
                  placeholder="상품이름을 입력하세요"
                  v-model="product.prdname"
                />
              </div>
            </div>
            <div class="row">
              <div class="subtitle">
                상품금액
                <input
                  type="text"
                  class="Rectangle7"
                  placeholder="상품금액을 입력하세요"
                  v-model="product.prdprice"
                />
              </div>
            </div>
          </div>
        </div>

        <div class="row">
          <div class="subtitle1">
            <p>상품설명</p>
            <textarea
              class="Rectangle8"
              placeholder="상품에 대한 설명을 입력하세요"
              v-model="product.prddes"
            ></textarea>
          </div>
        </div>
      </form>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import axios from 'axios';
import { useRouter } from 'vue-router';

const product = ref({
  imagePreview: null,
  prdid: "",
  prdname: "",
  prdprice: "",
  prddes: "",
  cmpid: "",
});

const addProduct = async () => {
  console.log("Selected company:", product.value.cmpid);
  try {
    const response = await axios.post("/api/products/add", product.value);
    alert(response.data);
    const router = useRouter();
    router.push("/productlist");
  } catch (error) {
    alert("Error adding product: " + error.message);
  }
};

const submitForm = () => {
  addProduct();
};
</script>


<style scoped>
.container {
  display: flex;
  flex-direction: row;
  align-items: center; /* 요소들을 수직 가운데로 정렬 */
  margin-top: 5%;
}

.row {
  margin: 5px 0;
  margin-bottom: 0%; /* 위쪽 여백 추가 */
}
.body-container {
  display: flex;
  flex-direction: row;
  width: 100%;
  margin: auto; /* 가로 가운데 정렬을 위한 margin 속성 */
  justify-content: center; /* 가로 방향 가운데 정렬 */
  align-items: center; /* 세로 방향 가운데 정렬 */
}

.body-container1 {
  justify-content: center;
  width: 90%;
}

.Rectangle2,
.Rectangle4,
.Rectangle5,
.Rectangle7 {
  width: 50%;
  height: 57px;
  background: #fefefe;
  border: 2px #0b4ef9 solid;
  text-align: left;
  font-size: 13px;
  align-items: center;
  justify-content: center;
  margin-left: 15%; /* 오른쪽 여백 추가 */
  margin-top: 5%; /* 위쪽 여백 추가 */
}

.Rectangle1 {
  width: 900px;
  height: 1000px;
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
}

.subtitle {
  font-size: 24px;
  color: #000000;
  text-align: right;
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
}

.Rectangle8 {
  width: 90%;
  height: 450px; /* 수정: 높이 조정 */
  background: #fefefe;
  border: 2px solid #0b4ef9;
  margin: 0 auto;
  padding: 10px; /* 수정: 내부 여백 추가 */
  justify-content: center;
  align-items: center;
  resize: none; /* 수정: 크기 조정 금지 */
}

.Rectangle6 {
  width: 500px;
  height: 300px;
  justify-content: center;
  background: #fefefe;
  border: 2px #0b4ef9 solid;
  margin-left: 50px; 
}

.register-button {
  width: 100px;
  height: 48px;
  background: #0a4efa;
  border-radius: 30px;

  justify-content: center; /* 수평 가운데 정렬 */
  align-items: center; /* 수직 가운데 정렬 */
  color: #fefefe;
  margin-left: 85%; /* 왼쪽 여백 추가 */
}

.register-button:hover {
  font-size: 110%;
  font-weight: bold; /* 텍스트 굵게 설정 */
}
</style>
