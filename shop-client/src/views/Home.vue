<template>
  <div class="common-layout">
    <el-container>

      <!-- 头部导航 -->
      <el-header>
        <Header></Header>
      </el-header>
      <div style="clear: both"></div>

      <!-- 主体部分 -->
      <el-main>Main</el-main>

      <!-- 底部链接 -->
      <el-footer>Footer</el-footer>
    </el-container>
  </div>
</template>

<script>
// @ is an alias to /src

import Header from "../components/Header";
export default {
  name: 'Home',
  components: {Header}
}
</script>
