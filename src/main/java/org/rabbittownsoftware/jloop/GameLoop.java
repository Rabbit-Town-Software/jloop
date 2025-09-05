package main.java.org.rabbittownsoftware.jloop;

import java.util.ArrayList;
import java.util.List;

/**
 * GameLoop handles the main update/render cycle of a game.
 *
 * <p>
 * It runs in its own thread, targeting a configurable FPS and UPS.
 * Users can register Updatable objects, Startable objects, and
 * custom update/render callbacks.
 * </p>
 */
@SuppressWarnings("unused")
public class GameLoop implements Runnable
{
    private final LoopConfig config;
    private boolean running;
    private Thread gameThread;

    private final List<Startable> startables = new ArrayList<>();
    private final List<Updatable> updatables = new ArrayList<>();

    private Runnable renderCallback;
    private Runnable updateCallback;

    private float deltaTime;

    public GameLoop(LoopConfig config)
    {
        this.config = config;
    }

    /** Starts the game loop in a new thread. */
    public void start()
    {
        if (running) return;
        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    /** Stops the game loop and waits for the thread to finish. */
    public void stop()
    {
        running = false;
        try
        {
            if (gameThread != null) gameThread.join();
        }
        catch (InterruptedException ignored) {}
    }

    @Override
    public void run()
    {
        startAll();

        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        double nsPerUpdate = 1_000_000_000.0 / config.getTargetUPS();
        double delta = 0;

        int frames = 0;
        int ticks = 0;

        while (running)
        {
            long now = System.nanoTime();
            deltaTime = (now - lastTime) / 1_000_000_000.0f;
            delta += (now - lastTime) / nsPerUpdate;
            lastTime = now;

            while (delta >= 1)
            {
                ticks++;
                update();
                delta--;
            }

            frames++;
            render();

            if (System.currentTimeMillis() - timer >= 1000)
            {
                timer += 1000;
                System.out.println("FPS: " + frames + " | UPS: " + ticks);
                frames = 0;
                ticks = 0;
            }

            long frameTime = System.nanoTime() - now;
            long nsPerFrame = (long)(1_000_000_000.0 / config.getTargetFPS());
            long sleepMs = (nsPerFrame - frameTime) / 1_000_000;
            if (sleepMs > 0)
            {
                try { Thread.sleep(sleepMs); }
                catch (InterruptedException ignored) {}
            }
        }
    }

    private void startAll()
    {
        for (Startable s : startables) s.start();
    }

    private void update()
    {
        if (updateCallback != null) updateCallback.run();
        for (Updatable u : updatables) u.update();
    }

    private void render()
    {
        if (renderCallback != null) renderCallback.run();
    }

    public void addStartable(Startable s) { startables.add(s); }
    public void addUpdatable(Updatable u) { updatables.add(u); }

    public void setUpdateCallback(Runnable updateCallback) { this.updateCallback = updateCallback; }
    public void setRenderCallback(Runnable renderCallback) { this.renderCallback = renderCallback; }

    public float getDeltaTime() { return deltaTime; }
    public LoopConfig getConfig() { return config; }
}
