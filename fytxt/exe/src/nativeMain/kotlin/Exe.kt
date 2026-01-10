import dev.oom_wg.purejoy.fyl.fytxt.FYTxt
import dev.oom_wg.purejoy.fyl.fytxt.FYTxtConfig
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) = runBlocking {
	FYTxtConfig.updateGroup(FYTxt.FYTxtGroups.Common)
	if (args.isNotEmpty()) FYTxtConfig.updateTags(listOf(args.first()), true)
	println("${FYTxt.已知语言}: ${FYTxtConfig.locTags.value.joinToString(", ")}")
	println("${FYTxt.可用语言}: ${FYTxtConfig.activeTags.value.joinToString(", ")}")
	println("${FYTxt.当前语言组}: ${FYTxtConfig.activeGroup.value!!.name}")
	println(
		"${FYTxt.翻译率}: ${
		FYTxt.FYTxtGroups.entries.joinToString("\n") {
			"${it.name}:  ${
				it.stats.map { (tag, stat) -> "$tag: ${(stat * 1000).toInt() / 10.0}%" }
					.joinToString(", ")
			}"
		}
	}")
}