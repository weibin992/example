<template>
    <div>
        <div class="home-header">
            <div class="logout">
                <i class="el-icon-error" @click="logout"></i>
            </div>
        </div>
        <div class="home-aside">
            <el-menu>
                <el-menu-item index="1">
                    <i class="el-icon-menu"></i>
                    <span slot="title">
                        <router-link to="/home">主页</router-link>
                    </span>
                </el-menu-item>
                <el-submenu index="2">
                    <template slot="title">
                        <i class="el-icon-location"></i>
                        <span>导航一</span>
                    </template>
                    <el-menu-item index="2-1">
                        <router-link to="/home/member">用户</router-link>
                    </el-menu-item>
                    <el-menu-item index="2-2">选项1</el-menu-item>
                    <el-menu-item index="2-3">选项1</el-menu-item>
                </el-submenu>
            </el-menu>
        </div>
        <div class="home-body">
            <router-view />
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            
        }
    },
    methods: {
        logout() {
            this.$http.get('/logout').then(() => {
                this.$router.replace({ name: 'Login' });
            });
        }
    }
};
</script>

<style lang="scss">
html,
body {
    margin: 0;
    padding: 0;
}
.home-header {
    position: fixed;
    top: 0;
    left: 0;
    right: 0;
    height: 100px;
    background: #0053a7;
    color: #ffffff;
    text-align: right;
    .logout {
        font-size: 30px;
        width: 60px;
        height: 100px;
        line-height: 100px;
        display: inline-block;
        text-align: center;
        cursor: pointer;
    }
}
.home-aside {
    position: fixed;
    top: 100px;
    left: 0;
    bottom: 0;
    width: 200px;
}
.home-body {
    position: fixed;
    top: 100px;
    left: 200px;
    right: 0;
    bottom: 0;
    background: #ffffff;
}
</style>