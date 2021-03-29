<!--
 * @Descripttion: 首页
 * @Author: 无声<ivestszheng@qq.com>
 * @Date: 2020-12-09 09:23:54
 * @LastEditTime: 2021-02-11 21:13:32
-->
<template>
  <div class="home">
    <swiper :swiperList="swiperList" class="home-swipe"></swiper>
    <table-view class="myTV"></table-view>
    <div class="section" v-for="(item, index) in songsList" :key="index">
      <div class="section-title">
        {{ item.name }}
        <span class="findMore">邂逅你的真爱{{ item.name }} ></span>
      </div>
      <content-list :contentList="item.list"></content-list>
    </div>
  </div>
</template>

<script>
import { getAllSwiper, getAllSinger, getAllSongList } from "../api/index";
import Swiper from "../components/Swiper.vue";
import TableView from "../components/TableView.vue";
import ContentList from "../components/ContentList.vue";

export default {
  name: "home",
  components: {
    Swiper,
    TableView,
    ContentList,
  },
  props: {
    msg: String,
  },
  data() {
    return {
      swiperList: [],
      songsList: [
        { name: "歌单", list: [] },
        { name: "歌手", list: [] },
      ],
    };
  },
  created() {
    // 获取轮播图数据
    this.getSwiperList();
    // 获取歌单
    this.getSongList();
    // 获取歌手
    this.getSinger();
  },
  methods: {
    getSwiperList() {
      // 获取轮播图数据方法
      getAllSwiper()
        .then((res) => {
          this.swiperList = res.slice(0, 5);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    getSongList() {
      //获取前十条歌单
      getAllSongList()
        .then((res) => {
          this.songsList[0].list = res.slice(0, 9);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    getSinger() {
      //获取前十名歌手
      getAllSinger()
        .then((res) => {
          this.songsList[1].list = res.slice(0, 9);
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
};
</script>

<style lang="scss" scoped>
@import "../assets/css/home.scss";
</style>
