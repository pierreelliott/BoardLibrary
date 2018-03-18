package mainlib.controller;

/**
 * Controller notifiable interface.
 *
 * Allow Controllers to notify each other without initializing Threads.
 */
public interface LNotifiable {
    void whenNotified();
}
