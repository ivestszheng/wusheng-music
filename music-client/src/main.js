// @ts-nocheck
/*
 * @Descripttion:
 * @Author: 无声<ivestszheng@qq.com>
 * @Date: 2020-12-09 09:14:37
 * @LastEditTime: 2021-03-01 09:03:29
 */
// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import store from './store/index'
// 导入Mui框架样式
import './lib/mui/css/mui.css'
import './lib/mui/css/icons-extra.css'
// 导入mint-ui样式
import 'mint-ui/lib/style.css'
// 按需引入mint-ui,Toast不能全局,需要在组件中引入
import { Header, Swipe, SwipeItem, Field, Lazyload, Button, Cell, IndexList, IndexSection, Switch, Range, MessageBox } from 'mint-ui';
// 按需引入Element-ui
import { Rate, Progress,Upload } from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
// import ElementUI from 'element-ui'
// 引入重写的mint-UI样式
import './assets/css/my-mint.scss'
import axios from './api/http'
// 引入iconfont
import '@/assets/js/iconfont.js'
import '@/assets/js/iconfont1.js'
import '@/assets/js/iconfont2.js'
import '@/assets/js/iconfont3.js'



// 注册组件
// Vue.use(MintUI)
Vue.use(axios)
// Mint-UI
Vue.use(Lazyload)
Vue.component(Header.name, Header)
Vue.component(Swipe.name, Swipe)
Vue.component(SwipeItem.name, SwipeItem)
Vue.component(Field.name, Field)
Vue.component(Button.name, Button)
Vue.component(Cell.name, Cell)
Vue.component(IndexList.name, IndexList)
Vue.component(IndexSection.name, IndexSection)
Vue.component(Switch.name, Switch)
Vue.component(Range.name, Range)
Vue.prototype.$messagebox = MessageBox
// Element-ui
Vue.component(Rate.name, Rate)
Vue.component(Progress.name, Progress)
Vue.component(Upload.name, Upload)
// Vue.use(ElementUI)

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
