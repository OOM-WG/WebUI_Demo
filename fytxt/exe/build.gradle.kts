plugins {
	kotlin("multiplatform")

	id("ren.shiror.fyl.fytxt")
}

fytxt {
	langSrcs = mapOf(
		"Common" to layout.projectDirectory.dir("../gradle/lang/common"),
		"Meow" to layout.projectDirectory.dir("../gradle/lang/meow")
	)
	langAliases = mapOf("ZH_CN" to "^ZH_.*(HANS|CN|SG)", "ZH" to "^ZH_(?!.*(HANS|CN|SG)).*")
	defaultLang = "ZH_CN"
}

kotlin {
	applyDefaultHierarchyTemplate()

	mingwX64 {
		binaries {
			executable {
				baseName = "fytxt-exe"
				entryPoint = "main"
			}
		}
	}
	linuxX64 {
		binaries {
			executable {
				baseName = "fytxt-exe"
				entryPoint = "main"
			}
		}
	}
}