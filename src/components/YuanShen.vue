<template>
  <button class="card-title-button" @click="runExec">
    {{ buttonText }}
  </button>
</template>

<script setup lang="ts">
import { toast, exec } from 'kernelsu';

defineProps<{
  buttonText: string
}>()

async function runExec() {
  // 这里用 am start 启动原神
  const res = await exec(
    'am start -n com.miHoYo.Yuanshen/com.miHoYo.GetMobileInfo.MainActivity'
  );
  if (res.errno === 0) {
    toast('已尝试启动原神应用');
  } else {
    toast(`启动失败: ${res.stderr?.trim() || "未知错误"}`);
  }
}
</script>

<style scoped>
.card-title-button {
  width: 100%;
  background: #fff;
  border-radius: 16px;
  padding: 16px 0;
  font-size: 16px;
  font-weight: 600;
  color: #333;
  border: none;
  cursor: pointer;
  box-shadow: none;
  text-align: center;
  transition: background 0.15s;
  margin-bottom: 12px;
  outline: none;
}
.card-title-button:hover {
  background: #f5f5f5;
}
.exec-output {
  color: #666;
  font-size: 14px;
  word-break: break-all;
  padding: 4px 0 0 0;
}
</style>