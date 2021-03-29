<template>
  <div>
    <div class="comment">
      <mt-button type="primary" class="sub-btn" @click="postComment"
        >评论</mt-button
      >
      <div class="comment-msg">
        <mt-field
          class="comment-input"
          placeholder="请输入内容"
          type="textarea"
          rows="1"
          v-model="textarea"
        ></mt-field>
      </div>
    </div>
    <p class="comment-list">精彩评论：共{{ commentList.length }}条评论</p>
    <ul class="popular" v-for="(item, index) in commentList" :key="index">
      <li>
        <div class="popular-imgAmsg">
          <div class="popular-img">
            <img :src="attachImageUrl(userPic[index])" />
          </div>
          <div class="popular-msg">
            <div class="name">{{ userName[index] }}</div>
            <div class="time">{{ item.createTime }}</div>
          </div>
        </div>
        <div class="content">{{ item.content }}</div>
        <div class="up" ref="up" @click="postUp(item.id, item.up, index)">
          {{ item.up }}
          <svg class="icon">
            <use xlink:href="#icon-zan"></use>
          </svg>
        </div>
      </li>
    </ul>
  </div>
</template>

<script>
import { Toast } from "mint-ui";
import { mixin } from "../mixins";
import { mapGetters } from "vuex";
import { setComment, setLike, getAllComment, getUserOfId } from "../api/index";

export default {
  name: "comment",
  mixins: [mixin],
  props: [
    "playId", //歌曲或歌单id
    "type", //0歌曲、1歌单
  ],
  computed: {
    ...mapGetters([
      "id", //歌曲或歌单id
      "loginIn", //用户是否已登录
      "userId", //当前登录用户id
      "avator", //当前登录用户头像
    ]),
  },
  data() {
    return {
      textarea: "", //存放输入的评论内容
      commentList: [], //存放评论列表
      userPic: [], //用户的头像
      userName: [], //用户的昵称
    };
  },
  mounted() {
    this.getComment();
  },
  methods: {
    //提交评论
    postComment() {
      if (this.loginIn) {
        let params = new URLSearchParams();
        if (this.type == 0) {
          params.append("songId", this.playId);
        } else {
          params.append("songListId", this.playId);
        }
        params.append("userId", this.userId);
        params.append("type", this.type);
        params.append("content", this.textarea);
        setComment(params)
          .then((res) => {
            if (res.code == 1) {
              Toast("评论成功");
              this.textarea = "";
              this.getComment();
            } else {
              Toast("评论失败");
            }
          })
          .catch((err) => {
            Toast("评论失败");
          });
      } else {
        this.rank = null;
        Toast("请先登录");
      }
    },
    //评论列表
    getComment() {
      getAllComment(this.type, this.playId)
        .then((res) => {
          this.commentList = res;
          for (let item of res) {
            this.getUsers(item.userId);
          }
        })
        .catch((err) => {
          Toast("评论加载失败");
        });
    },
    //获取用户的头像和昵称
    getUsers(id) {
      getUserOfId(id)
        .then((res) => {
          this.userPic.push(res.avator);
          this.userName.push(res.username);
        })
        .catch((err) => {
          Toast("出错了");
        });
    },
    //给某一个评论点赞
    postUp(id, up, index) {
      if (this.loginIn) {
        let params = new URLSearchParams();

        params.append("id", id);
        params.append("up", up + 1);
        setLike(params)
          .then((res) => {
            if (res.code == 1) {
              this.$refs.up[index].children[0].style.color = "#2796cd";
              this.getComment();
            } else {
              Toast("点赞失败");
            }
          })
          .catch((err) => {
            Toast("点赞失败");
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
@import "../assets/css/comment.scss";
</style>
