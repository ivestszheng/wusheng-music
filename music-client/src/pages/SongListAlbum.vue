<!--
 * @Descripttion: 歌单内容页面
 * @Author: 无声<ivestszheng@qq.com>
 * @Date: 2020-12-15 22:46:24
 * @LastEditTime: 2020-12-26 21:37:31
-->
<template>
  <div class="song-list-album">
    <div class="album">
      <div class="album-img">
        <img :src="attachImageUrl(tempList.pic)" />
      </div>
      <div class="underImg">
        <!-- 歌单评分 -->
        <div class="mui-icon mui-icon-starhalf album-score">
          <span>{{ average * 2 }}</span>
        </div>
        <div class="album-title">
          {{ tempList.title }}
        </div>
        <!-- 歌曲简介 -->
        <div
          class="mui-table-view-cell mui-collapse album-info"
          :class="{ 'mui-active': isActive }"
          @click="handleChangeView()"
        >
          <a class="mui-navigate-right" href="#">{{ tempList.introduction }}</a>
          <div class="mui-collapse-content">
            {{ tempList.introduction }}
          </div>
        </div>
        <div class="songs-body">
          <album-content :songList="listOfSongs"> </album-content>
        </div>
        <div></div>
        <!-- 我的评分 -->
        <div @click="setRank" class="my-score">
          <el-rate v-model="rank" allow-half show-text></el-rate>
        </div>
        <comment :playId="songListId" :type="1"></comment>
      </div>
    </div>
  </div>
</template>
<script>
import { Toast } from "mint-ui";
import { mixin } from "../mixins";
import { mapGetters } from "vuex";
import {
  listSongDetail,
  songOfSongId,
  setRank,
  getRankOfSongListId,
} from "../api/index";
import AlbumContent from "../components/AlbumContent";
import Comment from "../components/Comment";

export default {
  name: "song-list-album",
  mixins: [mixin],
  components: {
    AlbumContent,
    Comment,
  },
  data() {
    return {
      songLists: [], //当前页面需要展示的歌曲列表
      songListId: "", //前面传来的歌单id
      average: 0, //平均分
      rank: 0, //提交评价的分数
      isActive: false, //是否显示歌曲介绍
    };
  },
  computed: {
    ...mapGetters([
      "listOfSongs", //当前播放列表
      "tempList", //当前歌单对象
      "loginIn", //用户是否已登录
      "userId", //当前登录用户id
    ]),
  },
  created() {
    this.songListId = this.$route.params.id;
    this.getSongId();
    this.getRank(this.songListId);
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
    //获取当前歌单的歌曲列表
    getSongId() {
      listSongDetail(this.songListId)
        .then((res) => {
          for (let item of res) {
            this.getSongList(item.songId);
          }
          this.$store.commit("setListOfSongs", this.songLists);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    //根据歌曲id获取歌曲信息
    getSongList(id) {
      songOfSongId(id)
        .then((res) => {
          this.songLists.push(res);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    //获取歌单评分
    getRank(id) {
      getRankOfSongListId(id)
        .then((res) => {
          this.average = res / 2;
        })
        .catch((err) => {
          console.log(err);
        });
    },
    //提交评分
    setRank() {
      if (this.loginIn) {
        let params = new URLSearchParams();
        params.append("songListId", this.songListId);
        params.append("consumerId", this.userId);
        params.append("score", this.rank * 2);
        setRank(params)
          .then((res) => {
            if (res.code == 1) {
              Toast("评分成功");
              this.getRank(this.songListId);
            } else {
              Toast("评分失败");
            }
          })
          .catch((err) => {
            Toast("您已经评价过啦");
          });
      } else {
        this.rank = null;
        Toast("请先登录");
      }
    },
  },
};
</script>

<style lang="scss" scoped>
@import '../assets/css/song-list-album.scss'
</style>
