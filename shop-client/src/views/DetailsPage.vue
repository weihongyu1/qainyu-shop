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
        <span class="detail-link">用户评价</span><span class="detail-link-separate">|</span>
        <button class="buy" @click="toBuyPage()">立即购买</button>
      </div>
    </div>
  </div>

  <div>
    <img src="../assets/img/detail-page/detail-page-1.jpg" style="height: 50rem">
    <img src="../assets/img/detail-page/deatil-page-2.jpg" style="height: 50rem">
  </div>
</template>

<script>
import Header from "../components/Header";
export default {
  name: "DetailsPage",
  components: {Header},
  methods:{
    toBuyPage(){
      this.$router.push('/buy_page');
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

.buy{
  outline: none;
  background-color: #ffa500;
  height: 1.5rem;
  width: 5rem;
  border: none;
  cursor: pointer
}
.buy:hover{
  background-color: #ff8000;
  height: 1.48rem;
  width: 4.98rem;
}
</style>