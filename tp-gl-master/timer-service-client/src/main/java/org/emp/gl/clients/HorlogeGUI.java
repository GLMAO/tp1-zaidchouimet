package org.emp.gl.clients;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.emp.gl.timer.service.TimerService;

/**
 * Horloge graphique qui écoute les changements de temps via PropertyChangeListener.
 */
public class HorlogeGUI extends JFrame implements PropertyChangeListener {

    private final JLabel labelHeure = new JLabel("00:00:00", SwingConstants.CENTER);
    private TimerService timerService;

    public HorlogeGUI(String title) {
        super(title);
        initUI();
    }

    private void initUI() {
        labelHeure.setFont(new Font("Consolas", Font.BOLD, 40));
        labelHeure.setForeground(Color.BLUE);

        this.setLayout(new BorderLayout());
        this.add(labelHeure, BorderLayout.CENTER);
        this.setSize(300, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    public void setTimerService(TimerService timerService) {
        this.timerService = timerService;
        timerService.addTimeChangeListener(evt -> propertyChange(evt));
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (timerService != null) {
            SwingUtilities.invokeLater(() -> {
                String heure = String.format("%02d:%02d:%02d",
                        timerService.getHeures(),
                        timerService.getMinutes(),
                        timerService.getSecondes());
                labelHeure.setText(heure);
            });
        }
    }
}
