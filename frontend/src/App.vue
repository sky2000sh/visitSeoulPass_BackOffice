<script setup>
import { computed } from "vue";
import { useStore } from "vuex";

import Sidenav from "./examples/Sidenav";
import Configurator from "@/examples/Configurator.vue";
import Navbar from "@/examples/Navbars/Navbar.vue";
import AppFooter from "@/examples/Footer.vue";

const store = useStore();
const layout = computed(() => store.state.layout);
const showSidenav = computed(() => store.state.showSidenav);
const showNavbar = computed(() => store.state.showNavbar);
const showFooter = computed(() => store.state.showFooter);
const showConfig = computed(() => store.state.showConfig);
const hideConfigButton = computed(() => store.state.hideConfigButton);
</script>
<template>
  <div class="wrapper">
    <div
      v-show="layout === 'landing'"
      class="landing-bg h-100 bg-gradient-primary position-fixed w-100"
    ></div>
    <sidenav v-if="showSidenav" />
    <main class="main-content position-relative max-height-vh-100 h-100">
      <navbar v-if="showNavbar" />
      <router-view />
      <app-footer v-show="showFooter" />
      <configurator
        :class="[showConfig ? 'show' : '', hideConfigButton ? 'd-none' : '']"
      />
    </main>
  </div>
</template>
