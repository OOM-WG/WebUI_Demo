import kotlinx.coroutines.runBlocking
import tf.gal.shirosu.fyl.fytxt.*

fun main(args: Array<String>) = runBlocking {
	FYTxtConfig.updateGroup(FYTxtGroups.Common)
	if (args.isNotEmpty()) FYTxtConfig.updateTags(listOf(args.first()), true)
	println("${FYTxt.已知语言}: ${FYTxtConfig.locTags.value.joinToString(", ")}")
	println("${FYTxt.可用语言}: ${FYTxtConfig.activeTags.value.joinToString(", ")}")
	println("${FYTxt.当前语言组}: ${FYTxtConfig.activeGroup.value!!.name}")
	println(
		"${FYTxt.翻译率}: ${
		FYTxtGroups.entries.joinToString("\n") {
			"${it.name}:  ${
				it.stats.map { (tag, stat) -> "$tag: ${(stat * 1000).toInt() / 10.0}%" }.joinToString(", ")
			}"
		}
	}")
}