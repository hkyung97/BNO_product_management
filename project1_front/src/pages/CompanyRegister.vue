<template>
  <div class="form-signin w-100 m-auto">
    <h1 class="h3 mb-3 fw-normal">회사 정보 등록</h1>
    <div>
      <div class="form-floating mb-4">
        <input
          type="text"
          class="form-control"
          id="cmpname"
          v-model="company.cmpname"
        />
        <label for="cmpname">회사 이름</label>
      </div>

      <div>
        <div class="form-floating mb-4">
          <input
            type="text"
            class="form-control"
            id="cmpindu"
            v-model="company.cmpindu"
          />
          <label for="cmpindu">회사 업종 (아래 버튼을 눌러 업종 코드를 찾아서 입력해주세요)</label>
        </div>

        <button @click="findIndustryCode">업종 코드 찾기</button>
      </div>
      &nbsp;
      <CompanyAddress v-model:company="company" />

      <div class="form-floating mb-4">
        <input
          type="text"
          class="form-control"
          id="cmpadddetail"
          v-model="company.cmpadddetail"
        />
        <label for="cmpadddetail">상세 주소</label>
      </div>

      <div class="form-floating mb-4">
        <input
          type="text"
          class="form-control"
          id="cmpcontact"
          v-model="company.cmpcontact"
        />
        <label for="cmpcontact">회사번호</label>
      </div>

      <div class="form-floating mb-4">
        <textarea
          type="text"
          class="form-control"
          id="cmpinfo"
          v-model="company.cmpinfo"
        />
        <label for="cmpinfo">회사정보</label>
      </div>

      <button class="btn btn-primary w-100 py-2" @click="submitForm">
        회사등록
      </button>
    </div>
  </div>
</template>

<script setup>
import axios from "axios";
import router from "@/scripts/router";
import { ref } from "vue";
import CompanyAddress from "@/components/CompanyAddress.vue";

const company = ref({
  cmpid: "",
  cmpname: "",
  cmpadd: "",
  cmpcontact: "",
  cmppos: "",
  cmpaddnum: "",
  cmpadddetail: "",
});

const findIndustryCode = () => {
  // 업종 코드 찾기 버튼을 클릭하면 다음 URL로 이동합니다.
  window.location.href =
    "https://www.bigservice.co.kr/entsimpleinfo/gaeyo_ntscode.asp";
};

const submitForm = () => {
  console.log("Selected company:", company.value);
  addcompany();
};

const addcompany = async () => {
  console.log("Selected company:", company.value);
  try {
    const response = await axios.post("/api/company/add", company.value);
    alert(response.data);
    router.push({ path: "/" });
  } catch (error) {
    alert("Error adding company: " + error.message);
  }
};
</script>

<style scoped>
.form-signin {
  max-width: 50%;
  padding: 1rem;
  margin-top: 5%;
  padding-top: 5%; /* 위 여백 추가 */
  padding-bottom: 5%; /* 아래 여백 추가 */
}

/* .form-signin .form-floating:focus-within {
  z-index: 2;
} */

.form-signin input[type="text"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}
</style>
