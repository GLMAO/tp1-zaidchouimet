package org.emp.gl.core.launcher;

import org.emp.gl.clients.Horloge;
import org.emp.gl.clients.HorlogeGUI;
import org.emp.gl.time.service.impl.DummyTimeServiceImpl;
import org.emp.gl.timer.service.TimerService;

public class App {
    public static void main(String[] args) throws InterruptedException {
        TimerService timer = new DummyTimeServiceImpl();

        // 🕒 Horloge console
        Horloge h1 = new Horloge("Console Clock");
        h1.setTimerService(timer);

        // 🖥️ Horloge graphique (fenêtre Swing)
        new HorlogeGUI(timer);

        // laisser tourner 15 secondes
        Thread.sleep(15000);
        System.exit(0);
    }
}
