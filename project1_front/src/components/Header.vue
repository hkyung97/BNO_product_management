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
                <router-link to="/login" class="text-black" v-if="!isLoggedIn"
                  >로그인</router-link
                >
                <a
                  to="/login"
                  class="text-black"
                  @click="logout"
                  v-if="isLoggedIn"
                  >로그아웃</a
                >
              </li>
              <li class="list-inline-item">
                <!-- 변경 -->
                <router-link
                  to="/productlist"
                  class="text-black"
                  v-if="$store.state.account.empid"
                  >상품관리</router-link
                >
              </li>
              <li class="list-inline-item">
                <!-- 변경 -->
                <router-link
                  to="/companyregister"
                  class="text-black"
                  v-if="$store.state.account.empid"
                  >회사 정보 등록</router-link
                >
              </li>
              <li class="list-inline-item">
                <!-- 변경 -->
                <router-link
                  to="/membermanager"
                  class="text-black"
                  v-if="!isLoggedIn"
                >
                  회원가입
                </router-link>
              </li>
              <li class="list-inline-item">
                <!-- 변경 -->
                <router-link
                  to="/productpurchasing"
                  class="text-black"
                  v-if="$store.state.account.memberid"
                  >상품구매</router-link
                >
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
import { computed } from "vue";
import router from "@/scripts/router";
import { useStore } from "vuex";

const store = useStore();

const isLoggedIn = computed(() => {
  const empid = store.state.account.empid;
  const memberid = store.state.account.memberid;
  return empid || memberid;
});

const logout = () => {
  if (store.state.account.empid) {
    store.commit("setEmpId", null); // Vuex 스토어에서 empid 제거
    sessionStorage.removeItem("empid");
  } else if (store.state.account.memberid) {
    store.commit("setMemberId", null); // Vuex 스토어에서 memberid 제거
    sessionStorage.removeItem("memberid");
  }
  router.push({ path: "/" });
};
</script>

<style scoped>
.row {
  background-color: rgb(248, 245, 211);
}

.text-black {
  font-weight: bold;
}
</style>
