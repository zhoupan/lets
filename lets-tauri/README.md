# Tauri + React + Typescript

This template should help get you started developing with Tauri, React and Typescript in Vite.

## Recommended IDE Setup

- [VS Code](https://code.visualstudio.com/) + [Tauri](https://marketplace.visualstudio.com/items?itemName=tauri-apps.tauri-vscode) + [rust-analyzer](https://marketplace.visualstudio.com/items?itemName=rust-lang.rust-analyzer)

## Get started

```
pnpm install
pnpm tauri android init
```

### For Desktop development, run:

```
pnpm tauri dev
```

### For Android development, run:

```
pnpm tauri android dev --force-ip-prompt
```

### For Build, run:

```
pnpm tauri build
pnpm tauri android build
```

### Upgrade from Tauri 2.0 Beta

```
pnpm update @tauri-apps/cli@latest
pnpm tauri migrate
pnpm update @tauri-apps/api@latest
pnpm update @tauri-apps/plugin-app@latest
pnpm update @tauri-apps/plugin-os@latest
pnpm update @tauri-apps/plugin-shell@latest
pnpm update @tauri-apps/plugin-window@latest
pnpm update tauri-controls@latest
cargo update
```
