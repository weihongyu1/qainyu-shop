<template>
  <div>
    <div style="margin-bottom:15px;">
      <span v-if="roles === 'admin'">您的角色: 管理员</span>
      <span v-if="roles === 'editor'">您的角色: 编辑</span>
    </div>
    转变角色:
    <el-radio-group v-model="switchRoles">
      <el-radio-button label="编辑" />
      <el-radio-button label="管理员" />
    </el-radio-group>
  </div>
</template>

<script>
export default {
  computed: {
    roles() {
      return this.$store.getters.roles
    },
    switchRoles: {
      get() {
        return this.roles[0]
      },
      set(val) {
        this.$store.dispatch('user/changeRoles', val).then(() => {
          this.$emit('change')
        })
      }
    }
  }
}
</script>
