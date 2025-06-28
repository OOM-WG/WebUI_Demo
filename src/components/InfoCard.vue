<template>
  <div class="card-wrapper">
    <!-- 卡片外部的小标题 -->
    <h3 class="card-title">{{ sectionTitle }}</h3>

    <!-- 卡片内容 -->
    <div class="info-card">
      <div class="info-grid">
        <div v-for="(item, index) in infoItems" :key="index" class="info-row">
          <span class="label">{{ item.label }}</span>
          <span class="value">{{ item.value }}</span>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
interface InfoItem {
  label: string;
  value: string;
}

interface Props {
  sectionTitle: string;
  infoItems: InfoItem[];
}

defineProps<Props>();
</script>

<style scoped>
.card-wrapper {
  margin-bottom: 24px;
}

.card-title {
    font-size: 14px;
    font-weight: 400;
    color: #999;
    margin: 0 0 12px 0;
    text-align: left;
    padding-left: 8px;
}

.info-card {
  background: #ffffff;
  border-radius: 16px;
  padding: 8px 20px;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, sans-serif;
  box-shadow: none;
}

.info-grid {
  display: flex;
  flex-direction: column;
  gap: 0;
}

.info-row {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 12px 0;
  min-height: 40px;
  width: 100%;
}

.info-row:last-child {
  border-bottom: none;
}

.info-row .label {
  font-size: 14px;
  font-weight: 600;
  color: #333;
  text-align: left;
  flex-shrink: 0;
}

.info-row .value {
  font-size: 14px;
  color: #666;
  font-weight: 400;
  text-align: right;
  word-break: break-word;
  flex-shrink: 1;
  margin-left: 16px;
}
</style>
