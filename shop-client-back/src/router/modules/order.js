/** When your routing table is too long, you can split it into small modules **/

import Layout from '@/layout'

const componentsRouter = {
  path: '/order',
  component: Layout,
  redirect: 'noRedirect',
  name: 'Order',
  meta: {
    title: '订单管理',
    icon: 'shopping'
  },
  children: [
    {
      path: 'order-list',
      component: () => import('@/views/order/orderList'),
      name: 'OrderList',
      meta: { title: '订单列表' }
    },{
      path: 'order-form',
      component: () => import('@/views/order/orderForm'),
      name: 'OrderForm',
      meta: { title: '创建订单' }
    }
  ]
}

export default componentsRouter
