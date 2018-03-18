package mainlib.controller;

/**
 * Controller notifiable interface.
 *
 * Allow Controllers to notify each other without initializing Threads.
 *
 * @author  Tancrède SUARD 11505293
 * @author  Pierre-Elliott THIBOUD 11402690
 * @version 1.0
 * @since   2018-01-17
 */
public interface LNotifiable {
    void whenNotified();
}
