use tauri::{AppHandle, Emitter, Manager, Window};

#[tauri::command]
fn download(app: AppHandle, url: String) {
    app.emit("download-started", &url).unwrap();
    for progress in [1, 15, 50, 80, 100] {
        app.emit("download-progress", 10).unwrap();
    }
    app.emit("download-finished", &url).unwrap();
}

// Learn more about Tauri commands at https://tauri.app/develop/calling-rust/
#[tauri::command]
fn greet(name: &str) -> String {
    format!("Hello, {}! You've been greeted from Rust!", name)
}
#[tauri::command]
fn minimize(window: Window) {
  let result = window.minimize();
  if result.is_ok() {
      println!("minimize ok");
  } else {
      println!("minimize err");
  }
}
#[tauri::command]
fn maximize(window: Window) {
    let result = window.maximize();
    if result.is_ok() {
        println!("maximize ok");
    } else {
        println!("maximize err");
    }
}
#[tauri::command]
fn exit(app:AppHandle) {
    app.exit(0);
}


#[cfg_attr(mobile, tauri::mobile_entry_point)]
pub fn run() {
    tauri::Builder::default()
        .plugin(tauri_plugin_shell::init())
        .plugin(tauri_plugin_os::init())
        .invoke_handler(tauri::generate_handler![greet, minimize, maximize,exit])
        .run(tauri::generate_context!())
        .expect("error while running tauri application");
}
