<!--
 * @Descripttion: 轮播图
 * @Author: 无声<ivestszheng@qq.com>
 * @Date: 2020-12-09 09:23:46
 * @LastEditTime: 2021-02-08 16:58:56
-->
<template>
  <div>
    <mt-swipe :auto="4000">
      <mt-swipe-item v-for="item in swiperList" :key="item.id">
        <img :src="item.url" :alt="item.name"/>
      </mt-swipe-item>
    </mt-swipe>
  </div>
</template>

<script>
export default {
    name: 'swiper',
    props: ['swiperList'],
    data() {
        return {

        }
    },
    created() {

    },
    mounted() {

    },
    methods: {

    }
};
</script>

<style lang="scss" scoped>
@import '../assets/css/swiper.scss'
</style>
