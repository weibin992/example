import axios from 'axios'
import router from '../router'
import { Message } from 'element-ui'

// 默认请求头
// axios.defaults.headers.common['Authorization'] = "aaaaaaasssssssdddddwww";
// axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8';

// 请求拦截器
axios.interceptors.request.use(config => {
    if (!config.headers) {
        config.headers = {};
    }
    let data = config.data;
    let contentType = 'application/x-www-form-urlencoded';
    if (config.dataType == 'json') {
        contentType = 'application/json';
        if (data && typeof data != 'string') {
            config.data = JSON.stringify(data);
        }
    } else {
        if (data && typeof data != 'string') {
            let params = [];
            for (let key in data) {
                params.push(encodeURI(key) + '=' + encodeURI(data[key]));
            }
            config.data = params.join('&');
        }
    }
    config.headers['Content-Type'] = contentType;
    return config;
}, error => {
    return Promise.reject(error);
});

// 响应拦截器
axios.interceptors.response.use(response => {
    let data = response.data;
    if (data.code != 0) {
        Message.error({ message: data.message });
        return Promise.reject(data);
    }
    return data;
}, error => {
    if (error.response.status == 504 || error.response.status == 404) {
        Message.error({ message: '服务器被吃了( ╯□╰ )' })
    } else if (error.response.status == 403) {
        Message.error({ message: '权限不足，请联系管理员' })
    } else if (error.response.status == 401) {
        Message.error({ message: '尚未登录，请登录' })
        router.replace('/');
    } else {
        if (error.response.data.message) {
            Message.error({ message: error.response.data.message })
        } else {
            Message.error({ message: '未知错误!' })
        }
    }
    return Promise.reject(error);
})

export default axios;