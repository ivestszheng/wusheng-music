<!--
 * @Descripttion: 搜索
 * @Author: 无声<ivestszheng@qq.com>
 * @Date: 2020-12-10 18:23:43
 * @LastEditTime: 2021-02-13 20:26:54
-->
<template>
  <div class="search">
    <div class="header-search">
      <router-link to="/home">
        <div class="mui-icon mui-icon-back"></div>
      </router-link>
      <input
        class="search-input"
        type="text"
        placeholder="周杰伦"
        @keyup.enter="goSearch()"
        v-model="keywords"
      />
      <div class="search-btn" @click="goSearch()">
        <svg class="icon">
          <use xlink:href="#icon-sousuo"></use>
        </svg>
      </div>
      <nav class="searchList-nav" ref="change">
        <div
          :class="{ isActive: toggle == 'Songs' }"
          @click="handleChangeView('Songs')"
          size="small"
        >
          歌曲
        </div>
        <div
          :class="{ isActive: toggle == 'SongLists' }"
          @click="handleChangeView('SongLists')"
          size="small"
        >
          歌单
        </div>
      </nav>
    </div>
    <div class="search-content">
      <component :is="currentView"></component>
    </div>
  </div>
</template>

<script>
import SearchSongs from "../components/search/SearchSongs";
import SearchSongLists from "../components/search/SearchSongLists";

export default {
  inject: ["reload"],
  name: "search",
  components: {
    SearchSongs,
    SearchSongLists,
  },
  data() {
    return {
      keywords: "", // 搜索关键字
      toggle: "Songs",
      currentView: "SearchSongs",
    };
  },
  created() {},
  mounted() {},
  watch: {},
  methods: {
    goSearch() {
      this.$router.push({
        path: "/search",
        query: { keywords: this.keywords },
      });
      this.reload();
    },
    //切换组件
    handleChangeView(component) {
      this.currentView = "Search" + component;
      this.toggle = component;
    },
  },
};
</script>

<style lang="scss" scoped>
@import "../assets/css/search.scss";
</style>

