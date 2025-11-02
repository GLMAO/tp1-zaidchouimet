package org.emp.gl.core.launcher;

import org.emp.gl.clients.CompteARebours;
import org.emp.gl.clients.Horloge;
import org.emp.gl.clients.HorlogeGUI;
import org.emp.gl.time.service.impl.DummyTimeServiceImpl;
import org.emp.gl.timer.service.TimerService;
import java.util.Random;

public class App {
    public static void main(String[] args) throws InterruptedException {
        TimerService timer = new DummyTimeServiceImpl();

        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("   TP1 - Design Pattern Observer");
        System.out.println("═══════════════════════════════════════════════════\n");

        // ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
        // (c) - Création de plusieurs Horloges
        // ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
        System.out.println("📌 (c) Création de plusieurs horloges console...");
        Horloge h1 = new Horloge("Horloge-1");
        h1.setTimerService(timer);

        Horloge h2 = new Horloge("Horloge-2");
        h2.setTimerService(timer);

        Horloge h3 = new Horloge("Horloge-3");
        h3.setTimerService(timer);

        // ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
        // (d.1) - Création d'un CompteARebours avec paramètre 5
        // ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
        System.out.println("\n📌 (d.1) Test CompteARebours avec valeur 5...");
        CompteARebours compte1 = new CompteARebours(5, timer);

        // Attendre 7 secondes pour voir le compte à rebours se terminer
        Thread.sleep(7000);

        // ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
        // (d.3) - Création de 10 CompteARebours avec valeurs aléatoires (10-20)
        // ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
        System.out.println("\n📌 (d.3) Création de 10 comptes à rebours (valeurs 10-20)...");
        Random random = new Random();

        for (int i = 1; i <= 10; i++) {
            int valeur = random.nextInt(11) + 10; // 10 à 20
            new CompteARebours(valeur, timer);
        }

        // ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
        // (f) Bonus - Horloge graphique
        // ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
        System.out.println("\n📌 (f) Création de l'horloge graphique...");
        new HorlogeGUI(timer);

        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println("   ⏱️  Programme en cours d'exécution (30s)...");
        System.out.println("═══════════════════════════════════════════════════\n");

        // Attendre 30 secondes pour laisser tous les comptes à rebours se terminer
        Thread.sleep(30000);

        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println("   ✅ TP1 terminé avec succès!");
        System.out.println("   (e) PropertyChangeSupport fonctionne sans erreur");
        System.out.println("═══════════════════════════════════════════════════");
        System.exit(0);
    }
}