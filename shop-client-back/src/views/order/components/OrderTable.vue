<template>
  <div style="width: 99%;margin: 1rem">
    <el-button type="primary" style="float: left" size="small">新增</el-button>
    <!--  搜索框-->
    <div style="width: 20rem;float: left;margin-left: 15px">
      <el-input v-model="search.text" placeholder="请输入内容" class="input-with-select" size="small">
        <el-select slot="prepend" v-model="search.select" placeholder="请选择">
          <el-option label="订单号" value="orderId" />
          <el-option label="商品ID" value="commodityId" />
          <el-option label="用户名" value="username" />
          <el-option label="收件人" value="recipient" />
        </el-select>
        <el-button slot="append" icon="el-icon-search" />
      </el-input>
    </div>

    <div style="clear: both" />

    <!--    表格-->
    <el-table
      :data="orders"
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
            <el-form-item label="订单号">
              <span>{{ props.row.orderId }}</span>
            </el-form-item>
            <el-form-item label="商品 ID">
              <span>{{ props.row.commodityId }}</span>
            </el-form-item>
            <el-form-item label="用户名">
              <span>{{ props.row.username }}</span>
            </el-form-item>
            <el-form-item label="商品名称">
              <span>{{ props.row.commodityName }}</span>
            </el-form-item>
            <el-form-item label="商品分类">
              <span>{{ props.row.category }}</span>
            </el-form-item>
            <el-form-item label="商品描述">
              <span>{{ props.row.desc }}</span>
            </el-form-item>
            <el-form-item label="收件人">
              <span>{{ props.row.recipient }}</span>
            </el-form-item>
            <el-form-item label="收件地址">
              <span>{{ props.row.address }}</span>
            </el-form-item>
            <el-form-item label="收件电话">
              <span>{{ props.row.phoneNumber }}</span>
            </el-form-item>
            <el-form-item label="发货时间">
              <span>{{ props.row.deliveryTime }}</span>
            </el-form-item>
            <el-form-item label="订单创建时间">
              <span>{{ props.row.date }}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>

      <el-table-column prop="date" label="日期" sortable />
      <el-table-column prop="orderId" label="订单号" />
      <el-table-column prop="commodityId" label="商品ID" />
      <el-table-column prop="username" label="用户名" width="80px" />
      <el-table-column prop="recipient" label="收件人" width="80px" />
      <el-table-column prop="address" label="收件地址" :show-overflow-tooltip="true" />
      <el-table-column
        prop="paymentStatus"
        label="支付状态"
        :filters="[{text: '已支付', value: '已支付'}, {text: '未支付', value: '未支付'}]"
        :filter-method="filterPamentStaus"
        filter-placement="bottom-end"
        width="100px"
      >
        <template slot-scope="scope">
          <el-tag
            :type="scope.row.paymentStatus === '已支付' ? 'success' : 'danger'"
            disable-transitions
          >{{ scope.row.paymentStatus }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-popover
            placement="right"
            width="400"
            trigger="click"
          >
            <!--          表单-->
            <el-form ref="form" :model="form" label-width="80px">
              <el-form-item label="收件人">
                <el-input v-model="form.recipient" />
              </el-form-item>
              <el-form-item label="收件地址">
                <el-input v-model="form.address" />
              </el-form-item>
              <el-form-item label="收件电话">
                <el-input v-model="form.phoneNumber" />
              </el-form-item>
              <el-form-item label="支付状态">
                <el-input v-model="form.paymentStatus" />
              </el-form-item>
              <el-form-item>
                <el-button type="primary">确定</el-button>
                <el-button>取消</el-button>
              </el-form-item>
            </el-form>
            <!--          编辑-->
            <el-button slot="reference" size="mini">编辑</el-button>
          </el-popover>

          <el-popconfirm
            title="这将删除数据库中关于此订单的所有消息！"
          >
            <el-button slot="reference" type="danger" size="mini">删除</el-button>
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
  name: 'OrderTable',
  data() {
    return {
      allPageNumber: 20,
      value: true,
      search: {
        text: '',
        type: ''
      },
      form: {
        orderId: '202205060001',
        recipient: 'why',
        address: '甘肃省兰州市榆中县园子岔乡小岔村大敦子社17号',
        paymentStatus: '已支付',
        phoneNumber: '15337086013'
      },
      orders: [{
        orderId: '202205060001',
        commodityId: '1548',
        recipient: 'why',
        address: '甘肃省兰州市榆中县园子岔乡小岔村大敦子社17号',
        date: '2022-05-06 13:20',
        paymentStatus: '已支付',
        commodityName: '沐浴磨砂膏',
        category: '生活用品 洗护用品',
        desc: '用于沐浴，强效洁净身体',
        deliveryTime: '2022-05-07 9:00',
        phoneNumber: '15337086013',
        username: 'wyy'
      },
      {
        orderId: '202205060002',
        commodityId: '1549',
        recipient: 'wyy',
        address: '江苏省镇江市京口区象山街道学府路301号',
        date: '2022-05-06 13:30',
        paymentStatus: '已支付',
        commodityName: '沐浴磨砂膏',
        category: '生活用品 洗护用品',
        desc: '用于沐浴，强效洁净身体',
        deliveryTime: '2022-05-07 9:00',
        phoneNumber: '15337086013',
        username: 'wyy'
      },
      {
        orderId: '202205060002',
        commodityId: '1549',
        recipient: 'wyy',
        address: '江苏省镇江市京口区象山街道学府路301号',
        date: '2022-05-06 13:30',
        paymentStatus: '已支付',
        commodityName: '沐浴磨砂膏',
        category: '生活用品 洗护用品',
        desc: '用于沐浴，强效洁净身体',
        deliveryTime: '2022-05-07 9:00',
        phoneNumber: '15337086013',
        username: 'wyy'
      },
      {
        orderId: '202205060002',
        commodityId: '1549',
        recipient: 'wyy',
        address: '江苏省镇江市京口区象山街道学府路301号',
        date: '2022-05-06 13:30',
        paymentStatus: '已支付',
        commodityName: '沐浴磨砂膏',
        category: '生活用品 洗护用品',
        desc: '用于沐浴，强效洁净身体',
        deliveryTime: '2022-05-07 9:00',
        phoneNumber: '15337086013',
        username: 'wyy'
      },
      {
        orderId: '202205060002',
        commodityId: '1549',
        recipient: 'wyy',
        address: '江苏省镇江市京口区象山街道学府路301号',
        date: '2022-05-06 13:30',
        paymentStatus: '已支付',
        commodityName: '沐浴磨砂膏',
        category: '生活用品 洗护用品',
        desc: '用于沐浴，强效洁净身体',
        deliveryTime: '2022-05-07 9:00',
        phoneNumber: '15337086013',
        username: 'wyy'
      },
      {
        orderId: '202205060002',
        commodityId: '1549',
        recipient: 'wyy',
        address: '江苏省镇江市京口区象山街道学府路301号',
        date: '2022-05-06 13:30',
        paymentStatus: '已支付',
        commodityName: '沐浴磨砂膏',
        category: '生活用品 洗护用品',
        desc: '用于沐浴，强效洁净身体',
        deliveryTime: '2022-05-07 9:00',
        phoneNumber: '15337086013',
        username: 'wyy'
      },
      {
        orderId: '202205060002',
        commodityId: '1549',
        recipient: 'wyy',
        address: '江苏省镇江市京口区象山街道学府路301号',
        date: '2022-05-06 13:30',
        paymentStatus: '已支付',
        commodityName: '沐浴磨砂膏',
        category: '生活用品 洗护用品',
        desc: '用于沐浴，强效洁净身体',
        deliveryTime: '2022-05-07 9:00',
        phoneNumber: '15337086013',
        username: 'wyy'
      },
      {
        orderId: '202205060002',
        commodityId: '1549',
        recipient: 'wyy',
        address: '江苏省镇江市京口区象山街道学府路301号',
        date: '2022-05-06 13:30',
        paymentStatus: '已支付',
        commodityName: '沐浴磨砂膏',
        category: '生活用品 洗护用品',
        desc: '用于沐浴，强效洁净身体',
        deliveryTime: '2022-05-07 9:00',
        phoneNumber: '15337086013',
        username: 'wyy'
      },
      {
        orderId: '202205060002',
        commodityId: '1549',
        recipient: 'wyy',
        address: '江苏省镇江市京口区象山街道学府路301号',
        date: '2022-05-06 13:30',
        paymentStatus: '已支付',
        commodityName: '沐浴磨砂膏',
        category: '生活用品 洗护用品',
        desc: '用于沐浴，强效洁净身体',
        deliveryTime: '2022-05-07 9:00',
        phoneNumber: '15337086013',
        username: 'wyy'
      },
      {
        orderId: '202205060002',
        commodityId: '1549',
        recipient: 'wyy',
        address: '江苏省镇江市京口区象山街道学府路301号',
        date: '2022-05-06 13:30',
        paymentStatus: '未支付',
        commodityName: '沐浴磨砂膏',
        category: '生活用品 洗护用品',
        desc: '用于沐浴，强效洁净身体',
        deliveryTime: '2022-05-07 9:00',
        phoneNumber: '15337086013',
        username: 'wyy'
      }]
    }
  },
  methods: {
    filterPamentStaus(value, row, column) {
      return row.paymentStatus === value
    },
    handleEdit(index, row) {
      console.log(index, row)
    },
    handleDelete(index, row) {
      console.log(index, row)
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
