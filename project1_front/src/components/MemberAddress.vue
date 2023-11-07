<template>
  <div class="form-floating mb-4">
    <input
      type="text"
      class="form-control"
      id="memberaddnum"
      v-model="member.memberaddnum"
    />
    &nbsp;
    <label for="memberaddnum">우편번호</label>
    <div ref="embed"></div>
    <button @click="showApi">우편번호 찾기</button>
  </div>

  <div class="form-floating mb-4">
    <input
      type="text"
      class="form-control"
      id="memberadd"
      v-model="member.memberadd"
    />
    <label for="memberadd">기본 주소</label>
  </div>

</template>

<script setup>
import { ref, defineProps, defineEmits, onMounted } from "vue";

const props = defineProps(["member"]);
const emits = defineEmits(["update:member"]); // Define emits to send data back to parent

const member = ref(props.member);


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
      member.value.memberaddnum = data.zonecode; // 5자리 우편번호 사용
      member.value.memberadd = fullRoadAddr;
      
    },
  }).open();
  // 데이터를 부모 컴포넌트로 emit
  emits("update:member", member.value);
};

// Address 컴포넌트가 마운트된 후에 실행
onMounted(() => {
  // 예: 다른 데이터를 불러오거나 초기화하는 로직을 추가할 수 있습니다.
});
</script>


<style scoped>

</style>