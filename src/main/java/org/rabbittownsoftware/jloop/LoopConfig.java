package main.java.org.rabbittownsoftware.jloop;

/**
 * LoopConfig defines the configuration for a GameLoop.
 *
 * <p>
 * It provides simple control over target FPS/UPS, window size,
 * and fullscreen/decoration flags. Unlike file-based configs,
 * this is just a lightweight in-memory object.
 * </p>
 */
@SuppressWarnings("unused")
public class LoopConfig
{
    private int targetFPS = 60;
    private int targetUPS = 60;
    private int windowWidth = 800;
    private int windowHeight = 600;
    private boolean fullscreen = false;
    private boolean undecorated = false;

    public int getTargetFPS() { return targetFPS; }
    public void setTargetFPS(int targetFPS) { this.targetFPS = targetFPS; }

    public int getTargetUPS() { return targetUPS; }
    public void setTargetUPS(int targetUPS) { this.targetUPS = targetUPS; }

    public int getWindowWidth() { return windowWidth; }
    public void setWindowWidth(int windowWidth) { this.windowWidth = windowWidth; }

    public int getWindowHeight() { return windowHeight; }
    public void setWindowHeight(int windowHeight) { this.windowHeight = windowHeight; }

    public boolean isFullscreen() { return fullscreen; }
    public void setFullscreen(boolean fullscreen) { this.fullscreen = fullscreen; }

    public boolean isUndecorated() { return undecorated; }
    public void setUndecorated(boolean undecorated) { this.undecorated = undecorated; }
}
