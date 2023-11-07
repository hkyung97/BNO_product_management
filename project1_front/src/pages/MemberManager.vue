<template>
  <div class="login-type">
    <h1 class="h3 mb-3 fw-normal">회원가입 유형을 선택해주세요</h1>
    <div class="btn-group" role="group">
      <button
        type="button"
        class="btn btn-primary"
        @click="selectUserType('individual')"
      >
        개인
      </button>
      <button
        type="button"
        class="btn btn-primary"
        @click="selectUserType('admin')"
      >
        관리자
      </button>
    </div>
  </div>
</template>

<script>
import { useRouter } from "vue-router";

export default {
  setup() {
    const router = useRouter();

    const selectUserType = (type) => {
      if (type === "individual") {
        router.push("/memberregister"); // 개인 로그인 페이지로 이동
      } else if (type === "admin") {
        router.push("/managerregister"); // 관리자 로그인 페이지로 이동
      }
    };

    return {
      selectUserType,
    };
  },
};
</script>

<style scoped>
.login-type {
  max-width: 50%;
  margin: 0 auto;
  text-align: center;
  margin-top: 7%;
  padding: 20px;
  border: 1px solid #ddd;
  border-radius: 10px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  height: 60vh; /* 뷰포트 높이의 80%로 설정, 뷰포트 높이에 따라 조절됨 */
}

.btn-group {
  display: flex;
  justify-content: center;
  gap: 10px;
  margin-top: 20px;
}

.btn {
  padding: 10px 20px;
  font-size: 50px;
  background-color: rgb(253, 157, 31);
  color: #fff;
  border: none;
  border-radius: 10px;
  cursor: pointer;
  height: 50vh;
}

.btn:hover {
  background-color: #b36b00;
}

</style>

