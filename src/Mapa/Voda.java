package Mapa;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
/**
 * Trieda Voda slúži na vytváranie a vykreslovanie objektu Vody v triede HraciPanel.
 */
public class Voda {
    private int x;
    private int y;
    /**
     * Voda si pýta hodnoty X a Y, pomocou ktorých objekt vykreslujeme na daných súradniciach.
     * Samotný konštruktor slúži na inicializovanie používaných premenných.
     * Pri vykreslovaní obrázku som si pomohol tutoriálom (https://examples.javacodegeeks.com/desktop-java/awt/drawing-an-image-example/).
     */
    public Voda(int x, int y) {
        this.x = x;
        this.y = y;
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
    public void draw (Graphics2D gtd) {
        Image obrazok1 = Toolkit.getDefaultToolkit().getImage("pics/voda.jpg");
        gtd.drawImage(obrazok1, this.x, this.y, null);
    }
    /**
     * Metóda drawDolava(Graphics2D gtd) slúži na vykreslenie objektu pomocou importovanej knižnice Graphics2D.
     * Import knižnice Graphics2D vykresluje obárzok pomocou importovanej knižnice Image.
     * Na rozdiel od metódy draw(Graphics2D gtd) vykresluje iný obrázok toho istého objektu.
     */
    public void drawVacsiaVoda(Graphics2D gtd) {
        Image obrazok2 = Toolkit.getDefaultToolkit().getImage("pics/vodaVacsia.jpg");
        gtd.drawImage(obrazok2, this.x, this.y, null);
    }
    /**
     * Metóda drawDolava(Graphics2D gtd) slúži na vykreslenie objektu pomocou importovanej knižnice Graphics2D.
     * Import knižnice Graphics2D vykresluje obárzok pomocou importovanej knižnice Image.
     * Na rozdiel od metódy draw(Graphics2D gtd) a drawVacsiaVoda(Graphics2D gtd) vykresluje iný obrázok toho istého objektu.
     */
    public void drawMalaVoda(Graphics2D gtd) {
        Image obrazok3 = Toolkit.getDefaultToolkit().getImage("pics/vodaMala.jpg");
        gtd.drawImage(obrazok3, this.x, this.y, null);
    }

}
