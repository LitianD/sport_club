<template>
  <div class="outDiv">
    <div class="block1">
      <p style="
      font-family: 微软雅黑;
      font-size: 60px;
      background-image:-webkit-linear-gradient(right,#2584ff,#1012cd);
      -webkit-background-clip:text;
      -webkit-text-fill-color:transparent;">{{detailItem.name}}</p>
      <p style="margin-top: 10px">
        <span style="font-family: 微软雅黑; font-size: 25px; color: #000000">年龄：</span>
        <span style="font-family: 微软雅黑; font-size: 25px; color: #2758ff; text-overflow: ellipsis;white-space: normal;overflow: hidden;">{{detailItem.age}}</span>
      </p>
      <p style="margin-top: 10px">
        <span style="font-family: 微软雅黑; font-size: 25px; color: #000000">性别：</span>
        <span style="font-family: 微软雅黑; font-size: 25px; color: #2758ff; text-overflow: ellipsis;white-space: normal;overflow: hidden;">{{detailItem.sex}}</span>
      </p>
      <p style="margin-top: 10px">
        <span style="font-family: 微软雅黑; font-size: 25px; color: #000000">电话：</span>
        <span style="font-family: 微软雅黑; font-size: 25px; color: #2758ff; text-overflow: ellipsis;white-space: normal;overflow: hidden;">{{detailItem.phone}}</span>
      </p>
      <p style="margin-top: 10px">
        <span style="font-family: 微软雅黑; font-size: 25px; color: #000000">邮箱：</span>
        <span style="font-family: 微软雅黑; font-size: 25px; color: #2758ff; text-overflow: ellipsis;white-space: normal;overflow: hidden;">{{detailItem.email}}</span>
      </p>
      <p style="font-family: 微软雅黑; font-size: 20px; color: #000000; margin-top: 20px">
        {{detailItem.coachContent}}
      </p>
    </div>

    <div class="block2">
      <el-table
        :data="tableData"
        style="width: 100%">
        <el-table-column
          prop="time"
          label="日期"
          width="150">
        </el-table-column>
        <el-table-column
          prop="name"
          label="课程名称"
          width="120">
        </el-table-column>
        <el-table-column
          prop="address"
          label="地址">
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
  import API from '../../api'
  import Cookies from 'js-cookie'

  export default {
    name: "personCenter",

    data(){
      return{
        detailItem:{
          name:Cookies.get('name'),
          sex: (Cookies.get('sex') === '1')?"男":"女",
          phone:Cookies.get('phonenumber'),
          email:Cookies.get('mail'),
          age: Cookies.get('age'),
        },
        tableData:[],

        username:Cookies.get('username'),
      }
    },

    mounted:function () {
      this.getUserCourse();
    },

    methods:{
      getUserCourse(){

        let data={
          username:this.username
        };

        API.getUserCourses(data).then(res=>{
          if(res.code){
            alert(res.error_msg)
          }

          this.tableData = res.courseList;
        })

      },
    }

  }
</script>

<style scoped>

  .outDiv {
    display: flex;
  }
  .block1{
    background-color: #ffffff;
    padding: 40px 40px 40px 80px;
    display: flex;
    flex-direction: column;
    align-items:start;
  }
  .block2{
    background-color: #ffffff;
    padding: 40px 40px 40px 80px;
  }

  .outDiv {
    flex-direction: column;
  }
  .block1{
    width: 100%;
  }
  .block2{
    width: 100%;
    margin-top: 20px;
  }

  @media(min-device-width: 900px) and (min-width:900px){
    .outDiv{
      flex-direction: row;
    }
    .block1{
      width: 40%
    }
    .block2{
      margin-top: 0;
      margin-left: 5%;
      width: 55%
    }
  }


</style>
