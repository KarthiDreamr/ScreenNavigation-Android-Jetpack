# ScreenNavigation-Android-Jetpack 🎉📱

Welcome to the repository for the ScreenNavigation Android application built using Jetpack Compose! This app is a simple navigation application that demonstrates the use of navigation components in Jetpack Compose. It's a fun and interactive way to explore the capabilities of Jetpack Compose. 😄🚀

## Features 🎯

### 1. Greeting Composable
- Uses `rememberNavController` to remember a `NavController` that survives configuration changes.
- Uses `NavHost` to host a navigation graph. The `NavHost` includes two routes: "first_screen" and "second_screen".
- Each route uses the `PageBuilder` composable to build its page.

### 2. PageBuilder Composable
- Uses `rememberDrawerState` to remember a `DrawerState` that survives configuration changes.
- Uses `rememberCoroutineScope` to remember a `CoroutineScope` that survives configuration changes.
- Uses `ModalNavigationDrawer` to provide a navigation drawer. The `ModalNavigationDrawer` includes a `ModalDrawerSheet` with two `NavigationDrawerItem`s.
- Each `NavigationDrawerItem` navigates to "second_screen" when clicked.
- Uses `Scaffold` to provide a layout structure for your app. The `Scaffold` includes a `TopAppBar`.
- The `TopAppBar` includes a `Row` with an `IconButton` and a `Text`. The `IconButton` opens the drawer when clicked.
- The `Scaffold`'s content is a `Box` that displays the provided `pageName` in the center.

## Screenshots 📸

*Coming soon...*

## How to run 🏃‍♂️

- Clone this repository using `git clone https://github.com/KarthiDreamr/ScreenNavigation-Android-Jetpack.git`
- Open the project in Android Studio Arctic Fox or later
- Run the app on an emulator or a physical device

## License 📝

This project is licensed under the GNU General Public License (GPL-3.0). The GPL is a strong copyleft license that requires improvements to be shared back with the community. For more information, see the LICENSE file.
