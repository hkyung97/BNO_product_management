<template>
  <div class="form-floating mb-4">
    <input
      type="text"
      class="form-control"
      id="cmpaddnum"
      v-model="company.cmpaddnum"
    />
    &nbsp;
    <label for="cmpaddnum">우편번호</label>
    <div ref="embed"></div>
    <button @click="showApi">우편번호 찾기</button>
  </div>

  <div class="form-floating mb-4">
    <input
      type="text"
      class="form-control"
      id="cmpadd"
      v-model="company.cmpadd"
    />
    <label for="cmpadd">기본 주소</label>
  </div>

</template>

<script setup>
import { ref, defineProps, defineEmits, onMounted } from "vue";

const props = defineProps(["company"]);
const emits = defineEmits(["update:company"]); // Define emits to send data back to parent

const company = ref(props.company);


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
      company.value.cmpaddnum = data.zonecode; // 5자리 우편번호 사용
      company.value.cmpadd = fullRoadAddr;
      
    },
  }).open();
  // 데이터를 부모 컴포넌트로 emit
  emits("update:company", company.value);
};

// Address 컴포넌트가 마운트된 후에 실행
onMounted(() => {
  // 예: 다른 데이터를 불러오거나 초기화하는 로직을 추가할 수 있습니다.
});
</script>


<style scoped>

</style>