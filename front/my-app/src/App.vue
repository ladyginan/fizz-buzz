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
      <HelloWorld/>
    </v-content>
  </v-app>
</template>

<script>
import HelloWorld from './components/HelloWorld'

export default {
  name: 'App',
  components: {
    HelloWorld
  },
  data () {
    return {
      //
    }
  }
}
</script>
