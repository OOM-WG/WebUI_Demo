@file:Suppress("PackageDirectoryMismatch")

package dev.oom_wg.demo

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import android.widget.LinearLayout
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.highcapable.hikage.core.base.Hikageable
import com.highcapable.hikage.core.runtime.setState
import com.highcapable.hikage.extension.androidx.compose.ComposeView
import com.highcapable.hikage.widget.android.widget.*
import dev.oom_wg.purejoy.fyl.fytxt.*
import dev.oom_wg.purejoy.fyl.fytxt.compose.FYTxtProvider
import kotlin.system.measureTimeMillis
import com.highcapable.hikage.core.runtime.mutableStateOf as hikageStateOf

class Demo : ComponentActivity() {
	@SuppressLint("SetTextI18n")
	override fun onCreate(savedInstanceState: Bundle?) = super.onCreate(savedInstanceState).also {
		Hikageable(this) {
			LinearLayout(
				lparams = LayoutParams(matchParent = true),
				init = { orientation = LinearLayout.VERTICAL }) {
				val nativeResult = hikageStateOf("Native: Waiting...")
				val fytxtResult = hikageStateOf("FYTxt: Waiting...")
				LinearLayout(
					lparams = LayoutParams(widthMatchParent = true, height = 0) { weight = 1f },
					init = {
						orientation = LinearLayout.VERTICAL
						gravity = Gravity.CENTER
					}) {
					TextView {
						textSize = 20f
						setState(nativeResult) { text = it }
					}
					TextView {
						textSize = 20f
						setState(fytxtResult) { text = it }
					}
					Button {
						text = "Run"
						setOnClickListener {
							repeat(1000) { FYTxt.Text; getString(R.string.text) }
							var ignore = 0L
							val nativeTime = measureTimeMillis {
								repeat(100_0000) { ignore += getString(R.string.text).length }
							}
							nativeResult.value = "Native: ${nativeTime}ms"
							val fytxtTime = measureTimeMillis {
								repeat(100_0000) { ignore += FYTxt.Text.length }
							}
							fytxtResult.value = "FYTxt: ${fytxtTime + (ignore / ignore) - 1}ms"
						}
					}
				}
				ComposeView(
					lparams = LayoutParams(widthMatchParent = true, height = 0) { weight = 1f }) {
					FYTxtProvider {
						MaterialTheme {
							var test by remember { mutableStateOf(false) }
							var nativeResult by remember { mutableStateOf("Native: Waiting...") }
							var fytxtResult by remember { mutableStateOf("FYTxt: Waiting...") }
							Column(
								modifier = Modifier.fillMaxSize(),
								verticalArrangement = Arrangement.Center,
								horizontalAlignment = Alignment.CenterHorizontally
							) {
								Text(nativeResult, color = Color.White, fontSize = 20.sp)
								Text(fytxtResult, color = Color.White, fontSize = 20.sp)
								Button(onClick = { test = true }) { Text("Run") }
								if (test) {
									repeat(1000) { FYTxt.Text(); stringResource(R.string.text) }
									var ignore = 0L
									val nativeTime = measureTimeMillis {
										repeat(100_0000) { ignore += stringResource(R.string.text).length }
									}
									val fytxtTime = measureTimeMillis {
										repeat(100_0000) { ignore += FYTxtConfig.observe { FYTxt.Text }.length }
									}
									SideEffect {
										nativeResult = "Native: ${nativeTime}ms"
										fytxtResult = "FYTxt: ${fytxtTime + (ignore / ignore) - 1}ms"
										test = false
									}
								}
							}
						}
					}
				}
			}
		}.also { ui ->
			setContentView(ui.root)
		}
	}
}