<!--
 * @Descripttion: 顶部导航栏
 * @Author: 无声<ivestszheng@qq.com>
 * @Date: 2020-12-09 10:05:46
 * @LastEditTime: 2021-02-13 17:15:49
-->
<template>
  <mt-header :title="$route.meta.title" class="myHeader" v-show="showTopBar">
    <span slot="left">
      <router-link to="/setting">
        <mt-button class="mui-icon mui-icon-bars" v-show="!showBack"></mt-button
      ></router-link>
    </span>
    <span slot="left">
      <mt-button
        class="mui-icon mui-icon-back"
        @click="goBack"
        v-show="showBack"
      ></mt-button>
    </span>
    <router-link to="/search" slot="right">
      <mt-button
        class="mui-icon mui-icon-search"
        v-show="showSearch"
      ></mt-button>
    </router-link>
  </mt-header>
</template>

<script>
export default {
  name: "TopBar",
  data() {
    return {
      showBack: false,
      showSearch: false,
      showTopBar: true,
    };
  },
  created() {
    // 项目创建时，如果在这些页面，则返回按钮不显示
    this.showBack =
      this.$route.path !== "/home" &&
      this.$route.path !== "/mine" &&
      this.$route.path !== "/live";
    // 项目创建时，如果在这些页面，则搜索按钮不显示
    this.showSearch =
      this.$route.path !== "/login" && this.$route.path !== "/signUp";
    // 项目创建时，如果在搜索、设置页面，TopBar不显示
    this.showTopBar = this.$route.path !== "/search" && this.$route.path !== "/setting";
  },
  //  监听器，时刻保证对应页面不显示
  watch: {
    "$route.path"(newVal) {
      // 在搜索、设置 页面不显示TopBar
      this.showTopBar = newVal !== "/search" && newVal !== "/setting";
      this.showBack =
        newVal !== "/home" && newVal !== "/mine" && newVal !== "/live";
      this.showSearch = newVal !== "/login" && newVal !== "/signUp";
    },
  },
  methods: {
    goBack() {
      // 通过go方法退后一个访问页面
      this.$router.go(-1);
    },
  },
};
</script>

<style lang="scss" scoped>
@import "../assets/css/top-bar.scss";
</style>
