<template>
  <div style="width: 99%;margin: 1rem">
    <el-form ref="form" :model="form" label-width="80px">
      <el-form-item label="商品名称">
        <el-input v-model="form.commodityName" />
      </el-form-item>
      <el-form-item label="用户名">
        <el-input v-model="form.username" />
      </el-form-item>
      <el-form-item label="收件人">
        <el-input v-model="form.recipient" />
      </el-form-item>
      <el-form-item label="收件电话">
        <el-input v-model="form.phoneNumber" />
      </el-form-item>
      <el-form-item label="收件地址">
        <el-input v-model="form.address" aria-placeholder="请输入区县，街道门牌号详细地址" />
      </el-form-item>
      <el-form-item label="支付状态">
        <el-switch v-model="form.paymentStatus" />
      </el-form-item>
      <el-form-item label="发货时间">
        <el-col :span="11">
          <el-date-picker v-model="form.date" type="date" placeholder="选择日期" style="width: 100%;" />
        </el-col>
        <el-col class="line" :span="1" style="padding-left: 1.2rem">-</el-col>
        <el-col :span="11">
          <el-time-picker v-model="form.time" placeholder="选择时间" style="width: 100%;" />
        </el-col>
      </el-form-item>
      <el-form-item label="订单描述">
        <el-input v-model="form.desc" type="textarea" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">立即创建</el-button>
        <el-button>取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { provinceAndCityData, CodeToText } from 'element-china-area-data'
import { placeOrder } from '@/api/order'

export default {
  name: 'OrderForm',
  comments: { provinceAndCityData, CodeToText },
  data() {
    return {
      form: {
        commodityName: '',
        username: '',
        recipient: '',
        phoneNumber: '',
        selectedOptions: [],
        address: '',
        paymentStatus: false,
        date: '',
        time: '',
        desc: ''
      },
      options: provinceAndCityData
    }
  },
  methods: {
    onSubmit() {
      placeOrder(this.form).then(response => {
        if (response.code === 20000) {
          alert(response.msg)
          location.reload()
        }
      })
    },
  }
}
</script>

<style scoped>

</style>
