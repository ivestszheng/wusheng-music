<!--
 * @Descripttion:
 * @Author: 无声<ivestszheng@qq.com>
 * @Date: 2020-12-05 15:08:25
 * @LastEditTime: 2021-03-01 08:59:50
-->
<template>
  <div id="app">
    <SongAudio />
    <router-view></router-view>
  </div>
</template>

<script>
import SongAudio from './components/SongAudio'
export default {
  name: 'App',
  components: {
    SongAudio
  }
}
</script>

<style>
</style>
