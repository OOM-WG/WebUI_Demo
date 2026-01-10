@file:Suppress("UnstableApiUsage")

rootProject.name = "FYTxt-Demo"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

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
		maven("https://oom-maven.sawahara.host") {
			content {
				includeGroupByRegex("ren\\.shiror.*")
				includeGroupByRegex("dev\\.oom-wg.*")
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
		maven("https://oom-maven.sawahara.host") {
			content {
				includeGroupByRegex("ren\\.shiror.*")
				includeGroupByRegex("dev\\.oom-wg.*")
			}
		}
		gradlePluginPortal()
	}
}

plugins {
	id("org.jetbrains.kotlin.multiplatform") version "+" apply false
	id("org.jetbrains.kotlin.plugin.compose") version "+" apply false
	id("org.jetbrains.compose") version "+" apply false

	id("dev.oom-wg.purejoy.fyl.fytxt") version "+" apply false
}

include(":app", ":exe")