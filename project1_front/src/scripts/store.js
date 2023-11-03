import {createStore} from 'vuex'

const store = createStore({
    state() {
        return {
            account:{
                empid:0
            }
        }
    },
    mutations: {
        setAccount(state, payload){
            state.account.empid = payload;
        }
    }
})

export default store;


