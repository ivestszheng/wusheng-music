<!--
 * @Descripttion: 底部导航栏
 * @Author: 无声<ivestszheng@qq.com>
 * @Date: 2020-12-09 10:10:19
 * @LastEditTime: 2021-02-23 15:05:44
-->
<template>
  <nav class="mui-bar mui-bar-tab" v-show="showTabBar">
    <router-link class="mui-tab-item" to="/home" :class="{'mui-active':$route.meta.active === '/home'}">
      <span class="mui-icon mui-icon-home"></span>
      <span class="mui-tab-label">首页</span>
    </router-link>
    <router-link class="mui-tab-item" to="/mine" :class="{'mui-active':$route.meta.active === '/mine'}">
      <span class="mui-icon mui-icon-contact"></span>
      <span class="mui-tab-label">我的</span>
    </router-link>
    <router-link class="mui-tab-item" to="/live" :class="{'mui-active':$route.meta.active === '/live'}">
      <span class="mui-icon mui-icon-videocam"></span>
      <span class="mui-tab-label">现场</span>
    </router-link>
  </nav>
</template>

<script>
export default {
  name: "tab-bar",
  data() {
    return {
      showTabBar: true,
    };
  },
  created() {
    // 创建时播放栏不显示
    this.showTabBar =
      this.$route.path !== "/lyric" && this.$route.path !== "/setting" && this.$route.path !== "/sign-up" && this.$route.path !== "/info" && this.$route.path !== "/search" && this.$route.path !== "/singer-list" && this.$route.path !== "/song-list";
  },
  watch: {
    // 监听器，时刻保证不显示
    "$route.path"(newVal) {
      this.showTabBar = newVal !== "/lyric" && newVal !== "/setting" && newVal !== "/sign-up" && newVal !== "/info" && newVal !== "/search" && newVal !== "/singer-list" && this.$route.path !== "/song-list";
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="scss" scoped>
@import "../assets/css/tab-bar.scss";
</style>
