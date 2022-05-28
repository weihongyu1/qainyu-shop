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

export function getAllUser() {
  return request({
    url: '/user/get_all',
    method: 'get'
  })
}

export function editUser(data) {
  return request({
    url: '/user/update_info',
    method: 'post',
    data
  })
}

export function delUser(uId) {
  return request({
    url: '/user/del',
    method: 'get',
    params: {
      uId: uId
    }
  })
}
