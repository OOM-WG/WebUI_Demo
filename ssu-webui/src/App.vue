<script setup lang="ts">
import { fullScreen } from 'kernelsu'

import Footbar from './components/Footbar.vue'
import SystemCards from './components/SystemCards.vue'
import YuanShen from './components/YuanShen.vue'

fullScreen(true)
</script>

<template>
	<div class="app-container">
		<h1 class="main-title">WebUI Demo</h1>
		<SystemCards />
		<div>
			<YuanShen buttonText="原神 • 启动" />
		</div>
		<Footbar />
	</div>
</template>

<style>
html,
body {
	block-size: 100%;
	overflow: hidden;
	scrollbar-width: none;
	-ms-overflow-style: none;
}

body::-webkit-scrollbar,
html::-webkit-scrollbar {
	display: none;
}
</style>

<style scoped>
.app-container {
	min-block-size: 100vh;
	background: #f5f5f5;
	padding: 16px;
}

.main-title {
	font-size: 18px;
	font-weight: 600;
	color: #2c3e50;
	margin: 0 0 20px;
}

.cards-list {
	display: flex;
	flex-direction: column;
	gap: 0;
}

@media (width <= 768px) {
	.app-container {
		padding: 12px;
	}

	.main-title {
		font-size: 16px;
		margin-block-end: 16px;
	}
}
</style>
