<template>
  <div style="width: 99%;margin: 1rem">
    <el-button type="primary" style="float: left" size="small" @click="handleAddUser">新增</el-button>
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
      <el-table-column prop="userId" label="用户ID" width="80" />
      <el-table-column prop="username" label="用户名" />
      <el-table-column prop="date" label="账号创建日期" sortable />
      <el-table-column prop="address" label="默认地址" :show-overflow-tooltip="true" />
      <el-table-column prop="phoneNumber" label="电话" />
      <el-table-column prop="role" label="角色" width="80" />

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
            :type="scope.row.loginStatus === '已登录' ? 'success' : 'primary'"
            disable-transitions
          >{{ scope.row.loginStatus }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column prop="introduction" label="个人介绍" :show-overflow-tooltip="true" />

      <el-table-column label="操作">
        <template slot-scope="scope">
          <!--          编辑-->
          <el-button slot="reference" size="mini" @click="handleEditUser(scope.row)">编辑</el-button>

          <!--          删除-->
          <el-button slot="reference" type="danger" size="mini" @click="handleDelUser(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-dialog :visible.sync="dialogEditVisible" :title="dialogEditType==='edit'?'编辑用户':'新增用户'">
      <el-form :model="user" label-width="80px" label-position="left">
        <el-form-item label="用户名">
          <el-input v-model="user.username" placeholder="用户名" />
        </el-form-item>
        <el-form-item label="默认地址">
          <el-input v-model="user.address" placeholder="默认地址" />
        </el-form-item>
        <el-form-item label="电话">
          <el-input v-model="user.phoneNumber" placeholder="电话" />
        </el-form-item>
        <el-form-item label="角色">
          <el-input v-model="user.role" placeholder="角色" />
        </el-form-item>
        <el-form-item label="介绍">
          <el-input
            v-model="user.introduction"
            :autosize="{ minRows: 2, maxRows: 4}"
            type="textarea"
            placeholder="备注"
          />
        </el-form-item>
      </el-form>
      <div style="text-align:right;">
        <el-button type="danger" @click="dialogEditVisible=false">取消</el-button>
        <el-button type="primary" @click="confirmUser">确定</el-button>
      </div>
    </el-dialog>

    <el-dialog :visible.sync="dialogDelVisible" :title="dialogDelType==='del' ? '删除订单' : '删除订单'">
      <div>
        这将删除用户的所有信息，请谨慎操作！
      </div>
      <div style="text-align:right;">
        <el-button type="primary" @click="dialogDelVisible=false">取消</el-button>
        <el-button type="danger" @click="delUser()">确定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { delUser, editUser, getAllUser } from '@/api/user'

export default {
  name: 'UserPage',
  data() {
    return {
      dialogEditVisible: false,
      dialogEditType: 'new',
      dialogDelVisible: false,
      dialogDelType: 'del',
      search: '',
      allPageNumber: 20,
      form: {
        username: '',
        address: '',
        phoneNumber: '',
        role: ''
      },
      user: {
        userId: '3180604023',
        username: 'why',
        date: '2022-06-04',
        address: '江苏省镇江市京口区学府路301号',
        phoneNumber: '15337086013',
        loginStatus: '未登录',
        role: 'admin',
        introduction: ''
      },
      users: []
    }
  },
  created() {
    this.getAllUser()
  },
  methods: {
    filterPamentStaus(value, row, column) {
      return row.paymentStatus === value
    },
    handleAddUser() {
      this.dialogEditType = 'new'
      this.user = {}
      this.dialogEditVisible = true
    },
    handleEditUser(row) {
      this.user = {
        userId: row.userId,
        username: row.username,
        date: row.date,
        address: row.address,
        phoneNumber: row.phoneNumber,
        loginStatus: row.loginStatus,
        role: row.role,
        introduction: row.introduction
      }
      this.dialogEditVisible = true
      this.dialogEditType = 'edit'
    },
    handleDelUser(row) {
      this.user = {
        userId: row.userId,
        username: row.username,
        date: row.date,
        address: row.address,
        phoneNumber: row.phoneNumber,
        loginStatus: row.loginStatus,
        role: row.role,
        introduction: row.introduction
      }
      this.dialogDelVisible = true
      this.dialogDelType = 'del'
    },
    getAllUser() {
      getAllUser().then(response => {
        this.users = response.data
      })
    },
    confirmOrder() {
      this.dialogEditVisible = false
      editUser(this.user).then(response => {
        alert(response.msg)
        location.reload()
      })
    },
    delUser() {
      this.dialogDelVisible = false
      delUser(this.user.userId).then(resopnse => {
        if (resopnse.code === 20000) {
          alert(resopnse.msg)
        } else {
          alert('删除用户失败')
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
