<template>
  <div class="error">
    <div class="not-found">没有找到相关内容</div>
    <div class="go-home">
      去
      <router-link class="go-home-link" to="/home">首页</router-link>
      发现喜欢的音乐({{ time }})
    </div>
    <img src="../assets/img/is-play.gif" class="is-play">
  </div>
</template>

<script>
export default {
  name: '',
  data() {
    return {
      time: 0
    }
  },
  components: {},
  methods: {
    //   倒计时
    countDown() {
      let _this = this;
      _this.time--;
    },
  },
  mounted() {
    let _this = this;
    _this.time = 5;
    // 设定定时器，每一秒调用一次coundDown方法，time-1
    setInterval(_this.countDown, 1000);
  },
  watch: {
    //   监听 time 的值
    time: function (newVal) {
      if (newVal === 0) {
        this.$router.push("/home");
      }
    },
  },
}
</script>

<style lang="scss" scoped>
@import "../assets/css/404.scss";
</style>
