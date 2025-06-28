<template>
  <footer class="footer-bar">
    <div class="footer-top">
      © 2025  SakitinSU Build with
      <a href="https://vitejs.dev/" target="_blank" rel="noopener">Vite</a>
      <a>&</a>
      <a href="https://kernelsu.org/" target="_blank" rel="noopener">KernelSU</a>
    </div>
    <div class="footer-bottom">
      <a href="https://github.com/OOM-WG" target="_blank" rel="noopener">GitHub</a>
      <span class="dot">·</span>
      <a href="https://opensource.org/licenses/MIT" target="_blank" rel="noopener">MIT</a>
    </div>
  </footer>
</template>


<style scoped>
.footer-bar {
  width: 100%;
  padding: 16px 0 12px 0;
  color: #888;
  font-size: 14px;
  text-align: center;
  border: none;
  background: none;
}

.footer-top,
.footer-bottom {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-wrap: wrap;
  gap: 8px;
  margin-bottom: 4px;
}

.footer-bottom {
  margin-bottom: 0;
}

.footer-bar a {
  color: #888;
  text-decoration: underline;
  transition: color 0.2s;
}
.footer-bar a:hover {
  color: #333;
}

.dot {
  color: #ccc;
  margin: 0 4px;
  font-weight: bold;
}

.divider {
  margin: 0 6px;
  color: #ccc;
  font-weight: bold;
}
</style>