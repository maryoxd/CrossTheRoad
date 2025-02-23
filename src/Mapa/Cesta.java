package Mapa;

import java.awt.Graphics2D;
import java.awt.Color;
/**
 * Trieda Cesta slúži na vytváranie a vykreslovanie objektu cesty v triede HraciPanel.
 */
public class Cesta {
    private int x;
    private int y;
    private int sirka;
    private int vyska;
    /**
     * Cesta si pýta hodnoty X, Y, SIRKA a VYSKA, pomocou ktorých objekt vykreslujeme na daných súradniciach.
     * Samotný konštruktor slúži na inicializovanie používaných premenných.
     */
    public Cesta(int x, int y, int sirka, int vyska) {
        this.x = x;
        this.y = y;
        this.sirka = sirka;
        this.vyska = vyska;
    }
    /**
     * Metóda draw(Graphics2D gtd) slúži na vykreslenie objektu pomocou importovanej knižnice Graphics2D.
     */
    public void draw(Graphics2D gtd) {
        gtd.setColor(Color.BLACK);
        gtd.drawRect(this.x, this.y, this.sirka, this.vyska);
        gtd.fillRect(this.x, this.y, this.sirka, this.vyska);
    }
}
