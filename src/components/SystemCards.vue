<script setup lang="ts">
import { ref, onMounted } from "vue";
import { exec } from "kernelsu";
import InfoCard from "./InfoCard.vue";

const systemInfo = ref([
  { label: "系统架构", value: "获取中..." },
  { label: "Android版本", value: "获取中..." },
  { label: "Android SDK", value: "获取中..." },
  { label: "内核版本", value: "获取中..." },
]);

const securityInfo = ref([
  { label: "安全补丁", value: "获取中..." },
  { label: "开发者模式", value: "获取中..." },
  { label: "数据加密", value: "获取中..." },
]);

onMounted(async () => {
  const arch = await exec("uname -m");
  if (arch.errno === 0 && arch.stdout.trim()) {
    systemInfo.value[0].value = arch.stdout.trim();
  }
  const androidVer = await exec("getprop ro.build.version.release");
  if (androidVer.errno === 0 && androidVer.stdout.trim()) {
    systemInfo.value[1].value = androidVer.stdout.trim();
  }
  const sdk = await exec("getprop ro.build.version.sdk");
  if (sdk.errno === 0 && sdk.stdout.trim()) {
    systemInfo.value[2].value = sdk.stdout.trim();
  }
  const kernel = await exec("uname -r");
  if (kernel.errno === 0 && kernel.stdout.trim()) {
    systemInfo.value[3].value = kernel.stdout.trim();
  }
  const patch = await exec("getprop ro.build.version.security_patch");
  if (patch.errno === 0 && patch.stdout.trim()) {
    securityInfo.value[0].value = patch.stdout.trim();
  }
  const dev = await exec("getprop ro.debuggable");
  if (dev.errno === 0 && dev.stdout.trim()) {
    securityInfo.value[1].value = dev.stdout.trim() === "1" ? "已开启" : "未开启";
  }
  const encrypt = await exec("getprop ro.crypto.state");
  if (encrypt.errno === 0 && encrypt.stdout.trim()) {
    securityInfo.value[2].value = encrypt.stdout.trim() === "encrypted" ? "已加密" : encrypt.stdout.trim();
  }
});
</script>

<template>
  <div class="cards-list">
    <InfoCard section-title="系统信息" :info-items="systemInfo" />
    <InfoCard section-title="安全信息" :info-items="securityInfo" />
  </div>
</template>