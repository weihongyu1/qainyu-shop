<template>
  <div style="width: 99%;margin: 1rem">
    <el-button type="primary" style="float:left;" size="small" @click="handleAddOrder">新增</el-button>
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
            <el-form-item label="订单描述">
              <span>{{ props.row.orderDesc }}</span>
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
          <!--          编辑-->
          <el-button slot="reference" size="mini" @click="handleEditOrder(scope.row)">编辑</el-button>

          <!--          删除-->
          <el-button slot="reference" type="danger" size="mini" @click="handleDel(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-dialog :visible.sync="dialogVisible" :title="dialogType==='edit'?'编辑订单':'新增订单'">
      <el-form :model="order" label-width="80px" label-position="left">
        <el-form-item label="收件人">
          <el-input v-model="order.recipient" placeholder="收件人" />
        </el-form-item>
        <el-form-item label="收件电话">
          <el-input v-model="order.phoneNumber" placeholder="收件电话" />
        </el-form-item>
        <el-form-item label="收件地址">
          <el-input v-model="order.address" placeholder="收件地址" />
        </el-form-item>
        <el-form-item label="备注">
          <el-input
            v-model="order.orderDesc"
            :autosize="{ minRows: 2, maxRows: 4}"
            type="textarea"
            placeholder="备注"
          />
        </el-form-item>
      </el-form>
      <div style="text-align:right;">
        <el-button type="danger" @click="dialogVisible=false">取消</el-button>
        <el-button type="primary" @click="confirmOrder">确定</el-button>
      </div>
    </el-dialog>

    <el-dialog :visible.sync="dialogDelVisible" :title="dialogType==='删除订单' ? '删除订单' : '删除订单'">
      <div>
        这将删除订单的所有信息，请谨慎操作！
      </div>
      <div style="text-align:right;">
        <el-button type="primary" @click="dialogDelVisible=false">取消</el-button>
        <el-button type="danger" @click="delOrder">确定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { delOrder, getAllOrder, updateOrder } from '@/api/order'
import CodeToText from 'element-china-area-data'

export default {
  name: 'OrderTable',
  comments: CodeToText,
  data() {
    return {
      dialogDelVisible: false,
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
      order: {
        orderId: '',
        recipient: '',
        address: '',
        phoneNumber: '',
        orderDesc: ''
      },
      orders: [],
      routes: [],
      rolesList: [],
      dialogVisible: false,
      dialogType: 'new',
      delOrderId: 0
    }
  },
  created() {
    this.getAllOrder()
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
    },
    getAllOrder() {
      getAllOrder().then(response => {
        this.orders = response.data
      })
    },
    handleAddOrder() {
      this.dialogType = 'new'
      this.dialogVisible = true
    },
    handleEditOrder(row) {
      this.order = {
        orderId: row.orderId,
        recipient: row.recipient,
        address: row.address,
        phoneNumber: row.phoneNumber,
        orderDesc: row.orderDesc
      }
      this.dialogType = 'edit'
      this.dialogVisible = true
    },
    handleDel(row) {
      this.delOrderId = row.orderId
      this.dialogDelVisible = true
    },
    confirmOrder() {
      this.dialogVisible = false
      updateOrder(this.order).then(response => {
        if (response.code === 20000) {
          if (this.dialogType === 'new') {
            alert('订单新增成功')
          } else {
            alert('订单编辑成功')
          }
        } else {
          if (this.dialogType === 'new') {
            alert('订单新增失败')
          } else {
            alert('订单编辑失败')
          }
        }
      })
      location.reload()
    },
    delOrder() {
      this.dialogDelVisible = false
      delOrder(this.delOrderId).then(response => {
        if (response.code === 20000) {
          alert('订单删除成功')
        } else {
          alert('订单删除失败')
        }
      })
      location.reload()
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
