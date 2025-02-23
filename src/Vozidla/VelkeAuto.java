package Vozidla;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
/**
 * Trieda VelkeAuto slúži na vytváranie a vykreslovanie objektu veľkého auta v triede HraciPanel.
 */
public class VelkeAuto {
    private int x;
    private int y;
    private int vyska;
    private int sirka;
    /**
     * VelkeAuto si pýta hodnoty X a Y, pomocou ktorých objekt vykreslujeme na daných súradniciach.
     * Hodnoty sirka a vyska sú nastavené napevno, keďže sa nemenia -> obrázok má šírku a výšku 150x70.
     * Samotný konštruktor slúži na inicializovanie používaných premenných.
     * Pri vykreslovaní obrázku som si pomohol tutoriálom (https://examples.javacodegeeks.com/desktop-java/awt/drawing-an-image-example/).
     */
    public VelkeAuto(int x, int y) {
        this.x = x;
        this.y = y;
        this.sirka = 150;
        this.vyska = 70;
    }
    /**
     * Metóda getY() slúži na vrátenie hodnoty Y.
     */
    public int getY() {
        return this.y;
    }
    /**
     * Metóda getX() slúži na vrátenie hodnoty X.
     */
    public int getX() {
        return this.x;
    }
    /**
     * Metóda setX(int noveX) slúži na nastavenie novej hodnoty X.
     */
    public void setX(int noveX) {
        this.x = noveX;
    }
    /**
     * Metóda tikDoprava() slúži na zmenu hodnoty X o +2, čím je možné dané veľké auto posúvať doprava.
     */
    public void tikDoprava() {
        this.x = this.x + 2;
    }
    /**
     * Metóda tikDolava() slúži na zmenu hodnoty X o -2, čím je možné dané veľké auto posúvať doľava.
     */
    public void tikDolava() {
        this.x = this.x - 2;
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
     * Metóda draw(Graphics2D gtd) slúži na vykreslenie objektu pomocou importovanej knižnice Graphics2D.
     * Import knižnice Graphics2D vykresluje obrázok pomocou importovanej knižnice Image.
     */
    public void draw(Graphics2D gtd) {
        Image obrazok1 = Toolkit.getDefaultToolkit().getImage("pics/VelkeDoprava.png");
        gtd.drawImage(obrazok1, this.x, this.y, null);
    }
    /**
     * Metóda drawDolava(Graphics2D gtd) slúži na vykreslenie objektu pomocou importovanej knižnice Graphics2D.
     * Import knižnice Graphics2D vykresluje obárzok pomocou importovanej knižnice Image.
     * Na rozdiel od metódy draw(Graphics2D gtd) vykresluje iný obrázok toho istého objektu.
     */
    public void drawDolava(Graphics2D gtd) {
        Image obrazok2 = Toolkit.getDefaultToolkit().getImage("pics/VelkeDolava.png");
        gtd.drawImage(obrazok2, this.x, this.y, null);
    }
}
