<template>
  <div class="container">
    <div class="Rectangle1">
      <div>
        <div class="title">상품등록</div>
          <button class="register-button">등록하기</button>
      </div>

      <div class="body-container">
        <div class="Rectangle6">
          <div class="add-photo-button" @click="openFileInput"></div>
          <input
            type="file"
            ref="fileInput"
            class="file-input"
            @change="handleFileUpload"
          />
        </div>

        <div class = "body-container1">
          <div class="row">
            <div class="subtitle">
              <span>상품식별자</span>
              <input
                type="text"
                class="Rectangle2"
                placeholder="상품식별자를 입력하세요( ex : prd00000 )"
              />
            </div>
          </div>
          <div class="row">
            <div class="subtitle">
              <span>회사식별자</span>
              <select class="Rectangle4" v-model="selectedCompany">
                <option value="">-- 회사 식별자 선택 --</option>
                <option value="Company1">비오앤소프트</option>
                <option value="Company2">롯데정보통신</option>
                <option value="Company3">Company3</option>
              </select>
            </div>
          </div>
          <div class="row">
            <div class="subtitle">
              상품이름
              <input
                type="text"
                class="Rectangle5"
                placeholder="상품이름을 입력하세요"
              />
            </div>
          </div>
          <div class="row">
            <div class="subtitle">
              상품금액
              <input
                type="text"
                class="Rectangle7"
                placeholder="상품금액을 입력하세요"
              />
            </div>
          </div>
        </div>
      </div>

    <div class="row">
        <div class="subtitle1">
          <p>상품설명</p>
          <input type="text"
            class="Rectangle8"
            placeholder="상품에 대한 설명을 입력하세요"
          />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "ProductAdd",
};
</script>

<style scoped>
.container {
  margin-top: 30%;
}
</style>