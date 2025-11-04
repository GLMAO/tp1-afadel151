package org.emp.gl.core.launcher;

import org.emp.gl.clients.CompteARebours;
import org.emp.gl.time.service.impl.DummyTimeServiceImpl ;
import org.emp.gl.timer.service.TimerService;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        TimerService Service = new DummyTimeServiceImpl();
        testDuTimeService(Service);
    }

    private static void testDuTimeService(TimerService Service)
    {
        CompteARebours  compteur = new CompteARebours(5,Service);
        Service.addTimeChangeListener(compteur);
        ((DummyTimeServiceImpl) Service).setMinutes(4);
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
