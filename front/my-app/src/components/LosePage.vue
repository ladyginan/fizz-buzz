<template>
        <div> Sorry. You are lose. Try again.
            <v-btn color="success" @click="startGame">Success</v-btn>
        </div>
</template>
<script>
    export default {
        data: () => ({

        }),

        methods: {
           startGame(){
               this.$router.push("Home");
           }

        }
    }
</script>