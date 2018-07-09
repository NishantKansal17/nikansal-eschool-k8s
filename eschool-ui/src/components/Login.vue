<template>
  <div style="padding-top: 5em">
  <b-card 
    class="align-center"
    header-tag="header">
    <div class="alert alert-danger error-box" v-if="error">
      <a class="close" aria-label="close" @click="error=false">&times;</a>
      <p id="errorBox">{{ error }}</p>
    </div>
    <b-form id="loginForm" @submit.prevent="submit()">
      <b-form-group vertical
                    label="Username"
                    label-for="User"
                    class="form-vertical-align">
      <b-form-input id="User"
                      v-model="credentials.username"
                      required
                      placeholder="Username" autofocus>
     </b-form-input>
     </b-form-group>
     <b-form-group vertical
                    label="Password"
                    label-for="Password"
                    class="form-vertical-align">
     <b-form-input id="Password" type="password"
                      v-model="credentials.password"
                      required
                      placeholder="Password" autofocus>
     </b-form-input>
     </b-form-group>
     <b-button id="loginBtn" variant="primary" size="lg" type="submit">Sign in</b-button>
   </b-form>
   <div class="align-center" style="padding-top: 1em; font-size: smaller">&copy; Cisco Systems {{year}}</div>
  </b-card>
  </div>
</template>

<script>
import {AXIOS} from './http-common'
export default {
  mounted() {
    console.log("hellooooo ready!!");
  },
  data() {
    return {
      credentials: {
        username: "",
        password: ""
      },
      hostname: "",
      error: "",
      year: new Date().getFullYear(),
      response: [],
      errors: []
    };
  },
  methods: {
    submit() {
      console.log("submit() called..");
      AXIOS.get("/user/" + this.credentials.username)
      .then(response => {
            // JSON responses are automatically parsed.
            this.response = response.data
            console.log(response.data)
            localStorage.setItem("userName", this.response.firstName)
            localStorage.setItem("userPassword", this.response.lastName)
            this.$router.push("/welcome");
          })
          .catch(e => {
            this.errors.push(e)
            console.log(this.errors)
          })
    }
  }
};
</script>

<style scoped>
.card-header {
  padding: 0px;
  border-radius: inherit;
}
#header-div {
  border-top-left-radius: inherit;
  border-top-right-radius: inherit;
  padding-top: 1.1em;
  padding-bottom: 1em;
  height: 4em;
  font-size: 1.1rem;
}
.card {
  max-width: 30rem;
  margin: auto;
  border-radius: 7px;
  box-shadow: 2px 2px 1px 2px #eee; 
}

div.login-main-container {
  margin-left: 0;
  margin-right: 0;
}

.btn.inactive-button {
  pointer-events: none;
  cursor: default;
  border-color:#D8D8D8;
  color: #848484;
  background-color:#F2F2F2;
}
.form-vertical-align {
    text-align: left;
}
#errorBox {
  margin: 0px
}
</style>
