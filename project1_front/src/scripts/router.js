import {createRouter, createWebHistory} from 'vue-router'
import Home from "@/pages/Home.vue";
import Login from "@/pages/Login.vue";
import ProductList from "@/pages/ProductList.vue";
import ProductAdd from "@/pages/ProductAdd.vue";
import ProductUpdate from "@/pages/ProductUpdate.vue";
import ProductDetail from "@/pages/ProductDetail.vue";
import ManagerRegister from "@/pages/ManagerRegister.vue";
import ProductEdit from "@/pages/ProductEdit.vue";
import Address from "@/components/Address.vue";


// router를 사용 하겠다.
// routes 경로로 들어올때는 component를 home으로 연결
const routes = [
    {path: '/', component: Home},
    {path: '/login', component: Login},
    {path: '/productlist', component: ProductList},
    {path: '/productadd', component: ProductAdd},
    {path: '/product/:prdid', component: ProductDetail}, //<router-link :to="'/product/' + products.prdid"> 경로로 이동하는 방법 id는 동적 세그먼트
    {path: '/productupdate', component: ProductUpdate},
    {path: '/managerregister', component: ManagerRegister},
    {path: '/productedit/:prdid', component: ProductEdit},
    {path: '/address', component: Address},
]

//
const router = createRouter({
    history: createWebHistory(),
    routes
})


export default router;