# [ShiroSU WebUI](https://oom-wg.dev/ssu/dev/man/webui)

ShiroSU 的 WebUI 标准与 KerenlSU 保持一致，详细规范请参考 [**KerenlSU 规范**](https://kernelsu.org/zh_CN/guide/module-webui.html)

## 目录结构规范

模块目录应遵循以下结构:

```plaintext
.
├── module.prop
└── webroot
  ├── index.html (仅可为 index.html！不可为 index.htm 等)
  └── 其他网页资源...
```

- **`webroot`** 目录是 WebUI 的根目录，包含所有前端资源
- **`module.prop`** 为模块描述文件

## 开发与构建

本项目基于 [Vue 3](https://vuejs.org/) + [TypeScript](https://www.typescriptlang.org/) + [Vite](https://vitejs.dev/) 开发，
集成了 [KernelSU](https://www.npmjs.com/package/kernelsu) 包，便于快速开发和打包

## 快速开始

1. 安装依赖: `pnpm install`
2. 启动开发服务器: `pnpm dev`
3. 构建生产包 (产物会输出到 `dist`): `pnpm build`