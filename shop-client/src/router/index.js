import { createRouter, createWebHistory } from 'vue-router'

const routes = [
  {
    path: '/login',
    name: 'Login',
    component: () => import('../views/login/index')
  },
  {
    path: '/register',
    name: 'Register',
    component: () => import('../views/login/Register')
  },
  {
    path: '/index',
    name: 'Home',
    meta : {
      requireAuth: true,
    },
    component: () => import('../views/home/index')
  },
  {
    path: '/details',
    name: 'Details',
    meta : {
      requireAuth: true,
    },
    component: () => import('../views/details/index')
  },
  {
    path: '/success',
    name: 'ResultSuccess',
    meta : {
      requireAuth: true,
    },
    component: () => import('../components/ResultSuccess')
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

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
      next()
    }
  }
});
export default router
