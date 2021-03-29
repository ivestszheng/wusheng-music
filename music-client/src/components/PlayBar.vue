<!--
 * @Descripttion: 播放栏
 * @Author: 无声<ivestszheng@qq.com>
 * @Date: 2020-12-19 14:33:01
 * @LastEditTime: 2021-02-24 23:36:54
-->
<template>
  <div v-show="showPlayBar">
    <!-- 歌词页面显示的播放器 -->
    <div v-if="lyricPlayBar" class="kongjian">
      <div class="lyric-bg" @click="toLyric">
        <img :src="picUrl" class="lyric-bg-img" />
      </div>
      <!-- 音量栏 隐藏/显示 -->
      <mt-range
        class="volume"
        v-model="volume"
        v-show="showVolume"
        :min="0"
        :max="100"
        :step="10"
      ></mt-range>
      <!-- 收藏 -->
      <div class="item-icon item-icon-top">
        <div class="item" @click="collection">
          <svg :class="{ active: isActive }" class="icon">
            <use xlink:href="#icon-xihuan-shi"></use>
          </svg>
        </div>
        <!-- 下载 -->
        <div class="item" @click="download">
          <svg class="icon">
            <use xlink:href="#icon-xiazai"></use>
          </svg>
        </div>
        <!-- 当前播放的歌曲列表 -->
        <div class="item" @click="changeAside">
          <svg class="icon">
            <use xlink:href="#icon-liebiao"></use>
          </svg>
        </div>
        <!-- 音量按钮 -->
        <div class="item item-volume" @click="toggleVolume">
          <svg v-if="volume == 0" class="icon">
            <use xlink:href="#icon-yinliangjingyinheix"></use>
          </svg>
          <svg v-else class="icon">
            <use xlink:href="#icon-yinliang1"></use>
          </svg>
        </div>
      </div>
      <!-- 播放时间/总时长 -->
      <div class="time">{{ nowTime }}/{{ songTime }}</div>
      <!-- 播放进度 -->
      <div class="playing-speed">
        <div class="progress-box">
          <div ref="progress" class="progress" @mousemove="mousemove">
            <!-- 进度条 -->
            <div ref="bg" class="bg" @click="updatemove">
              <div
                ref="curProgress"
                class="cur-progress"
                :style="{ width: curLength + '%' }"
              ></div>
            </div>
            <!-- 拖动的点点 -->
            <div
              ref="idot"
              class="idot"
              :style="{ left: curLength + '%' }"
              @mousedown="mousedown"
              @mouseup="mouseup"
            ></div>
          </div>
        </div>
        <div class="item-icon item-icon-bottom">
          <!-- 上一首 -->
          <div class="item" @click="prev">
            <svg class="icon">
              <use xlink:href="#icon-ziyuanldpi"></use>
            </svg>
          </div>
          <!-- 播放 -->
          <div class="item" @click="togglePlay">
            <svg class="icon">
              <use :xlink:href="playButtonUrl"></use>
            </svg>
          </div>
          <!-- 下一首 -->
          <div class="item" @click="next">
            <svg class="icon">
              <use xlink:href="#icon-ziyuanldpi1"></use>
            </svg>
          </div>
        </div>
      </div>
    </div>

    <!-- 非歌词页面显示的播放器 -->
    <div class="play-bar"  :class="{'bottom-play-bar':$route.meta.bottomPlayBar === 'true'}" v-else>
      <!-- 歌曲图片 -->
      <div class="item-img" @click="toLyric">
        <img :src="picUrl" />
      </div>
      <!-- 歌曲文字 -->
      <div class="item-letter">{{ this.title }}-{{ this.artist }}</div>
      <!-- 按钮组 -->
      <div class="item-icon">
        <svg class="icon" @click="togglePlay">
          <use :xlink:href="playButtonUrl"></use>
        </svg>
        <svg class="icon" @click="changeAside">
          <use xlink:href="#icon-liebiao"></use>
        </svg>
      </div>
    </div>
  </div>
</template>
<script>
import { Toast } from "mint-ui";
import { mapGetters } from "vuex";
import { download, setCollect, getCollectOfUserId, deleteCollection } from "../api/index";

export default {
  name: "play-bar",
  data() {
    return {
      showPlayBar: true,
      lyricPlayBar: false,
      nowTime: "00:00", //当前播放进度的时间
      songTime: "00:00", //当前歌曲总时间
      curLength: 0, //进度条的位置
      progressLength: 0, //进度条的总长度
      mouseStartX: 0, //拖拽开始位置
      tag: false, //拖拽开始结束的标志，当开始拖拽，它的值才会变成true
      volume: 50, //音量，默认一半
      showVolume: true, //默认隐藏音量栏
      toggle: true, //显示隐藏播放器页面
    };
  },
  computed: {
    ...mapGetters([
      "id", //歌曲id
      "url", //歌曲地址
      "isPlay", //播放状态
      "playButtonUrl", //播放状态的图标
      "picUrl", //正在播放的音乐的图片
      "title", //歌名
      "artist", //歌手名
      "duration", //音乐时长
      "curTime", //当前音乐的播放位置
      "showAside", //是否显示播放中的歌曲列表
      "listIndex", //当前歌曲在歌单中的位置
      "listOfSongs", //当前歌单列表
      "autoNext", //自动播放下一首
      "loginIn", //用户是否已登录
      "userId", //当前登录用户的id
      "isActive", //当前播放的歌曲是否已收藏
    ]),
  },
  created() {
    // 创建时如果在设置页面，不显示
    this.showPlayBar =
      this.$route.path !== "/setting" &&
      this.$route.path !== "/sign-up" &&
      this.$route.path !== "/info";
    // 创建时如果在歌词页面，显示歌词页面播放栏
    this.lyricPlayBar = this.$route.path == "/lyric";
    // 显示、隐藏音量栏
    this.toggleVolume();
  },
  watch: {
    // 监听器，保证显示正确的播放器
    "$route.path"(newVal) {
      this.showPlayBar =
        newVal !== "/setting" && newVal !== "/sign-up" && newVal !== "/info";
      this.lyricPlayBar = newVal == "/lyric";
    },
    //切换播放状态的图标
    isPlay() {
      if (this.isPlay) {
        this.$store.commit("setPlayButtonUrl", "#icon-zanting");
      } else {
        this.$store.commit("setPlayButtonUrl", "#icon-bofang");
      }
    },
    curTime() {
      this.nowTime = this.formatSeconds(this.curTime);
      this.songTime = this.formatSeconds(this.duration);
      this.curLength = (this.curTime / this.duration) * 100;
    },
    //音量变化
    volume() {
      this.$store.commit("setVolume", this.volume / 100);
    },
    //自动播放下一首
    autoNext() {
      this.next();
    },
  },
  mounted() {
    this.progressLength = this.$refs.progress.getBoundingClientRect().width;
  },
  methods: {
    // 显示、隐藏音量栏
    toggleVolume() {
      if (this.showVolume) {
        this.showVolume = false;
      } else {
        this.showVolume = true;
      }
    },
    //控制音乐播放、暂停
    togglePlay() {
      if (this.isPlay) {
        this.$store.commit("setIsPlay", false);
      } else {
        this.$store.commit("setIsPlay", true);
      }
    },
    //解析时间
    formatSeconds(value) {
      let theTime = parseInt(value);
      let result = ""; //返回值
      let hour = parseInt(theTime / 3600); //小时
      let minute = parseInt((theTime / 60) % 60); //分钟
      let second = parseInt(theTime % 60); //秒
      if (hour > 0) {
        if (hour < 10) {
          result = "0" + hour + ":";
        } else {
          result = hour + ":";
        }
      }
      if (minute > 0) {
        if (minute < 10) {
          result += "0" + minute + ":";
        } else {
          result += minute + ":";
        }
      } else {
        result += "00:";
      }
      if (second > 0) {
        if (second < 10) {
          result += "0" + second;
        } else {
          result += second;
        }
      } else {
        result += "00";
      }
      return result;
    },
    //拖拽开始
    mousedown(e) {
      this.mouseStartX = e.clientX;
      this.tag = true;
    },
    //拖拽结束
    mouseup() {
      this.tag = false;
    },
    //拖拽中
    mousemove(e) {
      if (!this.duration) {
        return false;
      }
      if (this.tag) {
        let movementX = e.clientX - this.mouseStartX; //点点移动的距离
        let curLength = this.$refs.curProgress.getBoundingClientRect().width;
        let newPercent = ((movementX + curLength) / this.progressLength) * 100;
        if (newPercent > 100) {
          newPercent = 100;
        }
        this.curLength = newPercent;
        this.mouseStartX = e.clientX;
        this.changeTime(newPercent);
      }
    },
    //更改歌曲进度
    changeTime(percent) {
      let newCurTime = percent * 0.01 * this.duration;
      this.$store.commit("setChangeTime", newCurTime);
    },
    //点击播放条切换播放进度
    updatemove(e) {
      if (!this.tag) {
        //进度条的左侧坐标
        let curLength = this.$refs.bg.offsetLeft;
        let newPercent = ((e.clientX - curLength) / this.progressLength) * 100;
        if (newPercent > 100) {
          newPercent = 100;
        } else if (newPercent < 0) {
          newPercent = 0;
        }
        this.curLength = newPercent;
        this.changeTime(newPercent);
      }
    },
    //显示播放中的歌曲列表
    changeAside() {
      this.$store.commit("setShowAside", true);
    },
    //上一首
    prev() {
      if (this.listIndex != -1 && this.listOfSongs.length > 1) {
        //当前处于不可能状态或者只有只有一首音乐的时候不执行）
        if (this.listIndex > 0) {
          //不是第一首音乐
          this.$store.commit("setListIndex", this.listIndex - 1); //直接返回上一首
        } else {
          //当前是第一首音乐
          this.$store.commit("setListIndex", this.listOfSongs.length - 1); //切换到倒数第一首
        }
        this.toplay(this.listOfSongs[this.listIndex].url);
      }
    },
    //下一首
    next() {
      if (this.listIndex != -1 && this.listOfSongs.length > 1) {
        //当前处于不可能状态或者只有只有一首音乐的时候不执行）
        if (this.listIndex < this.listOfSongs.length - 1) {
          //不是最后一首音乐
          this.$store.commit("setListIndex", this.listIndex + 1); //直接返回下一首
        } else {
          //当前是最后一首音乐
          this.$store.commit("setListIndex", 0); //切换到第一首
        }
        this.toplay(this.listOfSongs[this.listIndex].url);
      }
    },
    //播放音乐
    toplay: function (url) {
      if (url && url != this.url) {
        this.$store.commit("setId", this.listOfSongs[this.listIndex].id);
        this.$store.commit("setUrl", this.$store.state.configure.HOST + url);
        this.$store.commit(
          "setPicUrl",
          this.$store.state.configure.HOST +
          this.listOfSongs[this.listIndex].pic
        );
        this.$store.commit(
          "setTitle",
          this.replaceFName(this.listOfSongs[this.listIndex].name)
        );
        this.$store.commit(
          "setArtist",
          this.replaceLName(this.listOfSongs[this.listIndex].name)
        );
        this.$store.commit(
          "setLyric",
          this.parseLyric(this.listOfSongs[this.listIndex].lyric)
        );
        this.$store.commit("setIsActive", false);
        if (this.loginIn) {
          getCollectOfUserId(this.userId).then((res) => {
            for (let item of res) {
              if (item.songId == id) {
                this.$store.commit("setIsActive", true);
                break;
              }
            }
          });
        }
      }
    },
    //获取名字前半部分--歌手名
    replaceLName(str) {
      let arr = str.split("-");
      return arr[0];
    },
    //获取名字后半部分--歌名
    replaceFName(str) {
      let arr = str.split("-");
      return arr[1];
    },
    //解析歌词
    parseLyric(text) {
      let lines = text.split("\n"); //将歌词按行分解成数组
      let pattern = /\[\d{2}:\d{2}.(\d{3}|\d{2})\]/g; //时间格式的正则表达式
      let result = []; //返回值
      //对于歌词格式不对的直接返回
      if (!/\[.+\]/.test(text)) {
        return [[0, text]];
      }
      //去掉前面格式不正确的行
      while (!pattern.test(lines[0])) {
        lines = lines.slice(1);
      }
      //遍历每一行，形成一个每行带着俩元素的数组，第一个元素是以秒为计算单位的时间，第二个元素是歌词
      for (let item of lines) {
        let time = item.match(pattern); //存前面的时间段
        let value = item.replace(pattern, ""); //存后面的歌词
        for (let item1 of time) {
          let t = item1.slice(1, -1).split(":"); //取出时间，换算成数组
          if (value != "") {
            result.push([parseInt(t[0], 10) * 60 + parseFloat(t[1]), value]);
          }
        }
      }
      //按照第一个元素--时间--排序
      result.sort(function (a, b) {
        return a[0] - b[0];
      });
      return result;
    },
    //转向歌词页面
    toLyric() {
      this.$router.push({ path: `/lyric` });
    },
    //下载音乐
    download() {
      download(this.url)
        .then((res) => {
          let content = res.data;
          let eleLink = document.createElement("a");
          eleLink.download = `${this.artist}-${this.title}.mp3`;
          eleLink.style.display = "none";
          //把字符内容转换成blob地址
          let blob = new Blob([content]);
          eleLink.href = URL.createObjectURL(blob);
          //把链接地址加到document里
          document.body.appendChild(eleLink);
          //触发点击
          eleLink.click();
          //然后移除掉这个新加的控件
          document.body.removeChild(eleLink);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    //收藏
    collection() {
      if (this.loginIn) {
        var params = new URLSearchParams();
        params.append("userId", this.userId);
        params.append("type", 0);
        params.append("songId", this.id);
        setCollect(params).then((res) => {
          if (res.code == 1) {
            // 已收藏，则改变收藏按钮颜色
            this.$store.commit("setIsActive", true);
            Toast("收藏成功");
          } else if (res.code == 2) {
            deleteCollection(this.userId, this.id)
              .then(res => {
                if (res) {
                  this.$store.commit("setIsActive", false);
                  Toast("已取消收藏");
                } else {
                  Toast("取消收藏失败");
                }
              })
              .catch(err => {
                console.log(err)
              })
          } else {
            Toast("收藏失败");
          }
        });
      } else {
        Toast("请先登录");
      }
    },
  },
};
</script>
<style  lang="scss" scoped>
@import "../assets/css/play-bar.scss";
</style>
