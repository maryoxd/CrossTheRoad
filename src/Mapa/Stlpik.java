package Mapa;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
/**
 * Trieda Stlpik slúži na vytváranie a vykreslovanie objektu stĺpika v triede HraciPanel.
 */
public class Stlpik { 
    private int x;
    private int y;
    private int sirka;
    private int vyska;
    /**
     * Stlpik si pýta hodnoty X a Y, pomocou ktorých objekt vykreslujeme na daných súradniciach.
     * Hodnoty sirka a vyska sú nastavené napevno, keďže sa nemenia -> obrázok má šírku a výšku 80x35.
     * Samotný konštruktor slúži na inicializovanie používaných premenných.
     * Pri vykreslovaní obrázku som si pomohol tutoriálom (https://examples.javacodegeeks.com/desktop-java/awt/drawing-an-image-example/).
     */
    public Stlpik(int x, int y) {
        this.x = x;
        this.y = y;
        this.sirka = 80;
        this.vyska = 35;
    }
    /**
     * Metóda getSirka() slúži na vrátenie hodnoty sirka.
     */
    public int getSirka() {
        return this.sirka;
    }
    /**
     * Metóda getVyska() slúži na vrátenie hodnoty vyska.
     */
    public int getVyska() {
        return this.vyska;
    }
    /**
     * Metóda getX() slúži na vrátenie hodnoty X.
     */
    public int getX() {
        return this.x;
    }
    /**
     * Metóda getY() slúži na vrátenie hodnoty Y.
     */
    public int getY() {
        return this.y;
    }
    /**
     * Metóda draw(Graphics2D gtd) slúži na vykreslenie objektu pomocou importovanej knižnice Graphics2D.
     * Import knižnice Graphics2D vykresluje obrázok pomocou importovanej knižnice Image.
     */
    public void draw(Graphics2D gtd) {
        Image obrazok1 = Toolkit.getDefaultToolkit().getImage("pics/stlpik.png");
        gtd.drawImage(obrazok1, this.x, this.y, null);
    }
}
