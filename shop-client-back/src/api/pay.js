import request from '@/utils/request'

export function pay(data) {
  return request({
    url: '/order/alipay',
    method: 'post',
    data
  })
}
