<template>
  <div class="container mt-5">
    <div class="row justify-content-center">
      <div class="col-md-8">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title">관리자 정보</h5>

            <div class="row mb-3">
              <div class="col">
                <strong>아이디 : </strong> {{ manager.empid }}
              </div>
            </div>
            <div class="row mb-3">
              <div class="col">
                <strong>관리자 이름 :</strong> {{ manager.empname }}
              </div>
            </div>

            <div class="row mb-3">
              <div class="col">
                <div>
                  <strong>관리자 우편번호 : </strong> {{ manager.empaddnum }}
                </div>
              </div>
            </div>
            <div class="row mb-3">
              <div class="col">
                <div><strong>관리자 주소 : </strong> {{ manager.empadd }}</div>
              </div>
              <div class="col">
                <div>
                  <strong>관리자 상세주소 : </strong> {{ manager.empadddetail }}
                </div>
              </div>
            </div>
            <div class="row mb-3">
              <div class="col">
                <strong>관리자 연락처 : </strong> {{ manager.empcontact }}
              </div>
            </div>
          </div>
        </div>

        <div v-if="!manager">
          <p>Loading...</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import axios from "axios";
import { ref, onMounted } from "vue";
import { useRoute } from "vue-router";

const route = useRoute();
const manager = ref({});

const fetchData = async () => {
  try {
    console.log("API 요청 시작");
    const empid = route.params.empid;
    console.log(empid);
    const response = await axios.get(`/api/manager/${empid}`);
    console.log("API 응답:", response.data);
    manager.value = response.data;
  } catch (error) {
    console.error("데이터를 불러오는 중 에러 발생:", error);
  }
};
onMounted(() => {
  fetchData();
});
</script>

<style scoped>
.container {
  background-color: #f8f9fa;
}

.card {
  width: 100%;
  border: none;
  box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
}

.card-body {
  padding: 20px;
  margin-top: 5%;
}

.card-title {
  font-size: 2.5rem;
  margin-bottom: 15px;
}

strong {
  font-weight: bold;
  font-size: 1.5rem;
}

.mb-3 {
  margin-bottom: 15px;
  margin-top: 5%;
  font-size: 1.3rem;
}
</style>