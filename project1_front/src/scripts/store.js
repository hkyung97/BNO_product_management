// store.js

import { createStore } from 'vuex';

export default createStore({
  state: {
    account: {
      empid: 0,
    },
    isUserMode: true, // 초기값은 사용자 모드
  },
  mutations: {
    setAccount(state, payload) {
      state.account.empid = payload;
    },
    switchMode(state) {
      state.isUserMode = !state.isUserMode;
    },
  },
});



