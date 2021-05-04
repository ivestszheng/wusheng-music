<!--
 * @Descripttion: 歌手索引列表
 * @Author: 无声<ivestszheng@qq.com>
 * @Date: 2020-12-11 13:43:58
 * @LastEditTime: 2021-05-04 11:36:46
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
      console.log(dataSource);
      for (let i = 0; i < this.index.length - 1; i++) {
        console.log(this.index[i].index);
        const tempList = []
        // 从后往前遍历，解决splice()后下标改变问题
        for (let x = dataSource.length-1 ;x >= 0;x--) {
          if (vPinyin.chineseToPinYin(dataSource[x].name) == this.index[i].index) {
            console.log(dataSource[x].name);
            tempList.push(dataSource[x])
            dataSource.splice(x, 1)
          }
        }
        this.index[i].list = tempList
      }
      console.log('#');
      console.log(dataSource);
      this.index[this.index.length - 1].list = dataSource
    }
  }
}
</script>

<style lang="scss" scoped>
@import "../assets/css/index-list.scss";
</style>
