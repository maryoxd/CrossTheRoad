package Panels;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
/**
 * Trieda UvodnaPlocha slúži na vytvorenie a vykreslenie úvodnej plochy, s použitím tlačidiel (buttonov).
 * Trieda používa najmä knižnicu JFrame na vytvorenie okna, s použítím ActionListeneru ktoré slúži na fungovanie tlačidiel (buttonov).
 */
public class UvodnaPlocha extends javax.swing.JFrame implements ActionListener {
    private JFrame frame;
    private JLabel label;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private int pocetKlikov;
    /**
     * Konštruktor triedy UvodnaPlocha vytvára pomocou importovaných knižníc JFrame, JLabel a JButton okno úvodnej plochy.
     * Úvodná plocha pozostáva zo šiestich buttonov, z ktorých sú 3 zapnuté a použiteľné (button ŠTART, button SKINY LEVELOV a button KONIEC)
     * Pri tvorení triedy som  si pomáhal používaním stackoverflow, java tutorials, YouTube video.
     * (https://stackoverflow.com/questions/1064977/setting-background-images-in-jframe , https://stackoverflow.com/questions/15393385/how-to-change-text-color-of-a-jbutton , https://www.youtube.com/watch?v=-IMys4PCkIA , https://docs.oracle.com/javase/tutorial/uiswing/components/button.html)
     */
    public UvodnaPlocha() {
        this.pocetKlikov = 0;
        
        ImageIcon postava1 = new ImageIcon("pics/postava.png");
        ImageIcon postava2 = new ImageIcon("pics/postava2.png");
        ImageIcon postava3 = new ImageIcon("pics/postava3.png");
       
        this.button1 = new JButton("START");
        this.button1.setBounds(250, 100, 300, 100);
        this.button1.addActionListener(this);
        this.button1.setFocusable(false);
        this.button1.setFont(new Font("Boomer Tantrum", Font.BOLD, 35));
        this.button1.setBackground(Color.GREEN);
        this.button1.setBorder(BorderFactory.createEtchedBorder());
        
        this.button2 = new JButton("SKINY LEVELOV");
        this.button2.setBounds(175, 220, 450, 100);
        this.button2.addActionListener(this);
        this.button2.setFocusable(false);
        this.button2.setFont(new Font("Boomer Tantrum", Font.BOLD, 25));
        this.button2.setBackground(Color.cyan);
        this.button2.setBorder(BorderFactory.createEtchedBorder());
        
        this.button3 = new JButton();
        this.button3.setBounds(240, 340, 100, 60);
        this.button3.addActionListener(this);
        this.button3.setText("LEVEL 1");
        this.button3.setFont(new Font("Boomer Tantrum", Font.BOLD, 20));
        this.button3.setHorizontalTextPosition(JButton.CENTER);
        this.button3.setVerticalTextPosition(JButton.BOTTOM);
        this.button3.setForeground(Color.WHITE);
        this.button3.setFocusable(false);
        this.button3.setBorder(BorderFactory.createEtchedBorder());
        this.button3.setIcon(postava1);
        this.button3.setBackground(Color.DARK_GRAY);
        this.button3.setVisible(false);
        this.button3.setEnabled(false);
        this.button3.setDisabledIcon(postava1);
        
        this.button4 = new JButton();
        this.button4.setBounds(340, 340, 100, 60);
        this.button4.addActionListener(this);
        this.button4.setText("LEVEL 2");
        this.button4.setFont(new Font("Boomer Tantrum", Font.BOLD, 20));
        this.button4.setHorizontalTextPosition(JButton.CENTER);
        this.button4.setVerticalTextPosition(JButton.BOTTOM);
        this.button4.setForeground(Color.WHITE);
        this.button4.setFocusable(false);
        this.button4.setBorder(BorderFactory.createEtchedBorder());
        this.button4.setIcon(postava2);
        this.button4.setBackground(Color.DARK_GRAY);
        this.button4.setVisible(false);
        this.button4.setEnabled(false);
        this.button4.setDisabledIcon(postava2);
        
        this.button5 = new JButton();
        this.button5.setBounds(440, 340, 100, 60);
        this.button5.addActionListener(this);
        this.button5.setText("LEVEL 3");
        this.button5.setFont(new Font("Boomer Tantrum", Font.BOLD, 20));
        this.button5.setHorizontalTextPosition(JButton.CENTER);
        this.button5.setVerticalTextPosition(JButton.BOTTOM);
        this.button5.setForeground(Color.WHITE);
        this.button5.setFocusable(false);
        this.button5.setBorder(BorderFactory.createEtchedBorder());
        this.button5.setIcon(postava3);
        this.button5.setBackground(Color.DARK_GRAY);
        this.button5.setVisible(false);
        this.button5.setEnabled(false);
        this.button5.setDisabledIcon(postava3);
        
        this.button6 = new JButton("KONIEC");
        this.button6.setBounds(250, 340, 300, 100);
        this.button6.addActionListener(this);
        this.button6.setFocusable(false);
        this.button6.setFont(new Font("Boomer Tantrum", Font.BOLD, 35));
        this.button6.setBackground(Color.RED);
        this.button6.setForeground(Color.WHITE);
        this.button6.setBorder(BorderFactory.createEtchedBorder());
        
        this.setLayout(new BorderLayout());
        JLabel background = new JLabel(new ImageIcon("pics/uvodnaplocha.jpg"));
        background.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setSize(824, 802);
        this.setVisible(true);
        this.setResizable(false);
        this.add(this.button1);
        this.add(this.button2);
        this.add(this.button3);
        this.add(this.button4);
        this.add(this.button5);
        this.add(this.button6);
        this.add(background);
        this.setTitle("Uvodná obrazovka | Cross The Road");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((int)(screenSize.getWidth() / 2 - this.getSize().getWidth() / 2), (int)(screenSize.getHeight() / 2 - this.getSize().getHeight() / 2));
    }
    /**
     * Metóda actionPerformed(ActionEvent e) slúži na zistenie, či používateľ stlačil daný button, a ak áno, vykoná sa daný kód. 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            OknoHry oknohry = new OknoHry();
            this.dispose();
        }
        if (e.getSource() == button2) {
            this.pocetKlikov = this.pocetKlikov + 1;
            if (this.pocetKlikov % 2 == 0) {
                this.button3.setVisible(false);
                this.button4.setVisible(false);
                this.button5.setVisible(false);
                this.button6.setBounds(250, 340, 300, 100);    
            
            }
            if (this.pocetKlikov % 2 != 0) {
                this.button3.setVisible(true);
                this.button4.setVisible(true);
                this.button5.setVisible(true);
                this.button6.setBounds(250, 440, 300, 100);
            }
        }
        if (e.getSource() == button6) {
            this.dispose();
        }
    }

}
