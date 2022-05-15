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
      :data="commodities"
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
              <span>{{ props.row.id }}</span>
            </el-form-item>
            <el-form-item label="商品名称">
              <span>{{ props.row.commodityName }}</span>
            </el-form-item>
            <el-form-item label="商品分类">
              <span>{{ props.row.category }}</span>
            </el-form-item>
            <el-form-item label="销售时间">
              <span>{{ props.row.shipAddress }}</span>
            </el-form-item>
            <el-form-item label="上架时间">
              <span>{{ props.row.takeUpDate }}</span>
            </el-form-item>
            <el-form-item label="商品地域">
              <span>{{ props.row.shipAddress }}</span>
            </el-form-item>
            <el-form-item label="商品描述">
              <span>{{ props.row.desc }}</span>
            </el-form-item>
            <el-form-item label="商品库存">
              <span>{{ props.row.stock }}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>
      <el-table-column prop="id" label="商品ID" width="100" />
      <el-table-column prop="commodityName" label="商品名称" :show-overflow-tooltip="true" />
      <el-table-column
        prop="category"
        label="商品分类"
        :filters="[{text: '生活家居', value: '生活家居'}, {text: '数码产品', value: '数码产品'}, {text: '潮流服饰', value: '潮流服饰'}, {text: '日用产品', value: '日用产品'}]"
        :filter-method="filterType"
        filter-placement="bottom-end"
        width="100px"
      >
        <template slot-scope="scope">
          <el-tag
            :type="parseColor(scope.row.category)"
            disable-transitions
          >{{ scope.row.category }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column prop="takeUpDate" label="上架时间" sortable />
      <el-table-column prop="shipAddress" label="商品地域" :show-overflow-tooltip="true" />
      <el-table-column prop="desc" label="商品描述" :show-overflow-tooltip="true" />
      <el-table-column prop="stock" width="60" label="库存" />
      <el-table-column label="操作">
        <template slot-scope="scope">
          <!--          编辑-->
          <el-button slot="reference" size="mini" @click="handleEdit(scope.row)">编辑</el-button>
          <!--          删除-->
          <el-button slot="reference" type="danger" size="mini" @click="handleDelete(scope.row)">下架</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-dialog :visible.sync="dialogEditVisible" :title="dialogEditType==='edit'?'编辑商品':'新增商品'">
      <el-form :model="commdity" label-width="80px" label-position="left">
        <el-form-item label="商品名称">
          <el-input v-model="commdity.commodityName" placeholder="商品名称" />
        </el-form-item>
        <el-form-item label="商品分类">
          <el-input v-model="commdity.category" placeholder="商品分类" />
        </el-form-item>
        <el-form-item label="销售时间">
          <el-input v-model="commdity.saleDate" placeholder="销售时间" />
        </el-form-item>
        <el-form-item label="商品地域">
          <el-input v-model="commdity.shipAddress" placeholder="商品地域" />
        </el-form-item>
        <el-form-item label="商品库存">
          <el-input v-model="commdity.stock" placeholder="商品库存" type="number" />
        </el-form-item>
        <el-form-item label="商品描述">
          <el-input
            v-model="commdity.desc"
            :autosize="{ minRows: 2, maxRows: 4}"
            type="textarea"
            placeholder="商品描述"
          />
        </el-form-item>
      </el-form>
      <div style="text-align:right;">
        <el-button type="danger" @click="dialogEditVisible=false">取消</el-button>
        <el-button type="primary" @click="confirmCommodity">确定</el-button>
      </div>
    </el-dialog>

<!--    下架-->
    <el-dialog :visible.sync="dialogDelVisible" :title="dialogDelType==='下架商品' ? '下架商品' : '下架商品'">
      <div>
        这将下架商品，请谨慎操作！
      </div>
      <div style="text-align:right;">
        <el-button type="primary" @click="dialogDelVisible=false">取消</el-button>
        <el-button type="danger" @click="delCommodity">确定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { getAllCommodity, takeDownCommodity, takeUpCommodity, takeUpCommodityList } from '@/api/commodity'

export default {
  name: 'CommodityList',
  created() {
    this.getAllCommodity()
  },
  data() {
    return {
      dialogEditType: 'edit',
      dialogEditVisible: false,
      dialogDelVisible: false,
      dialogDelType: '下架商品',
      search: '',
      allPageNumber: 20,
      form: {
      },
      commdity: {
        id: '',
        commodityName: '',
        category: '',
        saleDate: '',
        takeUpDate: '',
        shipAddress: '',
        desc: '',
        stock: 0
      },
      commodities: [],
      commodityId: 0
    }
  },
  methods: {
    getAllCommodity() {
      getAllCommodity().then(response => {
        this.commodities = response.data
      })
    },
    filterType(value, row, column) {
      return row.type === value
    },
    handleEdit(row) {
      this.commdity = {
        id: row.id,
        commodityName: row.commodityName,
        category: row.category,
        saleDate: row.saleDate,
        takeUpDate: row.takeUpDate,
        shipAddress: row.shipAddress,
        desc: row.desc,
        stock: row.stock
      }
      this.dialogEditType = 'edit'
      this.dialogEditVisible = true
    },
    confirmCommodity() {
      this.dialogEditType = false
      takeUpCommodityList(this.commdity).then(reponse => {
        if (reponse.code === 20000) {
          alert('修改商品信息成功')
          location.reload()
        } else {
          alert('修改商品信息失败')
          location.reload()
        }
      })
    },
    handleDelete(row) {
      this.commdity = {
        id: row.id,
        commodityName: row.commodityName,
        category: row.category,
        saleDate: row.saleDate,
        takeUpDate: row.takeUpDate,
        shipAddress: row.shipAddress,
        desc: row.desc,
        stock: row.stock
      }
      this.commodityId = row.commodityId
      this.dialogDelVisible = true
    },
    delCommodity() {
      this.dialogDelVisible = false
      takeDownCommodity(this.commdity).then(response => {
        if (response.code === 20000) {
          alert('商品下架成功')
        } else {
          alert('商品下架失败')
        }
      })
      // location.reload()
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
