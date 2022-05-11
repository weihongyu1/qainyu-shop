<template>
  <div>
    <img src="../assets/img/login-1.webp" style="width: 100%;height: 100vh;opacity:0.6;">
    <div class="login-body">
      <div class="login-body-img">
        <img src="../assets/img/login-1.webp" style="width: 30rem;height: 30rem;border-radius: 2rem 0rem 0rem 2rem;">
      </div>
      <div class="login-form">
        <div class="login-form-title"><span>Welcome！</span></div>
        <div class="login-form-describe"><span style="font-weight: lighter;">Please Sign in Your Account!</span></div>
        <div class="login-form-user">
          <input type="text" placeholder="用户名：" v-model="form.username" name="username"/><br>
          <input type="password" placeholder="密码：" v-model="form.password" name="password"/><br>
          <button @click="login()">登录</button><br>
        </div>
        <div id="register" style="margin-top: 0.8rem;margin-left: 8.5rem">
          <a href="#">没有账号？立即注册</a>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

import request from "../util/request";
import { mapMutations } from 'vuex';

export default {
  name: "Login",
  data(){
    return{
      form: {
        username: "",
        password: "",
      },

    }
  },
  methods:{
    ...mapMutations(['changeLogin']),
    login(){
      request.post("/api/auths/login",this.form).then(res =>{
        if (res.data != null){
          console.log(res.data)
          sessionStorage.setItem('username', JSON.stringify(this.form.username))

          this.changeLogin({ Authorization: res.data });
          this.$router.push({
            path: '/'
          }) ;
          alert("登录成功");
        }else {
          alert("用户名或密码错误");
        }
      });
    }
  }
}
</script>

<style>
.login-body{
  height: 30rem;
  width: 60rem;
  background-color: white;
  position: absolute;
  left: 13rem;
  top: 7rem;
  border-radius: 2rem;
}
.login-body-img{
  float: left;
}
.login-form{
  float: left;
  margin-left: 7.5rem;
  margin-top: 5rem;
}
.login-form-title{
  font-weight: bolder;
  font-size: xxx-large;
  color: #80b3ff;
}
.login-form-describe{
  margin-top: 1rem;
  padding-left: 0.6rem;
}
.login-form-user{
  margin-top: 1.5rem;
}
input{
  width: 15rem;
  height: 2rem;
  outline: 1px solid #80b3ff;
  padding-left: 1rem;
  margin: 0.8rem;
  margin-left: -0.3rem;
}
input:hover,input:focus{
  outline: 1px solid #4d94ff;
  box-shadow: #80b3ff 0px 0px 8px;
}

button{
  background-color: #80b3ff;
  width: 15rem;
  height: 3rem;
  border: none;
  margin-left: 0.3rem;
  margin-top: 1rem;
}
button:focus,button:hover{
  cursor: pointer;
  background-color: #4d94ff;
}
#register a{
  color: #80b3ff;
  font-size: xx-small;
  cursor: pointer;
}
#register a:hover,#register a:focus {
  color: #4d94ff;
}
</style>