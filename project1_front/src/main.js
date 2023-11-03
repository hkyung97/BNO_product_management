import {createApp} from 'vue'
import store from "@/scripts/store"
import router from "@/scripts/router"
import App from './App.vue'



createApp(App).use(store).use(router).mount('#app')

//router.js에서 선언된 router를 main에 import 하면 router는 다른 components에서도 쓰일 수 있게 된다.