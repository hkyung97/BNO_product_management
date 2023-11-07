<template>
  <!-- 사용자 모드와 관리자 모드를 선택하는 버튼 추가 -->
  <div>
    <label class="switch">
      <input type="checkbox" id="toggleSwitch" v-model="isSwitchOn" @change="toggleSwitch" />
      <span class="slider round"></span>
    </label>
  </div>
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
          {{ empid }}님,상품관리자 페이지에 오신 것을 환영합니다.
        </h1>
        <h1 v-else>상품관리자 페이지에 오신 것을 환영합니다!</h1>
      </div>
    </div>
  </div>
</template>

<script setup>
import { computed} from "vue";
import { useStore } from "vuex";


// const form = ref({
//   empid: "",
// });

const store = useStore();

// Vuex 스토어에서 empid를 가져옵니다.
const empid = computed(() => store.state.account.empid);

// Vuex 스토어에서 사용자 모드 정보를 가져옵니다.
const isSwitchOn = computed(() => store.state.isUserMode);

// 스위치를 토글하는 함수
const toggleSwitch = () => {
  store.commit("switchMode", !isSwitchOn.value); // 스위치를 토글할 때 Vuex 스토어의 모드 값을 변경

  if (isSwitchOn.value) {
    console.log("스위치가 켜졌습니다 (관리자 모드).");
    // 스위치가 켜진 경우에 수행할 동작 추가 (관리자 모드)
  } else {
    console.log("스위치가 꺼졌습니다 (사용자 모드).");
    // 스위치가 꺼진 경우에 수행할 동작 추가 (사용자 모드)
  }
};

// 로그인 함수를 onMounted 훅 내에서 호출
// onMounted(() => {
//   login();
// });

// const login = async () => {
//   const response = await axios.post("/api/manager/login", form.value);
//   store.commit("setAccount", response.data);
// };
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
  transition: .4s;
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
  transition: .4s;
  border-radius: 50%;
}

/* On 상태 스타일 */
input:checked + .slider {
  background-color: #2196F3;
}

input:checked + .slider:before {
  transform: translateX(26px);
}


</style>

