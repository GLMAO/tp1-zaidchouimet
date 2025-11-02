package org.emp.gl.clients;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.emp.gl.timer.service.TimerService;

/**
 * Horloge qui écoute les changements de temps via PropertyChangeListener.
 */
public class Horloge implements PropertyChangeListener {

    private String name;
    private TimerService timerService;

    public Horloge(String name) {
        this.name = name;
        System.out.println("Horloge " + name + " initialized!");
    }

    public void setTimerService(TimerService timerService) {
        this.timerService = timerService;
        // ✅ plus de cast vers TimerChangeListener !
        timerService.addTimeChangeListener(evt -> propertyChange(evt));
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        afficherHeure();
    }

    public void afficherHeure() {
        if (timerService != null) {
            System.out.println(name + " affiche " +
                    timerService.getHeures() + ":" +
                    timerService.getMinutes() + ":" +
                    timerService.getSecondes());
        }
    }
}
