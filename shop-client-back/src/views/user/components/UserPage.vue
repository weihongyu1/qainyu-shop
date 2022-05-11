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
      :data="users"
      border
      :default-sort="{prop: 'date', order: 'descending'}"
      style="margin-top: 10px"
      highlight-current-row
    >
      <!--    选中行-->
      <el-table-column type="selection" width="55" />
      <el-table-column prop="userId" label="用户ID" />
      <el-table-column prop="username" label="用户名" />
      <el-table-column prop="date" label="账号创建日期" sortable />
      <el-table-column prop="address" label="默认地址" :show-overflow-tooltip="true" />
      <el-table-column prop="phoneNumber" label="电话" />
      <el-table-column prop="role" label="角色" />

      <el-table-column
        prop="loginStatus"
        label="登录状态"
        :filters="[{text: '已登录', value: '已登录'}, {text: '未登录', value: '未登录'}]"
        :filter-method="filterPamentStaus"
        filter-placement="bottom-end"
        width="100px"
      >
        <template slot-scope="scope">
          <el-tag
            :type="scope.row.loginStatus === 1 ? 'success' : 'primary'"
            disable-transitions
          >{{ scope.row.loginStatus }}</el-tag>
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
              <el-form-item label="用户名">
                <el-input v-model="form.username" />
              </el-form-item>
              <el-form-item label="默认地址">
                <el-input v-model="form.address" />
              </el-form-item>
              <el-form-item label="电话">
                <el-input v-model="form.phoneNumber" />
              </el-form-item>
              <el-form-item label="角色">
                <el-input v-model="form.role" />
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
  name: 'UserPage',
  data() {
    return {
      search: '',
      allPageNumber: 20,
      form: {
        username: '',
        address: '',
        phoneNumber: '',
        role: ''
      },
      users: [{
        userId: '3180604023',
        username: 'why',
        date: '2022-06-04',
        address: '江苏省镇江市京口区学府路301号',
        phoneNumber: '15337086013',
        loginStatus: '未登录',
        role: 'admin'
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
