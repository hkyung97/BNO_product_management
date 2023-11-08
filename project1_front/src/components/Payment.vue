<template>
  <div class="button">
    <!-- <router-link to = "/productedit"> -->
    <button class="register-button" @click="onPayment" v-if="product1">결제하기</button>&nbsp;
    <!-- <button class="register-button1" v-if="isCurrentUserAuthor">
      문의하기
    </button> -->
  </div>
</template>

<script>
export default {
  props: {
    product1: Object, // product1 프로퍼티 정의
    member: Object, // member 프로퍼티 정의
  },

  methods: {
    onPayment() {

      const { IMP } = window;
      IMP.init("imp41876435");

      const data = {
        pg: "kakaopay",
        pay_method: "card",
        merchant_uid: this.product1.prdid,
        amount: this.product1.prdprice,
        name: this.product1.prdname,
        buyer_name: "this.member.membername",
        buyer_tel: "this.member.membercontact",
        buyer_email: "this.member.memberemail",
        buyer_addr: "this.member.memberadd",
        buyer_postcode: "this.member.memberaddnum",
      };

      console.log(data);

      IMP.request_pay(data, this.callback);
    },

    callback(response) {
      const { success, error_msg } = response;

      if (success) {
        alert(`${this.product1.prdname}의 결제가 완료 되었습니다.`);
      } else {
        alert(`결제 실패: ${error_msg}`);
      }
    },
  },
};
</script>

<style scoped>
.button {
  text-align: right; /* 내용을 오른쪽 정렬합니다. */
  margin-right: 10px; /* 오른쪽 여백을 10px로 설정합니다. */
}

.register-button {
  width: 100px;
  height: 48px;
  background: #0a4efa;
  border-radius: 30px;
  color: #fefefe;
  font-size: 20px;
}

.register-button1 {
  width: 100px;
  height: 48px;
  background: #f10404;
  border-radius: 30px;
  color: #fefefe;
  font-size: 20px;
}

.register-button:hover,
.register-button1:hover {
  font-size: 130%;
  font-weight: bold; /* 텍스트 굵게 설정 */
}
</style>
