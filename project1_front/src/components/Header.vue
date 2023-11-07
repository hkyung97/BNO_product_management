<template>
  <header data-bs-theme="dark">
    <div class="collapse text-bg-dark" id="navbarHeader">
      <div class="container">
        <div class="row">
          <div class="col-sm-4 py-4">
            <h4>사이트맵</h4>
            <ul class="list-inline">
              <!-- 변경 -->
              <li class="list-inline-item">
                <!-- 변경 -->
                <router-link to="/" class="text-black">메인화면</router-link>
              </li>
              <li class="list-inline-item">
                <!-- 변경 -->
                <router-link
                  to="/login"
                  class="text-black"
                  v-if="!$store.state.account.empid"
                  >로그인</router-link
                >
                <a to="/login" class="text-black" @click="logout()" v-else
                  >로그아웃</a
                >
              </li>
              <li class="list-inline-item">
                <!-- 변경 -->
                <router-link to="/productlist" class="text-black"
                  >상품관리</router-link
                >
              </li>
              <li class="list-inline-item">
                <!-- 변경 -->
                <router-link
                  to="/managerregister"
                  class="text-black"
                  v-if="!empid"
                >
                  회원가입
                </router-link>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
    <nav class="navbar navbar-dark bg-dark shadow-sm fixed-top">
      <div class="container">
        <a href="#" class="navbar-brand d-flex align-items-center">
          <svg
            xmlns="http://www.w3.org/2000/svg"
            width="20"
            height="20"
            fill="none"
            stroke="currentColor"
            stroke-linecap="round"
            stroke-linejoin="round"
            stroke-width="2"
            aria-hidden="true"
            class="me-2"
            viewBox="0 0 24 24"
          >
            <circle cx="12" cy="13" r="4" />
          </svg>
          <strong>상품관리 페이지</strong>
        </a>
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarHeader"
          aria-controls="navbarHeader"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
      </div>
    </nav>
  </header>
</template>

<script setup>
import router from "@/scripts/router";
// import store from "@/scripts/store";
import { computed } from "vue";
import { useStore } from "vuex";

const store = useStore();
// Vuex 스토어에서 empid를 가져옵니다.
const empid = computed(() => store.state.account.empid);

const logout = () => {
  store.commit("setAccount", 0);
  sessionStorage.removeItem("empid");
  router.push({ path: "/" });
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.row {
  background-color: rgb(248, 245, 211);
}

.text-black {
  font-weight: bold;
}
</style>
