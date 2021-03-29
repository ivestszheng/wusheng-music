<!--
 * @Descripttion: 返回顶部
 * @Author: 无声<ivestszheng@qq.com>
 * @Date: 2020-12-12 23:35:00
 * @LastEditTime: 2020-12-26 19:45:21
-->
<template>
  <div class="scrollTop" @click="returnTop" v-show="flag_scroll">
    <!-- <div class="scrollTop" @click="returnTop"> -->
    <span class="mui-icon-extra mui-icon-extra-top"></span>
  </div>
</template>
<script>
export default {
  name: "scroll-top",
  data() {
    return {
      flag_scroll: false,
    };
  },
  methods: {
    // 实现返回顶部效果
    returnTop() {
      document.documentElement.scrollTop = document.body.scrollTop = 0;
    },
    //  滑动超过800px时显示按钮
    handleScroll() {
      let scrolltop =
        document.documentElement.scrollTop || document.body.scrollTop;
      scrolltop > 800 ? (this.flag_scroll = true) : (this.flag_scroll = false);
      // console.log(scrolltop)
    },
  },
  mounted() {
    // 此处true需要加上，不加滚动事件可能绑定不成功
    window.addEventListener("scroll", this.handleScroll, true);
  },
};
</script>

<style lang="scss" scoped>
@import '../assets/css/scroll-top.scss'
</style>
