/*
 * @Descripttion:
 * @Author: 无声<ivestszheng@qq.com>
 * @Date: 2020-12-10 10:59:20
 * @LastEditTime: 2020-12-17 11:55:45
 */
import Vue from 'vue'
import Vuex from 'vuex'
import user from './moudels/user'
import song from './moudels/song'
import configure from './moudels/configure'

Vue.use(Vuex)

const store = new Vuex.Store({
  modules: {
      configure,
      user,
      song
  }
})

export default store
