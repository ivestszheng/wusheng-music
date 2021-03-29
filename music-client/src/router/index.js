// @ts-nocheck
/*
 * @Descripttion:
 * @Author: 无声<ivestszheng@qq.com>
 * @Date: 2020-12-09 09:14:37
 * @LastEditTime: 2021-02-24 22:54:55
 */
import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/pages/Home'
import LoginIn from '@/pages/mine/LoginIn'
import SignUp from '@/pages/mine/SignUp'
import Info from '@/pages/mine/Info'
import Upload from '@/pages/mine/Upload'
import Live from '@/pages/Live'
import Mine from '@/pages/Mine'
import Setting from '@/pages/Setting'
import Search from '@/pages/Search'
import SingerList from '@/pages/SingerList'
import SongList from '@/pages/SongList'
import Lyric from '@/pages/Lyric'
// 点击某一歌单和歌手跳转的页面
import SingerAlbum from '@/pages/SingerAlbum'
import SongListAlbum from '@/pages/SongListAlbum'
import Error from '@/pages/404'
Vue.use(Router)

const routes = [
  {
    path: '/',
    redirect: '/home',
  },
  {
    path: '/home',
    name: 'home',
    component: Home,
    meta: {
      title: '首页',
      active: '/home'
    }
  },
  {
    path: '/404',
    component: Error,
    meta: {
      title: '404',
      active: '/home'
    }
  },
  {
    path: '*',
    redirect: '/404',
  },
  {
    path: '/mine',
    name: 'mine',
    component: Mine,
    meta: {
      title: '我的',
      active: '/mine'
    }
  },
  {
    path: '/login-in',
    name: 'login-in',
    component: LoginIn,
    meta: {
      title: '密码登录',
      active: '/mine'
    }
  },
  {
    path: '/sign-up',
    name: 'sign-up',
    component: SignUp,
    meta: {
      title: '注册',
      active: '/mine'
    }
  },
  {
    path: '/info',
    name: 'info',
    component: Info,
    meta: {
      title: '编辑个人资料',
      active: '/mine'
    }
  },
  {
    path: '/upload',
    name: 'upload',
    component: Upload,
    meta: {
      title: '修改个人头像',
      active: '/mine'
    }
  },
  {
    path: '/live',
    name: 'live',
    component: Live,
    meta: {
      title: '现场',
      active: '/live'
    }
  },
  {
    path: '/search',
    name: 'search',
    component: Search,
    meta: {
      title: '搜索',
      active: '/home',
      bottomPlayBar: 'true'
    }
  },
  {
    path: '/setting',
    name: 'setting',
    component: Setting,
    meta: {
      title: '设置',
      active: '/home'
    }
  },
  {
    path: '/singer-list',
    name: 'singer-list',
    component: SingerList,
    meta: {
    title: '歌手',
    active: '/home',
    bottomPlayBar: 'true'
}
  },
  {
    path: '/song-list',
    name: 'song-list',
    component: SongList,
    meta: {
      title: '歌单',
      active: '/home',
      bottomPlayBar: 'true'
    }
  },
  {
    path: '/lyric',
    name: 'lyric',
    component: Lyric,
    meta: {
      title: '歌词',
      active: '/mine'
    }
  },
  {
    path: '/singer-album/:id',
    name: 'singer-album',
    component: SingerAlbum,
    meta: {
      title: '歌手内容',
      active: '/home'
    }
  },
  {
    path: '/song-list-album/:id',
    name: 'song-list-album',
    component: SongListAlbum,
    meta: {
      title: '歌单内容',
      active: '/home'
    }
  },

]


const router = new Router({
  mode: 'history',
  routes,
  // 给当前的路由添加一个类名
  // linkActiveClass: 'mui-active'
})

// 添加路由导航守卫，用来动态设置标题内容
router.beforeEach((to, from, next) => {
  if (to.meta.title) {
    document.title = to.meta.title + ' - 吾声音乐网'
  }
  next()  //放行函数，不加无法继续运行
})

export default router

