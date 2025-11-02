package org.emp.gl.time.service.impl;

import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

/**
 * Implémentation de TimerService basée sur PropertyChangeSupport.
 * Permet de notifier les changements d'heure sans erreurs de concurrence.
 */
public class DummyTimeServiceImpl implements TimerService {

    private int dixiemeDeSeconde;
    private int secondes;
    private int minutes;
    private int heures;

    // 🔹 Gestionnaire d'événements pour notifier les PropertyChangeListener
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public DummyTimeServiceImpl() {
        setTimeValues();

        // Timer Java : déclenche un "tick" toutes les 100 millisecondes
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                timeChanged();
            }
        };
        timer.scheduleAtFixedRate(task, 100, 100);
    }

    /** Met à jour les valeurs de l'heure actuelle */
    private void setTimeValues() {
        LocalTime localTime = LocalTime.now();

        setSecondes(localTime.getSecond());
        setMinutes(localTime.getMinute());
        setHeures(localTime.getHour());
        setDixiemeDeSeconde(localTime.getNano() / 100_000_000);
    }

    /** Méthode appelée à chaque "tick" */
    private void timeChanged() {
        setTimeValues();
    }

    // =============================================================
    // 🔸 Gestion des écouteurs (Listeners)
    // =============================================================
    @Override
    public void addTimeChangeListener(PropertyChangeListener pl) {
        pcs.addPropertyChangeListener(pl);
    }

    @Override
    public void removeTimeChangeListener(PropertyChangeListener pl) {
        pcs.removePropertyChangeListener(pl);
    }

    // =============================================================
    // 🔸 Notification des changements de temps
    // =============================================================
    public void setDixiemeDeSeconde(int newDixiemeDeSeconde) {
        if (dixiemeDeSeconde == newDixiemeDeSeconde)
            return;

        int oldValue = dixiemeDeSeconde;
        dixiemeDeSeconde = newDixiemeDeSeconde;
        pcs.firePropertyChange(TimerChangeListener.DIXEME_DE_SECONDE_PROP, oldValue, newDixiemeDeSeconde);
    }

    public void setSecondes(int newSecondes) {
        if (secondes == newSecondes)
            return;

        int oldValue = secondes;
        secondes = newSecondes;
        pcs.firePropertyChange(TimerChangeListener.SECONDE_PROP, oldValue, newSecondes);
    }

    public void setMinutes(int newMinutes) {
        if (minutes == newMinutes)
            return;

        int oldValue = minutes;
        minutes = newMinutes;
        pcs.firePropertyChange(TimerChangeListener.MINUTE_PROP, oldValue, newMinutes);
    }

    public void setHeures(int newHeures) {
        if (heures == newHeures)
            return;

        int oldValue = heures;
        heures = newHeures;
        pcs.firePropertyChange(TimerChangeListener.HEURE_PROP, oldValue, newHeures);
    }

    // =============================================================
    // 🔸 Accesseurs
    // =============================================================
    @Override
    public int getDixiemeDeSeconde() {
        return dixiemeDeSeconde;
    }

    @Override
    public int getHeures() {
        return heures;
    }

    @Override
    public int getMinutes() {
        return minutes;
    }

    @Override
    public int getSecondes() {
        return secondes;
    }
}
