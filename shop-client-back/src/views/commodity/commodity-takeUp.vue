<template>
  <div style="width: 99%;margin: 1rem">
    <el-form ref="form" :model="form" label-width="80px">
      <el-form-item label="商品名称">
        <el-input v-model="form.commodityName" />
      </el-form-item>
      <el-form-item label="商品地域">
        <el-input v-model="form.shipAddress" />
      </el-form-item>
      <el-form-item label="即时销售">
        <el-switch v-model="form.delivery" active-text="是" inactive-text="否" />
      </el-form-item>
      <el-form-item label="预售时间">
        <el-col :span="11">
          <el-date-picker v-model="form.date" type="date" placeholder="选择日期" style="width: 100%;" />
        </el-col>
        <el-col class="line" :span="1" style="padding-left: 1.2rem">-</el-col>
        <el-col :span="11">
          <el-time-picker v-model="form.time" placeholder="选择时间" style="width: 100%;" />
        </el-col>
      </el-form-item>
      <el-form-item label="商品标签">
        <el-radio-group v-model="form.category">
          <el-radio label="生活家居" />
          <el-radio label="数码产品" />
          <el-radio label="潮流服饰" />
          <el-radio label="日用产品" />
        </el-radio-group>
      </el-form-item>
      <el-form-item label="商品库存">
        <el-input v-model="form.shipAddress" />
      </el-form-item>
      <el-form-item label="商品描述">
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
import { provinceAndCityData } from 'element-china-area-data'
import { takeUpCommodityForm } from '@/api/commodity'
export default {
  name: 'CommodityTakeUp',
  comments: provinceAndCityData,
  data() {
    return {
      form: {
        commodityName: '',
        delivery: false,
        date: '',
        time: '',
        category: '',
        shipAddress: '',
        desc: '',
        stock: 0
      },
      selectedOptions: []
    }
  },
  methods: {
    onSubmit() {
      takeUpCommodityForm(this.form).then(response => {
        if (response.code === 20000) {
          alert('商品上架成功')
        } else {
          alert('商品上架失败')
        }
        location.reload()
      })
      console.log('submit!')
    },
    handleChange(value) {
      console.log('省市选择：', value)
    }
  }
}
</script>

<style scoped>

</style>
