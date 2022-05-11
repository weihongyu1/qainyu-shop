<template>
  <div style="background-color: #f2f2f2;overflow: hidden;margin-top: 1rem">
    <div class="card-list">
      <div>
        <img alt="未加载" src="../assets/img/ad-1.webp" style="width: 100%;height: 6rem;">
      </div>

      <div class="title">手机</div>

      <div class="card">
        <div class="card-left">
          <img src="../assets/img/card-left-1.webp" alt="未加载" style="width: 100%;height: 100%">
        </div>

        <div class="card-right" v-for="item in 4">
          <div class="card-right-top" @click="toDetailPage()">
            <img src="../assets/img/card-right-1.webp" style="height: 70%;width: 100%;" alt="未加载">
            <div style="text-align: center;font-weight: lighter;margin-top: 0.2rem">Xiaomi CIvi 1S</div>
            <div style="text-align: center;color:  #ff8000;margin-top: 1rem;font-size: smaller">2299元起</div>
          </div>
          <div class="card-right-bottom">
            <img src="../assets/img/card-right-1.webp" style="height: 70%;width: 100%" alt="未加载">
            <div style="text-align: center;font-weight: lighter;margin-top: 0.2rem">Xiaomi CIvi 1S</div>
            <div style="text-align: center;color:  #ff8000;margin-top: 1rem;font-size: smaller">2299元起</div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "CardList",
  methods:{
    toDetailPage(){
      this.$router.push('/detail_page');
    }
  }
}
</script>

<style scoped>
.card-list{
  height: 55rem;
  margin-left: 15vh;
  margin-right: 19.5vh;
  margin-top: 1rem;
}
.title{
  margin-top: 2rem;
  font-size: larger;
  font-weight: lighter;
}
.card-left{
  background-color: white;
  float: left;
  height: 35rem;
  width: 13.6rem;
  margin-top: 2rem;
}
.card-left:hover{
  box-shadow: 0 0 20px #cccccc;
  cursor: pointer;
}

.card-right{
  height: 35rem;
  width: 13.6rem;
  float: left;
  margin-top: 2rem;
  margin-left: 0.8rem;
}
.card-right-top,.card-right-bottom{
  background-color: white;
  height: 17rem;
  width: 100%;
}
.card-right-top:hover,.card-right-bottom:hover{
  cursor: pointer;
  box-shadow: 0 0 20px #cccccc;
}
.card-right-bottom{
  margin-top: 1rem;
}
</style>