package org.emp.gl.clients;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

public class CompteARebours implements PropertyChangeListener {

    private int compteur;
    private final TimerService timerService;

    public CompteARebours(int initial, TimerService timerService) {
        this.compteur = initial;
        this.timerService = timerService;

        // ✅ plus de cast, on ajoute le listener directement
        timerService.addTimeChangeListener(this);

        System.out.println("⏳ Compte à rebours démarré avec " + initial + " secondes");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // Ne réagit qu'aux changements de secondes
        if (TimerChangeListener.SECONDE_PROP.equals(evt.getPropertyName())) {
            tick();
        }
    }

    private void tick() {
        compteur--;
        System.out.println("⏳ " + compteur);

        if (compteur <= 0) {
            System.out.println("💥 Compte à rebours terminé!");
            timerService.removeTimeChangeListener(this);
        }
    }
}
