import { defineConfig } from "vite";
import react from "@vitejs/plugin-react";

// https://vite.dev/config/
export default defineConfig({
  plugins: [react()],
  server: {
    host: "0.0.0.0", // 외부 접속 허용
    port: 5173,
    watch: {
      usePolling: true, // 파일 변경 감지 활성화
    },
  },
});
