module.exports = {
  devServer: {
    proxy: {
      // api라는 주소로 시작하면 아래의 target 주소로 우회
      '/api' :{
        target : process.env.VUE_APP_API_URL
      }
    }
  }
}
