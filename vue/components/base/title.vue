<template >
  <div id="out_div">
    <!--<img class="el-icon-success in_line" src="../../assets/image/sport.png" style="height:50px;margin-left: 40px;display: table-cell;vertical-align: center">-->
    <p>健 身 俱 乐 部</p>
  </div>
</template>

<script>
  export default {
      name: "title"
  }
</script>

<style scoped>

  @keyframes change{
    0%{
      background: linear-gradient(to right, #4ad6ff, #2584ff, #2758ff);
    }
    50%{
      background: linear-gradient(to right, #2584ff, #2758ff, #4ad6ff);
    }
    100%{
      background: linear-gradient(to right, #2758ff, #4ad6ff, #2584ff);
    }
  }

  #out_div{
    width: 100%;
    height: 70px;
    background-color: #033e6b;

    display: flex;
    flex-direction: row;

    /*animation: change 1s infinite alternate ease-in-out;*/

  }




  p{
    position: absolute;
    left: 80px;
    color: #ffffff;
    top: 5px;
    font-size: 40px;
  }

  p::before{
    content: ' ';
    display: block;
    position: absolute;
    width: 40px;
    height: 40px;
    background-size: contain;
    top: 10px;
    left: -40px;
    background-image: url('../../assets/image/sport.png');
  }


</style>
