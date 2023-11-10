<template>
  <div class="form-signin w-100 m-auto">
    <h1 class="h3 mb-3 fw-normal">관리자 회원가입</h1>

    <!-- <div class="form-floating mb-4">
      <input
        type="text"
        class="form-control"
        id="empid"
        v-model="manager.empid"
      />
      <label for="empid">직원 아이디 (ex: emp00000)</label>
    </div> -->

    <div class="form-floating mb-4">
      <input
        type="text"
        class="form-control"
        id="emppassword"
        v-model="manager.emppassword"
      />
      <label for="emppassword"
        >비밀번호(영어,숫자, 특수문자 포함 8자리 이하로 작성해주세요)</label
      >
    </div>

    <div class="form-floating mb-4">
      <input
        type="text"
        class="form-control"
        id="empname"
        v-model="manager.empname"
      />
      <label for="empname">직원 이름</label>
    </div>

    <div class="form-floating mb-4">
      <input
        type="text"
        class="form-control"
        id="depname"
        v-model="manager.depname"
      />
      <label for="depname">부서 이름</label>
    </div>

    <div class="form-floating mb-4">
      <select class="form-control" id="cmpid" v-model="manager.cmpid">
        <option value="">-- 회사 선택 --</option>
        <option value="cmp69934">비앤오소프트</option>
        <option value="cmp04240">롯데정보통신</option>
      </select>
    </div>

    <Address v-model:manager="manager" />

    <div class="form-floating mb-4">
      <input
        type="text"
        class="form-control"
        id="empadddetail"
        v-model="manager.empadddetail"
      />
      <label for="empadddetail">상세 주소</label>
    </div>

    <div class="form-floating mb-4">
      <input
        type="text"
        class="form-control"
        id="empcontact"
        v-model="manager.empcontact"
      />
      <label for="empcontact">전화번호 (ex : 010-0000-0000)</label>
    </div>

    <div class="form-floating mb-4">
      <input
        type="text"
        class="form-control"
        id="emppos"
        v-model="manager.emppos"
      />
      <label for="emppos">직급</label>
    </div>

    <button class="btn btn-primary w-100 py-2" @click="submitForm">
      회원가입
    </button>
  </div>
</template>

<script setup>
import axios from "axios";
import router from "@/scripts/router";
import { ref } from "vue";
import Address from "@/components/Address.vue";

const manager = ref({
  empid: "",
  empname: "",
  depname: "",
  cmpid: "",
  empadd: "",
  empcontact: "",
  emppos: "",
  empaddnum: "",
  empadddetail: "",
  emppassword: ""
});

const submitForm = () => {
  console.log("Selected company:", manager.value);
  addManager();
};

const addManager = async () => {
  console.log("Selected company:", manager.value);
  try {
    const response = await axios.post("/api/manager/add", manager.value);
    alert(response.data);
    router.push({ path: "/" });
  } catch (error) {
    alert("Error adding manager: " + error.message);
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
