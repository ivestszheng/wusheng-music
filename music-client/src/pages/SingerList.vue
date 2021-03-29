<!--
 * @Descripttion: 歌手列表
 * @Author: 无声<ivestszheng@qq.com>
 * @Date: 2020-12-10 21:10:17
 * @LastEditTime: 2021-02-07 19:37:14
-->
<template>
  <div class="singerList">
    <index-list :indexList="indexList" v-if="flag"></index-list>
  </div>
</template>

<script>
import { getAllSinger } from "../api/index";
import IndexList from "../components/IndexList.vue";

export default {
  components: {
    IndexList,
  },
  data() {
    return {
      indexList: [],
      flag: false,
    };
  },
  created() {
    // 获取歌手列表数据
    this.getSingerList();
  },
  mounted() {},
  methods: {
    getSingerList() {
      // 获取歌手列表数据方法
      getAllSinger()
        .then((res) => {
          this.indexList = res;
          /**
           * 通过flag来确保传值后再加载组件
           * 避免出现空值过去的情况
           */
          this.flag = true;
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
};
</script>

<style lang="scss" scoped>
@import "../assets/css/singer-list.scss";
</style>
