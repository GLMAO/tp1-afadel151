package org.emp.gl.clients;
import java.beans.PropertyChangeEvent;

import org.emp.Lookup;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;
public class CompteARebours implements TimerChangeListener{

    private int value;
    private final TimerService Service;
    public CompteARebours(int val)
    {   
        Lookup lookup = Lookup.getInstance();
        this.Service = (TimerService)lookup.getService(TimerService.class);
        this.value = val;
    }
  
    @Override
    public  void propertyChange(PropertyChangeEvent event)
    {
        switch (event.getPropertyName()) {
            case SECONDE_PROP:
                if (this.value > 0) {
                        this.value -= 1;
                        System.out.println("Value : "+ this.value);
                    }else if (this.value == 0){
                        System.out.println("Value reached 0");
                        Service.removeTimeChangeListener(this);
                    }
                break;
        
            default:
                break;
        }

    }
}
