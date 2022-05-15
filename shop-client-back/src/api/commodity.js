import request from '@/utils/request'

export function getAllCommodity() {
  return request({
    url: '/commodity/get_all',
    method: 'get'
  })
}

export function takeUpCommodityList(data) {
  return request({
    url: '/commodity/take_up_list',
    method: 'post',
    data
  })
}

export function takeUpCommodityForm(data) {
  return request({
    url: '/commodity/take_up_form',
    method: 'post',
    data
  })
}

export function takeDownCommodity(data) {
  return request({
    url: '/commodity/take_down',
    method: 'post',
    data
  })
}
