import request from '../utils/request'

export function login(data){
    return request({
        url: '/auths/login',
        method: 'post',
        data: data
    })
}

export function getUser(){
    return request({
        url: '/user/get_user',
        method: 'get'
    })
}
