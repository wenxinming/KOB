<template>
    <ContentField>我的Bot</ContentField>
</template>

<script>
import ContentField from '@/components/ContentField.vue'
import $ from 'jquery'
import { useStore } from 'vuex';

export default {
    components: {
        ContentField
    },
    setup() {
        // const store = useStore();
        // $.ajax({
        //     url: "http://localhost:3000/user/bot/add/",
        //     type: "post",
        //     data: {
        //         title: "Bot的标题",
        //         description: "Bot的描述",
        //         content: "Bot的代码"

        //     },
        //     headers: {
        //         Authorization: "Bearer " + store.state.user.token,
        //     },
        //     success(resp) {
        //         console.log(resp)
        //     },
        //     error(resp) {
        //         console.log(resp)
        //     }
        // })


        // const store = useStore();
        // $.ajax({
        //     url: "http://localhost:3000/user/bot/remove/",
        //     type: "post",
        //     data: {
        //        bot_id:4

        //     },
        //     headers: {
        //         Authorization: "Bearer " + store.state.user.token,
        //     },
        //     success(resp) {
        //         console.log(resp)
        //     },
        //     error(resp) {
        //         console.log(resp)
        //     }
        // })

        // const store = useStore();
        // $.ajax({
        //     url: "http://localhost:3000/user/bot/update/",
        //     type: "post",
        //     data: {
        //         bot_id:12,
        //         title: "修改后Bot的标题",
        //         description: "修改后Bot的描述",
        //         content: "修改后Bot的代码"
        //     },
        //     headers: {
        //         Authorization: "Bearer " + store.state.user.token,
        //     },
        //     success(resp) {
        //         console.log(resp)
        //     },
        //     error(resp) {
        //         console.log(resp)
        //     }
        // })

        const store = useStore();
        $.ajax({
            url: "http://localhost:3000/user/bot/getlist/",
            type: "get",
            headers: {
                Authorization: "Bearer " + store.state.user.token,
            },
            success(resp) {
                console.log(resp)
            },
            error(resp) {
                console.log(resp)
            }
        })
    }
}
</script>

<style scoped></style>