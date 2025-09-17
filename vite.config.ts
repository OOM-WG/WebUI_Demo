import {defineConfig} from 'vite'
import vue from '@vitejs/plugin-vue'
import autoprefixer from 'autoprefixer'

// https://vite.dev/config/
export default defineConfig({
	plugins: [vue()],
	css: {
		postcss: {
			plugins: [autoprefixer()]
		}
	}
})
