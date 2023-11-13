<template>
  <div class="container mt-5">
    <div class="row justify-content-center">
      <div class="col-md-8">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title">개인 회원 정보</h5>

            <div class="row mt-n5">
              <div class="col text-end">
                <button
                  class="btn btn-primary"
                  @click="editProfile"
                  style="margin-top: -100px"
                >
                  수정
                </button>
              </div>
            </div>

            <div class="row mb-3">
              <div class="col">
                <div><strong>아이디 : </strong> {{ member.memberid }}</div>
              </div>
            </div>
            <div class="row mb-3">
              <div class="col">
                <div><strong>이름 : </strong> {{ member.membername }}</div>
              </div>
            </div>

            <div class="row mb-3">
              <div class="col">
                <div>
                  <strong>우편번호 : </strong> {{ member.memberaddnum }}
                </div>
              </div>
            </div>
            <div class="row mb-3">
              <div class="col">
                <div><strong>주소 : </strong> {{ member.memberadd }}</div>
              </div>
              <div class="col">
                <div>
                  <strong>상세주소 : </strong> {{ member.memberadddetail }}
                </div>
              </div>
            </div>

            <div class="row mb-3">
              <div class="col">
                <div>
                  <strong>전화번호 : </strong> {{ member.membercontact }}
                </div>
              </div>
            </div>
            <div class="row mb-3">
              <div class="col">
                <div><strong>이메일 : </strong> {{ member.memberemail }}</div>
              </div>
            </div>a
          </div>
        </div>

        <div v-if="!member">
          <p>회원정보가 없습니다. 로그인하세요</p>
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
const memberid = route.params.memberid;
const member = ref({});

const fetchData = async () => {
  try {
    console.log("API 요청 시작");
    const response = await axios.get(`/api/member/${memberid}`);
    console.log("API 응답:", response.data);
    member.value = response.data;
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
