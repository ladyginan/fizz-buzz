<template>
  <v-app>
    <v-toolbar color = "#4A76A8" app>
      <v-toolbar-title class="headline text-uppercase">
        <span>Fizz Buzz</span>
        <span class="font-weight-light"></span>
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn
        flat
        href="https://en.wikipedia.org/wiki/Fizz_buzz"
        target="_blank"
      >
        <span class="mr-2">The Rules</span>
      </v-btn>
    </v-toolbar>

    <v-content>
      <Game/>
    </v-content>
  </v-app>
</template>

<script>
import Game from './components/Game'

export default {
  name: 'App',
  components: {
    Game
  },
  data () {
    return {
      //
    }
  }
}
</script>
