<template>
  <div id = "app">
    <h1>Film list</h1>
    <FilmList :films="films" />
  </div>
</template>

<script>
import Filmlist from './components/FilmList.vue'
import axios from "axios"
export default {
  
  components: {
    Filmlist,
  },
  data(){
    return{
      films : [],
      loading: false,
      error: null,
    }
  },
  methods: {    
    async fetchFilms() {
      try {
        this.error = null
        this.loading = true
        const url = `http://localhost:8090/api/films`
        const response = await axios.get(url) 
        this.films = response.data      
        
      } catch (err) {       
        console.log(err)
      }
      this.loading = false
    },
  },
  mounted() {
    this.fetchFilms()
  },
}
</script>

<style>
#app {
  font-family: "SF Mono", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: left;
  color: #2c3e50;
  margin-top: 20px;
}
</style>
