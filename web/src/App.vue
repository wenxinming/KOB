<template>
  <nav-bar/>
  <router-view/>
</template>

<script>
import NavBar from '@/components/NavBar.vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap'
import $ from 'jquery'

export default{
  components:{
    NavBar
  },
  setup() {
    // $.ajax({
    //   url:"http://localhost:3000/user/account/token/",
    //   type:'post',
    //   data:{
    //     username:"bb",
    //     password:"pbb",
    //   },
    //   success(resp){
    //     console.log(resp)
    //   },
    //   error(resp){
    //     console.log(resp)
    //   }
    // })


    $.ajax({
      url:"http://localhost:3000/user/account/info/",
      type:"get",
      headers:{
        Authorization:"Bearer " + "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJhYTM4ZmFhZjkyMTM0MGZiODQyNDcyN2ZiYzlmNDRlZCIsInN1YiI6IjIiLCJpc3MiOiJzZyIsImlhdCI6MTcxNTE1OTM3OCwiZXhwIjoxNzE2MzY4OTc4fQ.6Tf8FeAdpmogtVbDWIgq8ELL900Z_T6DYRdvxn92_34",

      },
      success(resp) {
        console.log(resp)
      },
      error(resp){
        console.log(resp)
      }
    })

  //   $.ajax({
  //     url:"http://localhost:3000/user/account/register/",
  //     type:"post",
  //     data:{
  //       username:"ds",
  //       password:"pdd1",
  //       confirmedPassword:"pdd",
  //     },
  //     success(resp){
  //       console.log(resp)
  //     },
  //     error(resp){
  //       console.log(resp)
  //     }
  //   })
  }
}

</script>

<style>
body{
  background-image: url("@/assets/images/background.png");
  background-size: cover;
}
</style>
