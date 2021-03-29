<h1 align="center">Music-client</h1>

# 项目初始化

```
# 新建项目
vue init webpack "music-client"
```



```
# 安装node_moudles
npm install
```

修改`config>index.js`把`port`改为8081

## 安装并引入mui、mint-ui

下载 [MUI](https://github.com/dcloudio/mui.git) ，并将 dist 文件中内容复制到`src>lib`

目录下。

安装mint-ui

```
npm install mint-ui -S
```

修改`main.js`

```
// 导入Mui框架样式
import './lib/mui/css/mui.css'
import './lib/mui/css/icons-extra.css'
// 导入mint-ui组件库
import 'mint-ui/lib/style.css'
import Mint from 'mint-ui'
Vue.use(Mint)
```



## 安装scss

输入如下命令：

```
npm install sass-loader@7.3.1 -D
npm install node-sass@4.13 -D
npm install sass@^1.3.0 -D
npm install fibers@>=3.1.0 -D
```

不能直接使用命令：

```
npm install sass-loader --save-dev
npm install node-sass
```

因为当前sass的版本太高，webpack编译时出现了错误，所以指定：npm install sass-loader@7.3.1 --save-dev 安装低版本的。



# 轮播图

Swiper.vue

```
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
  .mint-swipe {
    height: 200px;
    color: #fff;

    .mint-swipe-items-wrap {
      .mint-swipe-item {
        text-align: center;
      }
    }
    img {
      width: 100%;
      height: 100%;
    }
  }
</style>

```

Home.vue

```
<template>
  <div class="home">
    <swiper :swiperList="swiperList"></swiper>
     <ul class="mui-table-view mui-grid-view mui-grid-9">
      <li class="mui-table-view-cell mui-media"><router-link to="/songList">
          <span class="mui-icon-extra mui-icon-extra-custom"></span>
          <div class="mui-media-body">歌单</div>
        </router-link></li>
      <li class="mui-table-view-cell mui-media"><router-link to="">
          <span class="mui-icon-extra mui-icon-extra-cate"></span>
          <div class="mui-media-body">电台</div>
        </router-link></li>
      <li class="mui-table-view-cell mui-media"><router-link to="">
          <span class="mui-icon-extra mui-icon-extra-rank"></span>
          <div class="mui-media-body">排行榜</div>
        </router-link></li>
      <li class="mui-table-view-cell mui-media"><router-link to="">
          <span class="mui-icon-extra mui-icon-extra-peoples"></span>
          <div class="mui-media-body">歌手</div>
        </router-link></li>
      <li class="mui-table-view-cell mui-media"><router-link to="">
          <span class="mui-icon-extra mui-icon-extra-notice"></span>
          <div class="mui-media-body">视频彩铃</div>
        </router-link></li>
    </ul>
  </div>
</template>

<script>
import Swiper from '../components/Swiper.vue'


export default {
  name: 'home',
  components: {
    Swiper

  },
  props: {
    msg: String
  },
  data () {
    return {
      swiperList: []
    }
  },
  created () {
    this.getSwiperList();
  },
  methods: {
    getSwiperList() {
      this.$http
        .get("swiper/allSwiper")
        .then((res) => {
          // window.console.log(res.data);
          this.swiperList = res.data;
        })
        .catch((err) => {});
    }
  }
}
</script>

<style lang="scss" scoped>
.mui-grid-view.mui-grid-9 {
  background-color: #fff;
  border: none;

  img {
    width: 60px;
    height: 60px;
  }
}

.mui-table-view-cell > a.title {
  display: inline;
}

.mui-grid-view.mui-grid-9 .mui-table-view-cell {
  font-size: 0.875rem;
  border: 0;
}

.mui-media-body {
  font-size: 14px;
}
</style>
```



# 安装axios

 新建`src>api`

http.js

```
import axios from 'axios'

import config from './config'

export default{
    install:function(vue){
        var auth = vue.prototype.$auth
        var obj = axios.create({
            baseURL:config.baseUrl
        })
        obj.interceptors.request.use(function(conf){
            conf.headers.Authorization = auth.getAuthorization()
            return conf
        })
        vue.prototype.$http = obj
    }
}
```

auth.js

```
var auth ={
    getAuthorization(){
        return localStorage.getItem('Authorization')
    },
    setAuthorization(Authorization){
        localStorage.setItem('Authorization',Authorization)
    }
}
export default{
    install:function(vue){
        vue.prototype.$auth = auth
    }
}
```

config.js

```
export default{
    baseUrl:'http://localhost:8888/'
}
```

最后在main.js中导入并注册

# 使用better-scroll滚动组件

```
npm i better-scroll@1.15.2
```



# 实现歌手拼音列表

# 实现音乐播放器

## 1.在store中添加状态管理

## 2.在Components中定义SongAudio

## 3.在App.vue中引入SongAudio



# 按需引入 Element-ui

## 1.安装Element-ui

```
npm install element-ui@2.4.11
```

## 2.安装babel-plugin-component：

```
npm install babel-plugin-component -D
```

## 3.修改.babelrc 

在"plugins"中添加

```json
// 按需引入Element-ui
    [
      "component",
      {
        "libraryName": "element-ui",
        "styleLibraryName": "theme-chalk"
      }
    ]
```

# z-index

1.TheAside  1000

2.TopBar,TabBar,LyricPlayBar 900

3.PlayBar 800

4.lyric 700

5.歌词页背景 -100

# BUG

1.退出登录后再次登录，然后刷新，无法获取到vuex中的信息，且我的页面不会变回未登录状态

解决方案：

```
      // 相当于重新刷新页面,一定要设一个延迟，否则不会toast
      setTimeout(function () {
        this.$router.go(0);
      }, 2000);
```

# 配置IP地址访问

```
music-client\config\index.js > host
music-client\src\api\http.js > defaults.baseURL
music-client\src\store\moudels\configure.js > HOST
```

