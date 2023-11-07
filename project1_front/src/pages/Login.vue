<template>
  <div class="form-signin w-100 m-auto">
    <div style="margin-bottom: 10%"></div>
    <h1 class="h3 mb-3 fw-normal">EMP_ID를 입력해주세요</h1>
    <div style="margin-bottom: 20%"></div>
    <div class="form-floating">
      <input
        type="id"
        class="form-control"
        id="floatingInput"
        v-model="state.form.empid"
      />
      <label for="floatingInput">emp00000</label>
    </div>
    <div class="form-floating">
      <input
        type="password"
        class="form-control"
        id="floatingPassword"
        v-model="state.form.emppassword"
      />
      <label for="floatingInput">비밀번호를 입력해주세요(영어,숫자 포함 8자리 이하)</label>
    </div>
    <div style="margin-bottom: 30%"></div>
    <button class="btn btn-primary w-100 py-2" @click="submit()">
      Sign in
    </button>
  </div>
</template>

<script>
import { reactive } from "vue";
import axios from "axios";
import store from "@/scripts/store";
import router from "@/scripts/router";

export default {
  setup() {
    const state = reactive({
      form: {
        empid: "",
        emppassword: ""
      },
    });

    const submit = () => {
      axios
        .post("/api/manager/login", state.form)
        .then((res) => {
          store.commit("setAccount", res.data);
          console.log(res.data);
          sessionStorage.setItem("empid", res.data);
          router.push({ path: "/" });

          window.alert("로그인 하였습니다.");
        })
        .catch(() => {
          window.alert("로그인 정보가 존재하지 않습니다.");
        });
    };
    return { state, submit };
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

.form-signin input[type="empid"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}

.form-signin input[type="emppassword"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}
</style>
