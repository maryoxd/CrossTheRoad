package Mapa;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
/**
 * Trieda Trava slúži na vytváranie a vykreslovanie objektu Trávy v triede HraciPanel.
 */
public class Trava {
    private int x;
    private int y;
    /**
     * Trava si pýta hodnoty X a Y, pomocou ktorých objekt vykreslujeme na daných súradniciach.
     * Pri vykreslovaní obrázku som si pomohol tutoriálom (https://examples.javacodegeeks.com/desktop-java/awt/drawing-an-image-example/).
     */
    public Trava(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Metóda draw(Graphics2D gtd) slúži na vykreslenie objektu pomocou importovanej knižnice Graphics2D.
     * Import knižnice Graphics2D vykresluje obrázok pomocou importovanej knižnice Image.
     */
    public void draw(Graphics2D gtd) {
        Image obrazok1 = Toolkit.getDefaultToolkit().getImage("pics/trava.png");
        gtd.drawImage(obrazok1, this.x, this.y, null);
    }
}
