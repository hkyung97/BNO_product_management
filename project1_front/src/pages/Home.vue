<template>
  <div style="margin-bottom: 5%"></div>
  <div class="home">
    <div class="content">
      <div class="image">
        <!-- 왼쪽에 이미지를 넣을 부분 -->
        <img src="@/assets/logo.png" />
      </div>
      <div class="text">
        <div style="margin-bottom: 50%"></div>
        <h1 v-if="empid">
          {{ empid }}님, 안녕하세요 상품 등록 및 수정 삭제가 가능합니다.
        </h1>
        <h1 v-else-if="memberid">
          {{ memberid }}님, 안녕하세요 상품구매가 가능합니다.
        </h1>
        <h1 v-else>저희 사이트를 방문해 주셔서 감사합니다!</h1>
      </div>
    </div>
  </div>
</template>

<script setup>
import { computed } from "vue";
import { useStore } from "vuex";

const store = useStore();
// Vuex 스토어에서 empid를 가져옵니다.
const empid = computed(() => store.state.account.empid);
const memberid = computed(() => store.state.account.memberid);


</script>

<style scoped>
.home {
  display: flex;
  justify-content: center; /* 수평 가운데 정렬 */
  align-items: center; /* 수직 가운데 정렬 */
  height: 100vh;
}

.content {
  display: flex;
}

.image {
  flex: 1; /* 왼쪽에 이미지가 차지할 공간을 지정*/
  max-width: 100%; /* 최대 너비를 부모 요소에 맞게 설정 */
  height: auto; /* 높이를 자동으로 조절하여 비율 유지 */
}

.text {
  flex: 1; /* 오른쪽에 텍스트가 차지할 공간을 지정 */
  text-align: right, center; /* 오른쪽 정렬 */
}

.switch {
  position: relative;
  display: inline-block;
  width: 60px;
  height: 34px;
  margin-left: 90%;
  position: fixed;
}

.switch input {
  display: none;
}

/* 슬라이더 스타일 */
.slider {
  position: absolute;
  cursor: pointer;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: rgb(238, 225, 42);
  transition: 0.4s;
  border-radius: 34px;
}

.slider:before {
  position: absolute;
  content: "";
  height: 26px;
  width: 26px;
  left: 4px;
  bottom: 4px;
  background-color: rgb(255, 255, 255);
  transition: 0.4s;
  border-radius: 50%;
}

/* On 상태 스타일 */
input:checked + .slider {
  background-color: #2196f3;
}

input:checked + .slider:before {
  transform: translateX(26px);
}
</style>
