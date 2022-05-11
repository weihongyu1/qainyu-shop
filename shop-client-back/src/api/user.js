import request from '@/utils/request'

export function login(data) {
  return request({
    url: '/auths/login',
    method: 'post',
    data
  })
}

export function getInfo(token) {
  return request({
    url: '/user/get_user',
    method: 'get',
    params: { token }
  })
}

export function logout() {
  return request({
    url: '/vue-element-admin/user/logout',
    method: 'post'
  })
}
