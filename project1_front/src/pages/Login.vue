<template>
  <div class="form-signin w-100 m-auto">
    <div style="margin-bottom: 10%"></div>
    <h1 class="h3 mb-3 fw-normal">로그인</h1>

    <div class="form-floating">
      <input
        type="text"
        class="form-control"
        id="floatingInput"
        :value="isManager ? form.empid : form.memberid"
        @input="
          isManager
            ? (form.empid = $event.target.value)
            : (form.memberid = $event.target.value)
        "
        placeholder="아이디"
      />
      <label for="floatingInput">아이디</label>
    </div>

    <div class="form-floating">
      <input
        type="password"
        class="form-control"
        id="floatingPassword"
        :value="isManager ? form.emppassword : form.memberpassword"
        @input="
          isManager
            ? (form.emppassword = $event.target.value)
            : (form.memberpassword = $event.target.value)
        "
        placeholder="비밀번호"
      />
      <label for="floatingPassword">비밀번호</label>
    </div>

 <div class="form-check form-switch">
  <input
    class="form-check-input"
    type="checkbox"
    id="roleSwitch"
    v-model="isManager"
  />
  <label class="form-check-label" for="roleSwitch">
  </label>
  <span v-if="isManager">관리자 모드</span>
  <span v-else>개인 모드</span>
</div>
    <div style="margin-bottom: 30%"></div>

    <button class="btn btn-primary w-100 py-2" @click="submitForm">
      로그인
    </button>
  </div>
</template>

<script>
import { ref, onMounted } from "vue";
import axios from "axios";
import store from "@/scripts/store";
import router from "@/scripts/router";

export default {
  setup() {
    const form = ref({
      empid: "",
      memberid: "",
      emppassword: "",
      memberpassword: "",
    });

    const isManager = ref(false);

    const submitForm = () => {
      const loginEndpoint = isManager.value
        ? "/api/manager/login"
        : "/api/member/login";
      const formData = isManager.value
        ? {
            empid: form.value.empid,
            emppassword: form.value.emppassword,
          }
        : {
            memberid: form.value.memberid,
            memberpassword: form.value.memberpassword,
          };

      axios
        .post(loginEndpoint, formData)
        .then((res) => {
          if (isManager.value) {
            store.commit("setEmpId", res.data); // Vuex 스토어에 로그인 정보 저장
            sessionStorage.setItem("empid", form.value.empid); // sessionStorage에도 저장
          } else {
            store.commit("setMemberId", res.data); // Vuex 스토어에 로그인 정보 저장
            sessionStorage.setItem("memberid", form.value.memberid); // sessionStorage에도 저장
          }

          // 로그인 성공 처리
          console.log(res.data);
          console.log(sessionStorage);
          window.alert("로그인 하였습니다.");
          router.push({ path: "/" }); // 홈 화면의 라우트 경로에 따라 수정
        })
        .catch(() => {
          // 로그인 실패 처리
          window.alert("로그인 정보가 존재하지 않습니다.");
        });
    };

    // 컴포넌트 초기화 시 Vuex 스토어에서 로그인 정보 가져오기
    onMounted(() => {
      const empid = store.state.empid;
      const memberid = store.state.memberid;
      if (empid || memberid) {
        // 스토어에 정보가 있으면 form에 할당
        form.value.empid = empid;
        form.value.memberid = memberid;
      }
    });

    return { form, isManager, submitForm };
  },
};
</script>

<style scoped>
html,
body {
  height: 100%;
}

.form-signin {
  max-width: 500px;
  padding: 1rem;
}

.form-signin .form-floating:focus-within {
  z-index: 2;
}

.form-signin input[type="text"],
.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-radius: 0;
}

.form-check.form-switch {
  margin: 10px 0;
}
</style>
