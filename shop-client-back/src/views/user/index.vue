<template>
  <div>
    <div v-permission="['editor']">只有管理员才能查看</div>
    <UserPage v-permission="['admin']" />
  </div>
</template>

<script>
import UserPage from './components/UserPage'
export default {
  name: 'AccountPage',
  components: { UserPage }
}
</script>

<style scoped>

</style>
