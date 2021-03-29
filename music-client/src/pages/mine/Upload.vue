<!--
 * @Descripttion: 上传用户头像
 * @Author: 无声<ivestszheng@qq.com>
 * @Date: 2021-02-14 20:22:58
 * @LastEditTime: 2021-02-14 21:07:05
-->
<template>
  <div class="upload">
    <el-upload
      drag
      :action="uploadUrl()"
      :show-file-list="false"
      :on-success="handleAvatorSuccess"
      :before-upload="beforeAvatorUpload"
    >
      <i class="el-icon-upload"></i>
      <div>将文件拖到此处，或<span style="color:#48658f;">修改头像</span></div>
      <div slot="tip">只能上传jpg/png文件，且不能超过10MB</div>
    </el-upload>
  </div>
</template>
<script>
import { Toast } from "mint-ui";
import { mapGetters } from "vuex";
import { mixin } from "../../mixins";

export default {
  name: "upload",
  mixins: [mixin],
  computed: {
    ...mapGetters(["userId"]),
  },
  methods: {
    //上传地址
    uploadUrl() {
      return `${this.$store.state.configure.HOST}/consumer/updateConsumerPic?id=${this.userId}`;
    },
    //上传成功
    handleAvatorSuccess(res, file) {
      if (res.code == 1) {
        this.$store.commit("setAvator", res.avator);
        Toast({
          message: "修改成功",
          iconClass: "mui-icon mui-icon-checkmarkempty",
        });
        this.$router.push('/mine');
      } else {
        Toast({
          message: "修改失败",
          iconClass: "mui-icon mui-icon-closeempty",
        });
      }
    },
    //上传之前的校验
    beforeAvatorUpload(file) {
      const isJPG = file.type == "image/jpeg";
      const isLt10M = file.size / 1024 / 1024 < 10;
      if (!isJPG) {
        Toast({
          message: "上传头像图片只能是JPG格式",
          iconClass: "mui-icon mui-icon-closeempty",
        });
        return false;
      }
      if (!isLt10M) {
        Toast({
          message: "上传头像图片不能大于10MB",
          iconClass: "mui-icon mui-icon-closeempty",
        });
        return false;
      }
      return true;
    },
  },
};
</script>
<style lang="scss" scoped>
@import "../../assets/css/upload.scss";
</style>
