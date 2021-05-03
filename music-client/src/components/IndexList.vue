<!--
 * @Descripttion: 歌手索引列表
 * @Author: 无声<ivestszheng@qq.com>
 * @Date: 2020-12-11 13:43:58
 * @LastEditTime: 2021-05-03 23:35:42
-->
<template>
  <div class="index-list">
    <mt-index-list>
      <mt-index-section v-for="i in index" :key="i.index" :index="i.index">
        <div
          v-for="item in i.list"
          :key="item.id"
          class="cell-content"
          @click="goAlbum(item, item.name)"
        >
          <img class="singer-img" v-lazy="attachImageUrl(item.pic)" />
          <span class="singer-name">{{ item.name }}</span>
          <span class="mui-icon mui-icon-arrowright"></span>
        </div>
      </mt-index-section>
    </mt-index-list>
  </div>
</template>

<script>
import vPinyin from "../api/vue-py";
import { mixin } from "../mixins/index";
import { index } from "../assets/data/index"

export default {
  props: ["indexList"],
  mixins: [mixin],
  computed: {},
  data() {
    return {
      index: [], // 索引
      specialList: []
    };
  },
  created() {

  },
  mounted() {
    this.index = index
    this.indexFilter()
  },
  methods: {
    // 跳转到对应歌手页面
    goAlbum(item, type) {
      this.$store.commit("setTempList", item);
      if (type) {
        //歌手
        this.$router.push({
          path: `singer-album/${item.id}`,
        });
      } else {
        //歌单
        this.$router.push({
          path: `song-list-album/${item.id}`,
        });
      }
    },
    indexFilter() {
      const dataSource = this.$props.indexList
      console.log(dataSource);
      this.index.forEach(i => {
        const tempList = []
        dataSource.forEach(element => {
          if (vPinyin.chineseToPinYin(element.name) == i.index) {
            tempList.push(element)
          }
        });
        i.list = tempList
      })
    }
  }
}
</script>

<style lang="scss" scoped>
@import "../assets/css/index-list.scss";
</style>
