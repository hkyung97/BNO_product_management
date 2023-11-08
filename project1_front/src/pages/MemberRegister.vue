<template>
  <div class="form-signin w-100 m-auto">
    <h1 class="h3 mb-3 fw-normal">개인 회원가입</h1>

    <div class="form-floating mb-4">
      <input
        type="text"
        class="form-control"
        id="memberid"
        v-model="member.memberid"
      />
      <label for="memberid">회원 아이디 (8자리 이하로 작성해주세요)</label>
    </div>

    <div class="form-floating mb-4">
      <input
        type="text"
        class="form-control"
        id="memberpassword"
        v-model="member.memberpassword"
      />
      <label for="memberpassword"
        >비밀번호(영어,숫자, 특수문자 포함 8자리 이하로 작성해주세요)</label
      >
    </div>

    <div class="form-floating mb-4">
      <input
        type="text"
        class="form-control"
        id="membername"
        v-model="member.membername"
      />
      <label for="membername">회원 이름</label>
    </div>

    <div class="form-floating mb-4">
      <input
        type="text"
        class="form-control"
        id="memberemail"
        v-model="member.memberemail"
      />
      <label for="memberemail">이메일</label>
    </div>

    <div class="mb-4">
      <label for="membergender" class="form-label">성별 선택</label> &nbsp;
      <div class="form-check form-check-inline">
        <input
          class="form-check-input"
          type="radio"
          name="membergender"
          id="male"
          value="male"
          v-model="member.membergender"
        />
        <label class="form-check-label" for="male">남자</label>
      </div>
      <div class="form-check form-check-inline">
        <input
          class="form-check-input"
          type="radio"
          name="gender"
          id="female"
          value="female"
          v-model="member.membergender"
        />
        <label class="form-check-label" for="female">여자</label>
      </div>
    </div>

    <MemberAddress v-model:member="member" />

    <div class="form-floating mb-4">
      <input
        type="text"
        class="form-control"
        id="memberadddetail"
        v-model="member.memberadddetail"
      />
      <label for="memberadddetail">상세 주소</label>
    </div>

    <div class="form-floating mb-4">
      <input
        type="text"
        class="form-control"
        id="membercontact"
        v-model="member.membercontact"
      />
      <label for="membercontact">전화번호 (ex : 010-0000-0000)</label>
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
import MemberAddress from "@/components/MemberAddress.vue";

const member = ref({
  memberid: "",
  memberpassword: "",
  membername: "",
  memberaddnum: "",
  memberadd: "",
  memberadddetail: "",
  membercontact: "",
  membergender: "",
  memberemail: "",
});

const submitForm = () => {
  console.log("Selected company:", member.value);
  addMember();
};

const addMember = async () => {
  console.log("Selected company:", member.value);
  try {
    const response = await axios.post("/api/member/add", member.value);
    alert(response.data);
    router.push({ path: "/" });
  } catch (error) {
    alert("Error adding member: " + error.message);
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
