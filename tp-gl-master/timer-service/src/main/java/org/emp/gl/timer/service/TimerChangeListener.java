package org.emp.gl.timer.service;

import java.beans.PropertyChangeListener;

public interface TimerChangeListener extends PropertyChangeListener {
    String HEURE_PROP = "heures";
    String MINUTE_PROP = "minutes";
    String SECONDE_PROP = "secondes";
    String DIXEME_DE_SECONDE_PROP = "dixieme";
}
