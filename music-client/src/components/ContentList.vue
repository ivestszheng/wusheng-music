<!--
 * @Descripttion: 歌单、歌手列表内容
 * @Author: 无声<ivestszheng@qq.com>
 * @Date: 2020-12-12 16:54:50
 * @LastEditTime: 2021-02-11 22:26:02
-->
<template>
  <div class="content-list">
    <ul class="section-content">
      <li
        class="content-item"
        v-for="(item, index) in contentList"
        :key="index"
      >
        <!-- 有item.name是歌手,没有则是歌单 -->
        <div class="kuo" @click="goAlbum(item, item.name)">
          <!-- v-lazy懒加载 -->
          <img class="item-img" v-lazy="attachImageUrl(item.pic)" />
        </div>
        <p class="item-name">{{ item.name || item.title }}</p>
      </li>
    </ul>
  </div>
</template>
<script>
import { mixin } from "../mixins/index";

export default {
  name: "content-list",
  mixins: [mixin],
  props: ["contentList"],
  methods: {
    goAlbum(item, type) {
      this.$store.commit("setTempList", item);
      if (type) {
        //歌手
        this.$router.push({
          path: `singer-album/${item.id}`,
        });
      } else {
        //歌单
        this.$router.push({
          path: `song-list-album/${item.id}`,
        });
      }
    },
  },
};
</script>
<style lang="scss" scoped>
@import "../assets/css/content-list.scss";
</style>
