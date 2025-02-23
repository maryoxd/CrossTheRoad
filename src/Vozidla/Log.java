package Vozidla;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
/**
 * Trieda Log slúži na vytváranie a vykreslovanie objektu logov (driev) v triede HraciPanel.
 */
public class Log {
    private int x;
    private int y;
    private int vyska;
    private int sirka;
    /**
     * Log si pýta hodnoty X a Y, pomocou ktorých objekt vykreslujeme na daných súradniciach. 
     * Hodnoty sirka a vyska sú nastavené napevno, keďže sa nemenia -> obrázok má šírku a výšku 150x50.
     * Samotný konštruktor slúži na inicializovanie používaných premenných.
     * Pri vykreslovaní obrázku som si pomohol tutoriálom (https://examples.javacodegeeks.com/desktop-java/awt/drawing-an-image-example/).
     */
    public Log(int x, int y) {
        this.x = x;
        this.y = y;
        this.sirka = 150;
        this.vyska = 50;
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
     * Metóda tikDoprava() slúži na zmenu hodnoty X o +1, čím je možné daný log posúvať doprava.
     */
    public void tikDoprava() {
        this.x = this.x + 1;
    }
    /**
     * Metóda tikDolava() slúži na zmenu hodnoty X o -1, čím je možné daný log posúvať doľava.
     */
    public void tikDolava() {
        this.x = this.x - 1;
    }
    /**
     * Metóda getSirka() slúži na vrátenie hodnoty sirka daného logu.
     */
    public int getSirka() {
        return this.sirka;
    }
    /**
     * Metóda getVyska() slúži na vrátenie hodnoty vyska daného logu.
     */
    public int getVyska() {
        return this.vyska;
    }
    /**
     * Metóda draw(Graphics2D gtd) slúži na vykreslenie objektu pomocou importovanej knižnice Graphics2D.
     * Import knižnice Graphics2D vykresluje obrázok pomocou importovanej knižnice Image.
     */
    public void draw(Graphics2D gtd) {
        Image obrazok1 = Toolkit.getDefaultToolkit().getImage("pics/log.png");
        gtd.drawImage(obrazok1, this.x, this.y, null);
    }
}
