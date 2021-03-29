<!--
 * @Descripttion: 注册
 * @Author: 无声<ivestszheng@qq.com>
 * @Date: 2020-12-10 18:23:43
 * @LastEditTime: 2021-02-14 16:32:48
-->
<template>
  <div class="signUp">
    <div ref="registerForm">
      <mt-field
        label="用户名"
        placeholder="必填：用户名"
        v-model="registerForm.username"
      ></mt-field>
      <mt-field
        label="密码"
        placeholder="必填：密码"
        type="password"
        v-model="registerForm.password"
      ></mt-field>
      <!-- 性别 -->
      <mt-field label="性别" placeholder="必填：性别" v-model="fakeSex" class="sex"
        ><mt-switch v-model="sexValue" @change="turn"></mt-switch>
        <input
          class="trueSexInput"
          type="text"
          v-model="registerForm.sex"
        />
      </mt-field>
      <!-- 性别 -->
      <mt-field
        label="手机"
        placeholder="选填：手机号"
        type="tel"
        v-model="registerForm.phoneNum"
      ></mt-field>
      <mt-field
        label="邮箱"
        placeholder="请输入邮箱"
        type="email"
        v-model="registerForm.email"
      ></mt-field>
      <mt-field
        label="生日"
        placeholder="必填：生日"
        type="date"
        v-model="registerForm.birth"
      ></mt-field>
      <!-- <router-link to="/register/location"> -->
      <mt-field
        label="地区"
        placeholder="选填：省份"
        v-model="registerForm.location"
      ></mt-field>
      <!-- </router-link> -->
      <mt-field
        label="签名"
        placeholder="选填：签名"
        type="textarea"
        rows="2"
        v-model="registerForm.introduction"
      ></mt-field>
      <div class="mui-content-padded">
        <button @click="SignUp" class="mui-btn mui-btn-block mui-btn-primary">
          注册
        </button>
      </div>
    </div>
  </div>
</template>

<script>
import { mixin } from "../../mixins";
import { Toast } from 'mint-ui';
import { SignUp } from "../../api/index";

export default {
  mixins: [mixin],
  data() {
    return {
      registerForm: {
        username: "", //用户名
        password: "", //密码
        sex: "1", //性别
        phoneNum: "", //手机
        email: "", //邮箱
        birth: "", //生日
        introduction: "", //签名
        location: "", //地区
      },
      sexValue: false,
      fakeSex: "男",
    };
  },
  created() {},
  mounted() {},
  methods: {
    SignUp() {
      let _this = this;
      console.log(this.registerForm.birth);
      let params = new URLSearchParams();
      params.append("username", this.registerForm.username);
      params.append("password", this.registerForm.password);
      params.append("sex", this.registerForm.sex);
      params.append("phoneNum", this.registerForm.phoneNum);
      params.append("email", this.registerForm.email);
      params.append("birth", this.registerForm.birth);
      params.append("introduction", this.registerForm.introduction);
      params.append("location", this.registerForm.location);
      params.append("avator", "/img/user.jpg");
      SignUp(params)
        .then((res) => {
          if (res.code == 1) {
            // 注册成功
            Toast({
              message: "注册成功",
              iconClass: "mui-icon mui-icon-checkmarkempty",
            });
            setTimeout(function () {
              _this.$router.push({ path: "/" });
            }, 2000);
          } else {
            // 注册失败
            Toast({
              message: "注册失败",
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
    turn() {
      // console.log(this.sexValue);
      if (this.sexValue) {
        // 后端传值
        this.registerForm.sex = "0";
        // 界面显示
        this.fakeSex = "女"
        // console.log(this.registerForm.sex);
      } else {
        this.registerForm.sex = "1";
        this.fakeSex = "男"
        // console.log(this.registerForm.sex);
      }
    },
  },
};
</script>

<style lang="scss" scoped>
@import '../../assets/css/sign-up.scss'
</style>
