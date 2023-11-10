<template>
  <div class="container mt-5">
    <div class="row justify-content-center">
      <div class="col-md-8">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title">사원 및 회사 정보</h5>

            <div class="row mb-3">
              <div class="col">
                <strong>아이디 : </strong> {{ manager.empid }}
              </div>
            </div>
            <div class="row mb-3">
              <div class="col">
                <strong>관리자 이름 : </strong> {{ manager.empname }}
              </div>
            </div>
            <div class="row mb-3">
              <div class="col">
                <strong>관리자 직급 : </strong> {{ manager.emppos }}
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
<div class="row mb-3 divider">
  <div class="col">
    <strong>관리자 연락처 : </strong> {{ manager.empcontact }}
  </div>
</div>

<div class="row mb-3">
  <div class="col">
    <strong>회사 이름 : </strong> {{ company.cmpname }}
  </div>
</div>
            <div class="row mb-3">
              <div class="col">
                <strong>회사 정보 : </strong> {{ company.cmpinfo }}
              </div>
            </div>
            <div class="row mb-3">
              <div class="col">
                <strong>회사 업종 : </strong> {{ company.cmpindu }}
              </div>
            </div>
            <div class="row mb-3">
              <div class="col">
                <div>
                  <strong>회사 우편번호 : </strong> {{ company.cmpaddnum }}
                </div>
              </div>
            </div>
            <div class="row mb-3">
              <div class="col">
                <div><strong>회사 주소 : </strong> {{ company.cmpadd }}</div>
              </div>
              <div class="col">
                <div>
                  <strong>회사 상세주소 : </strong> {{ company.cmpadddetail }}
                </div>
              </div>
            </div>
            <div class="row mb-3">
              <div class="col">
                <strong>회사 연락처 : </strong> {{ company.cmpcontact }}
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
const company = ref({});

const fetchData = async () => {
  try {
    console.log("API 요청 시작");
    const empid = route.params.empid;
    console.log(empid);
    const response = await axios.get(`/api/manager/${empid}`);
    console.log("API 응답:", response.data);
    manager.value = response.data;

    // 수정: fetchCompanyData 함수 호출 시 cmpid 설정
    await fetchCompanyData(manager.value.cmpid);
  } catch (error) {
    console.error("데이터를 불러오는 중 에러 발생:", error);
  }
};

const fetchCompanyData = async (cmpid) => {
  try {
    console.log("회사 정보 API 요청 시작");
    console.log(cmpid); // cmpid 확인
    const response = await axios.get(`/api/company/${cmpid}`);
    console.log("API 응답:", response.data);
    company.value = response.data;
  } catch (error) {
    console.error("회사 정보를 불러오는 중 에러 발생:", error);
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
  font-weight: bold;
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
  .divider {
    border-bottom: 1px solid #ccc; /* 선의 스타일을 설정합니다. */
    margin-bottom: 15px; /* 선 아래 여백을 설정합니다. */
    padding-bottom: 15px; /* 선과 하단 내용 사이 여백을 설정합니다. */
  }
</style>
