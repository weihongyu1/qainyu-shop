import request from '@/utils/request'

export function getAllOrder() {
  return request({
    url: '/order/get_all',
    method: 'get'
  })
}

export function placeOrder(data) {
  return request({
    url: '/order/place',
    method: 'post',
    data
  })
}

export function updateOrder(data) {
  return request({
    url: '/order/update',
    method: 'post',
    data
  })
}

export function delOrder(data) {
  return request({
    url: '/order/delete',
    method: 'get',
    params: {
      delOrderId: data
    }
  })
}
