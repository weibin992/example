(function(e){function t(t){for(var n,a,i=t[0],u=t[1],l=t[2],p=0,f=[];p<i.length;p++)a=i[p],Object.prototype.hasOwnProperty.call(s,a)&&s[a]&&f.push(s[a][0]),s[a]=0;for(n in u)Object.prototype.hasOwnProperty.call(u,n)&&(e[n]=u[n]);c&&c(t);while(f.length)f.shift()();return o.push.apply(o,l||[]),r()}function r(){for(var e,t=0;t<o.length;t++){for(var r=o[t],n=!0,i=1;i<r.length;i++){var u=r[i];0!==s[u]&&(n=!1)}n&&(o.splice(t--,1),e=a(a.s=r[0]))}return e}var n={},s={app:0},o=[];function a(t){if(n[t])return n[t].exports;var r=n[t]={i:t,l:!1,exports:{}};return e[t].call(r.exports,r,r.exports,a),r.l=!0,r.exports}a.m=e,a.c=n,a.d=function(e,t,r){a.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:r})},a.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},a.t=function(e,t){if(1&t&&(e=a(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var r=Object.create(null);if(a.r(r),Object.defineProperty(r,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var n in e)a.d(r,n,function(t){return e[t]}.bind(null,n));return r},a.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return a.d(t,"a",t),t},a.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},a.p="";var i=window["webpackJsonp"]=window["webpackJsonp"]||[],u=i.push.bind(i);i.push=t,i=i.slice();for(var l=0;l<i.length;l++)t(i[l]);var c=u;o.push([0,"chunk-vendors"]),r()})({0:function(e,t,r){e.exports=r("56d7")},"230c":function(e,t,r){},4251:function(e,t,r){},5338:function(e,t,r){"use strict";var n=r("230c"),s=r.n(n);s.a},"56d7":function(e,t,r){"use strict";r.r(t);var n=r("2b0e"),s=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{attrs:{id:"app"}},[r("router-view")],1)},o=[],a=r("2877"),i={},u=Object(a["a"])(i,s,o,!1,null,null,null),l=u.exports,c=r("8c4f"),p=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{attrs:{id:"login"}},[r("el-form",{ref:"form",attrs:{model:e.user,"label-width":"100px"}},[r("div",{staticClass:"title"},[e._v("welcome")]),r("el-form-item",{attrs:{label:"帐号名"}},[r("el-input",{attrs:{autofocus:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.login(t)}},model:{value:e.user.userName,callback:function(t){e.$set(e.user,"userName",t)},expression:"user.userName"}})],1),r("el-form-item",{attrs:{label:"密码"}},[r("el-input",{nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.login(t)}},model:{value:e.user.password,callback:function(t){e.$set(e.user,"password",t)},expression:"user.password"}})],1),r("el-form-item",[r("el-button",{attrs:{type:"primary"},on:{click:e.login}},[e._v("立即登录")])],1)],1)],1)},f=[],d=(r("ac1f"),r("5319"),{data:function(){return{user:{userName:"",password:""}}},methods:{login:function(){var e=this;this.$util.isEmpty(this.user.userName)?this.$message.error("登录失败，请输入帐号名"):this.$util.isEmpty(this.user.password)?this.$message.error("登录失败，请输入密码"):this.$http.post("login",this.user).then((function(){e.$router.replace({name:"Home"}),e.$message({message:"登录成功",type:"success",duration:1500})}))}}}),m=d,h=(r("5338"),Object(a["a"])(m,p,f,!1,null,null,null)),v=h.exports,g=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",[r("div",{staticClass:"home-header"},[r("div",{staticClass:"logout"},[r("i",{staticClass:"el-icon-error",on:{click:e.logout}})])]),r("div",{staticClass:"home-aside"},[r("el-menu",[r("el-menu-item",{attrs:{index:"1"}},[r("i",{staticClass:"el-icon-menu"}),r("span",{attrs:{slot:"title"},slot:"title"},[r("router-link",{attrs:{to:"/home"}},[e._v("主页")])],1)]),r("el-submenu",{attrs:{index:"2"}},[r("template",{slot:"title"},[r("i",{staticClass:"el-icon-location"}),r("span",[e._v("导航一")])]),r("el-menu-item",{attrs:{index:"2-1"}},[r("router-link",{attrs:{to:"/home/member"}},[e._v("用户")])],1),r("el-menu-item",{attrs:{index:"2-2"}},[e._v("选项1")]),r("el-menu-item",{attrs:{index:"2-3"}},[e._v("选项1")])],2)],1)],1),r("div",{staticClass:"home-body"},[r("router-view")],1)])},b=[],y={data:function(){return{}},methods:{logout:function(){var e=this;this.$http.get("/logout").then((function(){e.$router.replace({name:"Login"})}))}}},_=y,w=(r("dbc2"),Object(a["a"])(_,g,b,!1,null,null,null)),x=w.exports,O=function(){var e=this,t=e.$createElement;e._self._c;return e._m(0)},$=[function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",[r("h1",[e._v(" this is dashboard ")])])}],j={},k=j,E=Object(a["a"])(k,O,$,!1,null,null,null),M=E.exports,C=function(){var e=this,t=e.$createElement;e._self._c;return e._m(0)},P=[function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",[r("h2",[e._v("this is Member page")])])}],N={},S=N,T=Object(a["a"])(S,C,P,!1,null,null,null),J=T.exports;n["default"].use(c["a"]);var H=[{path:"/",redirect:"/login"},{path:"/login",name:"Login",component:v},{path:"/home",name:"Home",component:x,redirect:"/home/dashboard",children:[{path:"dashboard",component:M},{path:"member",component:J}]}],I=new c["a"]({routes:H}),L=r("5c96"),R=r.n(L),U=(r("0fae"),{isEmpty:function(e){return null===e||void 0===e||""===e},isNotEmpty:function(e){return!this.isNotEmpty(e)},alert:function(e){L["Message"].error({message:e})}}),q=U,z=(r("a15b"),r("d3b7"),r("e6cf"),r("bc3a")),A=r.n(z);A.a.interceptors.request.use((function(e){e.headers||(e.headers={});var t=e.data,r="application/x-www-form-urlencoded";if("json"==e.dataType)r="application/json",t&&"string"!=typeof t&&(e.data=JSON.stringify(t));else if(t&&"string"!=typeof t){var n=[];for(var s in t)n.push(encodeURI(s)+"="+encodeURI(t[s]));e.data=n.join("&")}return e.headers["Content-Type"]=r,e}),(function(e){return Promise.reject(e)})),A.a.interceptors.response.use((function(e){var t=e.data;return 0!=t.code?(L["Message"].error({message:t.message}),Promise.reject(t)):t}),(function(e){return 504==e.response.status||404==e.response.status?L["Message"].error({message:"服务器被吃了( ╯□╰ )"}):403==e.response.status?L["Message"].error({message:"权限不足，请联系管理员"}):401==e.response.status?(L["Message"].error({message:"尚未登录，请登录"}),I.replace("/")):e.response.data.message?L["Message"].error({message:e.response.data.message}):L["Message"].error({message:"未知错误!"}),Promise.reject(e)}));var B=A.a;n["default"].config.productionTip=!1,n["default"].prototype.$util=q,n["default"].prototype.$http=B,n["default"].use(R.a),new n["default"]({router:I,render:function(e){return e(l)}}).$mount("#app")},dbc2:function(e,t,r){"use strict";var n=r("4251"),s=r.n(n);s.a}});
//# sourceMappingURL=app.efc565f1.js.map