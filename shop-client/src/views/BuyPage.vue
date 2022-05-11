<template>
  <div><Header></Header></div>
  <div style="clear: both"></div>
  <div style="box-shadow-: 0px 5px 5px #cccccc">

    <div style="margin-left: 15vh;margin-right: 19.5vh;height: 4rem;">
      <div style="float: left;margin-top: 1.5rem;">
        <span style="font-weight: lighter">Xiaomi Civi 1S</span>
        <span style="margin-left: 0.5rem;margin-right: 0.5rem;font-weight: lighter">|</span>
        <span style="font-weight: lighter;font-size: small">Xiaomi Civi</span>
      </div>
      <div style="float: right;margin-top: 1.23rem;">
        <span class="detail-link">概述页</span><span class="detail-link-separate">|</span>
        <span class="detail-link">参数页</span><span class="detail-link-separate">|</span>
        <span class="detail-link">正品验证</span><span class="detail-link-separate">|</span>
        <span class="detail-link">咨询客服</span><span class="detail-link-separate">|</span>
        <span class="detail-link">用户评价</span>
      </div>
    </div>
  </div>

<!--  购买详情页 -->
  <div class="buy-detail">
    <div class="buy-img">
      <img src="../assets/img/buy-page/buy-01.png" style="width: 100%;text-align: center">
    </div>
    <div class="buy-info">
      <div style="font-size: x-large">Xiaomi Civi 1S</div>
      <div style="width: 80%;margin-top: 2rem;">
        <span style="font-weight: lighter">「至高享6期免息；购机赠小米尊享礼盒」原生美肌人像2.0 | 4D光追焕颜美妆技术 |</span><br><br>
        <span style="font-weight: lighter;padding-top: 1rem">3200万高清质感自拍 | 升级人眼追焦 | 6400万AI三摄 | 3D曲面OLED柔性屏 | </span><br><br>
        <span style="font-weight: lighter;padding-top: 1rem">120Hz+Dolby Vision | 55W有线闪充 | 立体声双扬声器 | 多功能NFC</span><br>
      </div>
      <div style="margin-top: 10rem">
        <button class="buy" @click="buy()">立即购买</button>
      </div>
    </div>
  </div>
</template>

<script>
import Header from "../components/Header";
export default {
  name: "BuyPage",
  components: {Header},
  methods:{
    buy(){
      this.$router.push("/order_page");
    }
  }
}
</script>

<style scoped>
.detail-link{
  font-weight: lighter;
  font-size: medium;
  cursor: pointer;
}
.detail-link:hover{
  color: #ff8000;
}
.detail-link-separate{
  margin-left: 0.5rem;
  margin-right: 0.5rem;
  font-weight: lighter
}

.buy-detail{
  width: 100%;
  margin-left: 15vh;
  margin-right: 19.5vh;
}
.buy-img{
  text-align: center;
  width: 40%;
  float: left;
}
.buy-info{
  float: left;
  width: 60%;
}

.buy{
  outline: none;
  background-color: #ffa500;
  height: 3rem;
  width: 10rem;
  border: none;
  cursor: pointer;
  margin-left: 28rem;
}
.buy:hover{
  background-color: #ff8000;
  height: 2.98rem;
  width: 9.98rem;
}
</style>