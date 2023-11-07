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

</template>

<script setup>
import { ref, defineProps, defineEmits, onMounted } from "vue";

const props = defineProps(["manager"]);
const emits = defineEmits(["update:manager"]); // Define emits to send data back to parent

const manager = ref(props.manager);


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
      
    },
  }).open();
  // 데이터를 부모 컴포넌트로 emit
  emits("update:manager", manager.value);
};

// Address 컴포넌트가 마운트된 후에 실행
onMounted(() => {
  // 예: 다른 데이터를 불러오거나 초기화하는 로직을 추가할 수 있습니다.
});
</script>


<style scoped>

</style>