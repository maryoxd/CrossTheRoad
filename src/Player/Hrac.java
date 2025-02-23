package Player;

import Panels.HraciPanel;
import Panels.Level;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
/**
 * Trieda Hrac predstavuje samotný objekt hráča, ktorý je možný ovládať, taktiež slúži na jeho vykreslenie v triede HraciPanel pomocou metódy draw().
 */
public class Hrac {
    private HraciPanel panel;
    
    private int x;
    private int y;
    private int vyska;
    private int sirka;
    private Level level;
    private boolean keyUp;
    private boolean keyDown;
    private boolean keyRight;
    private boolean keyLeft;
    /**
     * Hrac si pýta hodnoty X, Y a HraciPanel. Pomocou hodnôt X a Y objekt vykreslujeme na daných súradniciach. 
     * Hodnoty SIRKA a VYSKA sú nastavené napevno, keďže sa nemenia -> obrázok má šírku a výšku 30x30.
     * Na pohyb hráča sú použité boolean variable keyUp (w), keyDown (s), keyRight (d), keyLeft (a).
     * Pre správne fungovanie je použitá aj trieda Level a HraciPanel.
     * Pri vykreslovaní obrázku som si pomohol tutoriálom (https://examples.javacodegeeks.com/desktop-java/awt/drawing-an-image-example/).
     * Pri pohybe hráča v metóde set() som si pomohol tutoriálom (https://www.youtube.com/watch?v=Icd2gAHDSfY) -> prepojenie pohybu hráča medzi triedami
     * Konštruktor slúži na inicializovanie HraciehoPanela, ostatných používaných hodnôť a nastavenia LEVELU1.
     */
    public Hrac(int x, int y, HraciPanel panel) {
        this.panel = panel;
        this.x = x;
        this.y = y;
        this.sirka = 30;
        this.vyska = 30;
        this.level = this.level.LEVEL1;
        
        this.keyUp = keyUp;
        this.keyDown = keyDown;
        this.keyRight = keyRight;
        this.keyLeft = keyLeft;
    }
    /**
     * Metóda setKeyUp(boolean keyUp) slúži na nastavenie hodnoty keyUp na true, čo signalizuje že používateľ stlačil alebo drží tlačidlo W.
     */
    public void setKeyUp(boolean keyUp) {
        this.keyUp = keyUp;
    }
    /**
     * Metóda setKeyDown(boolean keyDown) slúži na nastavenie hodnoty keyDown na true, čo signalizuje že používateľ stlačil alebo drží tlačidlo S.
     */
    public void setKeyDown(boolean keyDown) {
        this.keyDown = keyDown;
    }
    /**
     * Metóda setKeyRight(boolean keyRight) slúži na nastavenie hodnoty keyRight na true, čo signalizuje že používateľ stlačil alebo drží tlačidlo D.
     */
    public void setKeyRight(boolean keyRight) {
        this.keyRight = keyRight;
    }
    /**
     * Metóda setKeyLeft(boolean keyLeft) slúži na nastavenie hodnoty keyLeft na true, čo signalizuje že používateľ stlačil alebo drží tlačidlo A.
     */
    public void setKeyLeft(boolean keyLeft) {
        this.keyLeft = keyLeft;
    }
    /**
     * Metóda setX(int x) slúži na nastavenie novej int hodnoty X hráča.
     */
    public void setX(int noveX) {
        this.x = noveX;
    }
    /**
     * Metóda getX() slúži na vrátenie int hodnoty X hráča.
     */
    public int getX() {
        return this.x;
    }    
    /**
     * Metóda setY(int noveY) slúži na nastavenie int novej hodnoty Y hráča.
     */
    public void setY(int noveY) {
        this.y = noveY;
    }
    /**
     * Metóda getY() slúži na vrátenie int hodnoty Y hráča.
     */
    public int getY() {
        return this.y;
    }
    /**
     * Metóda getSirka() slúži na vrátenie int hodnoty sirka.
     */
    public int getSirka() {
        return this.sirka;
    }
    /**
     * Metóda getVyska() slúži na vrátenie int hodnoty vyska.
     */
    public int getVyska() {
        return this.vyska;
    }
    /**
     * Metóda set() slúži primárne na pohyb hráča ktorý závisí od boolean hodnôt metód keyUp, keyDown, keyRight, keyLeft.
     * Metóda taktiež kontroluje level ktorý sa práve odohráva, a zakazuje pohyb ak by sa hráč mal pohnúť cez hracie okno.
     */
    public void set() {
        if (this.keyLeft && this.keyRight || !this.keyLeft && !this.keyRight && this.panel.getPocitadlo() != 1) { 
            this.setX(this.x);
        }  else if (this.keyLeft && !this.keyRight && this.getX() != 0 && this.panel.getPocitadlo() != 1 ) { 
            this.setX (this.x - 15);
        }   else if (this.keyRight && !this.keyLeft && this.getX() != 780 && this.panel.getPocitadlo() != 1) { 
            this.setX (this.x + 15);
        }
        if (this.keyUp && this.keyDown || !this.keyUp && !this.keyDown && this.panel.getPocitadlo() != 1) { 
            this.setY(this.y);
        }   else if (this.keyUp && !this.keyDown && this.level.getLevel() == 3 && this.getY() == 0 && this.panel.getPocitadlo() != 1) {
            this.setY(this.y);
        }   else if (this.keyUp && !this.keyDown && this.panel.getPocitadlo() != 1) { 
            this.setY(this.y - 15);
        }   else if (this.keyDown && !this.keyUp && this.getY() != 735 && this.panel.getPocitadlo() != 1) { 
            this.setY(this.y + 15);
        }
    }
    /**
     * Metóda reset() slúži na vyresetovanie X a Y pozície hráča.
     */
    public void reset() {
        this.setX(375);
        this.setY(720);
    }
    /**
     * Metóda draw(Graphics2D gtd) slúži na vykreslenie objektu pomocou importovanej knižnice Graphics2D.
     * Import knižnice Graphics2D vykresluje obrázok pomocou importovanej knižnice Image.
     * Vykreslovanie vzhľadu (skinu) hráča závisí od levelu ktorý sa práve odohráva, teda každý level vykresluje iný vzhľad.
     */
    public void draw(Graphics2D gtd) {
        Image obrazok1 = Toolkit.getDefaultToolkit().getImage("pics/postava.png");
        Image obrazok2 = Toolkit.getDefaultToolkit().getImage("pics/postava2.png");
        Image obrazok3 = Toolkit.getDefaultToolkit().getImage("pics/postava3.png");
        if (this.level.getLevel() == 1) {
            gtd.drawImage(obrazok1, this.x, this.y, null);
        }
        if (this.level.getLevel() == 2) {
            gtd.drawImage(obrazok2, this.x, this.y, null);
        }
        if (this.level.getLevel() == 3 && this.panel.getPocitadlo() != 1) {
            gtd.drawImage(obrazok3, this.x, this.y, null);
        }
    }
    /**
     * Metóda vymaz(Graphics2D gtd) slúži na vymazanie objektu hráča pomocou príkazu dispose.
     */
    public void vymaz(Graphics2D gtd) {
        gtd.dispose();
    }
}
