<template>
  <Header></Header><div style="clear: both"></div>

 <div style="background-color: #f2f2f2;height: 100vh">
   <div class="order">
     <div class="order-img">
       <img src="../assets/img/buy-page/buy-01.png" style="height: 10rem;width: 10rem">
     </div>
     <div class="order-info">
       Xiaomi Civi 1S
     </div>
     <div class="order-price">2299元</div>
   </div>
 </div>
</template>

<script>
import Header from "../components/Header";
export default {
  name: "OrderPage",
  components: {Header}
}
</script>

<style scoped>
.order{
  margin-top: 2rem;
  margin-left: 15vh;
  margin-right: 19.5vh;
  height: 10rem;
  background-color: white;
}
.order:hover{
  box-shadow: 0px 0px 10px #cccccc;
}
.order-img{
  float: left;
}
.order-info{
  float: left;
  font-size: larger;
  margin-top: 4rem;
  margin-left: 15rem;
}
.order-price{
  float: left;
  font-weight: lighter;
  color: #ff8000;
  margin-top: 4rem;
  margin-left: 5rem;
}
</style>