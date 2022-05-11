import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'

const routes = [
  {
    path: '/',
    name: 'Home',
    meta : {
      requireAuth: true,
    },
    component: Home
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import('../views/Login.vue')
  },
  {
    path: '/detail_page',
    name: 'DetailPage',
    meta: {
      requireAuth: true
    },
    component: () => import('../views/DetailsPage')
  },
  {
    path: '/order_page',
    name: 'OrderPage',
    meta: {
      requireAuth: true
    },
    component: () => import('../views/OrderPage')
  },
  {
    path: '/buy_page',
    name: 'BuyPage',
    meta: {
      requireAuth: true
    },
    component: () => import('../views/BuyPage')
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
});

// 导航守卫
// 使用 router.beforeEach 注册一个全局前置守卫，判断用户是否登陆
router.beforeEach((to, from, next) => {
  if (to.path === '/login') {
    next();
  } else {
    let token = localStorage.getItem('Authorization');

    if (token === null || token === '') {
      next('/login');
    } else {
      next();
    }
  }
});

export default router
