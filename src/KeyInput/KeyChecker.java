package KeyInput;

import Panels.HraciPanel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/**
 * Trieda KeyChecker používa importy knižníc KeyAdapter a KeyEvent, pomocou ktorých je možné zistiť, kedy hráč stlačil požadovanú klávesu (keyPressed) a kedy danú klávesu pustil (keyReleased).
 * Trieda teda priamo súvisí a používa sa na pohyb objektu hráča.
 */
public class KeyChecker extends KeyAdapter {
    private HraciPanel panel;
    /**
     * KeyChecker si pýta HraciPanel, keďže v tejto triede je potrebné zisťovať pohyb hráča.
     * Pri tvorení triedy som si pomáhal tutoriálom (https://www.youtube.com/watch?v=Icd2gAHDSfY) - vytvorenie pohybu hráča, inicializácia knižníc KeyAdapter, KeyEvent.
     */
    public KeyChecker(HraciPanel panel) {
        this.panel = panel;
    }
    @Override
    /**
     * Metóda keyPressed(KeyEvent e) slúži na zistenie, či používateľ stlačil požadovanú klávesu.
     */
    public void keyPressed(KeyEvent e) {
        this.panel.keyPressed(e);
    }
    @Override
    /**
     * Metóda keyReleased(keyEvent e) slúži na zistenie, či používateľ pustil požadovanú klávesu.
     */
    public void keyReleased(KeyEvent e) {
        this.panel.keyReleased(e);
    }
}
