/** When your routing table is too long, you can split it into small modules **/

import Layout from '@/layout'

const componentsRouter = {
  path: '/commodity',
  component: Layout,
  redirect: 'noRedirect',
  name: 'Commodity',
  meta: {
    title: '商品管理',
    icon: 'international'
  },
  children: [
    {
      path: 'commodity-list',
      component: () => import('@/views/commodity/commodity-list'),
      name: 'CommodityList',
      meta: { title: '商品列表' }
    },{
      path: 'commodity-take-off',
      component: () => import('@/views/commodity/commodity-takeUp'),
      name: 'CommodityTakeUp',
      meta: { title: '商品上架' }
    }
  ]
}

export default componentsRouter
