<script setup lang="ts">
import {fullScreen} from 'kernelsu';
import SystemCards from "./components/SystemCards.vue";
import Footbar from './components/Footbar.vue';
import YuanShen from './components/YuanShen.vue';

fullScreen(true);
</script>

<template>
  <div class="app-container">
    <h1 class="main-title">WebUI Demo</h1>
    <SystemCards/>
    <div>
      <YuanShen buttonText="原神 • 启动"/>
    </div>
    <Footbar/>
  </div>
</template>

<style>
html, body {
  height: 100%;
  overflow: hidden;
}

body::-webkit-scrollbar, html::-webkit-scrollbar {
  display: none;
}

body, html {
  scrollbar-width: none;
  -ms-overflow-style: none;
}
</style>

<style scoped>
.app-container {
  min-height: 100vh;
  background: #F5F5F5;
  padding: 16px;
}

.main-title {
  font-size: 18px;
  font-weight: 600;
  color: #2c3e50;
  margin: 0 0 20px 0;
}

.cards-list {
  display: flex;
  flex-direction: column;
  gap: 0;
}

@media (max-width: 768px) {
  .app-container {
    padding: 12px;
  }

  .main-title {
    font-size: 16px;
    margin-bottom: 16px;
  }
}
</style>
