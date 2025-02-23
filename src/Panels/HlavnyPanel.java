package Panels;

import KeyInput.KeyChecker;

/**
 * Trieda HlavnyPanel slúži na vytvorenie HraciehoPanelu ktorý sa zobrazuje vďaka triede HlavnyPanel.
 * Trieda taktiež slúži ako samotné zobrazovacie okno triedy HraciPanel vďaka rozšíreniu javax.swing.JFrame.
 */
public class HlavnyPanel extends javax.swing.JFrame {
    /**
     * Konštruktor triedy HlavnyPanel nastavuje lokáciu okna či pridáva keyListener do triedy HraciPanel (premenná panel).
     * Pri tvorení tried HlavnyPanel, OknoHry, HraciPanel som si pomáhal tutoriálom (https://www.youtube.com/watch?v=Icd2gAHDSfY) -> pochopenie fungovania JFrame, ako pracovať s oknami, nastavenie lokácie okna, titulku.
     */
    public HlavnyPanel() {
        HraciPanel panel = new HraciPanel();
        
        panel.setLocation(0, 0);
        panel.setSize(this.getSize());
        panel.setVisible(true);
        this.add(panel);
        addKeyListener(new KeyChecker(panel));
    }
}
