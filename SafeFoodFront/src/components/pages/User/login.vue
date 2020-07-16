<template>
  <div class="container">
    <b-jumbotron fluid container-fluid style="text-align: center" bg-variant="info" text-variant="primary" border-variant="dark">
      <template v-slot:header>
        <strong>LOG IN</strong>
      </template>
      <template v-slot:lead><p>로그인 페이지 입니다.</p></template>
      <hr class="my-4"/>
      <p>로그인하여 저희가 제공하는 모든 서비스를 무료로 사용해보세요.</p>
    </b-jumbotron>
<div class="d-flex justify-content-center">
		<div class="card">
			<div class="card-header">
				<h3>Sign In</h3>
			</div>
			<div class="card-body">
				<form>
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-user"></i></span>
						</div>
						<input  v-model="user.id" id="inputUserId"  type="text" class="form-control" placeholder="ID">
						
					</div>
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-key"></i></span>
						</div>
						<input v-model="user.password" id="inputUserPw" type="password" class="form-control" placeholder="PASSWORD">
					</div>
					<div class="row align-items-center remember">
						<input type="checkbox">Remember Me
					</div>
					<div class="form-group">
						<input type="submit" @click="doLogin" value="Login" class="btn float-right login_btn">
					</div>
				</form>
			</div>
			<div class="card-footer">
				<div class="d-flex justify-content-center links">
					Don't have an account?<router-link to="/registUser">Sign Up</router-link>
				</div>
				<div class="d-flex justify-content-center">
					<a href="#">Forgot your password?</a>
				</div>
			</div>
		</div>
	</div>
	<div style="width:1500px;"></div>
  </div>

</template>

<script>
import axios from '../../../js/http-commons.js';
export default {
    data() {
        return {
          user: {}
        };
    },
    methods: {
        doLogin() {
            axios.post("/user/login", this.user)
            .then(res => {
              alert("로그인 되었습니다.");
              this.$store.state.loginUser=res.data;
              this.$store.state.isLogin=true;
                this.$router.push({
                  path: "/"
                });
            }).catch(() => {
              alert("아이디, 비밀번호를 확인하세요.");
            })
        }
    }
}
</script>

<style scoped>

.container{
align-content: center;
}

.card{
height: 370px;
margin-top: auto;
margin-bottom: auto;
width: 400px;
background-color: rgba(0,0,0,0.5) !important;
}

.social_icon span{
font-size: 60px;
margin-left: 10px;
color: #FFC312;
}

.social_icon span:hover{
color: white;
cursor: pointer;
}

.card-header h3{
color: white;
}

.social_icon{
position: absolute;
right: 20px;
top: -45px;
}

.input-group-prepend span{
width: 50px;
background-color: #FFC312;
color: black;
border:0 !important;
}

input:focus{
outline: 0 0 0 0  !important;
box-shadow: 0 0 0 0 !important;

}

.remember{
color: white;
}

.remember input
{
width: 20px;
height: 20px;
margin-left: 15px;
margin-right: 5px;
}

.login_btn{
color: black;
background-color: #FFC312;
width: 100px;
}

.login_btn:hover{
color: black;
background-color: white;
}

.links{
color: white;
}

.links a{
margin-left: 4px;
}
</style>