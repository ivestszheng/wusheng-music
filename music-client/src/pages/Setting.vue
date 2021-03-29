<!--
 * @Descripttion:
 * @Author: 无声<ivestszheng@qq.com>
 * @Date: 2021-02-13 16:40:16
 * @LastEditTime: 2021-02-14 19:01:12
-->
<template>
  <div class="setting">
    <ul class="item">
      <li class="bb">设置<span class="mui-icon mui-icon-arrowright" /></li>
      <li class="bb">我的账户<span class="mui-icon mui-icon-arrowright" /></li>
      <li>彩铃广场<span class="mui-icon mui-icon-arrowright" /></li>
      <li class="bb">DIY彩铃<span class="mui-icon mui-icon-arrowright" /></li>
      <li>活动中心<span class="mui-icon mui-icon-arrowright" /></li>
      <li>达人CLUB<span class="mui-icon mui-icon-arrowright" /></li>
      <li>
        吾声隐私权政策<span class="extra">尊贵标识&独享权益</span
        ><span class="mui-icon mui-icon-arrowright" />
      </li>
      <li>帮助与客服<span class="mui-icon mui-icon-arrowright" /></li>
    </ul>
    <router-link to="/home">
      <div class="mui-icon mui-icon-closeempty"></div
    ></router-link>
    <div class="mui-icon-extra mui-icon-extra-sweep"></div>
        <button
      class="mui-btn mui-btn-block mui-btn-default"
      @click="logout"
      v-if="loginIn"
    >
      退出登录
    </button>
        <button class="mui-btn mui-btn-block mui-btn-default" @click="closeApp">
      关闭应用
    </button>
  </div>
</template>

<script>
import { Toast } from "mint-ui";
import { mixin } from "../mixins";
import { mapGetters } from "vuex";

export default {
  inject: ["reload"],
  name: "setting",
  mixins: [mixin],
  computed: {
    ...mapGetters([
      "loginIn", //用户是否已登录
    ]),
  },
  data() {
    return {};
  },
  created() {},
  mounted() {},
  methods: {
    // 退出登录
    logout() {
      this.$messagebox
        .confirm("确定退出当前账号？", "提示")
        .then((action) => {
          if (action == "confirm") {
            // 提示用户退出成功
            Toast({
              message: "已退出登录",
              position: "top",
              duration: 5000,
            });
            // 将Vuex中的用户信息删除
            this.$store.commit("setLoginIn", false);
            // 解决我的页面数据残留
            this.reload();
            this.$router.push("/home");
          }
        })
        .catch((err) => {
          if (err == "cancel") {
          }
        });
    }, // 退出应用
    closeApp() {
      this.$messagebox
        .confirm("确定退出应用？", "提示")
        .then((action) => {
          if (action == "confirm") {
            // 提示用户退出成功
            window.open("about:blank", "_self", ""); //子窗口句柄设置为自身，此时他的打开对象不为空
            window.close(); //window.close()和self.close()只能关闭弹出窗口，不能关闭非弹出窗口
          }
        })
        .catch((err) => {
          if (err == "cancel") {
          }
        });
    },
  },
};
</script>

<style lang="scss" scoped>
@import "../assets/css/mui-btn.scss";
@import "../assets/css/setting.scss";
</style>
