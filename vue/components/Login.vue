<template>
  <div class="loginWrapper">
    <div class="back-ground">
      <img src="../assets/image/6.jpg">
    </div>
    <div class="bd">
      <el-form :model="loginForm" :rules="loginRule" ref="loginForm" :label-position="labelPosition">
        <el-form-item  prop="userName" class="login-item">
          <el-input type="userName" v-model="loginForm.userName" placeholder="账号" @keyup.enter.native="submitForm('loginForm')"></el-input>
        </el-form-item>
        <el-form-item prop="pwd" style="margin-bottom: 0px">
          <el-input v-model="loginForm.pwd" placeholder="密码" type="password" @keyup.enter.native="submitForm('loginForm')"></el-input>
        </el-form-item>
        <el-form-item style="height: 30px;margin-top: 0px;margin-bottom: 10px">
        <el-button type="text" @click="dialogRegister = true" style="float: right;color:#ffffff;font-weight:bold">注册账号</el-button>
          <el-button type="text" @click="dialogForget = true" style="float: left;color: #ffffff;font-weight:bold">忘记密码</el-button>
        </el-form-item>
        <el-form-item>
          <el-button  style="background-color: #409eff" type="primary" @click="login" class="submitBtn" round >登录</el-button>
        </el-form-item>
      </el-form>
    </div>

    <el-dialog
      title="注册"
      :visible.sync="dialogRegister"
      :before-close="handleClose">

      <el-form :model="registerForm" ref="registerForm" label-width="80px" >
        <el-form-item label="用户名" prop="userName" class="login-item">
          <el-input v-model="registerForm.username"  placeholder="请输入您的用户名" @keyup.enter.native="registerform('registerForm')"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password" >
          <el-input v-model="registerForm.password" placeholder="请输入您的账号密码" type="password" @keyup.enter.native="registerform('registerForm')"></el-input>
        </el-form-item>
        <el-form-item label="确认密码" prop="passwordConfirm" >
          <el-input v-model="registerForm.passwordConfirm" placeholder="请再次输入密码确认" type="password" @keyup.enter.native="registerform('registerForm')"></el-input>
        </el-form-item>
        <el-form-item label="姓名" prop="name" class="login-item">
          <el-input v-model="registerForm.name"  placeholder="请输入您的真实姓名" @keyup.enter.native="registerform('registerForm')"></el-input>
        </el-form-item>
        <el-form-item label="邮箱" prop="email" >
          <el-input v-model="registerForm.email" placeholder="邮箱作为找回密码的唯一途径，请输入常用邮箱，便于密码找回"  @keyup.enter.native="registerform('registerForm')"></el-input>
        </el-form-item>
        <el-form-item label="电话" prop="phone" >
          <el-input v-model="registerForm.phone" placeholder="请输入电话"  @keyup.enter.native="registerform('registerForm')"></el-input>
        </el-form-item>
        <el-form-item label="年龄" prop="age" >
          <el-input v-model="registerForm.age" placeholder="邮箱作为找回密码的唯一途径，请输入常用邮箱，便于密码找回"  @keyup.enter.native="registerform('registerForm')"></el-input>
        </el-form-item>
        <el-form-item label="性别" prop="sex" >
          <el-select v-model="registerForm.sex" placeholder="请选择" @keyup.enter.native="registerform('registerForm')">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
    <el-button @click="dialogRegister = false">取 消</el-button>
    <el-button type="primary" @click="registerform">注 册</el-button>
  </span>
    </el-dialog>

    <el-dialog
      title="找回密码"
      :visible.sync="dialogForget">
      <el-form :model="findPwForm" :rules="findPwRule" ref="findPwForm" label-width="80px" >
        <el-form-item label="用户名" prop="jobNumber" class="login-item">
          <el-input v-model="findPwForm.jobNumber"  placeholder="账号" @keyup.enter.native="findpwform('findPwForm')"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
    <el-button @click="dialogForget = false">取 消</el-button>
    <el-button type="primary" @click="findpwform('findPwForm')">确 定</el-button>
  </span>
    </el-dialog>
  </div>
</template>
<script type="text/javascript">
  import API from '../api'
  import Cookie from 'cookie'
  import Cookies from 'js-cookie'
  export default {
    name: 'Login',
    data () {
      return {
        loadingLogin: false,
        dialogForget:false,
        labelPosition: 'left',
        dialogRegister: false,
        jobNumber:'',
        userId:'',
        role:'',
        loginForm: {
          userName: '',
          pwd: ''
        },
        loginRule: {
          userName: [
            { required: true, message: '请输入用户名', trigger: 'blur' }
            // { min: 3, max: 10, message: '长度在 3 到 16 个字符', trigger: 'blur' }
          ],
          pwd: [
            { required: true, message: '请输入密码', trigger: 'blur' }
            // { min: 3, max: 20, message: '长度在 3 到 20 个字符', trigger: 'blur' }
          ]
        },
        registerForm:{
          username: '',
          password: '',
          passwordConfirm: '',
          name: '',
          email: '',
          phone: '',
          age: '',
          sex:'',
        },

        options: [{
          value: '0',
          label: '男'
        }, {
          value: '1',
          label: '女'
        },],

        findPwForm: {
          jobNumber: ''
        },
        findPwRule: {
          jobNumber: [
            { required: true, message: '请输入用户名', trigger: 'blur' }
            // { min: 3, max: 10, message: '长度在 3 到 16 个字符', trigger: 'blur' }
          ]
        },
      }
    },
    head () {
      return {
        title: '仓库管理系统',
        meta: [
          {hid: 'description', name: 'viewport', content: 'width=device-width, initial-scale=1.0, user-scalable=no'}
        ]
      }
    },
    methods: {

      async submitForm (loginForm) {

        this.$router.push({path: `/nonfinalContractsPage`})

        /*let result = await this.$store.dispatch('login', {
          action:'login',
          username:this.loginForm.userName,
          password:this.loginForm.pwd,
        })
        if (result !== 0) {
          if (result === 100310) {
            this.loadingLogin = false
            alert('密码／用户名不能为空')
            console.log('密码／用户名不能为空')
            return
          } else if (result === 300101) {
            this.loadingLogin = false
            console.log('密码不正确')
            return
          } else if (result === 300100) {
            console.log(result)
            this.loadingLogin = false
            alert('用户名不存在！')
            return
          }
        }
        this.$router.push({path: `/nonfinalContractsPage`})*/
      },
      login() {

        //this.$router.push({path: `/mainPage/mainPage`})

        let data={
          action:'login',
          username:this.loginForm.userName,
          password:this.loginForm.pwd,
        }
        API.login(data).then(res=>{
          if(res.code){
              alert(res.error_msg);
              return res;
            }

          Cookies.set('username', res.username);
          Cookies.set('age', res.age);
          Cookies.set('name', res.name);
          Cookies.set('phonenumber', res.phonenumber);
          Cookies.set('sex', res.sex);
          Cookies.set('mail', res.mail);
          this.$router.push({path: `/mainPage/mainPage`})
        })
      },

      handleClose(done) {
        this.$confirm('确认关闭？')
          .then(_ => {
            done();
          })
          .catch(_ => {});
      },
      registerform(){

          let data = {
          username:this.registerForm.username,
          password:this.registerForm.password,
          repasswordd:this.registerForm.passwordConfirm,
          name:this.registerForm.name,
          mail:this.registerForm.email,
          phonenumber:this.registerForm.phone,
          age:this.registerForm.age,
          sex:this.registerForm.sex,
          }

          API.register(data).then(res => {
            if(res.code){
              alert(res.error_msg);
              return res;
            }

            alert('注册成功!')

          }).catch(msg => {
            alert('操作失败')
          })

      },
      findpwform(findPwForm){

          let data = {
            action:'findcode',
            userName: this.findPwForm.jobNumber,
          }
          alert('请查收邮箱')
          API.actionApi(data).then(res => {

            return res
          }).catch(msg => {
            alert('操作失败')
          })


      }
    }
  }
</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .back-ground{
    position: absolute;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
    overflow-x: hidden;
    overflow-y: hidden;
  }
  .back-ground>img{
    width: 100%;
    height: 100%;
  }

  .bd{
    width: 20%;
    margin-left: 40%;
    margin-top: 18rem;
  }
  .submitBtn{
    width: 100%;
  }

  .login-icon {
    top: 10%;
    width: 40%;
    margin-left: 30%;
    position: absolute;
  }
  .login-title {
    position: absolute;
    top: 37%;
    width: 40%;
    text-align: center;
    margin-left: 30%;
  }
  .login-title p {
    color: #b0e36f;
    font-face: "微软雅黑";
    font-weight: bold;
    font-size: 1.5rem;
  }
  .login-icon img {
    width: 100%;
  }
  .beian {
    position: absolute;
    bottom: 1rem;
    width: 100%;
    text-align: center;
  }

  .beian p {
    width: 100%;
    text-align: center;
  }

</style>
