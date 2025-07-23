# 🌀 BorutoApp – Modern Android App with REST API & Ktor Server

BorutoApp is a fully functional, modern Android application built using **Jetpack Compose**, **Kotlin**, **Hilt**, and **MVVM architecture**. It fetches paginated data from a custom **Ktor server** and displays it in a clean, material design UI.

**Image**:

<img width="1280" height="720" alt="68747470733a2f2f692e706f7374696d672e63632f347958347658435a2f426f7275746f2e706e67" src="https://github.com/user-attachments/assets/17dd963e-3f97-4c11-b5e5-9ce6bae2138d" />



> **⚠️ This app requires its server to run**, which is implemented separately using Ktor in this repository:  
> 👉 [Ktor Server (Ktor Server)](https://github.com/BirminghamDeveloper/KtorBorutoServer)

---

## 📲 Features of BorutoApp (Android)

- ✅ Built with **Jetpack Compose** for modern declarative UI
- ✅ **Clean MVVM Architecture** with separation of concerns
- ✅ **Koin** for dependency injection
- ✅ **Ktor client** for consuming REST API
- ✅ **Paging 3** for efficient lazy loading of data
- ✅ **Room DB** for offline caching
- ✅ Animated splash screen and seamless navigation
- ✅ Displaying images using **Coil**
- ✅ Elegant UI following material guidelines

---

## 🧠 Features of DemoServer_website (Ktor Server)

- ✅ Written using **Ktor**, a lightweight Kotlin backend framework
- ✅ Provides REST API endpoints for Boruto characters
- ✅ Supports pagination and searching
- ✅ JSON serialization with Kotlinx
- ✅ Uses mock data for demonstration
- ✅ Modular and scalable project structure

---

## ⚙️ Getting Started

### Prerequisites

1. Android Studio Giraffe or newer
2. Minimum Android SDK 24
3. Kotlin 1.9+
4. Java 17
5. Internet connection for API access
6. Clone both this app and the required server

---

## 🚀 Setup Guide

### Step 1 – Clone this Android app

```bash
git clone https://github.com/BirminghamDeveloper/BorutoApp.git
