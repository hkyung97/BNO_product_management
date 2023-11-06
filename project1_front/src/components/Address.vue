<template>
  <div class="form-floating mb-4">
    <input
      type="text"
      class="form-control"
      id="empaddnum"
      v-model="manager.empaddnum"
    />
    <label for="empaddnum">우편번호</label>
    <div ref="embed"></div>
    <button @click="showApi">우편번호 찾기</button>
  </div>

  <div class="form-floating mb-4">
    <input
      type="text"
      class="form-control"
      id="empadd"
      v-model="manager.empadd"
    />
    <label for="empadd">기본 주소</label>
  </div>

  <div class="form-floating mb-4">
    <input
      type="text"
      class="form-control"
      id="empadddetail"
      v-model="manager.empadddetail"
    />
    <label for="empadddetail">상세주소</label>
  </div>
</template>

<script setup>
import { ref } from "vue";

const manager = ref({
  empaddnum: "",
  empadd: "",
  empadddetail: "",
});

const showApi = () => {
  new window.daum.Postcode({
    oncomplete: (data) => {
      let fullRoadAddr = data.roadAddress;
      let extraRoadAddr = "";

      if (data.bname !== "" && /[동|로|가]$/g.test(data.bname)) {
        extraRoadAddr += data.bname;
      }

      if (data.buildingName !== "" && data.apartment === "Y") {
        extraRoadAddr +=
          extraRoadAddr !== "" ? ", " + data.buildingName : data.buildingName;
      }

      if (extraRoadAddr !== "") {
        extraRoadAddr = " (" + extraRoadAddr + ")";
      }

      if (fullRoadAddr !== "") {
        fullRoadAddr += extraRoadAddr;
      }

      // 우편번호와 주소 정보를 해당 필드에 넣는다.
      manager.value.empaddnum = data.zonecode; // 5자리 우편번호 사용
      manager.value.empadd = fullRoadAddr;
      manager.value.empadddetail = data.jibunAddress; // 상세주소를 추가합니다.
    },
  }).open(document.querySelector(".daummap"));
};
</script>

<style scoped></style>
