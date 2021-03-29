<!--
 * @Descripttion: 歌手索引列表
 * @Author: 无声<ivestszheng@qq.com>
 * @Date: 2020-12-11 13:43:58
 * @LastEditTime: 2020-12-26 20:15:08
-->
<template>
  <div class="index-list">
    <mt-index-list>
      <!-- 所有歌手 -->
      <mt-index-section index="#" class="index">
        <div
          v-for="item in indexList"
          :key="item.id"
          class="cell-content"
          @click="goAlbum(item, item.name)"
        >
          <img class="singer-img" v-lazy="attachImageUrl(item.pic)" />
          <span class="singer-name">{{ item.name }}</span>
          <span class="mui-icon mui-icon-arrowright"></span>
        </div>
      </mt-index-section>
      <!-- 英文字母、拼音首字母过滤的歌手 -->
      <mt-index-section index="A">
        <div
          v-for="item in listA"
          :key="item.id"
          class="cell-content"
          @click="goAlbum(item, item.name)"
        >
          <img class="singer-img" v-lazy="attachImageUrl(item.pic)" />
          <span class="singer-name">{{ item.name }}</span>
          <span class="mui-icon mui-icon-arrowright"></span>
        </div>
      </mt-index-section>
      <mt-index-section index="B">
        <div
          v-for="item in listB"
          :key="item.id"
          class="cell-content"
          @click="goAlbum(item, item.name)"
        >
          <img class="singer-img" v-lazy="attachImageUrl(item.pic)" />
          <span class="singer-name">{{ item.name }}</span>
          <span class="mui-icon mui-icon-arrowright"></span>
        </div>
      </mt-index-section>
      <mt-index-section index="C">
        <div
          v-for="item in listC"
          :key="item.id"
          class="cell-content"
          @click="goAlbum(item, item.name)"
        >
          <img class="singer-img" v-lazy="attachImageUrl(item.pic)" />
          <span class="singer-name">{{ item.name }}</span>
          <span class="mui-icon mui-icon-arrowright"></span>
        </div>
      </mt-index-section>
      <mt-index-section index="D">
        <div
          v-for="item in listD"
          :key="item.id"
          class="cell-content"
          @click="goAlbum(item, item.name)"
        >
          <img class="singer-img" v-lazy="attachImageUrl(item.pic)" />
          <span class="singer-name">{{ item.name }}</span>
          <span class="mui-icon mui-icon-arrowright"></span>
        </div>
      </mt-index-section>
      <mt-index-section index="E">
        <div
          v-for="item in listE"
          :key="item.id"
          class="cell-content"
          @click="goAlbum(item, item.name)"
        >
          <img class="singer-img" v-lazy="attachImageUrl(item.pic)" />
          <span class="singer-name">{{ item.name }}</span>
          <span class="mui-icon mui-icon-arrowright"></span>
        </div>
      </mt-index-section>
      <mt-index-section index="F">
        <div
          v-for="item in listF"
          :key="item.id"
          class="cell-content"
          @click="goAlbum(item, item.name)"
        >
          <img class="singer-img" v-lazy="attachImageUrl(item.pic)" />
          <span class="singer-name">{{ item.name }}</span>
          <span class="mui-icon mui-icon-arrowright"></span>
        </div>
      </mt-index-section>
      <mt-index-section index="G">
        <div
          v-for="item in listG"
          :key="item.id"
          class="cell-content"
          @click="goAlbum(item, item.name)"
        >
          <img class="singer-img" v-lazy="attachImageUrl(item.pic)" />
          <span class="singer-name">{{ item.name }}</span>
          <span class="mui-icon mui-icon-arrowright"></span>
        </div>
      </mt-index-section>
      <mt-index-section index="H">
        <div
          v-for="item in listH"
          :key="item.id"
          class="cell-content"
          @click="goAlbum(item, item.name)"
        >
          <img class="singer-img" v-lazy="attachImageUrl(item.pic)" />
          <span class="singer-name">{{ item.name }}</span>
          <span class="mui-icon mui-icon-arrowright"></span>
        </div>
      </mt-index-section>
      <mt-index-section index="I">
        <div
          v-for="item in listI"
          :key="item.id"
          class="cell-content"
          @click="goAlbum(item, item.name)"
        >
          <img class="singer-img" v-lazy="attachImageUrl(item.pic)" />
          <span class="singer-name">{{ item.name }}</span>
          <span class="mui-icon mui-icon-arrowright"></span>
        </div>
      </mt-index-section>
      <mt-index-section index="J">
        <div
          v-for="item in listJ"
          :key="item.id"
          class="cell-content"
          @click="goAlbum(item, item.name)"
        >
          <img class="singer-img" v-lazy="attachImageUrl(item.pic)" />
          <span class="singer-name">{{ item.name }}</span>
          <span class="mui-icon mui-icon-arrowright"></span>
        </div>
      </mt-index-section>
      <mt-index-section index="K">
        <div
          v-for="item in listK"
          :key="item.id"
          class="cell-content"
          @click="goAlbum(item, item.name)"
        >
          <img class="singer-img" v-lazy="attachImageUrl(item.pic)" />
          <span class="singer-name">{{ item.name }}</span>
          <span class="mui-icon mui-icon-arrowright"></span>
        </div>
      </mt-index-section>
      <mt-index-section index="L">
        <div
          v-for="item in listL"
          :key="item.id"
          class="cell-content"
          @click="goAlbum(item, item.name)"
        >
          <img class="singer-img" v-lazy="attachImageUrl(item.pic)" />
          <span class="singer-name">{{ item.name }}</span>
          <span class="mui-icon mui-icon-arrowright"></span>
        </div>
      </mt-index-section>
      <mt-index-section index="M">
        <div
          v-for="item in listM"
          :key="item.id"
          class="cell-content"
          @click="goAlbum(item, item.name)"
        >
          <img class="singer-img" v-lazy="attachImageUrl(item.pic)" />
          <span class="singer-name">{{ item.name }}</span>
          <span class="mui-icon mui-icon-arrowright"></span>
        </div>
      </mt-index-section>
      <mt-index-section index="N">
        <div
          v-for="item in listN"
          :key="item.id"
          class="cell-content"
          @click="goAlbum(item, item.name)"
        >
          <img class="singer-img" v-lazy="attachImageUrl(item.pic)" />
          <span class="singer-name">{{ item.name }}</span>
          <span class="mui-icon mui-icon-arrowright"></span>
        </div>
      </mt-index-section>
      <mt-index-section index="O">
        <div
          v-for="item in listO"
          :key="item.id"
          class="cell-content"
          @click="goAlbum(item, item.name)"
        >
          <img class="singer-img" v-lazy="attachImageUrl(item.pic)" />
          <span class="singer-name">{{ item.name }}</span>
          <span class="mui-icon mui-icon-arrowright"></span>
        </div>
      </mt-index-section>
      <mt-index-section index="P">
        <div
          v-for="item in listP"
          :key="item.id"
          class="cell-content"
          @click="goAlbum(item, item.name)"
        >
          <img class="singer-img" v-lazy="attachImageUrl(item.pic)" />
          <span class="singer-name">{{ item.name }}</span>
          <span class="mui-icon mui-icon-arrowright"></span>
        </div>
      </mt-index-section>
      <mt-index-section index="Q">
        <div
          v-for="item in listQ"
          :key="item.id"
          class="cell-content"
          @click="goAlbum(item, item.name)"
        >
          <img class="singer-img" v-lazy="attachImageUrl(item.pic)" />
          <span class="singer-name">{{ item.name }}</span>
          <span class="mui-icon mui-icon-arrowright"></span>
        </div>
      </mt-index-section>
      <mt-index-section index="R">
        <div
          v-for="item in listR"
          :key="item.id"
          class="cell-content"
          @click="goAlbum(item, item.name)"
        >
          <img class="singer-img" v-lazy="attachImageUrl(item.pic)" />
          <span class="singer-name">{{ item.name }}</span>
          <span class="mui-icon mui-icon-arrowright"></span>
        </div>
      </mt-index-section>
      <mt-index-section index="S">
        <div
          v-for="item in listS"
          :key="item.id"
          class="cell-content"
          @click="goAlbum(item, item.name)"
        >
          <img class="singer-img" v-lazy="attachImageUrl(item.pic)" />
          <span class="singer-name">{{ item.name }}</span>
          <span class="mui-icon mui-icon-arrowright"></span>
        </div>
      </mt-index-section>
      <mt-index-section index="T">
        <div
          v-for="item in listT"
          :key="item.id"
          class="cell-content"
          @click="goAlbum(item, item.name)"
        >
          <img class="singer-img" v-lazy="attachImageUrl(item.pic)" />
          <span class="singer-name">{{ item.name }}</span>
          <span class="mui-icon mui-icon-arrowright"></span>
        </div>
      </mt-index-section>
      <mt-index-section index="U">
        <div
          v-for="item in listU"
          :key="item.id"
          class="cell-content"
          @click="goAlbum(item, item.name)"
        >
          <img class="singer-img" v-lazy="attachImageUrl(item.pic)" />
          <span class="singer-name">{{ item.name }}</span>
          <span class="mui-icon mui-icon-arrowright"></span>
        </div>
      </mt-index-section>
      <mt-index-section index="V">
        <div
          v-for="item in listV"
          :key="item.id"
          class="cell-content"
          @click="goAlbum(item, item.name)"
        >
          <img class="singer-img" v-lazy="attachImageUrl(item.pic)" />
          <span class="singer-name">{{ item.name }}</span>
          <span class="mui-icon mui-icon-arrowright"></span>
        </div>
      </mt-index-section>
      <mt-index-section index="W">
        <div
          v-for="item in listW"
          :key="item.id"
          class="cell-content"
          @click="goAlbum(item, item.name)"
        >
          <img class="singer-img" v-lazy="attachImageUrl(item.pic)" />
          <span class="singer-name">{{ item.name }}</span>
          <span class="mui-icon mui-icon-arrowright"></span>
        </div>
      </mt-index-section>
      <mt-index-section index="X">
        <div
          v-for="item in listX"
          :key="item.id"
          class="cell-content"
          @click="goAlbum(item, item.name)"
        >
          <img class="singer-img" v-lazy="attachImageUrl(item.pic)" />
          <span class="singer-name">{{ item.name }}</span>
          <span class="mui-icon mui-icon-arrowright"></span>
        </div>
      </mt-index-section>
      <mt-index-section index="Y">
        <div
          v-for="item in listY"
          :key="item.id"
          class="cell-content"
          @click="goAlbum(item, item.name)"
        >
          <img class="singer-img" v-lazy="attachImageUrl(item.pic)" />
          <span class="singer-name">{{ item.name }}</span>
          <span class="mui-icon mui-icon-arrowright"></span>
        </div>
      </mt-index-section>
      <mt-index-section index="Z">
        <div
          v-for="item in listZ"
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
// var aaa=vPinyin.chineseToPinYin("张三")
// window.console.log(vPinyin.chineseToPinYin(aaa))
// Z
import { mixin } from "../mixins/index";

export default {
  props: ["indexList"],
  mixins: [mixin],
  computed: {
    // 过滤显示拼音首字母为A的名字
    listA: function () {
      return this.$props.indexList.filter(function (item) {
        if (vPinyin.chineseToPinYin(item.name) == "A") {
          return item;
        }
      });
    },
    listB: function () {
      return this.$props.indexList.filter(function (item) {
        if (vPinyin.chineseToPinYin(item.name) == "B") {
          return item;
        }
      });
    },
    listC: function () {
      return this.$props.indexList.filter(function (item) {
        if (vPinyin.chineseToPinYin(item.name) == "C") {
          return item;
        }
      });
    },
    listD: function () {
      return this.$props.indexList.filter(function (item) {
        if (vPinyin.chineseToPinYin(item.name) == "D") {
          return item;
        }
      });
    },
    listE: function () {
      return this.$props.indexList.filter(function (item) {
        if (vPinyin.chineseToPinYin(item.name) == "E") {
          return item;
        }
      });
    },
    listF: function () {
      return this.$props.indexList.filter(function (item) {
        if (vPinyin.chineseToPinYin(item.name) == "F") {
          return item;
        }
      });
    },
    listG: function () {
      return this.$props.indexList.filter(function (item) {
        if (vPinyin.chineseToPinYin(item.name) == "G") {
          return item;
        }
      });
    },
    listH: function () {
      return this.$props.indexList.filter(function (item) {
        if (vPinyin.chineseToPinYin(item.name) == "H") {
          return item;
        }
      });
    },
    listI: function () {
      return this.$props.indexList.filter(function (item) {
        if (vPinyin.chineseToPinYin(item.name) == "I") {
          return item;
        }
      });
    },
    listJ: function () {
      return this.$props.indexList.filter(function (item) {
        if (vPinyin.chineseToPinYin(item.name) == "J") {
          return item;
        }
      });
    },
    listK: function () {
      return this.$props.indexList.filter(function (item) {
        if (vPinyin.chineseToPinYin(item.name) == "K") {
          return item;
        }
      });
    },
    listL: function () {
      return this.$props.indexList.filter(function (item) {
        if (vPinyin.chineseToPinYin(item.name) == "L") {
          return item;
        }
      });
    },
    listM: function () {
      return this.$props.indexList.filter(function (item) {
        if (vPinyin.chineseToPinYin(item.name) == "M") {
          return item;
        }
      });
    },
    listN: function () {
      return this.$props.indexList.filter(function (item) {
        if (vPinyin.chineseToPinYin(item.name) == "N") {
          return item;
        }
      });
    },
    listO: function () {
      return this.$props.indexList.filter(function (item) {
        if (vPinyin.chineseToPinYin(item.name) == "O") {
          return item;
        }
      });
    },
    listP: function () {
      return this.$props.indexList.filter(function (item) {
        if (vPinyin.chineseToPinYin(item.name) == "P") {
          return item;
        }
      });
    },
    listQ: function () {
      return this.$props.indexList.filter(function (item) {
        if (vPinyin.chineseToPinYin(item.name) == "Q") {
          return item;
        }
      });
    },
    listR: function () {
      return this.$props.indexList.filter(function (item) {
        if (vPinyin.chineseToPinYin(item.name) == "R") {
          return item;
        }
      });
    },
    listS: function () {
      return this.$props.indexList.filter(function (item) {
        if (vPinyin.chineseToPinYin(item.name) == "S") {
          return item;
        }
      });
    },
    listT: function () {
      return this.$props.indexList.filter(function (item) {
        if (vPinyin.chineseToPinYin(item.name) == "T") {
          return item;
        }
      });
    },
    listU: function () {
      return this.$props.indexList.filter(function (item) {
        if (vPinyin.chineseToPinYin(item.name) == "U") {
          return item;
        }
      });
    },
    listV: function () {
      return this.$props.indexList.filter(function (item) {
        if (vPinyin.chineseToPinYin(item.name) == "V") {
          return item;
        }
      });
    },
    listW: function () {
      return this.$props.indexList.filter(function (item) {
        if (vPinyin.chineseToPinYin(item.name) == "W") {
          return item;
        }
      });
    },
    listX: function () {
      return this.$props.indexList.filter(function (item) {
        if (vPinyin.chineseToPinYin(item.name) == "X") {
          return item;
        }
      });
    },
    listY: function () {
      return this.$props.indexList.filter(function (item) {
        if (vPinyin.chineseToPinYin(item.name) == "Y") {
          return item;
        }
      });
    },
    listZ: function () {
      return this.$props.indexList.filter(function (item) {
        if (vPinyin.chineseToPinYin(item.name) == "Z") {
          return item;
        }
      });
    },
  },
  data() {
    return {
      list1: [],
    };
  },
  created() {
    // this.init()
  },
  mounted() {},
  methods: {
    //     init() {
    //   // 从接口获取的数据
    //   var singer = this.indexList;
    //   // console.log(this.indexList);
    //   for (var i = 0; i < singer.length; i++) {
    //     console.log(vPinyin.chineseToPinYin(singer[i].name));
    //     if (vPinyin.chineseToPinYin(singer[i].name) == "A") {
    //       this.listA.push(singer[i].name);
    //       console.log(this.listA);
    //     }
    //   }
    // },
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
  },
};
</script>

<style lang="scss" scoped>
@import "../assets/css/index-list.scss";
</style>
