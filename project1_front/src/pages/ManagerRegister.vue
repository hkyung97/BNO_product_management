<template>
  <div class="form-signin w-100 m-auto">
    <h1 class="h3 mb-3 fw-normal">회원가입</h1>

    <div class="form-floating mb-4">
      <input type="text" class="form-control" id="empid" v-model="manager.empid" />
      <label for="empid">직원 아이디 (ex: emp00000)</label>
    </div>

    <div class="form-floating mb-4">
      <input type="text" class="form-control" id="empname" v-model="manager.empname" />
      <label for="empname">직원 이름</label>
    </div>

    <div class="form-floating mb-4">
      <input type="text" class="form-control" id="depname" v-model="manager.depname" />
      <label for="depname">부서 이름</label>
    </div>

    <div class="form-floating mb-4">
      <select class="form-control" id="cmpid" v-model="manager.cmpid" >
        <option value="">-- 회사 선택 --</option>
        <option value="cmp00001">비앤오소프트</option>
        <option value="cmp00002">롯데정보통신</option>
      </select>
    </div>

    <div class="form-floating mb-4">
      <input type="text" class="form-control" id="empadd" v-model="manager.empadd" />
      <label for="empadd">직원 주소</label>
    </div>

    <div class="form-floating mb-4">
      <input type="text" class="form-control" id="empcontact" v-model="manager.empcontact" />
      <label for="empcontact">전화번호 (ex : 010-0000-0000)</label>
    </div>

    <div class="form-floating mb-4">
      <input type="text" class="form-control" id="emppos" v-model="manager.emppos" />
      <label for="emppos">직급</label>
    </div>

    <button class="btn btn-primary w-100 py-2" @click="submitForm">회원가입</button>
  </div>
</template>

<script>
import axios from "axios";
import router from '@/scripts/router';
export default {
  name: "ManagerRegister",
  data() {
    return {
      manager: {
        empid: "",
        empname: "",
        depname: "",
        cmpid: "",
        empadd: "",
        empcontact: "",
        emppos: ""
      },
    };
  },
  methods: {

    submitForm() {
      console.log("Selected company:", this.manager);
      this.addManager();
    },

    async addManager() {
      console.log("Selected company:", this.manager);
      try {
        const response = await axios.post("http://localhost:8080/api/manager/add", this.manager);
        alert(response.data); // 성공 메시지 또는 다른 처리를 수행
        router.push({ path: "/" });
      } catch (error) {
        alert("Error adding manager: " + error.message);
      }
    },
  },
};
</script>

<style scoped>
html,
body {
  height: 100%;
}

.form-signin {
  max-width: 50%;
  padding: 1rem;
}

/* .form-signin .form-floating:focus-within {
  z-index: 2;
} */

.form-signin input[type="text"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}
</style>
