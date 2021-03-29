<!--
 * @Descripttion:
 * @Author: 无声<ivestszheng@qq.com>
 * @Date: 2020-12-10 18:23:43
 * @LastEditTime: 2021-02-14 20:26:59
-->
<template>
  <div>
    <div class="mui-content">
      <form class="mui-input-group" :model="loginForm" ref="loginForm">
        <div class="mui-input-row">
          <label>账号</label>
          <input
            v-model="loginForm.username"
            type="text"
            class="mui-input-clear"
            placeholder="请输入用户名"
          />
        </div>
        <div class="mui-input-row">
          <label>密码</label>
          <input
            v-model="loginForm.password"
            type="password"
            class="mui-input-password"
            placeholder="请输入密码"
          />
        </div>
      </form>
      <div class="mui-content-padded">
        <button
          @click="handleLoginIn"
          class="mui-btn mui-btn-block mui-btn-primary"
        >
          登录
        </button>
        <div class="link-area" @click="goSignUp">还没有注册，去注册</div>
      </div>
    </div>
  </div>
</template>

<script>
import { Toast } from "mint-ui";
import { mixin } from "../../mixins";
import { loginIn } from "../../api/index";

export default {
  name: "Login",
  data() {
    return {
      loginForm: {
        username: "",
        password: "",
      },
    };
  },
  mounted() {},
  methods: {
    handleLoginIn() {
      let _this = this;
      let params = new URLSearchParams();
      params.append("username", this.loginForm.username);
      params.append("password", this.loginForm.password);
      loginIn(params)
        .then((res) => {
          if (res.code == 1) {
            Toast({
              message: "登录成功",
              iconClass: "mui-icon mui-icon-checkmarkempty",
            });
            // 提交信息到vuex中
            _this.$store.commit("setLoginIn", true);
            _this.$store.commit("setUserId", res.userMsg.id);
            _this.$store.commit("setUsername", res.userMsg.username);
            _this.$store.commit("setAvator", res.userMsg.avator);
            setTimeout(function () {
              _this.$router.push({ path: "/mine" });
            }, 2000);
          } else {
            Toast({
              message: "用户名或密码错误",
              iconClass: "mui-icon mui-icon-closeempty",
            });
          }
        })
        .catch((err) => {
          Toast({
            message: "无法连接到服务器",
            iconClass: "mui-icon mui-icon-spinner-cycle mui-spin",
          });
        });
    },
    goSignUp() {
      this.$router.push({ path: "/sign-up" });
    },
  },
};
</script>
<style lang="scss" scoped>
@import '../../assets/css/login-in.scss'
</style>
