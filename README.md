# JLoop

**JLoop** is a lightweight standalone Java game loop library for 2D games.  
It provides a configurable main loop with target FPS/UPS, delta time tracking, and simple lifecycle interfaces (`Startable`, `Updatable`).

---

## Features

- Fixed-update + variable-render loop (classic game loop pattern).
- Configurable FPS and UPS (frames per second, updates per second).
- Delta time tracking for smooth animations. 
- Interfaces for lifecycle management (`Startable`, `Updatable`).
- Simple config file integration (`config.properties`).
- Designed for **2D games**, integrates with custom renderers.

---

## Installation

### Option 1 – Manual JAR
Download the latest [release](https://github.com/Rabbit-Town-Software/jloop/releases) and add it to your project.

**Gradle**
```gradle
implementation files('libs/jloop-1.0.0.jar')
```

**Maven (local install)**
```bash
mvn install:install-file   -Dfile=jloop-1.0.0.jar   -DgroupId=org.rabbittownsoftware   -DartifactId=jloop   -Dversion=1.0.0   -Dpackaging=jar
```

### Option 2 – Source & Javadoc
Include `jloop-1.0.0-sources.jar` and `jloop-1.0.0-javadoc.jar` for inline docs in your IDE.

---

## Example Usage

```java
import org.rabbittownsoftware.jloop.*;

public class Main 
{
    public static void main(String[] args) 
    {
        Renderer renderer = new Renderer();
        TimeSystem timeSystem = new TimeSystem(1.0f);
        GameLoop gameLoop = new GameLoop(timeSystem, renderer);

        // Add an Updatable
        gameLoop.addUpdatable(() -> 
        {
            System.out.println("Updating game logic...");
        });

        // Add a Startable
        gameLoop.addStartable(() -> 
        {
            System.out.println("Game started!");
        });

        // Start loop
        gameLoop.start();
    }
}
```

---
## License

JLoop is licensed under the **GNU General Public License v3.0 (GPL-3.0)**.  
You are free to use, modify, and distribute the code, as long as any modified versions remain under the same license.

- ✔️ Commercial use allowed
- ✔️ Modifications allowed
- ✔️ Distribution allowed
- ❗ Derivative works must also be GPL-3.0 licensed

---

## Contact

Questions, bug reports, or feature requests?
- Email: [support@rabbittownsoftware.com](mailto:support@rabbittownsoftware.com)
- Or open an [issue!](https://github.com/Rabbit-Town-Software/jloop/issues/new)

---


## Rabbit Town Software

<br/>

<p align="center">
  <img src="https://github.com/Rabbit-Town-Software/misa-engine/blob/eb3aa63bad02385d2af4b7b130d1bde70e2a2715/assets/rabbittownlogo.jpg?raw=true" alt="Rabbit Town Software Logo" width="180"/>
</p>

<p align="center">
  <strong>Rabbit Town Software</strong><br/>
  Open-source. No compromise.
</p>
