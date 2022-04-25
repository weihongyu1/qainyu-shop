<template>
  <div id="nav-top">
    <div id="nav-top-left">
      <el-breadcrumb separator="" style="padding: 0.7rem;">
        <el-breadcrumb-item :to="{ path: '/' }" class="nav-top-item">千羽商城</el-breadcrumb-item>
        <el-breadcrumb-item class="nav-top-item">QY</el-breadcrumb-item>
        <el-breadcrumb-item class="nav-top-item">云服务</el-breadcrumb-item>
        <el-breadcrumb-item class="nav-top-item">有品</el-breadcrumb-item>
        <el-breadcrumb-item class="nav-top-item">千羽开放平台</el-breadcrumb-item>
        <el-breadcrumb-item class="nav-top-item">企业团购</el-breadcrumb-item>
        <el-breadcrumb-item class="nav-top-item">资质证照</el-breadcrumb-item>
        <el-breadcrumb-item class="nav-top-item">协议规则</el-breadcrumb-item>
        <el-breadcrumb-item class="nav-top-item">下载app</el-breadcrumb-item>
        <el-breadcrumb-item class="nav-top-item">QUUI</el-breadcrumb-item>
      </el-breadcrumb>
    </div>

    <div id="nav-top-mid">
      <el-breadcrumb separator="" style="padding: 0.7rem;margin-left:15vh">
        <el-breadcrumb-item :to="{ path: '/' }" class="nav-top-item">登录</el-breadcrumb-item>
        <el-breadcrumb-item class="nav-top-item">注册</el-breadcrumb-item>
        <el-breadcrumb-item class="nav-top-item">消息通知</el-breadcrumb-item>
      </el-breadcrumb>
    </div>

    <div id="nav-top-right">
      <div class="shop-car-left">
        <img alt="未加载" src="../assets/img/shopping-car.png" style="height: 1rem">
      </div>
      <div class="shop-car-right">购物车（0）</div>
    </div>
  </div>

  <div style="clear: both"></div>

  <div id="nav-bottom">
    <div class="nav-bottom-logo">
      <img alt="未加载" src="../assets/img/logo.png" class="img-logo">
    </div>

    <div style="height: 100%;float: left;" @mouseleave="outInfoWindow()">
      <div class="nav-bottom-link">
        <ul>
          <li @mouseenter="inInfoWindow()"><a>手机</a></li>
          <li @mouseenter="inInfoWindow()"><a>笔记本</a></li>
          <li @mouseenter="inInfoWindow()"><a>潮鞋</a></li>
          <li @mouseenter="inInfoWindow()"><a>手表</a></li>
          <li @mouseenter="inInfoWindow()"><a>箱包</a></li>
          <li @mouseenter="inInfoWindow()"><a>生活家居</a></li>
          <li @mouseenter="inInfoWindow()"><a>配饰</a></li>
          <li @mouseenter="inInfoWindow()"><a>美妆</a></li>
          <li @mouseenter="inInfoWindow()"><a>潮玩</a></li>
          <li @mouseenter="inInfoWindow()"><a>艺术</a></li>
        </ul>
        <div class="nav-bottom-link-info" v-show="alertInfo">
         <div style="margin-left: 10vh;height: 100%;margin-right: 15vh;margin-top: 1rem">
           <div v-for="item in 6" class="nav-bottom-link-info-product">
             <div v-if="item != 6" style="border-right: 2px solid #d9d9d9">
               <img src="../assets/img/info-1.webp" style="height: 7rem">
             </div>
             <div v-if="item == 6">
               <img src="../assets/img/info-1.webp" style="height: 7rem">
             </div>
             <div style="text-align: center">小米手机 3100￥</div>
           </div>
         </div>
        </div>
      </div>
    </div>

    <div class="nav-bottom-search">
      <input type="text" placeholder="笔记本">
      <div>
        <img alt="未加载" src="../assets/img/search.png" style="height: 1.5rem;padding: 0.8rem" @mouseover="removeActive">
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Header",
  data(){
    return{
      searchImg: "E:\\文件\\毕业设计\\qainyu-shop\\shop-client\\src\\assets\\img\\search.png",
      alertInfo: false
    }
  },

  methods: {
    removeActive(){
      this.searchImg = "E:\\文件\\毕业设计\\qainyu-shop\\shop-client\\src\\assets\\img\\search.png";
    },
    inInfoWindow(){
      this.alertInfo = true;
    },
    outInfoWindow(){
      this.alertInfo = false;
    },
  }
}
</script>

<style scoped>
/* 上部导航 */
#nav-top{
  height: 2rem;
  width: 100%;
  background-color: #262626;
  color: #bfbfbf;
  font-size: xx-small;
}
#nav-top-left{
  width: 55%;
  margin-left: 15vh;
  float: left;
}
#nav-top-mid{
  float: left;
}
#nav-top-right{
  float: left;
  height: 100%;
  background-color: #595959;
}
#nav-top-right:hover{
  background-color: white;
  color: #ff8000;
  cursor:pointer;
}
.shop-car-left{
  float: left;
  padding-top: 0.6rem;
  padding-left: 1rem;
}
.shop-car-right{
  float: left;
  margin-left: 0.3rem;
  padding-top: 0.7rem;
  padding-right: 1rem;
}
.nav-top-item{
  cursor:pointer;
  padding-left: 0.6rem;
  padding-right: 0.3rem;
}
.nav-top-item:hover{
  color: white;
}
div{
  white-space:nowrap;
}

/* 下部导航 */
#nav-bottom{
  height: 6rem;
}
.nav-bottom-logo{
  margin-left: 15vh;
  padding: 1rem;
  width: 9rem;
  float: left;
}
.img-logo{
  height: 4rem;
}
.img-logo:hover{
  height: 3.99rem;
}

.nav-bottom-link{
  height: 2rem;
  margin-top: 2rem;
  margin-left: 2rem;
}
.nav-bottom-link li{
  padding: 0.6rem;
  float: left;
  height: 1rem;
  cursor:pointer;
}
a{
  color: #262626;
}
.nav-bottom-link li a:hover{
  color: #ff8000;
}

/* 导航链接产品 */
.nav-bottom-link-info{
  height: 12rem;
  width: 100%;
  clear: both;
  position: absolute;
  left: 0;
  top: 8rem;
  border-top: 0.1px solid  #e6e6e6;
  box-shadow: 0px 3px 3px #e6e6e6;
  background-color: white;
  z-index: 999;
}
.nav-bottom-link-info-product{
  float: left;
  margin-left: 2.1rem;
}

/* 搜索框 */
.nav-bottom-search{
  float: left;
  margin-left: 18vh;
  margin-top: 1.5rem;
}
.nav-bottom-search input{
  height: 3rem;
  width: 13rem;
  float: left;
  border: 1px solid #d9d9d9;
}
.nav-bottom-search input:hover{
  border: 1px solid #bfbfbf;
}
.nav-bottom-search input:focus{
  border: 1px solid #bfbfbf;
}
.nav-bottom-search div{
  float: left;
  height: 3rem;
  width: 3rem;
  border: 1px solid #d9d9d9;
}
.nav-bottom-search div:hover{
  border: 1px solid #bfbfbf;
  cursor: pointer;
  background-color: #ff8000;
}
</style>