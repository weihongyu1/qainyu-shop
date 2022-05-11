<template>
  <div class="carousel">
    <div class="carousel-top">

      <!--    左侧导航栏-->
      <div class="carousel-top-left-link">
        <ul>
          <li @mouseenter="openProductList()">手机 <img src="../assets/img/right.png" class="img-right"></li>
          <li>电视 <img src="../assets/img/right.png" class="img-right"></li>
          <li>笔记本 平板 <img src="../assets/img/right.png" class="img-right"></li>
          <li>家电 <img src="../assets/img/right.png" class="img-right"></li>
          <li>出行 穿戴 <img src="../assets/img/right.png" class="img-right"></li>
          <li>智能 路由器 <img src="../assets/img/right.png" class="img-right"></li>
          <li>电源 配件 <img src="../assets/img/right.png" class="img-right"></li>
          <li>健康 儿童 <img src="../assets/img/right.png" class="img-right"></li>
          <li>耳机 音箱 <img src="../assets/img/right.png" class="img-right"></li>
          <li>生活 箱包 <img src="../assets/img/right.png" class="img-right"></li>
        </ul>
      </div>
<!--      弹出层-->
      <div class="carousel-top-left-link-product" v-show="openProduct">

      </div>

      <!--    右侧轮播图-->
      <div class="carousel-top-right-img">
        <a><img v-bind:src="imgSrc" style="height: 100%;width: 100%"></a>
      </div>
    </div>

    <div></div>
  </div>
</template>

<script>
export default {
  name: "Carousel",
  data(){
    return {
      imgSrc : require("../assets/img/carousel-4.webp"),
      openProduct: false,
    }
  },
  methods:{
    openProductList(){
      this.openProduct = true;
    }
  }
}
</script>

<style scoped>
.carousel{
  margin-left: 15vh;
  margin-right: 19.5vh;
  overflow: hidden;
}
.carousel-top{
  height: 25rem;
}
ul li{
  list-style: none;
}
/* 左侧导航 */
.carousel-top-left-link{
  height: 25rem;
  width: 13.5rem;
  float: left;
  position: absolute;
  background-color: rgb(128, 128, 128, .6);
}
.carousel-top-left-link ul{
  margin-top: 1.5rem;
}
.carousel-top-left-link ul li{
  height: 1.8rem;
  font-size: 1rem;
  padding-left: 2rem;
  padding-top: 0.5rem;
  cursor: pointer;
}
.carousel-top-left-link ul li:hover{
  background-color: #ff8000;
}
.img-right{
  height: 1rem;
  padding-top: 0.1rem;
  margin-right: 1rem;
  float: right;
}
.carousel-top-left-link-product{
  height: 25rem;
  width: calc(100% - 13.5rem);
  background-color: white;
  position: absolute;
  left: calc(15vh + 13.5rem);
}

/* 轮播 */
.carousel-top-right-img{
  height: 25rem;
  width: 100%;
  cursor: pointer;
}
</style>