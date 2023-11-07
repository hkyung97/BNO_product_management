<template>
  <div class="payment-form">
    <h2>결제 정보 입력</h2>
    <form @submit.prevent="processPayment">
      <div class="form-group">
        <label for="cardNumber">카드 번호:</label>
        <input type="text" id="cardNumber" v-model="paymentInfo.cardNumber" placeholder="1234 5678 9012 3456" />
      </div>
      <div class="form-group">
        <label for="expiryDate">만료 날짜:</label>
        <input type="text" id="expiryDate" v-model="paymentInfo.expiryDate" placeholder="MM/YY" />
      </div>
      <div class="form-group">
        <label for="cvc">CVC 코드:</label>
        <input type="text" id="cvc" v-model="paymentInfo.cvc" placeholder="123" />
      </div>
      <button type="submit">결제하기</button>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      paymentInfo: {
        cardNumber: '',
        expiryDate: '',
        cvc: '',
      },
    };
  },
  methods: {
    processPayment() {
      // 여기에 결제 처리 로직을 추가하세요.
      // this.paymentInfo에 있는 정보를 사용하여 결제를 진행할 수 있습니다.
      console.log('결제 정보:', this.paymentInfo);
      // 결제 처리 로직을 작성하세요.
    },
  },
};
</script>

<style scoped>
.payment-form {
  max-width: 400px;
  margin: 0 auto;
  margin-top :5%;
}

.form-group {
  margin-bottom: 20px;
}

label {
  display: block;
  font-weight: bold;
}

input {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
}

button {
  padding: 10px 20px;
  background-color: #007bff;
  color: #fff;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

button:hover {
  background-color: #0056b3;
}
</style>
