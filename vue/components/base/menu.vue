<template>
  <div style="align-items: center; background-color: #25567b;padding-right: 0;height: 1500px;">
      <!--<div style="height: 150px; padding-top: 30px;  width: 100% ;align-items: center;border-right: solid 1px #e6e6e6;" >
       &lt;!&ndash; <div class="pic" style="background-color: #545c64; display: inline-block">
          <img src="../assets/image/pic.jpg">
        </div>&ndash;&gt;
        <div style="text-align:center; padding-top: 15px; margin-left: 5px;">
          <p style="font-family: '黑体';font-size: 30px;color: #033e6b">{{name}}</p>
          <p style="font-family: '黑体';font-size: 25px;color: #ffffff; margin-top: 10px">欢迎您</p>
        </div>
      </div>-->
      <el-menu
        :default-active="activeIndex"
        class="el-menu-vertical-demo"
        @open="handleOpen"
        @close="handleClose"
        background-color="#25567b"
        text-color="#ffffff"
        active-text-color="#A4D3EE"
        style="text-align: left"
      >

        <el-menu-item class="items" index="1" @click="clickButton('1')">主页</el-menu-item>
        <el-menu-item class="items" index="2" @click="clickButton('2')">课程列表</el-menu-item>
        <!--<el-menu-item class="items" index="10" @click="clickButton('10')">个人中心</el-menu-item>-->
        <el-menu-item class="items" index="11" @click="logout">退出</el-menu-item>


      </el-menu>

    <el-dialog
      title="温馨提示"
      :visible.sync="centerDialogVisible"
      width="30%"
      center>
      <span>页面正在开发，敬请期待</span>
      <span slot="footer" class="dialog-footer">
    <el-button type="primary" @click="centerDialogVisible = false" style="background-color: #033e6b">确 定</el-button>
  </span>
    </el-dialog>
  </div>
</template>

<script>
  import Cookies from 'js-cookie'
    export default {
        name: "menu",
      props:{
        pageIndex: {
          type: String
        },
        userId:{
          type: String
        }
      },
      data () {
        return {
          activeIndex: "1",
          name:'',
          centerDialogVisible:false,
          isShow:false,
        }
      },
      mounted:function () {
        this.activeIndex = this.pageIndex;
        if(this.role === '1') this.isShow = true;
        console.log('menu'+this.userId);
      },
      methods: {
        handleOpen(key, keyPath) {
          console.log(key, keyPath);
        },
        handleClose(key, keyPath) {
          console.log(key, keyPath);
        },

        showIndexPage(){
          this.$router.push({path: `/mainPage/mainPage`})
        },

        clickButton(pageIndex){

          let titleMsg = '';
          let comName = '';
          if(pageIndex === '1'){
            /*titleMsg = '主页'
            comName = 'mainPageMsg'*/
            titleMsg = '主页'
            comName = 'personCenter'
          }else if(pageIndex === '2'){
            titleMsg = '课程列表'
            comName = 'courseList'
          }else if(pageIndex === '10'){
            titleMsg = '个人中心'
            comName = 'personCenter'
          }else if(pageIndex === '11'){
            titleMsg = ''
          }

          this.$emit('menuClick', {pageIndex:pageIndex, titleMsg:titleMsg, comName : comName})
        },

        logout(){
          this.$router.push({path: `/`})
        },
        showdialog(){
          this.centerDialogVisible = true
        }
      }
    }
</script>

<style scoped>
  .spans{
    margin-left: 10px;
    font-family: 微软雅黑;
    font-size: 20px;
  }

  .items{
    margin-left: 50px;
    font-family: 微软雅黑;
    font-size: 15px;

    transition:all 1s; /*过渡*/
  }
  .items:hover{
    font-size: 20px;
  }

  .el-menu-vertical-demo{
    text-align:center;
    height: 1000px;
    width: 100%;
  }

  .menuclick {
    background-color: #4ba3a5;
  }

  .pic{
    width: 80px;
    height: 80px;
  }
  .pic img{
    width: 100%;
    border-radius: 80%;
  }
</style>
