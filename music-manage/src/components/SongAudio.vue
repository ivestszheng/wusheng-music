<!--
 * @Descripttion: 歌曲播放器组件
 * @Author: 无声<ivestszheng@qq.com>
 * @Date: 2020-12-05 15:08:25
 * @LastEditTime: 2020-12-20 21:08:33
-->
<template>
    <div class="song-audio">
        <audio id="player"
            :src="url"
            controls = "controls"
            preload = "true"
            @canplay="startPlay"
            @ended="ended"
        ></audio>
    </div>
</template>
<script>
import {mapGetters} from 'vuex' // 监控store文件夹里的值
export default {
  name: 'song-audio',
  computed: {
    ...mapGetters([
      'id',
      'url',
      'isPlay'
    ])
  },
  watch: {
    // 监听播放还是暂停
    isPlay: function () {
      this.togglePlay()
    }
  },
  methods: {
    // 获取链接后准备播放
    startPlay () {
      let player = document.querySelector('#player')
      // 开始播放
      player.play()
    },
    // 播放完成之后触发
    ended () {
      this.isPlay = false
    },
    // 开始、暂停
    togglePlay () {
      let player = document.querySelector('#player')
      if (this.isPlay) {
        player.play()
      } else {
        player.pause()
      }
    }
  }
}
</script>

<style>
    .song-audio {
        display: none;
    }
</style>
