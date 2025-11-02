package org.emp.gl.clients;

import org.emp.gl.timer.service.TimerService;
import org.emp.gl.timer.service.TimerChangeListener;

public class Horloge implements TimerChangeListener {
    String name;
    TimerService timerService;

    public Horloge(String name) {
        this.name = name;
        System.out.println("Horloge " + name + " initialized!");
    }

    public void setTimerService(TimerService timerService) {
        this.timerService = timerService;
        timerService.addTimeChangeListener(this);
    }

    @Override
    public void propertyChange(String propertyName, Object oldValue, Object newValue) {
        // cette méthode est appelée à chaque tick du timer
        afficherHeure();
    }

    public void afficherHeure() {
        if (timerService != null)
            System.out.println(name + " affiche " +
                    timerService.getHeures() + ":" +
                    timerService.getMinutes() + ":" +
                    timerService.getSecondes());
    }
}
