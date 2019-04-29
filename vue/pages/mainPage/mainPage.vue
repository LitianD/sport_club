<template style="overflow-y: hidden">
  <div style="overflow-y: hidden">
    <cliTitle style="position: fixed; z-index: 100"></cliTitle>
    <div style="position:fixed; width: 15%;height: 2000px;margin-top: 70px;">
      <cliMenu @menuClick="menuClick" :pageIndex="pageIndex"></cliMenu>
    </div>

    <div style="margin-left:15%; margin-top: 70px; width: 85%; height: 800px; background-color: #f4f4f4; padding-left: 2.5%; padding-right: 2.5%; overflow-y: hidden">
      <!--分界线-->
      <div class="titleLine" >
        <p style="color: #ffffff; font-family: 微软雅黑; font-size: 20px; padding: 5px 10px; letter-spacing: 6px">{{titleMsg}}</p>
      </div>

      <component class="componentStyle" :is="componentName"></component>


    </div>
  </div>
</template>

<script>
  import cliMenu from '~/components/base/menu.vue'
  import cliTitle from '~/components/base/title.vue'
  import courseList from '~/components/coursePage/courseList.vue'
  import mainPageMsg from '~/components/mainPage/mainPageMsg.vue'
  import personCenter from '~/components/personCenterPage/personCenter.vue'
  import API from '../../api'
  import Cookies from 'js-cookie'
  import PRO from '../../api/API_PRO.js'

  export default {
    name: "mainPage",

    components:{cliMenu, cliTitle, courseList, mainPageMsg, personCenter},

    data(){
      return{
        pageIndex:'1',
        titleMsg:'主页',

        componentName:'personCenter',
      }
    },

    mounted:function(){

      console.log(a);

      var a = 2;

    },

    methods:{
      menuClick(response){
        this.pageIndex = response.pageIndex;
        this.titleMsg = response.titleMsg;
        this.componentName = response.comName;
      },


    }


  }
</script>

<style scoped>
  .titleLine{
    background: linear-gradient(to right, #2584ff, #2758ff, #4ad6ff);
    margin-top: 20px;

    /*transition:all 1s*/
  }

  /*.titleLine:hover{
    background: linear-gradient(to right, #2758ff, #4ad6ff, #2584ff);
  }*/

  .componentStyle{
    margin-top: 20px;
  }

</style>
