<!--
 * @Descripttion: 搜索歌单
 * @Author: 无声<ivestszheng@qq.com>
 * @Date: 2020-12-25 13:09:35
 * @LastEditTime: 2021-02-14 20:17:38
-->
<template>
  <div class="search-song-Lists">
    <content-list :contentList="albumDatas"></content-list>
  </div>
</template>
<script>
import ContentList from "../ContentList";
import { getSongListOfLikeTitle } from "../../api/index";

export default {
  name: "search-song-lists",
  components: {
    ContentList,
  },
  data() {
    return {
      albumDatas: [],
    };
  },
  mounted() {
    this.getSearchList();
  },
  methods: {
    getSearchList() {
      if (!this.$route.query.keywords) {
        Toast("您输入的内容为空");
      } else {
        getSongListOfLikeTitle(this.$route.query.keywords).then((res) => {
          if (res) {
            this.albumDatas = res;
          } else {
           Toast("暂无该歌曲内容");
          }
        });
      }
    },
  },
};
</script>

<style lang="scss" scoped>
</style>
