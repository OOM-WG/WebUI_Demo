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
			}
		}
		gradlePluginPortal()
	}
}

// noinspection GradleDynamicVersion
plugins {
	// AndroidGradlePluginVersion
	id("com.android.application") version "9.1.0" apply false
	kotlin("multiplatform") version "+" apply false
	kotlin("plugin.compose") version "+" apply false
	id("org.jetbrains.compose") version "+" apply false

	id("ren.shiror.fyl.fytxt") version "+" apply false
}

include(":app", ":exe", ":test")