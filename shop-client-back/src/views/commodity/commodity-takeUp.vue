<template>
  <div style="width: 99%;margin: 1rem">
    <el-form ref="form" :model="form" label-width="80px">
      <el-form-item label="商品名称">
        <el-input v-model="form.name"></el-input>
      </el-form-item>
      <el-form-item label="商品地域">
        <el-cascader
          size="large"
          :options="form.options"
          v-model="selectedOptions"
          @change="handleChange">
        </el-cascader>
      </el-form-item>
      <el-form-item label="即时销售">
        <el-switch v-model="form.delivery"></el-switch>
      </el-form-item>
      <el-form-item label="预售时间">
        <el-col :span="11">
          <el-date-picker type="date" placeholder="选择日期" v-model="form.date1" style="width: 100%;"></el-date-picker>
        </el-col>
        <el-col class="line" :span="1" style="padding-left: 1.2rem">-</el-col>
        <el-col :span="11">
          <el-time-picker placeholder="选择时间" v-model="form.date2" style="width: 100%;"></el-time-picker>
        </el-col>
      </el-form-item>
      <el-form-item label="商品标签">
        <el-radio-group v-model="form.type">
          <el-radio label="生活家居"></el-radio>
          <el-radio label="数码产品"></el-radio>
          <el-radio label="潮流服饰"></el-radio>
          <el-radio label="日用产品"></el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="商品描述">
        <el-input type="textarea" v-model="form.desc"></el-input>
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
export default {
  name: 'CommodityTakeUp',
  comments: provinceAndCityData,
  data() {
    return {
      form: {
        name: '',
        options: provinceAndCityData,
        date1: '',
        date2: '',
        delivery: false,
        type: [],
        desc: ''
      },
      selectedOptions: []
    }
  },
  methods: {
    onSubmit() {
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
