<!--
 * @Descripttion:
 * @Author: 无声<ivestszheng@qq.com>
 * @Date: 2020-12-10 18:23:43
 * @LastEditTime: 2021-02-14 23:48:07
-->
<template>
  <div id="app">
    <div class="container">
      <top-bar></top-bar>
      <!-- transition实现页面切换过渡效果 -->
      <transition name="fade">
        <!-- 非常重要 用来实现路由 -->
        <router-view />
      </transition>
      <scroll-top></scroll-top>
      <song-audio class="songAudio"></song-audio>
      <the-aside></the-aside>
      <play-bar></play-bar>
      <tab-bar></tab-bar>
      <router-view v-if="isRouterAlive" class="router-alive"></router-view>
    </div>
  </div>
</template>

<script>
import TopBar from "./components/TopBar.vue"
import TabBar from "./components/TabBar.vue"
import ScrollTop from "./components/ScrollTop.vue"
import SongAudio from "./components/SongAudio.vue"
import TheAside from "./components/TheAside.vue"
import PlayBar from "./components/PlayBar.vue"


export default {
  name: "App",
  provide(){
    return{
      reload: this.reload,
      showTopBar: true,
    }
  },
  data(){
    return{
      isRouterAlive: true
    }
  },
  components: {
    TopBar,
    TabBar,
    ScrollTop,
    SongAudio,
    TheAside,
    PlayBar
  },
  created() {

  },
  methods:{
    // reload()方法，在需要的页面注入使用
    reload(){
      this.isRouterAlive = false
      this.$nextTick(function(){
        this.isRouterAlive = true
      })
    }
  }
};
</script>

<style  lang="scss" scoped>
@import './assets/css/app.scss'

</style>
