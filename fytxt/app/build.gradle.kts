import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
	kotlin("multiplatform")
	kotlin("plugin.compose")
	id("org.jetbrains.compose")

	id("dev.oom-wg.purejoy.fyl.fytxt")
}

fytxt {
	langSrcs = mapOf(
		"Common" to layout.projectDirectory.dir("../gradle/lang/common"),
		"Meow" to layout.projectDirectory.dir("../gradle/lang/meow")
	)
	langAliases = mapOf("ZH_CN" to "^ZH_.*(HANS|CN|SG)", "ZH" to "^ZH_(?!.*(HANS|CN|SG)).*")
	defaultLang = "ZH_CN"
	composeGen = true
}

compose.resources {
	packageOfResClass = "dev.oom_wg.demo.generated.resources"
}

kotlin {
	applyDefaultHierarchyTemplate()

	@OptIn(ExperimentalWasmDsl::class) wasmJs {
		browser {
			commonWebpackConfig {
				outputFileName = "fytxt-app.js"
			}
		}
		binaries.executable()
	}

	// noinspection GradleDynamicVersion
	@Suppress("DEPRECATION") sourceSets.webMain.dependencies {
		implementation(compose.runtime)
		implementation(compose.foundation)
		implementation("top.yukonga.miuix.kmp:miuix:+")
		implementation(compose.ui)
		implementation(compose.uiUtil)
		implementation(compose.preview)
		implementation(compose.components.resources)
		implementation(compose.components.uiToolingPreview)
	}
}