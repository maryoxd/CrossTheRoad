package Mapa;

import java.awt.Graphics2D;
import java.awt.Color;
/**
 * Trieda Ciary slúži na vytváranie a vykreslovanie objektu čiar v triede HraciPanel.
 */
public class Ciary {
    private int x;
    private int y;
    private int sirka;
    private int vyska;
    /**
     * Ciary si pýta hodnoty X a Y, pomocou ktorých objekt vykreslujeme na daných súradniciach.
     * Hodnoty sirka a vyska sú nastavené napevno, keďže sa nemenia.
     * Samotný konštruktor slúži na inicializovanie používaných premenných.
     */
    public Ciary(int x, int y) {
        this.x = x;
        this.y = y;
        this.sirka = 150;
        this.vyska = 30;
    }
    /**
     * Metóda draw(Graphics2D gtd) slúži na vykreslenie objektu pomocou importovanej knižnice Graphics2D.
     */
    public void draw(Graphics2D gtd) {
        gtd.setColor(Color.WHITE);
        gtd.drawRect(this.x, this.y, this.sirka, this.vyska);
        gtd.fillRect(this.x, this.y, this.sirka, this.vyska);
    }
}
