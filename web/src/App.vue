<template>
  <div>
    <div>bot name:{{bot_name}}</div>
    <div>bot age:{{bot_age}}</div>
  </div>
  <router-view/>
</template>

<script>
import $ from 'jquery'
import { ref } from 'vue';

export default{
  name:'App',
  setup: ()=>{
    let bot_name = ref("")
    let bot_age = ref("")

    $.ajax({
      url:"http://127.0.0.1:3000/pk/getbotinfo/",
      type:"get",
      success:resp => {
        bot_name.value = resp.name;
        bot_age.value = resp.age;
      }
    })

    return {
      bot_age,
      bot_name
    }

  }
}

</script>

<style>
body{
  background-image: url("@/assets/background.png");
  background-size: cover;
}
</style>
