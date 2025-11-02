package org.emp.gl.clients;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.emp.gl.timer.service.TimerService;

/**
 * Horloge graphique qui affiche l’heure en temps réel.
 */
public class HorlogeGUI extends JFrame implements PropertyChangeListener {

    private final JLabel timeLabel = new JLabel();
    private final SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
    private TimerService timerService;

    public HorlogeGUI(TimerService timerService) {
        this.timerService = timerService;

        // 🔹 Configuration de la fenêtre
        setTitle("🕒 Horloge graphique");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        // 🔹 Style du texte
        timeLabel.setFont(new Font("Consolas", Font.BOLD, 40));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(timeLabel, BorderLayout.CENTER);
        setVisible(true);

        // 🔹 S’abonner au timer
        timerService.addTimeChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        long now = System.currentTimeMillis();
        timeLabel.setText(format.format(new Date(now)));
    }
}
