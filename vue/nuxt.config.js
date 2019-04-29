const webpack = require('webpack')
module.exports = {
  /*
  ** Headers of the page
  */
  head: {
    title: '本科生教育管理质量提升项目综合服务系统',
    meta: [
      { charset: 'utf-8' },
      { name: 'viewport', content: 'width=device-width, initial-scale=1' },
      { hid: 'description', name: 'description', content: 'Nuxt.js project' }
    ],
    link: [
      { rel: 'icon', type: 'image/x-icon', href: '/favicon.ico' }
    ]
  },
  /*
  ** Customize the progress bar color
  */
  loading: { color: '#3B8070' },
  /*
  ** Build configuration
  */
  build: {
    vendor: ['axios', 'element-ui'],
    babel: {
      'plugins': [['component', [
        {
          'libraryName': 'element-ui',
          'styleLibraryName': 'theme-chalk'
        },
        'transform-async-to-generator',
        'transform-runtime'
      ]]],
      comments: true
    },
    /*
    ** Run ESLint on save
    */
    extend (config, { isDev, isClient }) {
      if (isDev && isClient) {
        config.module.rules.push({
          enforce: 'pre',
          test: /\.(js|vue)$/,
          loader: 'eslint-loader',
          exclude: /(node_modules)/
        })
      }
    },
    plugins: [
      new webpack.ProvidePlugin({
        '$': 'jquery',
        '_': 'lodash'
      })
    ]
  },
  plugins: [
    { src: '~plugins/element-ui.js' },
    { src: '~plugins/quill-plugins.js',ssr:false},
    {src: '~plugins/lodash.js', ssr: false},
  ],

  /*modules:[
    '@gauseen/nuxt-proxy',
  ],
  proxyTable:{
    "/apis": {
      target: "http://www.123.com/",  // 线上地址
      // target: "http://127.0.0.1:8000/",  // 本地环境
      pathRewrite: {"^/apis" : ""}
    }
  },*/
}

