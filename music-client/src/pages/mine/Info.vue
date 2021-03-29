<!--
 * @Descripttion: 修改用户个人信息
 * @Author: 无声<ivestszheng@qq.com>
 * @Date: 2021-02-14 16:28:58
 * @LastEditTime: 2021-02-14 20:23:13
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
      <mt-field
        label="性别"
        placeholder="必填：性别"
        v-model="fakeSex"
        class="sex"
        ><mt-switch v-model="sexValue" @change="turn"></mt-switch>
        <input class="trueSexInput" type="text" v-model="registerForm.sex" />
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
        <button @click="saveMsg" class="mui-btn mui-btn-block mui-btn-primary">
          保存
        </button>
      </div>
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import { mixin } from "../../mixins";
import { Toast } from "mint-ui";
import { getUserOfId, updateUserMsg } from "../../api/index";

export default {
  name: "info",
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
  computed: {
    ...mapGetters(["userId"]),
  },
  created() {},
  mounted() {
    this.getMsg(this.userId);
  },
  methods: {
    getMsg(userId) {
      getUserOfId(userId)
        .then((res) => {
          this.registerForm.username = res.username;
          this.registerForm.password = res.password;
          this.registerForm.sex = res.sex;
          this.registerForm.phoneNum = res.phoneNum;
          this.registerForm.email = res.email;
          this.registerForm.birth = this.attachBirth(res.birth);
          this.registerForm.introduction = res.introduction;
          this.registerForm.location = res.location;
        })
        .catch((err) => {
          console.log(err);
        });
    },
    saveMsg() {
      let _this = this;
      let d = new Date(this.registerForm.birth);
      let datetime =
        d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + d.getDate();
      let params = new URLSearchParams();
      params.append("id", this.userId);
      params.append("username", this.registerForm.username);
      params.append("password", this.registerForm.password);
      params.append("sex", this.registerForm.sex);
      params.append("phoneNum", this.registerForm.phoneNum);
      params.append("email", this.registerForm.email);
      params.append("birth", datetime);
      params.append("introduction", this.registerForm.introduction);
      params.append("location", this.registerForm.location);
      updateUserMsg(params)
        .then((res) => {
          if (res.code == 1) {
            _this.$store.commit("setUsername", this.registerForm.username);
            Toast({
              message: "修改成功",
              iconClass: "mui-icon mui-icon-checkmarkempty",
            });
            setTimeout(function () {
              _this.$router.push({ path: "/" });
            }, 2000);
          } else {
            Toast({
              message: "修改失败",
              iconClass: "mui-icon mui-icon-closeempty",
            });
          }
        })
        .catch((err) => {
          Toast({
            message: "修改失败",
            iconClass: "mui-icon mui-icon-closeempty",
          });
        });
    },
    turn() {
      if (this.sexValue) {
        // 后端传值
        this.registerForm.sex = "0";
        // 界面显示
        this.fakeSex = "女";
      } else {
        this.registerForm.sex = "1";
        this.fakeSex = "男";
      }
    },
  },
};
</script>

<style lang="scss" scoped>
@import "../../assets/css/sign-up.scss";
</style>
