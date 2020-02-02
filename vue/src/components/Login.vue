<template>
    <div id="login">
        <el-form ref="form" :model="user" label-width="100px">
            <div class="title">welcome</div>
            <el-form-item label="帐号名">
                <el-input v-model="user.userName" autofocus @keyup.enter.native="login"></el-input>
            </el-form-item>
            <el-form-item label="密码">
                <el-input v-model="user.password" @keyup.enter.native="login"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="login">立即登录</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
export default {
    data() {
        return {
            user: {
                userName: "",
                password: ""
            }
        };
    },
    methods: {
        login() {
            if (this.$util.isEmpty(this.user.userName)) {
                this.$message.error("登录失败，请输入帐号名");
                return;
            }
            if (this.$util.isEmpty(this.user.password)) {
                this.$message.error("登录失败，请输入密码");
                return;
            }
            this.$http.post("login", this.user).then(() => {
                this.$router.replace({ name: "Home" });
                this.$message({
                    message: "登录成功",
                    type: "success",
                    duration: 1500
                });
            });
        }
    }
};
</script>

<style lang="scss">
#login {
    width: 500px;
    margin: 120px auto 0;
    border: 1px solid #d4d4d4;
    padding: 20px;
    border-radius: 10px;
    .title {
        text-align: center;
        font-size: 26px;
        margin-bottom: 16px;
        color: #333333;
    }
}
</style>