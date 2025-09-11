# JLoop Documentation

Welcome to the **JLoop** user documentation!

This library provides a lightweight, standalone **game loop** for Java applications. It is designed for 2D games but can be adapted to any project that requires a fixed update/render cycle.

---
## Overview

JLoop is built around four main components:

1. **GameLoop** – Runs the update/render cycle in its own thread.  
2. **LoopConfig** – Configures target FPS/UPS and window settings.  
3. **Startable** – Interface for objects that need initialization before the loop starts.  
4. **Updatable** – Interface for objects that update each tick.

---
## Table of Contents

- [Installation](Java%20Libraries/JLoop/Documentation%20(Users)/1.%20Installation.md)  
- [GameLoop](2.%20GameLoop.md)  
- [LoopConfig](3.%20LoopConfig.md)  
- [Startable](4.%20Startable.md)  
- [Updatable](5.%20Updatable.md)  
- [Basic Demo](Java%20Libraries/JLoop/Documentation%20(Users)/6.%20Basic%20Demo.md)

---
## Getting Started

1. Create a `LoopConfig` to define FPS, UPS, and window settings.  
2. Instantiate a `GameLoop` with the config.  
3. Register your `Startable` and `Updatable` objects.  
4. Set update and render callbacks.  
5. Call `start()` to begin the loop.

