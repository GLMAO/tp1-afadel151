package org.emp.gl;

import java.beans.PropertyChangeEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import org.emp.Lookup;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

public class HorlogeGUI implements TimerChangeListener {

    String name;
    JFrame frame = new JFrame();
    JLabel label = new JLabel();
    private final TimerService timerService;

    public HorlogeGUI(String name) {
        Lookup lookup = Lookup.getInstance();
        this.name = name;
        this.timerService = (TimerService)lookup.getService(TimerService.class);
        System.out.println("Horloge " + name + " initialized! with timer service");
        init();
    }

    private void init() {
        this.timerService.addTimeChangeListener(this);
        frame.setTitle("Horloge: " + name);
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(label);
        frame.setVisible(true);
        updateLabel(); 
    }

    public void updateLabel() {
        if (timerService != null) {
            String time = String.format("%02d:%02d:%02d",
                    timerService.getHeures(),
                    timerService.getMinutes(),
                    timerService.getSecondes());
            label.setText(time);
        }

    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        if (TimerChangeListener.SECONDE_PROP.equals(event.getPropertyName())) {
            SwingUtilities.invokeLater(this::updateLabel);
        }
    }
}
