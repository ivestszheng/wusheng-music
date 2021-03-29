<!--
 * @Descripttion:
 * @Author: 无声<ivestszheng@qq.com>
 * @Date: 2020-12-05 15:08:25
 * @LastEditTime: 2020-12-05 16:18:42
-->
<template>
    <div>
        <the-header></the-header>
        <the-aside></the-aside>
        <div class="content-box" :class="{'content-collapse':collapse}">
            <router-view></router-view>
        </div>
    </div>
</template>

<script>
import TheHeader from './TheHeader'
import TheAside from './TheAside'
import bus from '../assets/js/bus'

export default {
  components: {
    TheHeader,
    TheAside
  },
  data () {
    return {
      collapse: false
    }
  },
  created () {
    // 通过Bus进行组件间的通信，来折叠侧边栏
    bus.$on('collapse', msg => {
      this.collapse = msg
    })
  }
}
</script>
