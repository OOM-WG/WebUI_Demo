# [FYTxt 示例](https://app.niggergo.work/purejoy/fytxt)

本示例的内容包括 _Compose UI_ 与 _CLI 命令行_ 的多语言示例

## 多语言配置

多语言文件存放于 [_此处_](gradle/lang/)

其中 `common` 为默认语言组，`meow` 为喵言喵语语言组

其中以 `Text` 作为基准，为默认语言组的 _简体中文_、_繁体中文_、_英文_ 进行了多语言翻译，
为喵言喵语语言组的 _简体中文_、_繁体中文_ 进行了多语言翻译

> [!NOTE]
> 由于 Compose 默认不支持显示中文，中文的后面均添加了拼音

## 示例内容

示例中以 `wasmJs` 作为 Compose 示例（`app` 模块），以 `linux`/`mingw` 作为 CLI 示例（`exe` 模块）

Compose 示例 有完整的功能展示: 多语言文本、系统语言列表、可用语言列表、语言组切换、自动更新锁、翻译率

CLI 示例 由于成本问题，仅有: 多语言文本、系统语言列表、可用语言列表、翻译率，传入给 CLI 程序的**第一个**内容将被切换为当前系统语言

## 性能测试

`test` 模块 是一个使用 _原生 View_ 与 _Jetpack Compose_ 测试 _原生方法_ 与 _FYTxt_ 获取 **一百万次** 字符串性能的 Android 应用

经过 `debug`/`release` 测试，FYTxt 稳定快**几倍**至**十几倍**，
由于 FYTxt 的 Compose 调用方式添加了监听，会显著拖慢速度，但仍比原生方式快不少
（也可将 FYTxt 的直接获取方式直接与 Compose 的原生获取方式对比，因为两种界面的原生获取速度基本一致，FYTxt 的 Compose 因监听而稍慢）
