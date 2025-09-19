import autoprefixer from 'autoprefixer'
import {defineConfig} from 'vite'

import vue from '@vitejs/plugin-vue'

// https://vite.dev/config/
export default defineConfig({
	plugins: [vue()],
	css: {
		postcss: {
			plugins: [autoprefixer()]
		}
	}
})
