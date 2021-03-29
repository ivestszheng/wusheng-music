<!--
 * @Descripttion:
 * @Author: 无声<ivestszheng@qq.com>
 * @Date: 2020-12-12 16:44:25
 * @LastEditTime: 2021-02-13 20:51:32
-->
<template>
  <div>
    <ul class="mui-table-view mui-grid-view mui-grid-9">
      <li class="mui-table-view-cell mui-media">
        <router-link to="/song-list">
          <span class="mui-icon-extra mui-icon-extra-custom"></span>
          <div class="mui-media-body">歌单</div>
        </router-link>
      </li>
      <li class="mui-table-view-cell mui-media">
        <router-link to="/">
          <span class="mui-icon-extra mui-icon-extra-find"></span>
          <div to="" class="mui-media-body">电台</div>
        </router-link>
      </li>
      <li class="mui-table-view-cell mui-media">
        <router-link to="/">
          <span class="mui-icon-extra mui-icon-extra-rank"></span>
          <div to="" class="mui-media-body">排行榜</div>
        </router-link>
      </li>
      <li class="mui-table-view-cell mui-media">
        <router-link to="/singer-list">
          <span class="mui-icon-extra mui-icon-extra-peoples"></span>
          <div class="mui-media-body">歌手</div>
        </router-link>
      </li>
      <li class="mui-table-view-cell mui-media">
        <router-link to="/">
          <span class="mui-icon-extra mui-icon-extra-notice"></span>
          <div class="mui-media-body">视频彩铃</div>
        </router-link>
      </li>    </ul>
  </div>
</template>

<script>
export default {
  name: "table-view",
  data() {
    return {};
  },
  created() {},
  mounted() {},
  methods: {},
};
</script>

<style lang="scss" scoped>
@import "../assets/css/table-view.scss";
</style>
