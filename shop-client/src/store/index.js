import { createStore } from 'vuex'
import storage from "@/utils/storage";

export default createStore({
  state: {
    // 存储token
    Authorization: localStorage.getItem('Authorization') ? localStorage.getItem('Authorization') : '',
    user: {
      id: 0,
      username: '',
      roles: [],
      introduction: '',
      avatar: ''
    }
  },
  mutations: {
    // 修改token，并将token存入localStorage
    changeLogin (state, user) {
      state.Authorization = user.Authorization;
      localStorage.setItem('Authorization', user.Authorization);
    },
    setUser(state, user){
      state.user = user
    }
  },
  // 提交的是mutation, 并且可以异步操作
  // 异步触发mutations中的方法
  // action中的自定义函数: 一个context(上下文)以及要变化的 “形参”
  // context与store实例具有相同的方法和属性, 故context.commit('')有效！
  // 作用：存在业务逻辑
  // action在组件内通过this.$store.dipatch(方法名)来触发
  actions: {
    commitToken(context) {
      context.commit('setUser');
    },
  },
  modules: {
  },
  // 将各个组件中的computed中的方法提取出来
  // 实时监测state中变量值的变化
  // 可以通过this.$store.state.xxx获取变量值, 但getters更专业(类似于Bean的getter方法)
  getters: {

    // 方法名随意
    // _this.$store.getters.getUser
    getUser(state) {
      state.user = storage.get('user');
      return state.user;
    }
  }
})
