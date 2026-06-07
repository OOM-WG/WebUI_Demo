import vue from '@vitejs/plugin-vue'
import autoprefixer from 'autoprefixer'
import { defineConfig } from 'vite-plus'

export default defineConfig({
	plugins: [vue()],
	css: {
		postcss: {
			plugins: [autoprefixer()]
		}
	},
	staged: { '*': 'vp check --fix' },
	fmt: {
		arrowParens: 'avoid',
		bracketSameLine: true,
		jsxSingleQuote: true,
		semi: false,
		sortImports: true,
		sortTailwindcss: true,
		trailingComma: 'none',
		ignorePatterns: ['*-lock.*', '*.lock']
	}
})