<template>
  <div class="common-layout">
    <el-container>

      <!-- 头部导航 -->
      <el-header>
        <Header></Header>
      </el-header>
      <div style="clear: both"></div>

      <!-- 主体部分 -->
      <el-main>
        <Carousel></Carousel>
        <div style="clear: both"></div>
        <CardList></CardList>
      </el-main>
      <div style="clear: both"></div>
      <!-- 底部链接 -->
      <el-footer>Footer</el-footer>
    </el-container>
  </div>
</template>

<script>
// @ is an alias to /src

import Header from "../components/Header";
import Carousel from "../components/Carousel";
import request from "../util/request";
import CardList from "../components/CardList";
export default {
  name: 'Home',
  components: {CardList, Carousel, Header},
  created() {
    this.load();
  },
  methods:{
    load(){
      request.get("/api/test/user/hello",{
      }).then(res =>{
        console.log(res.data)
        if (res.code === 10002){
          localStorage.removeItem('Authorization');
          this.$router.push('/login');
        }
      });
    }
  }
}
</script>
