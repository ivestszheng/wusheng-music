<!--
 * @Descripttion:
 * @Author: 无声<ivestszheng@qq.com>
 * @Date: 2020-12-14 18:00:07
 * @LastEditTime: 2020-12-26 19:57:23
-->
<!--
 * @Descripttion: 歌单列表 可以按风格查询歌单
 * @Author: 无声<ivestszheng@qq.com>
 * @Date: 2020-12-10 18:23:43
 * @LastEditTime: 2020-12-25 14:48:12
-->
<template>
  <div class="song-list">
    <!-- 风格导航 -->
    <div class="song-list-header">
      <mt-button
        v-for="(item, index) in songStyle"
        :key="index"
        @click.native="handleChangeView(item.name)"
        class="song-list-header-button"
        :class="{ active: item.name == activeName }"
        size="small"
        >{{ item.name }}</mt-button
      >
    </div>
    <!-- 歌单列表 -->
    <content-list :contentList="data"></content-list>
  </div>
</template>

<script>
import ContentList from "../components/ContentList.vue";
import { getAllSongList, getSongListOfLikeStyle } from "../api/index";
import { mixin } from "../mixins";
import { songStyle } from "../assets/data/songList";

export default {
  name: "song-list",
  components: {
    ContentList,
  },
  data() {
    return {
      songsList: [{ name: "歌单", list: [] }], // 歌单
      albumDatas: [], //歌单数据
      songStyle: [], //风格
      activeName: "全部歌单", //当前风格
    };
  },
  computed: {
    //计算歌单中的数据
    data() {
      return this.albumDatas
    },
  },
  mounted() {
    this.songStyle = songStyle;
    this.getSongList(); // 获取歌单
  },
  methods: {
    getSongList() {
      getAllSongList().then((res) => {
        this.albumDatas = res;
      });
    },
    //根据style显示对应的歌单
    handleChangeView(name) {
      this.activeName = name;
      this.albumDatas = [];
      if (name == "全部歌单") {
        this.getSongList();
      } else {
        this.goSongListOfStyle(name);
      }
    },
    //根据style查询对应的歌单
    goSongListOfStyle(style) {
      getSongListOfLikeStyle(style).then((res) => {
        this.albumDatas = res;
      });
    },
  },
};
</script>

<style lang="scss" scoped>
@import '../assets/css/song-list.scss'
</style>
