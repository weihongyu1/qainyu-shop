<template>
  <button style="width: 100px;height: 30px" value="支付" @click="submit" />
</template>

<script>
import { pay } from '@/api/pay'

export default {
  name: 'Index',
  data() {
    return {
      pay: {
        // 订单编号
        orderId: 9,
        // 订单名称
        orderName: '商品支付',
        // 订单金额
        orderPrice: '400'
      }
    }
  },
  methods: {
    submit() {
      pay(this.pay).then(response => {
        // 添加之前先删除一下，如果单页面，页面不刷新，添加进去的内容会一直保留在页面中，二次调用form表单会出错
        const divForm = document.getElementsByTagName('div')
        if (divForm.length) {
          document.body.removeChild(divForm[0])
        }
        const div = document.createElement('div')
        div.innerHTML = response.data // data就是接口返回的form 表单字符串
        document.body.appendChild(div)
        document.forms[0].setAttribute('target', '_blank') // 新开窗口跳转
        document.forms[0].submit()
      })
      this.$router.push('/')
    }
  }
}
</script>

<style scoped>

</style>
