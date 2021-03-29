<!--
 * @Descripttion:
 * @Author: 无声<ivestszheng@qq.com>
 * @Date: 2020-12-15 22:07:37
 * @LastEditTime: 2020-12-26 18:30:38
-->
<template>
  <div class="content">
    <ul>
      <li v-for="(item, index) in songList" :key="index">
        <div
          class="song-item"
          @click="
            toplay(item.id, item.url, item.pic, index, item.name, item.lyric)
          "
        >
          <div class="item-index">
            {{ index + 1 }}
          </div>
          <div class="item">
            <div class="item-title">{{ replaceFName(item.name) }}</div>
            <span class="item-name">{{ replaceLName(item.name) }} ·</span>
            <span class="item-intro">{{ item.introduction }}</span>
          </div>
        </div>
        <div class="mui-icon mui-icon-more my-icon-more"></div>
      </li>
    </ul>
  </div>
</template>
<script>
import { mapGetters } from "vuex";
import { mixin } from "../mixins";
export default {
  name: "album-content",
  mixins: [mixin],
  props: ["songList"],
};
</script>

<style lang="scss" scoped>
@import '../assets/css/album-content.scss';
</style>
