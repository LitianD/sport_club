<template>
  <div class="out_div">
    <el-table
      :data="tableData"
      border
      style="width: 100%">
      <el-table-column
        fixed
        prop="name"
        label="课程名称"
        width="150">
      </el-table-column>
      <el-table-column
        prop="coachName"
        label="教练名称"
        width="150">
      </el-table-column>
      <el-table-column
        prop="gymName"
        label="健身房"
        width="180">
      </el-table-column>
      <el-table-column
        prop="time"
        label="日期"
        width="250">
      </el-table-column>
      <el-table-column
        prop="address"
        label="地址"
        width="400">
      </el-table-column>
      <el-table-column
        fixed="right"
        label="操作"
        width="150">
        <template slot-scope="scope">
          <el-button @click="detail(scope.row)" type="text" size="small">查看</el-button>
          <el-button @click="addCourse(scope.row)" type="text" size="small">预约</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-pagination
      @current-change=currentChange
      :current-page.sync=currentPage
      :page-size="pageSize"
      layout="prev, pager, next, jumper"
      :total=total>>
    </el-pagination>


    <el-dialog
      v-if="dialogVisible"
      title="课程简介"
      :visible.sync="dialogVisible"
      width="70%"
      :before-close="handleClose">
        <div style="padding-left: 30px; padding-right: 30px;padding-bottom: 50px; display: flex; justify-content:space-between">
          <div style="width: 50%; ">

            <div >
              <p style="font-family: 微软雅黑; font-size: 60px; color: #2584ff;">{{detailItem.name}}</p>
              <p>
                <span style="font-family: 微软雅黑; font-size: 25px; color: #2584ff">花费：</span>
                <span style="font-family: 微软雅黑; font-size: 20px; color: #2584ff">￥</span>
                <span style="font-family: 微软雅黑; font-size: 30px; color: #2758ff">{{detailItem.cost}}</span>
              </p>
              <p>
                <span style="font-family: 微软雅黑; font-size: 25px; color: #2584ff">时间：</span>
                <span style="font-family: 微软雅黑; font-size: 30px; color: #2758ff">{{detailItem.time}}</span>
              </p>
              <p style="font-family: 微软雅黑; font-size: 20px; color: #000000; margin-top: 20px">
                {{detailItem.content}}
              </p>
            </div>
            <div style="margin-top: 30px">
              <p style="font-family: 微软雅黑; font-size: 40px; color: #2584ff;">{{detailItem.gym.name}}</p>
              <p>
                <span style="font-family: 微软雅黑; font-size: 25px; color: #2584ff">位于：</span>
                <span style="font-family: 微软雅黑; font-size: 30px; color: #000000; text-overflow: ellipsis;white-space: normal;overflow: hidden;">{{detailItem.gym.address}}</span>
              </p>
            </div>
          </div>

          <div style="width: 45%">
            <p style="margin-top: 70px">
              <span style="font-family: 微软雅黑; font-size: 40px; color: #2758ff; text-overflow: ellipsis;white-space: normal;overflow: hidden;">{{detailItem.coach.name}}</span>
              <span style="font-family: 微软雅黑; font-size: 25px; color: #000000">教练</span>
            </p>
            <p style="margin-top: 10px">
              <span style="font-family: 微软雅黑; font-size: 25px; color: #000000">年龄：</span>
              <span style="font-family: 微软雅黑; font-size: 25px; color: #2758ff; text-overflow: ellipsis;white-space: normal;overflow: hidden;">{{detailItem.coach.age}}</span>
            </p>
            <p style="margin-top: 10px">
              <span style="font-family: 微软雅黑; font-size: 25px; color: #000000">性别：</span>
              <span style="font-family: 微软雅黑; font-size: 25px; color: #2758ff; text-overflow: ellipsis;white-space: normal;overflow: hidden;">{{detailItem.coach.sex}}</span>
            </p>
            <p style="margin-top: 10px">
              <span style="font-family: 微软雅黑; font-size: 25px; color: #000000">电话：</span>
              <span style="font-family: 微软雅黑; font-size: 25px; color: #2758ff; text-overflow: ellipsis;white-space: normal;overflow: hidden;">{{detailItem.coach.phoneNumber}}</span>
            </p>
            <p style="margin-top: 10px">
              <span style="font-family: 微软雅黑; font-size: 25px; color: #000000">邮箱：</span>
              <span style="font-family: 微软雅黑; font-size: 25px; color: #2758ff; text-overflow: ellipsis;white-space: normal;overflow: hidden;">{{detailItem.coach.mail}}</span>
            </p>
            <p style="font-family: 微软雅黑; font-size: 20px; color: #000000; margin-top: 20px">
              {{detailItem.coach.content}}
            </p>
          </div>

        </div>
    </el-dialog>

  </div>
</template>

<script>
  import API from '../../api'
  import Cookie from 'cookie'
  import Cookies from 'js-cookie'
  import axios from 'axios'

  export default {
    name: "courseList",

    data(){
      return{
        total:1,
        pageSize:9,
        currentPage:1,



        tableData: [{
          courseName : 'xxxcourse',
          cost:1000.00,
          courseContent:"这是个课程这是个课程这是个课程这是个课程这是个课程这是个课程这是个课程这是个课程这是个课程这是个课程这是个课程这是个课程",
          coachName : 'xxxcoach',
          coachContent:'他是个教练他是个教练他是个教练他是个教练他是个教练他是个教练他是个教练他是个教练',
          gymName : 'xxxgym',
          time : '201x-xx-xx xx:xx-xx:xx',
          address : '北京交通大学主校区南门',
          sex: "男",
          phone:123456789,
          email:"xxx@xxx.xom",
          age: 22,

        },],

        detailItem:{},
        dialogVisible:false,
        username:Cookies.get('username'),
      }
    },

    mounted:function(){
      this.getCourseList();
    },

    methods:{
      currentChange(val){
        this.currentPage = val;
        this.getCourseList();
      },
      detail(item){

        let url = 'http://106.15.200.225:80/course/show/' + item.id

        let config = {
          url: url,
          method: 'get',
          data: {},
          headers: {
          }
        }
        axios(config).then(res=>{
          console.log(res)
          if (res.data.code) {
            alert(res.error_msg);
          }

          this.detailItem = res.data.data;
          console.log(this.detailItem)
          this.dialogVisible = true;
        })

      },

      addCourse(item){
        let data={
          id:item.id,
          username: this.username,
        }

        API.addCourse(data).then(res=>{
          console.log(res)
          if (res.code) {
            alert(res.data.error_msg);
            return;
          }

          alert('预约课程成功！')
        })

      },

      getCourseList(){
        let page = this.currentPage - 1;
        let url = 'http://106.15.200.225:80/course/list/' + page + '/' + this.pageSize

        let config = {
          url: url,
          method: 'get',
          data: {},
          headers: {
          }
        }
        axios(config).then(res=>{
          console.log(res)
          if (res.data.code) {
            alert(res.error_msg);
          }

          this.tableData = res.data.data.courseList;
          this.total = res.data.data.total;
        })

      }


    }

  }
</script>

<style scoped>
  .out_div{
    width: 100%;
    background-color: white;
    padding: 30px;
  }
</style>
