 <template>
  <div class="container">
    <div class="Rectangle1">
      <div>
        <div class="title">상품 상세</div>
        &nbsp;
        <div class="button">
          <!-- <router-link to = "/productedit"> -->
          <router-link :to="'/productedit/' + (product1 ? product1.prdid : '')">
          <button class="register-button" v-if="isCurrentUserAuthor">수정</button>
          </router-link>&nbsp;
          <button class="register-button1" v-if="isCurrentUserAuthor" @click="confirmDelete">삭제</button>
        </div>
      </div>
      &nbsp;
      <div class="Rectangle6">
        <img :src="product1 ? product1.imgpath : '/loading.gif'" alt="Product Image" style="max-width: 100%; max-height: 100%;" />
      </div>
      <div class="body-container1" v-if="product1">
        <div class="row">
          <div class="subtitle">
            <span>상품식별자</span>
            <div class="Rectangle4">
              {{ product1.prdid }}
            </div>
          </div>
          <div class="subtitle">
            <span>회사식별자</span>
            <div class="Rectangle4">
              {{ product1.cmpid }}
            </div>
          </div>
          <div class="subtitle">
            <span>상품이름</span>
            <div class = "Rectangle4">
              {{ product1.prdname }}
            </div>
          </div>
          <div class="subtitle">
            <span>상품가격</span>
            <div class="Rectangle4">
              {{ lib.getNumberFormatted(product1.prdprice) }}원
            </div>
          </div>
        </div>
      </div>
      <div class="subtitle1" v-if="product1">
        <span>상품내용</span>
        &nbsp;
        <div class="Rectangle8">
          {{ product1.prddes }}
        </div>
      </div>
      <div class="loading" v-else>
        데이터를 불러오는 중...
      </div>
    </div>
  </div>
</template>

<script setup>
import lib from "@/scripts/lib";
import axios from 'axios';
import { ref, onMounted } from 'vue';
import { useRoute, useRouter } from 'vue-router';

const route = useRoute();
const router = useRouter();
const prdid = route.params.prdid;
const product1 = ref(null);

// 세션에서 현재 로그인한 사용자 정보 가져오기
const currentUserID = ref(sessionStorage.getItem('empid'));
let isCurrentUserAuthor = ref(false); // isCurrentUserAuthor를 블록 외부에서 정의

const fetchData = async () => {
  try {
    console.log('API 요청 시작');
    const response = await axios.get(`/api/products/${prdid}`);
    console.log('API 응답:', response.data);
    product1.value = response.data;

    // 작성자의 아이디를 가져온 후, 현재 로그인한 사용자와 비교하여 버튼을 표시할지 결정
    const authorID = response.data.empid;
    if (authorID) {
      isCurrentUserAuthor.value = currentUserID.value === authorID;
    }
  } catch (error) {
    console.error('데이터를 불러오는 중 에러 발생:', error);
  }
};

const prdDelete = async () => {
  try {
    await axios.delete(`/api/products/${prdid}`);
    router.push('/productlist');
  } catch (error) {
    console.error('상품 삭제 중 에러 발생:', error);
  }
};

const confirmDelete = () => {
  if (window.confirm('정말로 삭제하시겠습니까?')) {
    prdDelete();
  }
};

onMounted(() => {
  fetchData(); // onMounted 함수 내에서 데이터를 가져옵니다.
});

</script>


<style scoped>
.container {
  display: flex;
  flex-direction: row;
  align-items: center; /* 요소들을 수직 가운데로 정렬 */
}

.row {
  margin: 0 auto; /* 가로 가운데 정렬을 위한 margin 속성 */
  justify-content: center; /* 가로 방향 가운데 정렬 */
  margin-right: -100px; /* 오른쪽으로 10px 이동 */
}

.body-container {
  
  
  width: 50%;
  margin: 0 auto; /* 가로 가운데 정렬을 위한 margin 속성 */
  justify-content: center; /* 가로 방향 가운데 정렬 */
  align-items: center; /* 세로 방향 가운데 정렬 */
  
}


.body-container1 {
    justify-content: center;
    width: 90%;
}


.Rectangle4 {
  width : 50%;
  margin-top: -45px; /* 위로 10px 올립니다. */
  background: #fefefe;
  border: 2px #0b4ef9 solid;
  margin-left: 180px; /* 위로 10px 올립니다. */
  text-align: center;
}

.Rectangle1 {
  width: 900px;
  height: 1200px;
  background: #fefefe;
  border: 2px #0b4ef9 solid;
  margin-top: 5%; /* 위쪽 여백 추가 */
  margin-left: 17%; /* 왼쪽 여백 추가 */
}

.title {
  width: 50%;
  font-size: 32px; /* 제목 텍스트 크기를 32px로 변경 */
  font-family: Inter;
  font-weight: 400;
  word-wrap: break-word;
  color: #000000;
  text-align: left; /* 텍스트 왼쪽 정렬 추가 */
  font-weight: bold;
  margin-left: 10px; /* 왼쪽 여백을 10px로 설정 */
  margin-top: 10px; /* 위쪽 여백을 10px로 설정 */
}

.subtitle {
  width: 50%;
  font-size: 24px;
  color: #000000;
  text-align: right;
  margin-top: 5%;
  text-align: left; /* 왼쪽 정렬로 변경 */
  
}

.subtitle1 {
  font-size: 24px;
  font-family: Inter;
  word-wrap: break-word;
  color: #000000;
  text-align: left;
  display: flex;
  flex-direction: column;
  direction: ltr;
 
  margin-left: 10px; /* 왼쪽 여백을 10px로 설정 */
  margin-top: 50px; /* 위쪽 여백을 10px로 설정 */
}

.Rectangle8 {
  width: 90%;
  height: 450px;
  background: #fefefe;
  border: 2px #0b4ef9 solid;
  margin: 0 auto; /* 가로 가운데 정렬을 위한 margin 속성 */
  justify-content: center; /* 가로 방향 가운데 정렬 */
  
}

.Rectangle6 {
  width: 80%;
  height: 300px;
  margin: 0 auto; /* 수평 가운데 정렬을 위해 margin을 설정합니다. */
  background: #fefefe;
  border: 2px #0b4ef9 solid;
  display: flex; /* 내용을 가운데 정렬하기 위해 flexbox를 사용합니다. */
  justify-content: center; /* 내용을 수평 가운데로 정렬합니다. */
  align-items: center; /* 내용을 수직 가운데로 정렬합니다. */
}

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

.register-button:hover, .register-button1:hover {
  font-size: 130%;
  font-weight: bold; /* 텍스트 굵게 설정 */
}

</style>