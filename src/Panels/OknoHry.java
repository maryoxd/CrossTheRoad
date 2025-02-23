package Panels;

import java.awt.Dimension;
import java.awt.Toolkit;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
/**
 * Trieda OknoHry slúži na vytvorenie HlavnehoPanelu.
 */
public class OknoHry {
    /**
     * Konštruktor triedy OknoHry nastavuje veľkosť okna, vďaka importovanej knižnici Dimension taktiež jeho lokáciu podľa rozlíšenia obrazovky, zakazuje meniť veľkosť okna či nastavuje titulok okna.
     * Pri tvorení tried HlavnyPanel, OknoHry, HraciPanel som si pomáhal tutoriálom (https://www.youtube.com/watch?v=Icd2gAHDSfY) -> pochopenie fungovania JFrame, ako pracovať s oknami, nastavenie lokácie okna, titulku.  
     */
    public OknoHry() {
        HlavnyPanel panel = new HlavnyPanel();
        panel.setSize(824, 802);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        panel.setLocation((int)(screenSize.getWidth() / 2 - panel.getSize().getWidth() / 2), (int)(screenSize.getHeight() / 2 - panel.getSize().getHeight() / 2));
        
        panel.setResizable(false);
        panel.setTitle("Cross the Road | by Mário Žilinčík");
        panel.setVisible(true);
        panel.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
