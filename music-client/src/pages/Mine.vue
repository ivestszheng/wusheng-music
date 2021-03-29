<!--
 * @Descripttion: 我的
 * @Author: 无声<ivestszheng@qq.com>
 * @Date: 2020-12-09 10:07:48
 * @LastEditTime: 2021-02-14 20:30:51
-->
<template>
  <div class="mine">
    <!-- 登录后显示页面 -->
    <div class="isLogin" v-if="loginIn">
      <div class="album-top">
        <router-link to="upload">
        <div class="album-img">
          <img :src="attachImageUrl(avator)" />
        </div>
        </router-link>
        <div class="album-info">
          <span class="info-name">{{ username }}</span>
          <span class="info-sex">{{ userSex }} |</span>
          <span class="info-birth">{{ birth }} |</span>
          <span class="info-location">{{ location }} |</span>
          <span class="info-signature">{{ introduction }}</span>
        </div>
        <router-link to="/info"><div class="mui-icon mui-icon-compose logout"></div></router-link>
      </div>
      <div class="album-content">
        <p class="album-content-title">我的收藏</p>
        <div class="songs-body">
          <album-content :songList="collectList"> </album-content>
        </div>
      </div>
    </div>
    <!-- 未登录显示页面 -->
    <div v-else>
      <div class="member">
        <div class="header-con">
          <router-link to="/login-in">
            <div class="user-info">
              <div class="avatar-con">
                <div class="avatar">
                  <img
                    src="../assets/img/avatar_default.png"
                    class="image-info"
                    alt=""
                  />
                </div>
              </div>
              <div class="person-con">
                <span> 登录 / 注册</span>
              </div>
            </div>
          </router-link>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mixin } from "../mixins";
import { mapGetters } from "vuex";
import { getUserOfId, getCollectOfUserId, songOfSongId } from "../api/index";
import AlbumContent from "../components/AlbumContent";

export default {
  name: "mine",
  mixins: [mixin],
  components: {
    AlbumContent,
  },
  data() {
    return {
      avator: "", //用户头像
      username: "", //昵称
      userSex: "", //性别
      birth: "", //生日
      location: "", //故乡
      introduction: "", //签名
      collection: [], //收藏的歌曲列表
      collectList: [], //收藏的歌曲列表（带歌曲详情）
    };
  },
  computed: {
    ...mapGetters([
      "listOfSongs", //当前播放列表
      "userId", //当前登录用户id
    ]),
  },
  mounted() {
    this.getMsg(this.userId);
    this.getCollection(this.userId);
  },
  methods: {
    getMsg(userId) {
      getUserOfId(userId)
        .then((res) => {
          this.avator = res.avator;
          this.username = res.username;
          if (res.sex == 0) {
            this.userSex = "女";
          } else if (res.sex == 1) {
            this.userSex = "男";
          }
          this.birth = this.attachBirth(res.birth);
          this.location = res.location;
          this.introduction = res.introduction;
        })
        .catch((err) => {
          console.log(err);
        });
    },
    //获取我的收藏列表
    getCollection(userId) {
      getCollectOfUserId(userId)
        .then((res) => {
          this.collection = res;
          //通过歌曲id获取歌曲信息
          for (let item of this.collection) {
            this.getSongsOfIds(item.songId);
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
    //通过歌曲id获取歌曲信息
    getSongsOfIds(id) {
      songOfSongId(id)
        .then((res) => {
          this.collectList.push(res);
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
};
</script>

<style lang="scss" scoped>
@import "../assets/css/mui-btn.scss";
@import "../assets/css/mine.scss";
</style>
