package org.emp.gl;

import java.beans.PropertyChangeEvent;

import org.emp.Lookup;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

public class Chronometer implements TimerChangeListener {

    private int dizieme = 0;
    private int secondes = 0;

    private boolean running = false;

    public Chronometer() {
        TimerService ts = Lookup.getInstance().getService(TimerService.class);
        ts.addTimeChangeListener(this);
    }

    public void start() {
        running = true;
    }

    public void stop() {
        running = false;
    }

    public void reset() {
        dizieme = 0;
        secondes = 0;
    }

    public boolean isRunning() {
        return running;
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (!running) return;             
        dizieme++;
        if (dizieme == 10) {
            dizieme = 0;
            secondes++;
        }
    }
    

    public int getSecondes() {
        return secondes;
    }

    public int getDizieme() {
        return dizieme;
    }
}
