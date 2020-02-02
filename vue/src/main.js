import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import myUtil from './utils/myUtil'
import axios from './api/http'

Vue.config.productionTip = false

// 绑定全局函数
Vue.prototype.$util = myUtil;
Vue.prototype.$http = axios;

Vue.use(ElementUI)
// Vue.use(ElementUI, { size: 'small' })

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
