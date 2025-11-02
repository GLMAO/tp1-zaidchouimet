package org.emp.gl.core.launcher;

import org.emp.gl.clients.Horloge;
import org.emp.gl.clients.CompteARebours;
import org.emp.gl.time.service.impl.DummyTimeServiceImpl;

public class App {
    public static void main(String[] args) throws InterruptedException {

        DummyTimeServiceImpl timer = new DummyTimeServiceImpl();

        Horloge h1 = new Horloge("Num 1");
        h1.setTimerService(timer);

        new CompteARebours(5, timer);
        new CompteARebours(8, timer);
        new CompteARebours(12, timer);

        Thread.sleep(15000); // attendre un peu avant d'arrêter
    }
}
