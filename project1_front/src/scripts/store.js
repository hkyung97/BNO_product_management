// store.js

import { createStore } from 'vuex';

export default createStore({
  state: {
    account: {
      empid: 0,
      memberid: "",
    },
    isUserMode: true,
  },
  mutations: {
    setAccount(state, payload) {
      state.account.empid = payload.empid;
      state.account.memberid = payload.memberid;
    },
    switchMode(state) {
      state.isUserMode = !state.isUserMode;
    },
    setEmpId(state, empid) {
      state.account.empid = empid;
    },
    setMemberId(state, memberid) {
      state.account.memberid = memberid;
    },
  },
});


