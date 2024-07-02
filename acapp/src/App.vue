<template>
  <div class="game-body">
    <MenuView v-if="$store.state.router.router_name === 'menu'" />
    <PkIndexView v-else-if="$store.state.router.router_name === 'pk'" />
    <RecordIndexView v-else-if="$store.state.router.router_name === 'record'" />
    <RecordContentView v-else-if="$store.state.router.router_name === 'record_content'" />
    <RankListIndexView v-else-if="$store.state.router.router_name === 'rank_list'" />
    <UserBotIndexView v-else-if="$store.state.router.router_name === 'user_bot'" />
  </div>
</template>

<script>
import { useStore } from 'vuex'
import MenuView from "./views/MenuView.vue"
import PkIndexView from './views/pk/PkIndexView.vue'
import RecordIndexView from './views/record/RecordIndexView.vue'
import RecordContentView from './views/record/RecordContentView.vue'
import RankListIndexView from './views/ranklist/RankListIndexView.vue'
import UserBotIndexView from './views/user/bot/UserBotIndexView.vue'
import $ from 'jquery'

export default {
  components: {
    MenuView,
    PkIndexView,
    RecordContentView,
    RecordIndexView,
    RankListIndexView,
    UserBotIndexView
  },
  setup() {
    const store = useStore();

    $.ajax({
      url: "https://app4973.acapp.acwing.com.cn/api/user/account/acwing/acapp/apply_code/",
      type: "get",
      success: resp => {
        if (resp.result === 'success') {
          store.state.user.AcWingOS.api.oauth2.authorize(resp.appid, resp.redirect_uri, resp.scope, resp.state, resp => {
            if (resp.result === 'success') {
              const jwt_token = resp.jwt_token
              if (jwt_token) {
                store.commit("updateToken", jwt_token)
                store.dispatch("getInfo", {
                  success() {
                    store.commit('updatePullingInfo', false)
                  },
                  error() {
                    store.commit('updatePullingInfo', false)
                  }
                })
              }
            } else {
              console.log(resp)
              store.state.user.AcWingOS.api.window.close();
            }
          })

        } else {
          console.log(resp)
          store.state.user.AcWingOS.api.window.close();
        }
      }
    })



  }
}

</script>

<style scoped>
body {
  margin: 0;
}

div.game-body {
  background-image: url("@/assets/images/background.png");
  background-size: cover;
  width: 100%;
  height: 100%;
}

div.window {
  width: 100vw;
  height: 100vh;
}
</style>
