<template>
  <div id="app">
    <SeatingChart />
  </div>
</template>

<script>
import SeatingChart from './components/SeatingChart.vue';

export default {
  name: 'App',
  components: {
    SeatingChart
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
