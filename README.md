# SakitinSU WebUI

SakitinSU 的 WebUI 标准与 KerenlSU 保持一致，详细规范请参考 [KerenlSU WebUI 模块 Web 界面](https://kernelsu.org/zh_CN/guide/module-webui.html)。

除此之外，SakitinSU 的 WebUI JavaScript 接口的 `moduleInfo` 函数额外提供一个`updatable`值，此值会受到用户网络环境影响。

## 目录结构规范

模块的目录结构如下：

``` tree
.
├── module.prop
└── webroot
  ├── index.html
  └── 其他Web资源...
```

- `webroot` 目录为 WebUI 的根目录，包含所有前端资源。
- `module.prop` 为模块描述文件。

## 开发与构建

本项目基于 [Vue 3](https://vuejs.org/) + [TypeScript](https://www.typescriptlang.org/) + [Vite](https://vitejs.dev/) 开发，集成了 KernelSU 包，便于快速开发和打包。

### 快速开始

1. 安装依赖：
   ```sh
   pnpm install
   ```
2. 启动开发服务器：
   ```sh
   pnpm dev
   ```
3. 构建生产包（产物会输出到 `dist`）：
   ```sh
   pnpm build
   ```
