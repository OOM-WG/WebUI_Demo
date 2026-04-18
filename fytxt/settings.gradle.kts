@file:Suppress("UnstableApiUsage")

rootProject.name = "FYTxt-Demo"

pluginManagement {
	repositories {
		mavenLocal()
		mavenCentral()
		google {
			mavenContent {
				includeGroupAndSubgroups("androidx")
				includeGroupAndSubgroups("com.android")
				includeGroupAndSubgroups("com.google")
			}
		}
		maven("https://maven.oom-wg.dev") {
			content {
				includeGroupAndSubgroups("ren.shiror")
				includeGroupAndSubgroups("sbs.fvvlang")
				includeGroupAndSubgroups("dev.oom-wg")
				includeGroupAndSubgroups("dev.oom_wg")
			}
		}
		gradlePluginPortal()
	}
}
dependencyResolutionManagement {
	repositories {
		mavenLocal()
		mavenCentral()
		maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
		google {
			mavenContent {
				includeGroupAndSubgroups("androidx")
				includeGroupAndSubgroups("com.android")
				includeGroupAndSubgroups("com.google")
			}
		}
		maven("https://maven.oom-wg.dev") {
			content {
				includeGroupAndSubgroups("ren.shiror")
				includeGroupAndSubgroups("sbs.fvvlang")
				includeGroupAndSubgroups("dev.oom-wg")
				includeGroupAndSubgroups("dev.oom_wg")
			}
		}
		gradlePluginPortal()
	}
}

// noinspection GradleDynamicVersion
plugins {
	// AndroidGradlePluginVersion
	id("com.android.application") version "9.0.0-alpha06" apply false
	kotlin("multiplatform") version "+" apply false
	kotlin("plugin.compose") version "+" apply false
	id("org.jetbrains.compose") version "+" apply false

	id("dev.oom-wg.purejoy.fyl.fytxt") version "+" apply false
}

include(":app", ":exe", ":test")