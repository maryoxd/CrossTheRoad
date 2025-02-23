package Panels;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
/**
 * Trieda Zivoty slúži na vytváranie a vykreslovanie objektu životov (srdcí) v triede HraciPanel.
 */
public class Zivoty {
    private int x;
    private int y;
    /**
     * Zivoty si pýta int hodnoty X a Y, pomocou ktorých objekt vykreslujeme na daných súradniciach.
     * Samotný konštruktor slúži na inicializovanie používaných premenných.
     * Pri vykreslovaní obrázku som si pomohol tutoriálom (https://examples.javacodegeeks.com/desktop-java/awt/drawing-an-image-example/).
     */
    public Zivoty(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Metóda draw(Graphics2D gtd) slúži na vykreslenie objektu pomocou importovanej knižnice Graphics2D.
     * Import knižnice Graphics2D vykresluje obrázok pomocou importovanej knižnice Image.
     */
    public void draw(Graphics2D gtd) {
        Image obrazok1 = Toolkit.getDefaultToolkit().getImage("pics/srdce.png");
        gtd.drawImage(obrazok1, this.x, this.y, null);
    }
}
