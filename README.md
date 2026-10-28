# StudentPortal

A simple Android student portal app written in Java.

## Features

- Welcome screen
- Login with email validation
- Registration
- Forgot password / reset password flow
- Dashboard
- Student profile

## Tech stack

- Java 11
- Android Gradle Plugin (Kotlin DSL build scripts)
- AndroidX AppCompat, ConstraintLayout, Material Components
- minSdk 24, targetSdk 37

## Getting started

1. Clone the repository:
   ```bash
   git clone https://github.com/<your-username>/StudentPortal.git
   ```
2. Open the folder in Android Studio.
3. Let Gradle sync, then run the `app` configuration on an emulator or device.

## Project structure

```
app/src/main/java/com/example/studentportal/
├── WelcomeActivity.java         (launcher)
├── LoginActivity.java
├── RegisterActivity.java
├── ForgotPasswordActivity.java
├── ResetPasswordActivity.java
├── DashboardActivity.java
└── ProfileActivity.java
```

## Note

Authentication is currently a demo only (no backend). Do not use it for real credentials.
