<template>
<div style="margin-bottom: 5%;"></div>
  <div class="home">
    
    <div class="content">
      <div class="image">
        <!-- 왼쪽에 이미지를 넣을 부분 -->
        <img src="@/assets/logo.png">
      </div>
      <div class="text">
        <div style="margin-bottom: 50%;"></div>
        <h1 v-if="empid">{{ empid }}님,상품관리자 페이지에 오신 것을 환영합니다.</h1>
        <h1 v-else>상품관리자 페이지에 오신 것을 환영합니다</h1>
      </div>
    </div>
  </div>
</template>

<script>
import { computed, ref } from 'vue';
import { useStore } from 'vuex';
import axios from 'axios';

export default {
  setup() {
    const store = useStore();
    const form = ref({
      empid: ''
    });

    // Vuex 스토어에서 empid를 가져옵니다.
    const empid = computed(() => store.state.account.empid);

    const login = async () => {
      const response = await axios.post('/api/manager/login', form.value);
      store.commit('setAccount', response.data);
    };

    // 로그인 함수를 setup 함수 내에서 호출하거나, 컴포넌트 라이프사이클 훅에서 호출할 수 있습니다.
    // 이 예제에서는 setup 함수 내에서 호출하였습니다.
    login();

    return { empid, form, login };
  },
};
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
</style>
