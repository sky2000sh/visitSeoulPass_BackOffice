<script setup>
import ArgonInput from "@/components/ArgonInput.vue";
import ArgonButton from "@/components/ArgonButton.vue";
const emit = defineEmits(["nextStep"]);
</script>
<template>
  <div
    class="card multisteps-form__panel p-3 border-radius-xl bg-white"
    data-animation="FadeIn"
  >
    <h5 class="font-weight-bolder mb-0">About me</h5>
    <p class="mb-0 text-sm">Mandatory informations</p>
    <div class="multisteps-form__content">
      <div class="row mt-3">
        <div class="col-12 col-sm-6">
          <label>First Name</label>
          <argon-input
            id="firstname"
            class="multisteps-form__input"
            type="text"
            placeholder="eg. Michael"
            icon-dir="left"
            icon="ni ni-check-bold"
          />
        </div>
        <div class="col-12 col-sm-6 mt-3 mt-sm-0">
          <label>Last Name</label>
          <argon-input
            id="lastname"
            class="multisteps-form__input"
            type="text"
            placeholder="eg. Prior"
          />
        </div>
      </div>
      <div class="row">
        <div class="col-12 col-sm-6">
          <label>Company</label>
          <argon-input
            id="company"
            class="multisteps-form__input"
            type="text"
            placeholder="eg. Creative Tim"
          />
        </div>
        <div class="col-12 col-sm-6 mt-3 mt-sm-0">
          <label>Email Address</label>
          <argon-input
            id="email"
            class="multisteps-form__input"
            type="email"
            placeholder="eg. argon@dashboard.com"
          />
        </div>
      </div>
      <div class="row">
        <div class="col-12 col-sm-6">
          <label>Password</label>
          <argon-input
            id="password"
            class="multisteps-form__input"
            type="password"
            placeholder="******"
          />
        </div>
        <div class="col-12 col-sm-6 mt-sm-0">
          <label>Repeat Password</label>
          <argon-input
            id="repeat-password"
            class="multisteps-form__input"
            type="password"
            placeholder="******"
          />
        </div>
      </div>
      <div class="button-row d-flex mt-2">
        <argon-button
          type="button"
          color="dark"
          variant="gradient"
          class="ms-auto mb-0 js-btn-next"
          @click="emit('nextStep')"
          >Next</argon-button
        >
      </div>
    </div>
  </div>
</template>
