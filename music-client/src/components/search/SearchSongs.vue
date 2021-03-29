<!--
 * @Descripttion: 搜索歌曲
 * @Author: 无声<ivestszheng@qq.com>
 * @Date: 2020-12-25 13:09:41
 * @LastEditTime: 2021-02-14 18:56:06
-->
<template>
    <div class="search-songs">
       <album-content :songList="listOfSongs"></album-content>
    </div>
</template>
<script>
import {mapGetters} from "vuex"
import {mixin} from "../../mixins"
import AlbumContent from "../AlbumContent"

export default {
    name: 'search-songs',
    components:{
        AlbumContent
    },
    mixins: [mixin],
    computed:{
        ...mapGetters([
            'listOfSongs'
        ])
    },
    mounted() {
        this.getSong();
    },
    methods: {

    }
}
</script>

<style lang="scss" scoped>
</style>
