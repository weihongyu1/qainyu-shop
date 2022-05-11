<template>
  <div style="width: 99%;margin: 1rem">
    <el-button type="primary" style="float: left" size="small">新增</el-button>
    <!--  搜索框-->
    <div style="width: 20rem;float: left;margin-left: 15px">
      <el-input v-model="search" placeholder="请输入内容" class="input-with-select" size="small">
        <el-button slot="append" icon="el-icon-search" />
      </el-input>
    </div>

    <div style="clear: both" />

    <!--    表格-->
    <el-table
      :data="commodity"
      border
      :default-sort="{prop: 'date', order: 'descending'}"
      style="margin-top: 10px"
      highlight-current-row
    >
      <!--    选中行-->
      <el-table-column type="selection" width="55" />
      <!--    展开详细描述-->
      <el-table-column type="expand">
        <template slot-scope="props">
          <el-form label-position="left" inline class="demo-table-expand">
            <el-form-item label="商品ID">
              <span>{{ props.row.commodityId }}</span>
            </el-form-item>
            <el-form-item label="商品名称">
              <span>{{ props.row.commodityName }}</span>
            </el-form-item>
            <el-form-item label="商品分类">
              <span>{{ props.row.category }}</span>
            </el-form-item>
            <el-form-item label="销售时间">
              <span>{{ props.row.address }}</span>
            </el-form-item>
            <el-form-item label="上架时间">
              <span>{{ props.row.phoneNumber }}</span>
            </el-form-item>
            <el-form-item label="商品地域">
              <span>{{ props.row.phoneNumber }}</span>
            </el-form-item>
            <el-form-item label="商品描述">
              <span>{{ props.row.desc }}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>
      <el-table-column prop="commodityId" label="商品ID" />
      <el-table-column prop="commodityName" label="商品名称" />
      <el-table-column
        prop="type"
        label="商品分类"
        :filters="[{text: '生活家居', value: '生活家居'}, {text: '数码产品', value: '数码产品'}, {text: '潮流服饰', value: '潮流服饰'}, {text: '日用产品', value: '日用产品'}]"
        :filter-method="filterType"
        filter-placement="bottom-end"
        width="100px"
      >
        <template slot-scope="scope">
          <el-tag
            :type="parseColor(scope.row.type)"
            disable-transitions
          >{{ scope.row.type }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column prop="saleDate" label="销售时间" sortable />
      <el-table-column prop="takeUpDate" label="上架时间" sortable />
      <el-table-column prop="address" label="商品地域" :show-overflow-tooltip="true" />
      <el-table-column prop="desc" label="商品描述" :show-overflow-tooltip="true" />
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-popover
            placement="right"
            width="400"
            trigger="click"
          >
            <!--          表单-->
            <el-form ref="form" :model="form" label-width="80px">

            </el-form>
            <!--          编辑-->
            <el-button slot="reference" size="mini">编辑</el-button>
          </el-popover>

          <el-popconfirm
            title="这将删除数据库中关于此订单的所有消息！"
          >
            <el-button slot="reference" type="danger" size="mini">下架</el-button>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>

    <div>
      <el-pagination
        layout="prev, pager, next"
        :total="allPageNumber">
      </el-pagination>
    </div>
  </div>
</template>

<script>
export default {
  name: 'CommodityList',
  data() {
    return {
      search: '',
      allPageNumber: 20,
      form: {
      },
      commodity: [{
        commodityId: '14556687686',
        commodityName: '半亩花田-磨砂膏',
        type: '生活家居',
        saleDate: '2022-06-04 13:20',
        takeUpDate: '2022-06-04 13:20',
        address: '江苏省镇江市京口区学府路301号',
        desc: '半亩花田磨砂膏'
      }, {
        commodityId: '14556687686',
        commodityName: '半亩花田-磨砂膏',
        type: '数码产品',
        saleDate: '2022-06-04 13:20',
        takeUpDate: '2022-06-04 13:20',
        address: '江苏省镇江市京口区学府路301号',
        desc: '半亩花田磨砂膏'
      }]
    }
  },
  methods: {
    filterType(value, row, column) {
      return row.type === value
    },
    handleEdit(index, row) {
      console.log(index, row)
    },
    handleDelete(index, row) {
      console.log(index, row)
    },
    parseColor(type) {
      switch (type) {
        case '生活家居': return 'success'
        case '数码产品': return 'primary'
        case '潮流服饰': return 'warning'
        case '日用产品': return 'danger'
      }
    }
  }
}
</script>

<style scoped>
.demo-table-expand {
  font-size: 0;
}
.demo-table-expand label {
  width: 90px;
  color: #99a9bf;
}
.demo-table-expand .el-form-item {
  margin-right: 0;
  margin-bottom: 0;
  width: 50%;
}

.el-select .el-input {
  width: 130px;
}
.input-with-select .el-input-group__prepend {
  background-color: #fff;
}
</style>
