package org.emp.gl.timer.service;

import java.beans.PropertyChangeListener;

public interface TimerService {
    void addTimeChangeListener(PropertyChangeListener pl);
    void removeTimeChangeListener(PropertyChangeListener pl);

    int getDixiemeDeSeconde();
    int getSecondes();
    int getMinutes();
    int getHeures();
}
