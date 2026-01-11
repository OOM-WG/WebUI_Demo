@file:Suppress("UnstableApiUsage")

import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
	id("com.android.application")
	kotlin("android")
	kotlin("plugin.compose")

	id("org.lsposed.lsplugin.resopt") version "+"

	id("dev.oom-wg.purejoy.fyl.fytxt")
}

fytxt {
	langSrcs = mapOf(
		"Common" to layout.projectDirectory.dir("../gradle/lang/common"),
		"Meow" to layout.projectDirectory.dir("../gradle/lang/meow")
	)
	langAliases = mapOf(
		"ZH_CN" to "^ZH_.*(HANS|CN|SG)", "ZH" to "^ZH_(?!.*(HANS|CN|SG)).*"
	)
	defaultLang = "ZH_CN"
	composeGen = true
	internalClass = false
}

composeCompiler.includeComposeMappingFile = false

kotlin.compilerOptions.jvmTarget = JvmTarget.JVM_25

android {
	namespace = "dev.oom_wg.demo"
	compileSdk = 36
	buildToolsVersion = "36.1.0"

	defaultConfig {
		applicationId = "dev.oom_wg.demo"
		minSdk = 24
		targetSdk = 36
	}
	buildTypes {
		release {
			isMinifyEnabled = true
			isShrinkResources = true
			signingConfig = signingConfigs.getByName("debug")
			proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
		}
		debug {
			signingConfig = signingConfigs.getByName("debug")
			proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
		}
	}
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_25
		targetCompatibility = JavaVersion.VERSION_25
	}
	buildFeatures {
		buildConfig = true
		compose = true
	}
}

// noinspection GradleDynamicVersion
dependencies {
	implementation(project.dependencies.platform("androidx.compose:compose-bom:+"))
	implementation("androidx.compose.ui:ui")
	implementation("androidx.compose.runtime:runtime")
	implementation("androidx.compose.foundation:foundation")
	implementation("androidx.compose.material3:material3")
	implementation("androidx.activity:activity-compose:+")

	implementation("com.highcapable.hikage:hikage-core:+")
	implementation("com.highcapable.hikage:hikage-extension-compose:+")
}