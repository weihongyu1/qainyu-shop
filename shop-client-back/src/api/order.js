import request from '@/utils/request'

export function getAllOrder() {
  return request({
    url: '/order/get_all',
    method: 'get'
  })
}
