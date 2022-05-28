import request from '@/utils/request'

export function getRoutes() {
  return request({
    url: '/vue-element-admin/routes',
    method: 'get'
  })
}

export function getRoles() {
  return request({
    url: '/permission/get_all',
    method: 'get'
  })
}

export function addRole(data) {
  return request({
    url: '/permission/update',
    method: 'post',
    data
  })
}

export function updateRole(id, data) {
  return request({
    url: `/permission/update`,
    method: 'post',
    data
  })
}

export function deleteRole(id) {
  return request({
    url: `/permission/delete`,
    method: 'delete',
    params: {
      id
    }
  })
}
