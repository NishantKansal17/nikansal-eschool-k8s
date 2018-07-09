<template>
  <div style="padding-top: 5em">
  <b-card 
    class="align-center"
    header-tag="header">
    <b-form id="stuRegistrationForm" @submit.prevent="submit()">
      <b-form-group vertical
                    label="First Name"
                    label-for="firstName"
                    class="form-vertical-align">
      <b-form-input id="firstName"
                      v-model="student.firstName"
                      placeholder="First name" autofocus>
     </b-form-input>
     </b-form-group>
     <b-form-group vertical
                    label="Middle Name"
                    label-for="middleName"
                    class="form-vertical-align">
     <b-form-input id="middleName" type="text"
                      v-model="student.middleName"
                      placeholder="Middle name">
     </b-form-input>
     </b-form-group>
     
     <b-form-group vertical
                    label="Last Name"
                    label-for="lastName"
                    class="form-vertical-align">
     <b-form-input id="lastName" type="text"
                      v-model="student.lastName"
                      placeholder="Last name">
     </b-form-input>
     </b-form-group>
     
     <b-form-group vertical
                    label="Mobile"
                    label-for="mobile"
                    class="form-vertical-align">
     <b-form-input id="mobile" type="text"
                      v-model="student.mobile"
                      placeholder="Mobile no.">
     </b-form-input>
     </b-form-group>
     
     <b-form-group vertical
                    label="Address"
                    label-for="address"
                    class="form-vertical-align">
     <b-form-input id="address" type="text"
                      v-model="student.address"
                      placeholder="Address">
     </b-form-input>
     </b-form-group>
     
     <b-form-group vertical
                    label="Country"
                    label-for="country"
                    class="form-vertical-align">
     <b-form-input id="country" type="text"
                      v-model="student.country"
                      placeholder="Country">
     </b-form-input>
     </b-form-group>
     
     
     <b-form-group vertical
                    label="State"
                    label-for="state"
                    class="form-vertical-align">
     <b-form-input id="state" type="text"
                      v-model="student.state"
                      placeholder="State">
     </b-form-input>
     </b-form-group>
     
     <b-form-group vertical
                    label="Email"
                    label-for="email"
                    class="form-vertical-align">
     <b-form-input id="email" type="email"
                      v-model="student.email"
                      placeholder="Email id">
     </b-form-input>
     </b-form-group>
     
     <b-button id="loginBtn" variant="primary" size="lg" type="submit">Go</b-button>
   </b-form>
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
      student: {
        firstName: "",
        middleName: "",
        lastName: "",
        mobile: "",
        address: "",
        country: "",
        state: "",
        "email": ""
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
      AXIOS.post("/eschool/student/registration/create", this.student)
      .then(response => {
            // JSON responses are automatically parsed.
            this.response = response.data
            console.log(response.data)
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
