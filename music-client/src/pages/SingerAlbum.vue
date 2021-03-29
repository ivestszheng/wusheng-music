<!--
 * @Descripttion: 歌手页面
 * @Author: 无声<ivestszheng@qq.com>
 * @Date: 2020-12-15 22:46:24
 * @LastEditTime: 2020-12-26 21:38:04
-->
<template>
  <div class="singer-album">
    <div class="album">
      <div class="singer">
        <div class="singer-name">{{ singer.name }}</div>
        <div v-if="singer.sex == 0 || singer.sex == 1" class="singer-sex">
          性别：{{ attachSex(singer.sex) }}
        </div>
        <div class="singer-birth">生日：{{ attachBirth(singer.birth) }}</div>
        <div class="singer-hometown">故乡：{{ singer.location }}</div>
      </div>
      <div class="singer-img">
        <img :src="attachImageUrl(singer.pic)" />
      </div>
    </div>
    <div class="underImg">
      <!-- 歌手介绍 -->
      <div
        class="mui-table-view-cell mui-collapse singer-info"
        :class="{ 'mui-active': isActive }"
        @click="handleChangeView()"
      >
        <a class="mui-navigate-right" href="#">{{ singer.introduction }}</a>
        <div class="mui-collapse-content">
          {{ singer.introduction }}
        </div>
      </div>
      <div class="content">
        <album-content :songList="listOfSongs"> </album-content>
      </div>
    </div>
  </div>
</template>
<script>
import { mixin } from "../mixins";
import { mapGetters } from "vuex";
import { songOfSingerId } from "../api/index";
import AlbumContent from "../components/AlbumContent";
export default {
  name: "singer-album",
  mixins: [mixin],
  components: {
    AlbumContent,
  },
  data() {
    return {
      singerId: "", //前面传来的歌手id
      singer: {}, //当前歌手信息
      isActive: false, //是否显示歌手介绍
    };
  },
  computed: {
    ...mapGetters([
      "listOfSongs", //当前播放列表
      "tempList", //当前歌手对象
      "loginIn", //用户是否已登录
      "userId", //当前登录用户id
    ]),
  },
  created() {
    this.singerId = this.$route.params.id;
    this.singer = this.tempList;
    this.getSongOfSingerId();
  },
  methods: {
    // 点击切换折叠面板样式
    handleChangeView() {
      if (this.isActive) {
        this.isActive = false;
      } else {
        this.isActive = true;
      }
    },
    //根据歌手id查询歌曲
    getSongOfSingerId() {
      songOfSingerId(this.singerId)
        .then((res) => {
          this.$store.commit("setListOfSongs", res);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    //获取性别
    attachSex(value) {
      if (value == 0) {
        return "女";
      } else if (value == 1) {
        return "男";
      }
      return "";
    },
  },
};
</script>

<style lang="scss" scoped>
@import "../assets/css/singer-album.scss";
</style>
