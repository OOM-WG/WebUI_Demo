import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.ComposeViewport
import dev.oom_wg.purejoy.fyl.fytxt.FYTxt
import dev.oom_wg.purejoy.fyl.fytxt.FYTxtConfig
import dev.oom_wg.purejoy.fyl.fytxt.compose.FYTxtProvider
import top.yukonga.miuix.kmp.basic.*
import top.yukonga.miuix.kmp.extra.SuperDropdown
import top.yukonga.miuix.kmp.extra.SuperSwitch
import top.yukonga.miuix.kmp.theme.*

@Composable
@Preview
fun App() {
	Scaffold(topBar = { TopAppBar(title = "FYTxt") }) { padding ->
		Column(Modifier.padding(padding).verticalScroll(rememberScrollState())) {
			val locTags by FYTxtConfig.locTags.collectAsState()
			val activeTags by FYTxtConfig.activeTags.collectAsState()
			val activeGroup by FYTxtConfig.activeGroup.collectAsState()
			val lock by FYTxtConfig.lock.collectAsState()
			Card {
				BasicComponent(title = FYTxt.Text())
				BasicComponent(title = FYTxt.已知语言(), summary = locTags.joinToString(", "))
				BasicComponent(title = FYTxt.可用语言(), summary = activeTags.joinToString(", "))
				var selectedIndex by mutableStateOf((activeGroup as FYTxt.FYTxtGroups).ordinal)
				val options = FYTxt.FYTxtGroups.entries.map { it.name }
				SuperDropdown(
					title = FYTxt.当前语言组(),
					items = options,
					selectedIndex = selectedIndex,
					onSelectedIndexChange = {
						selectedIndex = it
						FYTxtConfig.updateGroup(FYTxt.FYTxtGroups.entries[selectedIndex])
					})
				SuperSwitch(
					title = FYTxt.自动更新锁(),
					checked = lock,
					onCheckedChange = { FYTxtConfig.updateTags(lock = it) })
				BasicComponent(
					title = FYTxt.翻译率(), summary = FYTxt.FYTxtGroups.entries.joinToString("\n") {
						"${it.name}:  ${
							it.stats.map { (tag, stat) ->
								"$tag: ${(stat * 1000).toInt() / 10.0}%"
							}.joinToString(", ")
						}"
					})
			}
		}
	}
}

@Composable
fun AppTheme(content: @Composable () -> Unit) {
	val controller = remember { ThemeController(ColorSchemeMode.System) }
	return MiuixTheme(controller = controller, content = content)
}

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
	FYTxtConfig.updateGroup(FYTxt.FYTxtGroups.Common)
	ComposeViewport {
		FYTxtProvider { AppTheme { App() } }
	}
}