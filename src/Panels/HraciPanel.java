package Panels;

import Mapa.*;
import Player.Hrac;
import Vozidla.Auto;
import Vozidla.Log;
import Vozidla.RychleAuto;
import Vozidla.VelkeAuto;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JLabel;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
/**
 * Trieda HraciPanel predstavuje tú najdôležitejšiu triedu celého programu (hry), keďže obsahuje vykreslovanie všetkých objektov uložených v ArrayListoch, vykreslovanie hráča a metódy ktoré tvoria celú logiku hry.
 * Trieda taktiež slúži na pridanie objektov do ArrayListov, inicializovanie používaných premenných a vytvorenie JLabelu skóre (textu).
 * Pri tvorení triedy som si pomáhal tutoriálom (https://www.youtube.com/watch?v=Icd2gAHDSfY) -> pochopenie fungovania JFrame, TimerTask, tvorba hry, implementovanie ActionListeneru.
 * Pri importoch knižníc Calendar, Date a ich používaní som si pomohol tutoriálom (https://stackoverflow.com/questions/180158/how-do-i-time-a-methods-execution-in-java).
 * Pri používaní PrintWriteru som si pomohol tutoriálom (https://www.javatpoint.com/java-printwriter-class).
 * 
 */
public class HraciPanel extends javax.swing.JPanel implements ActionListener {
    private Date zaciatok;
    private Date koniecHry;
    private Level level;
    private Timer gameTimer;
    private Hrac hrac;
    
    private int pocetZivotov;
    private int pocetSkore;
    private int pocitadlo;
    private int pocitadloZivotov;
    
    private ArrayList<Zivoty> zivot = new ArrayList<>();
    private ArrayList<Cesta> cesty = new ArrayList<>();
    private ArrayList<Ciary> ciara = new ArrayList<>();
    private ArrayList<Trava> travy = new ArrayList<>();
    private ArrayList<Voda> vody = new ArrayList<>();
    private ArrayList<Stlpik> stlp = new ArrayList<>();
    private ArrayList<RychleAuto> rychleAutoDolava = new ArrayList<>();
    private ArrayList<RychleAuto> rychleAutoDoprava = new ArrayList<>();
    private ArrayList<Auto> autoDoprava = new ArrayList<>();
    private ArrayList<Auto> autoDolava = new ArrayList<>();
    private ArrayList<VelkeAuto> velkeAutoDoprava = new ArrayList<>();
    private ArrayList<VelkeAuto> velkeAutoDolava = new ArrayList<>();
    private ArrayList<Log> logDoprava = new ArrayList<>();
    private ArrayList<Log> logDolava = new ArrayList<>();
    
    private JLabel skore = new JLabel("");
    /**
     * Konštruktor triedy HraciPanel vytvára nový objekt HRÁČA, nastavuje počet začiatočných ŽIVOTOV, počet začiatočného SKÓRE, začiatočný LEVEL, POČÍTADLÁ používaných v programe a inicializuje hrací LEVEL1.
     * Taktiež v sebe uschováva TimerTasky, ktoré obsahujú ďaľšie metódy.
     */
    public HraciPanel() {
        this.zaciatok = zaciatok;
        this.koniecHry = koniecHry;
        this.hrac = new Hrac(375, 720, this);
        this.pocetZivotov = 3;
        this.pocetSkore = 0;
        this.pocitadlo = 0;
        this.pocitadloZivotov = 0;
        this.level = Level.LEVEL1;
        this.skore = skore;
        
        this.zaciatok = Calendar.getInstance().getTime();
        this.vytvorLevel1();

        
        this.gameTimer = new Timer();
        this.gameTimer.schedule(new TimerTask() {
            
            @Override
            /**
             * Metóda run() v závislosti od práve hrajúceho sa LEVELU volá metódy tikov hracích objektov (Logy, Autá) a každú chvíľu volá metódy tejto triedy, ktoré kontrolujú či nenastala kolízia medzi hráčom a objektami.
             * Metóda taktiež používa príkaz repaint() pomocou ktorého dané objekty aj prekresluje.
             * Metóda sa nachádza v TimerTasku, teda sa neustále opakuje.
             */
            public void run() {
                if (HraciPanel.this.level.getLevel() == 3) {
                    for (Log log: HraciPanel.this.logDolava) {
                        log.tikDolava();
                    }
                    for (RychleAuto rychleAuto : HraciPanel.this.rychleAutoDoprava) {
                        rychleAuto.tikDoprava();
                    }
                    for (VelkeAuto velkeAuto : HraciPanel.this.velkeAutoDolava) { 
                        velkeAuto.tikDolava();
                    }
                    for (Auto auto : HraciPanel.this.autoDoprava) { 
                        auto.tikDoprava();
                    }
                    for (Auto auto : HraciPanel.this.autoDolava) { 
                        auto.tikDolava();
                    }
                }
                if (HraciPanel.this.level.getLevel() == 2) {
                    for (Auto auto: HraciPanel.this.autoDoprava) {
                        auto.tikDoprava();
                    }
                    for (Auto auto: HraciPanel.this.autoDolava) {
                        auto.tikDolava();
                    }
                    for (Log log: HraciPanel.this.logDolava) {
                        log.tikDolava();
                    }
                    for (Log log: HraciPanel.this.logDoprava) {
                        log.tikDoprava();
                    }
                    for (RychleAuto rychleAuto: HraciPanel.this.rychleAutoDolava) {
                        rychleAuto.tikDolava();
                    }
                    for (RychleAuto rychleAuto : HraciPanel.this.rychleAutoDoprava) { 
                        rychleAuto.tikDoprava();
                    }
                    HraciPanel.this.jeKuskomStlpik();
                    HraciPanel.this.jeNaStlpiku();
                }
                if (HraciPanel.this.level.zistiLevel()) {
                    for (VelkeAuto velkeAuto: HraciPanel.this.velkeAutoDoprava) {
                        velkeAuto.tikDoprava();
                    }
                    for (VelkeAuto velkeAuto: HraciPanel.this.velkeAutoDolava) {
                        velkeAuto.tikDolava();
                    }
                    for (Log log: HraciPanel.this.logDolava) {
                        log.tikDolava();
                    }
                    for (RychleAuto rychleAuto: HraciPanel.this.rychleAutoDolava) {
                        rychleAuto.tikDolava();
                    }
                    for (RychleAuto rychleAuto : HraciPanel.this.rychleAutoDoprava) {
                        rychleAuto.tikDoprava();
                    }
                }
                if (HraciPanel.this.level.getLevel() != 4) {
                    HraciPanel.this.kontrolaZivotov();
                    HraciPanel.this.jeNaLoguDoprava();
                    HraciPanel.this.jeNaLoguDolava();
                    HraciPanel.this.jeKuskomDoprava();
                    HraciPanel.this.jeKuskomDolava();
                    HraciPanel.this.kontrolaKolizieVody();
                    HraciPanel.this.kontrolaLevelu();
                    HraciPanel.this.kontrolaKolizieAuto();
                    HraciPanel.this.kontrolaAut();
                    HraciPanel.this.kontrolaLogov();
                }
                repaint();
            }
        }, 0, 17);
        
        this.gameTimer.schedule(new TimerTask() {
            
            @Override
            /**
             * Metóda run() volá metódu hráča (set()) a prekresluje hráčovu pozíciu.
             * Metóda sa nachádza v TimerTasku, teda sa neustále opakuje.
             * Používa príkaz repaint() aby mohla prekresliť hráčove pozície, pokiaľ sa hýbe vďaka metóde hrac.set() v triede Hrac.
             */
            public void run() {
                HraciPanel.this.hrac.set();
                repaint();
            }
        }, 0, 80);
        
    }
    /**
     * Metóda getPocetZivotov() slúži na vrátenie int hodnoty pocetZivotov.
     */
    public int getPocetZivotov() {
        return this.pocetZivotov;
    }
    /**
     * Metóda getPocitadlo() slúži na vrátenie int hodnoty pocitadlo.
     */
    public int getPocitadlo() {
        return this.pocitadlo;
    }
    /**
     * Metóda kontrolaLevelu() slúži na prekreslenie LEVELU a zvýšenie hodnoty LEVELU, prekreslenie polohy hráča pokiaľ sa hráč ocitne na konci daného LEVELU.
     */
    public void kontrolaLevelu() {
        if (this.hrac.getY() + this.hrac.getVyska() <= 0) {
            this.level.zvysLevel();
            this.prekresliLevel();
            this.hrac.reset();
        }
    }
    /**
     * Metóda kontrolaZivotov() slúži na odpočet životov ak nastane kolízia hráča a vozidla alebo hráča a vody, na základe počtu životov ich pridáva do ArrayListu, či vymazáva objekty pokiaľ hráč dosiahne 0 životov (ukončenie hry).
     * Taktiež v sebe obsahuje príkaz Thread.sleep, ktorý slúži na pridanie input lagu v prípade, že hráč narazí do objektu (nastane kolízia).
     */
    public void kontrolaZivotov() {
        if (this.kontrolaKolizieAuto() || this.kontrolaKolizieVody()) {
            try {
                Thread.sleep(400);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            this.hrac.reset();
            this.pocetZivotov = this.pocetZivotov - 1;
        }
        if (this.pocitadlo != 1) {
            switch (this.pocetZivotov) {
                case 3:
                    if (this.pocitadloZivotov != 3) {
                        for (int i = 0; i < 75; i += 25) {
                            this.zivot.add(new Zivoty(0 + i, 0));
                        }
                    }
                    this.pocitadloZivotov = 3;
                    break;
                case 2:
                    if (this.pocitadloZivotov != 2) {
                        this.zivot.clear();
                        for (int i = 0; i < 50; i += 25) {
                            this.zivot.add(new Zivoty(0 + i, 0));
                        }
                    }
                    this.pocitadloZivotov = 2;
                    break;
                case 1:
                    if (this.pocitadloZivotov != 1) {
                        this.zivot.clear();
                        this.zivot.add(new Zivoty(0, 0));
                    }
                    this.pocitadloZivotov = 1;
                    break;
                case 0:
                    this.zivot.clear();
                    this.koniecHry = Calendar.getInstance().getTime();
                    this.prekresliLevel();
                    this.koniec();
                    break;
            }
        }
        if (this.level.getLevel() == 3 && this.hrac.getY() == 0) {
            if (this.pocitadlo == 0) {
                this.logDoprava.clear();
                this.logDolava.clear();
                this.autoDolava.clear();
                this.autoDoprava.clear();
                this.rychleAutoDolava.clear();
                this.rychleAutoDoprava.clear();
                this.velkeAutoDoprava.clear();
                this.velkeAutoDolava.clear();
                this.zivot.clear();
                this.travy.clear();
                this.vody.clear();
                this.cesty.clear();
                this.ciara.clear();
                this.stlp.clear();
                this.koniec();
            }
            this.pocitadlo = 1;
        }
    }
    /**
     * Metóda jeKuskomStlpik() kontroluje, či sa Y pozícia hráča nerovná 60 (Y pozícia kde je vykreslený objekt Stlpik a zároveň na tej pozícii môže byť aj Log) a zároveň či nie je kúskom svojej výšky zároveň aj na objekte Log.
     */
    public boolean jeKuskomStlpik() {
        boolean pravdivost = false;
        for (Log log : this.logDolava) {
            if (this.hrac.getY() == 60 && this.hrac.getX() >= log.getX() && this.hrac.getX() + this.hrac.getSirka() <= log.getX() + log.getSirka()) {
                pravdivost = true;
            }
        }
        for (Stlpik stlpik : this.stlp) {  
            if (this.hrac.getY() == 60 && this.hrac.getX() >= stlpik.getX() && this.hrac.getX() + this.hrac.getSirka() <= stlpik.getX() + stlpik.getSirka() &&
                    pravdivost) { 
                return true;
            } 
        }   
        return false;
    }
    /**
     * Metóda jeNaStlpiku() kontroluje, či sa X a Y pozícia hráča nenachádza na objekte STLPIK, a teda neplatí kolízia s objektom VODA.
     */
    public boolean jeNaStlpiku() {
        for (Stlpik stlpik : this.stlp) {
            if (this.hrac.getX() >= stlpik.getX() && this.hrac.getX() + this.hrac.getSirka() <= stlpik.getX() + stlpik.getSirka() && this.hrac.getY() >= stlpik.getY() &&
                    this.hrac.getY() + this.hrac.getVyska() <= stlpik.getY() + stlpik.getVyska()) {
                return true;
            }   
        }
        return false;
    }
    /**
     * Metóda jeKuskomDoprava() kontroluje či sa hráčove Y pozície v určitých bodoch a X pozície všeobecne nenachádzajú kúskom výšky a zároveň šírky na objekte LOGU ktorý sa posúva doprava.
     */
    public boolean jeKuskomDoprava() {
        if (this.level.getLevel() == 2) {
            for (Log log: this.logDoprava) {
                if (this.hrac.getY() == 270 && this.hrac.getX() >= log.getX() && this.hrac.getX() + this.hrac.getSirka() <= log.getX() + log.getSirka()
                    || this.hrac.getY() == 255 && this.hrac.getX() >= log.getX() && this.hrac.getX() + this.hrac.getSirka() <= log.getX() + log.getSirka()
                    || this.hrac.getY() == 225 && this.hrac.getX() >= log.getX() && this.hrac.getX() + this.hrac.getSirka() <= log.getX() + log.getSirka()
                    || this.hrac.getY() == 210 && this.hrac.getX() >= log.getX() && this.hrac.getX() + this.hrac.getSirka() <= log.getX() + log.getSirka()
                    || this.hrac.getY() == 165 && this.hrac.getX() >= log.getX() && this.hrac.getX() + this.hrac.getSirka() <= log.getX() + log.getSirka()
                    || this.hrac.getY() == 150 && this.hrac.getX() >= log.getX() && this.hrac.getX() + this.hrac.getSirka() <= log.getX() + log.getSirka()
                    || this.hrac.getY() == 120 && this.hrac.getX() >= log.getX() && this.hrac.getX() + this.hrac.getSirka() <= log.getX() + log.getSirka()
                    || this.hrac.getY() == 105 && this.hrac.getX() >= log.getX() && this.hrac.getX() + this.hrac.getSirka() <= log.getX() + log.getSirka()) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * Metóda jeKuskomDolava() kontroluje, či sa hráčove Y pozície v určitých bodoch a X pozície všeobecne nenachádzajú kúskom výšky a zároveň šírky na objekte LOGU ktorý sa posúva doľava.
     * V LEVELOCH 1 a 3 nastáva situácia, kedy môže byť hráč kúskom "tela" na logu a zároveň na objekte TRÁVA a teda neplatí kolízia s objektom VODA.
     * V LEVELI 2 nastáva situácia, kedy môže byť hráč pri prechode cez VODU kúskom "tela" zároveň na jednom LOGU a zároveň na druhom LOGU a teda neplatí kolízia s objektom VODA.
     */
    public boolean jeKuskomDolava() {
        if (this.level.getLevel() == 1) { 
            for (Log log : this.logDolava) {
                if (
                    this.hrac.getY() == 345 && this.hrac.getX() >= log.getX() && this.hrac.getX() + this.hrac.getSirka() <= log.getX() + log.getSirka()
                        || this.hrac.getY() == 330 && this.hrac.getX() >= log.getX() && this.hrac.getX() + this.hrac.getSirka() <= log.getX() +
                    log.getSirka()
                        || this.hrac.getY() == 270 && this.hrac.getX() >= log.getX() && this.hrac.getX() + this.hrac.getSirka() <= log.getX() +
                    log.getSirka()
                        || this.hrac.getY() == 285 && this.hrac.getX() >= log.getX() && this.hrac.getX() + this.hrac.getSirka() <= log.getX() +
                    log.getSirka()
                        || this.hrac.getY() == 285 && this.hrac.getX() >= log.getX() && this.hrac.getX() + this.hrac.getSirka() <= log.getX() +
                    log.getSirka()
                        || this.hrac.getY() == 315 && this.hrac.getX() >= log.getX() && this.hrac.getX() + this.hrac.getSirka() <= log.getX() +
                    log.getSirka()) { 
                    return true;
                }
            }
        }
        if (this.level.getLevel() == 2) { 
            for (Log log : this.logDolava) {
                if (
                    this.hrac.getY() == 315 && this.hrac.getX() >= log.getX() && this.hrac.getX() + this.hrac.getSirka() <= log.getX() + log.getSirka()
                        || this.hrac.getY() == 270 && this.hrac.getX() >= log.getX() && this.hrac.getX() + this.hrac.getSirka() <= log.getX() +
                    log.getSirka() && this.jeKuskomDoprava()
                        || this.hrac.getY() == 255 && this.hrac.getX() >= log.getX() && this.hrac.getX() + this.hrac.getSirka() <= log.getX() +
                    log.getSirka() && this.jeKuskomDoprava()
                        || this.hrac.getY() == 225 && this.hrac.getX() >= log.getX() && this.hrac.getX() + this.hrac.getSirka() <= log.getX() +
                    log.getSirka() && this.jeKuskomDoprava()
                        || this.hrac.getY() == 210 && this.hrac.getX() >= log.getX() && this.hrac.getX() + this.hrac.getSirka() <= log.getX() +
                    log.getSirka() && this.jeKuskomDoprava()
                        || this.hrac.getY() == 165 && this.hrac.getX() >= log.getX() && this.hrac.getX() + this.hrac.getSirka() <= log.getX() +
                    log.getSirka() && this.jeKuskomDoprava()
                        || this.hrac.getY() == 150 && this.hrac.getX() >= log.getX() && this.hrac.getX() + this.hrac.getSirka() <= log.getX() +
                    log.getSirka() && this.jeKuskomDoprava()
                        || this.hrac.getY() == 120 && this.hrac.getX() >= log.getX() && this.hrac.getX() + this.hrac.getSirka() <= log.getX() +
                    log.getSirka() && this.jeKuskomDoprava()
                        || this.hrac.getY() == 105 && this.hrac.getX() >= log.getX() && this.hrac.getX() + this.hrac.getSirka() <= log.getX() +
                    log.getSirka() && this.jeKuskomDoprava()) {  
                    return true;
                }
            }
        }
        if (this.level.getLevel() == 3) {
            for (Log log : this.logDolava) {
                if (
                    this.hrac.getY() == 390 && this.hrac.getX() >= log.getX() && this.hrac.getX() + this.hrac.getSirka() <= log.getX() + log.getSirka()
                        || this.hrac.getY() == 375 && this.hrac.getX() >= log.getX() && this.hrac.getX() + this.hrac.getSirka() <= log.getX() + log.getSirka()
                        || this.hrac.getY() == 345 && this.hrac.getX() >= log.getX() && this.hrac.getX() + this.hrac.getSirka() <= log.getX() + log.getSirka()
                        ||  this.hrac.getY() == 330 && this.hrac.getX() >= log.getX() && this.hrac.getX() + this.hrac.getSirka() <= log.getX() + log.getSirka()) {
                    return true;
                }
            }
        }
        return false;
    }   
    /**
     * Metóda jeNaLoguDoprava() kontroluje, či sa hráčove X a Y pozície nachádzajú na hodnotách X, Y, ŠÍRKA a VÝŠKA objektu LOG, ktorý smeruje doprava.
     */
    public boolean jeNaLoguDoprava() {
        for (Log log: this.logDoprava) {
            if ( this.hrac.getX() >= log.getX() && this.hrac.getX() + this.hrac.getSirka() <= log.getX() + log.getSirka() && this.hrac.getY() >= log.getY() &&
                this.hrac.getY() + this.hrac.getVyska() <= log.getY() + log.getVyska()
                || (this.hrac.getX() + this.hrac.getSirka() >= log.getX() && this.hrac.getX() <= log.getX() + log.getSirka() && this.hrac.getY() + this.hrac.getVyska() >= log.getY() &&
                this.hrac.getY() <= log.getY() + log.getVyska() && this.jeNaLoguDolava())) {
                return true;
            }
        }
        return false;
    }
    /**
     * Metóda jeNaLoguDolava() kontroluje, či sa hráčove X a Y pozície nachádzajú na hodnotách X, Y, ŠÍRKA a VÝŠKA objektu LOG, ktorý smeruje doľava.
     */
    public boolean jeNaLoguDolava() {
        for (Log log: this.logDolava) {
            if (this.hrac.getX() >= log.getX() && this.hrac.getX() + this.hrac.getSirka() <= log.getX() + log.getSirka() && this.hrac.getY() >= log.getY() &&
                this.hrac.getY() + this.hrac.getVyska() <= log.getY() + log.getVyska()) {
                return true;
            }
        }
        return false;
    }
    /**
     * Metóda kontrolaKolizieVody() slúži na kontrolu kolízie hráča s VODOU v závislosti od momentálne hraného LEVELU.
     * Používa metódy jenaLoguDolava(), jeKuskomDolava(), jeNaLoguDoprava(), jeNaStlpiku(), jeKuskomStlpik().
     */
    public boolean kontrolaKolizieVody() {
        if (this.level.getLevel() == 1) {
            for (Voda voda: this.vody) {
                if (this.hrac.getX() + this.hrac.getSirka() >= voda.getX() && this.hrac.getX() <= voda.getX() + 824 && this.hrac.getY() + this.hrac.getVyska() >= voda.getY() &&
                    this.hrac.getY() <= voda.getY() + 55 && !this.jeNaLoguDolava() && !this.jeKuskomDolava()) {                
                    return true;
                }
            }    
        }
        if (this.level.getLevel() == 2) {
            for (Voda voda: this.vody) {
                if (this.hrac.getX() + this.hrac.getSirka() >= voda.getX() && this.hrac.getX() <= voda.getX() + 824 && this.hrac.getY() + this.hrac.getVyska() >= voda.getY() &&
                    this.hrac.getY() <= voda.getY() + 264 && !this.jeNaLoguDolava() && !this.jeNaLoguDoprava() &&
                    !this.jeKuskomDolava() && !this.jeNaStlpiku() && !this.jeKuskomStlpik()) {
                    return true;
                }
            }    
        }
        if (this.level.getLevel() == 3) {
            for (Voda voda : this.vody) {
                if (this.hrac.getX() + this.hrac.getSirka() >= voda.getX() && this.hrac.getX() <= voda.getX() + 150 && this.hrac.getY() + this.hrac.getVyska() >= voda.getY() &&
                    this.hrac.getY() <= voda.getY() + 50 && !this.jeNaLoguDolava() && !this.jeKuskomDolava() && !this.jeKuskomStlpik()) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * Metóda kontrolaKolizieAuto() slúži na kontrolu kolízie hráča s objektom AUTO, RYCHLEAUTO alebo VELKEAUTO v závislosti od hraného LEVELU.
     */
    public boolean kontrolaKolizieAuto() {
        if (this.level.zistiLevel()) {
            for (VelkeAuto velkeAuto : this.velkeAutoDoprava) {
                if (this.hrac.getX() + this.hrac.getSirka() >= velkeAuto.getX() && this.hrac.getX() <= velkeAuto.getX() + velkeAuto.getSirka() &&
                    this.hrac.getY() + this.hrac.getVyska() >= velkeAuto.getY() && this.hrac.getY() <= velkeAuto.getY() + velkeAuto.getVyska()) {
                    return true;
                }
            }
            for (VelkeAuto velkeAuto : this.velkeAutoDolava) {
                if (this.hrac.getX() + this.hrac.getSirka() >= velkeAuto.getX() && this.hrac.getX() <= velkeAuto.getX() + velkeAuto.getSirka() &&
                    this.hrac.getY() + this.hrac.getVyska() >= velkeAuto.getY() && this.hrac.getY() <= velkeAuto.getY() + velkeAuto.getVyska()) {
                    return true;
                }
            }
            for (RychleAuto rychleAuto : this.rychleAutoDolava) {
                if (this.hrac.getX() + this.hrac.getSirka() >= rychleAuto.getX() && this.hrac.getX() <= rychleAuto.getX() + rychleAuto.getSirka() &&
                    this.hrac.getY() + this.hrac.getVyska() >= rychleAuto.getY() && this.hrac.getY() <= rychleAuto.getY() + rychleAuto.getVyska()) {
                    return true;
                }
            }
            for (RychleAuto rychleAuto : this.rychleAutoDoprava) {
                if (this.hrac.getX() + this.hrac.getSirka() >= rychleAuto.getX() && this.hrac.getX() <= rychleAuto.getX() + rychleAuto.getSirka() &&
                    this.hrac.getY() + this.hrac.getVyska() >= rychleAuto.getY() && this.hrac.getY() <= rychleAuto.getY() + rychleAuto.getVyska()) {
                    return true;
                }
            }
        }
        if (this.level.getLevel() == 2) {
            for (Auto auto : this.autoDoprava) {
                if (this.hrac.getX() + this.hrac.getSirka() >= auto.getX() && this.hrac.getX() <= auto.getX() + auto.getSirka() &&
                    this.hrac.getY() + this.hrac.getVyska() >= auto.getY() && this.hrac.getY() <= auto.getY() + auto.getVyska()) {
                    return true;
                }
            }
            for (Auto auto : this.autoDolava) {
                if (this.hrac.getX() + this.hrac.getSirka() >= auto.getX() && this.hrac.getX() <= auto.getX() + auto.getSirka() &&
                    this.hrac.getY() + this.hrac.getVyska() >= auto.getY() && this.hrac.getY() <= auto.getY() + auto.getVyska()) {
                    return true;
                }
            }
            for (RychleAuto rychleAuto : this.rychleAutoDolava) {
                if (this.hrac.getX() + this.hrac.getSirka() >= rychleAuto.getX() && this.hrac.getX() <= rychleAuto.getX() + rychleAuto.getSirka() &&
                    this.hrac.getY() + this.hrac.getVyska() >= rychleAuto.getY() && this.hrac.getY() <= rychleAuto.getY() + rychleAuto.getVyska()) {
                    return true;
                }
            }
            for (RychleAuto rychleAuto : this.rychleAutoDoprava) {
                if (this.hrac.getX() + this.hrac.getSirka() >= rychleAuto.getX() && this.hrac.getX() <= rychleAuto.getX() + rychleAuto.getSirka() &&
                    this.hrac.getY() + this.hrac.getVyska() >= rychleAuto.getY() && this.hrac.getY() <= rychleAuto.getY() + rychleAuto.getVyska()) {
                    return true;
                }
            }
        }
        if (this.level.getLevel() == 3) {
            for (Auto auto : this.autoDoprava) {
                if (this.hrac.getX() + this.hrac.getSirka() >= auto.getX() && this.hrac.getX() <= auto.getX() + auto.getSirka() &&
                    this.hrac.getY() + this.hrac.getVyska() >= auto.getY() && this.hrac.getY() <= auto.getY() + auto.getVyska()) {
                    return true;
                }
            }
            for (Auto auto : this.autoDolava) {
                if (this.hrac.getX() + this.hrac.getSirka() >= auto.getX() && this.hrac.getX() <= auto.getX() + auto.getSirka() &&
                    this.hrac.getY() + this.hrac.getVyska() >= auto.getY() && this.hrac.getY() <= auto.getY() + auto.getVyska()) {
                    return true;
                }
            }
            for (RychleAuto rychleAuto : this.rychleAutoDoprava) {
                if (this.hrac.getX() + this.hrac.getSirka() >= rychleAuto.getX() && this.hrac.getX() <= rychleAuto.getX() + rychleAuto.getSirka() &&
                    this.hrac.getY() + this.hrac.getVyska() >= rychleAuto.getY() && this.hrac.getY() <= rychleAuto.getY() + rychleAuto.getVyska()) {
                    return true;
                }
            }
            for (VelkeAuto velkeAuto : this.velkeAutoDolava) {
                if (this.hrac.getX() + this.hrac.getSirka() >= velkeAuto.getX() && this.hrac.getX() <= velkeAuto.getX() + velkeAuto.getSirka() &&
                    this.hrac.getY() + this.hrac.getVyska() >= velkeAuto.getY() && this.hrac.getY() <= velkeAuto.getY() + velkeAuto.getVyska()) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * Metóda kontrolaAut() kontroluje X pozície objektov AUTO, RYCHLEAUTO a VELKEAUTO.
     * Pokiaľ sa jeden z týchto objektov (smerujúcich doprava) dostane na X hodnotu 850, metóda ho vráti na X hodnotu -150 a môže sa ďalej pohybovať doprava, dokým hra/level neskončí.
     * Pokiaľ sa jeden z týchto objektov (smerujúcich doľava) dostane na Y hodnotu -150, metóda ho vráti na X hodnotu 850 a môže sa ďalej pohybovať doľava, dokým hra/level neskončí.
     */
    public void kontrolaAut() {
        if (this.level.zistiLevel()) {
            for (VelkeAuto velkeAuto : this.velkeAutoDoprava) {
                if (velkeAuto.getX() == 850) {
                    velkeAuto.setX(-150);
                }
            }
            for (VelkeAuto velkeAuto : this.velkeAutoDolava) {
                if (velkeAuto.getX() == -150) {
                    velkeAuto.setX(850);
                }
            }
            for (RychleAuto rychleAuto : this.rychleAutoDoprava) {
                if (rychleAuto.getX() == 850) {
                    rychleAuto.setX(-150);
                }
            }
            for (RychleAuto rychleAuto : this.rychleAutoDolava) {
                if (rychleAuto.getX() == -150) {
                    rychleAuto.setX(850);
                }
            }
        }
        if (this.level.getLevel() == 2) {
            for (Auto auto : this.autoDoprava) {
                if (auto.getX() == 850) {
                    auto.setX(-150);
                }
            }
            for (Auto auto : this.autoDolava) {
                if (auto.getX() == -150) {
                    auto.setX(850);
                }
            }
            for (RychleAuto rychleAuto : this.rychleAutoDolava) {
                if (rychleAuto.getX() == -150) {
                    rychleAuto.setX(850);
                }
            }
            for (RychleAuto rychleAuto : this.rychleAutoDoprava) {
                if (rychleAuto.getX() == 850) {
                    rychleAuto.setX(-150);
                }
            }
        }
        if (this.level.getLevel() == 3) {
            for (Auto auto : this.autoDoprava) {
                if (auto.getX() == 850) {
                    auto.setX(-150);
                }
            }
            for (Auto auto : this.autoDolava) {
                if (auto.getX() == -150) {
                    auto.setX(850);
                }
            }
            for (VelkeAuto velkeAuto : this.velkeAutoDolava) {
                if (velkeAuto.getX() == -150) {
                    velkeAuto.setX(850);
                }
            }
            for (RychleAuto rychleAuto : this.rychleAutoDoprava) {
                if (rychleAuto.getX() == 850) {
                    rychleAuto.setX(-150);
                }
            }
        }
    }
    /**
     * Metóda kontrolaLogov() kontroluje X pozície objektu LOG.
     * Pokiaľ sa tento objekt (smerujúci doprava) dostane na X hodnotu 850, metóda ho vráti na X hodnotu -150 a môže sa ďalej pohybovať doprava, dokým hra/level neskončí.
     * Pokiaľ sa tento objekt (smerujúci doľava) dostane na X hodnotu -150, metóda ho vráti na X hodnotu 850 a môže sa ďalej pohybovať doľava, dokým hra/level neskončí.
     */
    public void kontrolaLogov() {
        for (Log log : this.logDoprava) {
            if (log.getX() == 850) {
                log.setX(-150);
            }
        }
        for (Log log: this.logDolava) {
            if (log.getX() == -150) {
                log.setX(850);
            }
        }
    }
    /**
     * Metóda vytvorLevel1() slúži na vytvorenie LEVELU1 tým, že pridá všetky potrebné objekty LEVELU do ArrayListov ktoré sú následne v inej metóde vykreslené.
     */
    public void vytvorLevel1() {
        this.vody.add(new Voda(-1, 289));
        this.travy.add(new Trava(-1, 650));
        this.travy.add(new Trava (-1, 345));
        this.travy.add(new Trava(-1, 180));
        this.travy.add (new Trava(-1, 0));
        this.cesty.add(new Cesta(-1, 457, 824, 242));
        this.cesty.add(new Cesta(-1, 46, 824, 149));
        for (int i = 0; i < 1200; i += 300) {
            this.ciara.add(new Ciary(30 + i, 565));
            this.ciara.add(new Ciary(30 + i, 105));
        }
        for (int i = 0; i < 1250; i += 250) {
            this.velkeAutoDoprava.add(new VelkeAuto(-250 + i, 480));
        }
        for (int i = 0; i < 1250; i += 250) {
            this.velkeAutoDolava.add(new VelkeAuto(100 + i, 610));
        }
        for (int i = 0; i < 600; i += 250) {
            this.rychleAutoDoprava.add(new RychleAuto(100 + i, 50));
        }
        for (int i = 0; i < 600; i += 250) {
            this.rychleAutoDolava.add(new RychleAuto(100 + i, 140));
        }
        for (int i = 0; i < 600; i += 300) {
            this.logDolava.add(new Log(10 + i, 289));
        }
    }
    /**
     * Metóda vytvorProstredie() vytvára prostredie LEVELU2 a LEVELU3, tým že pridá všetky potrebné objekty v závislosti od LEVELU do ArrayListov.
     * V závislosti od počtu životov ktoré hráčovi zostali z minulého levelu sa pripočítáva aj SKÓRE.
     */
    public void vytvorProstredie() {
        switch (this.level.getLevel()) {
            case 2:
                switch (this.pocetZivotov) {
                    case 3:
                        this.pocetSkore = this.pocetSkore + 300;
                        break;
                    case 2:
                        this.pocetSkore = this.pocetSkore + 200;
                        break;
                    case 1:
                        this.pocetSkore = this.pocetSkore + 100;
                        break;
                }
                this.vody.add(new Voda(-1, 65));
                this.cesty.add(new Cesta(-1, 400, 824, 300));
                this.travy.add(new Trava(-1, 700));
                this.travy.add(new Trava(-1, 330));
                this.travy.add(new Trava(-1, 0));
            
                for (int i = 0; i < 750; i += 250) {
                    this.stlp.add(new Stlpik(100 + i, 40));
                }
                for (int i = 0; i < 1200; i += 300) {
                    this.ciara.add(new Ciary(15 + i, 535));
                }
                for (int i = 0; i < 900; i += 300) {
                    this.logDoprava.add(new Log(10 + i, 229));
                    this.logDoprava.add(new Log(10 + i, 125));
                }
                for (int i = 0; i < 900; i += 300) {
                    this.logDolava.add(new Log(10 + i, 280));
                    this.logDolava.add(new Log(10 + i, 177));
                    this.logDolava.add(new Log(10 + i, 74));
                }
                for (int i = 0; i < 850; i += 170) {
                    this.rychleAutoDoprava.add(new RychleAuto(100 + i, 580));
                }
                for (int i = 0; i < 850; i += 170) {
                    this.rychleAutoDolava.add(new RychleAuto(100 + i, 470));
                }
                for (int i = 0; i < 1000; i += 250) {
                    this.autoDoprava.add(new Auto(10 + i, 410));
                }
                for (int i = 0; i < 1000; i += 250) {
                    this.autoDolava.add(new Auto(10 + i, 640));
                }
                break;
            case 3:
                switch (this.pocetZivotov) {
                    case 3:
                        this.pocetSkore = this.pocetSkore + 300;
                        break;
                    case 2:
                        this.pocetSkore = this.pocetSkore + 200;
                        break;
                    case 1:
                        this.pocetSkore = this.pocetSkore + 100;
                        break;
                }
                this.travy.add(new Trava (-1, 645));
                this.travy.add(new Trava(-1, 285));
                this.travy.add(new Trava(-1, 0));
                for (int i = 0; i < 750; i += 250) {
                    this.vody.add(new Voda(70 + i, 645));
                }
                for (int i = 0; i < 800; i += 150) {
                    this.vody.add(new Voda(i, 354));
                }
                this.cesty.add(new Cesta(-1, 404, 824, 239));
                this.cesty.add(new Cesta(-1, 50, 824, 234));
                for (int i = 0; i < 1200; i += 300) {
                    this.ciara.add(new Ciary(15 + i, 154));
                    this.ciara.add(new Ciary(15 + i, 495));
                }
                for (int i = 0; i < 850; i += 170) {
                    this.rychleAutoDoprava.add(new RychleAuto(100 + i, 535));
                }
                for (int i = 0; i < 1000; i += 250) {
                    this.autoDoprava.add(new Auto(100 + i, 590));
                }
                for (int i = 0; i < 1250; i += 250) {
                    this.velkeAutoDolava.add(new VelkeAuto(-250 + i, 415));
                }
                for (int i = 0; i < 800; i += 400) {
                    this.logDolava.add(new Log(50 + i, 354));
                }
                for (int i = 0; i < 1250; i += 250) {
                    this.autoDolava.add(new Auto(10 + i, 75));
                }
                for (int i = 0; i < 1250; i += 250) {
                    this.autoDoprava.add(new Auto(10 + i, 210));
                }
                break;
        }
    }
    /**
     * Metóda prekresliLevel() slúži na prekreslenie LEVELU, vymaže všetky momentálne objekty uložené v ArrayListoch a pokiaľ má HRÁČ dostatok ŽIVOTOV, volá metódu vytvorProstredie().
     */
    public void prekresliLevel() {
        this.logDoprava.clear();
        this.logDolava.clear();
        this.autoDolava.clear();
        this.autoDoprava.clear();
        this.rychleAutoDolava.clear();
        this.rychleAutoDoprava.clear();
        this.velkeAutoDoprava.clear();
        this.velkeAutoDolava.clear();
        this.travy.clear();
        this.vody.clear();
        this.cesty.clear();
        this.ciara.clear();
        this.stlp.clear();
        
        if (this.pocetZivotov >= 1) {
            this.vytvorProstredie();
        }
    }
    /**
     * Metóda koniec() slúži na vytvorenie konečnej obrazovky, nastavuje LEVEL na KONECNYLEVEL(4).
     * V závislosti od VÝHRY/PREHRY hráča vykresľuje pomocou importov JLabel text s informáciou o výhre alebo s informáciou o prehre.
     * Pri zavolaní metódy koniec() sa ukladá premenná koniecHry, ktorá zaznamenáva čas v ktorý hráč dokončil hru.
     * Pokiaľ sa hráčovi podarilo hru vyhrať, tak mu je pripočítané skóre v závislosti od počtu ŽIVOTOV, ktoré mal pri dokončení.
     */
    public void koniec() {
        this.level = Level.KONECNYLEVEL;
        this.koniecHry = Calendar.getInstance().getTime();
        Color farba = Color.GREEN;
        
        this.setLayout(new BorderLayout());
        this.setBackground(Color.LIGHT_GRAY);
        switch (this.pocetZivotov) {
            case 3:
                this.pocetSkore = this.pocetSkore + 300;
                break;
            case 2:
                this.pocetSkore = this.pocetSkore + 200;
                break;
            case 1:
                this.pocetSkore = this.pocetSkore + 100;
                break;
            case 0:
                this.pocetSkore = this.pocetSkore;
                break;
        }
        int x;
        int x2;
        int vyska;
        int width;
        String ukoncenie;
        if (this.pocetZivotov > 0) {
            ukoncenie = "VYHRAL SI!";
            x = 180;
            x2 = 290;
            width = 700;
        } else {
            ukoncenie = "PREHRAL SI!";
            x = 160;
            x2 = 305;
            width = 550;
            farba = Color.RED;
        }
        JLabel podakovanie = new JLabel(ukoncenie);
        podakovanie.setFont(new Font("Boomer Tantrum", Font.BOLD, 80));
        podakovanie.setForeground(farba);
        podakovanie.setBounds(x, 50, width, 550);
        podakovanie.setVisible(true);
        
        JLabel klavesy = new JLabel("Klavesou ESC ukoncis hru");
        klavesy.setFont(new Font("Boomer Tantrum", Font.BOLD, 20));
        klavesy.setForeground(Color.WHITE);
        klavesy.setBounds(260, 275, 350, 200);
        klavesy.setVisible(true);

        this.skore.setFont(new Font("Boomer Tantrum", Font.BOLD, 40));
        this.skore.setForeground(Color.GREEN);
        this.skore.setBounds(x2, 280, 300, 400);
        this.skore.setVisible(true);
        this.skore.setText("SKORE: " + this.pocetSkore);
        
        this.setSize(824, 802);
        this.setVisible(true);
        this.add(this.skore);
        this.add(podakovanie);
        this.add(klavesy);
        this.zapis();
    }
   /**
    * Metóda paint(Graphics g) slúži na vykreslovanie objektov v ArrayListoch (okrem hráča). 
    * Používa import knižníc Graphics a Graphics2D.
    */
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D gtd = (Graphics2D)g;
        if (this.getPocetZivotov() >= 1) {
            for (Trava trava: this.travy) {
                trava.draw(gtd);
            }
            if (this.level.getLevel() == 3) {
                for (Voda voda : this.vody) {
                    voda.drawMalaVoda(gtd);
                }
            }
            if (this.level.getLevel() == 2) {
                for (Voda voda : this.vody) {
                    voda.drawVacsiaVoda(gtd);
                }
            }
            if (this.level.getLevel() == 1) {
                for (Voda voda: this.vody) {
                    voda.draw(gtd);
                }
            }
            for (Stlpik stlpiky : this.stlp) {
                stlpiky.draw(gtd);
            }
            for (Cesta cesta: this.cesty) {
                cesta.draw(gtd);
            }
            for (Auto auto: this.autoDoprava) {
                auto.draw(gtd);
            }
            for (Auto auto: this.autoDolava) {
                auto.drawDolava(gtd);
            }
            for (Ciary ciary: this.ciara) {
                ciary.draw(gtd);
            }
            for (Log log: this.logDoprava) {
                log.draw(gtd);
            }
            for (Log log: this.logDolava) {
                log.draw(gtd);
            }
            for (Zivoty zivoty: this.zivot) {
                zivoty.draw(gtd);
            }
            for (RychleAuto rychleAuto: this.rychleAutoDolava) {
                rychleAuto.drawDolava(gtd);
            }
            for (RychleAuto rychleAuto: this.rychleAutoDoprava) {
                rychleAuto.draw(gtd);
            }
            for (VelkeAuto velkeAuto: this.velkeAutoDoprava) { 
                velkeAuto.draw(gtd);
            }
            for (VelkeAuto velkeAuto: this.velkeAutoDolava) {
                velkeAuto.drawDolava(gtd);
            }
        }
        gtd.setFont(new Font("Boomer Tantrum", Font.BOLD, 20));
        gtd.setColor(Color.WHITE);
        if (this.level.getLevel() != 4) {
            this.hrac.draw(gtd);
            if (this.pocetSkore == 0) {
                gtd.drawString ("SKORE: " + this.pocetSkore, 705, 20);
            } else {
                gtd.drawString ("SKORE: " + this.pocetSkore, 680, 20);
            }
        } else {
            this.hrac.vymaz(gtd);
        }
    }
    /**
     * Metóda zapis() slúži na zapísanie "loga" hry (CROSS THE ROAD) do súboru "skore.txt" spoločne so skóre hráča, počtu zvyšných životov hráča a dátumu a času začiatku a konca hrania.
     * Používa import knižnice PrintWriter.
     */
    public void zapis() {
        try {
            PrintWriter writer = new PrintWriter("skore.txt", "UTF-8");
            writer.println( "..####...#####....####....####....####...........######..##..##..######..........#####....####....####...#####..");
            writer.println(".##..##..##..##..##..##..##......##................##....##..##..##..............##..##..##...##..##..##..##..##.");
            writer.println(".##......#####...##..##...####....####.............##....######..####............#####...##...##..######..##..##.");
            writer.println(".##..##..##..##..##..##......##......##............##....##..##..##..............##..##..##...##..##..##..##..##.");
            writer.println("..####...##..##...####....####....####.............##....##..##..######..........##..##...####...##..##..#####..");
            writer.println("................................................................................................................");
            
            writer.println("HRÁČ1 | " + "SKÓRE: " + this.pocetSkore + " | POČET ZVYŠNÝCH ŽIVOTOV: " + this.pocetZivotov);
            writer.println("ZAČIATOK HRANIA: " + zaciatok + " " + " | KONIEC HRANIA: " + koniecHry);
            writer.println("................................................................................................................");
            writer.println();
            writer.close();
        } catch (IOException e) {
        }
    } 
    /**
     * Metóda keyPressed(KeyEvent e) slúži na poslanie správy objektu Hrac že hráč stlačil danú klávesu (W -> keyUp (true), S -> keyDown (true), D -> keyRight (true), A -> keyLeft (true))
     * Taktiež kontroluje či hráč nestlačil KeyCode ESCAPE (tlačidlo ESC), ktoré vypne program.
     */
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'w') { 
            this.hrac.setKeyUp(true);
        }
        if (e.getKeyChar() == 's') {
            this.hrac.setKeyDown(true);
        }
        if (e.getKeyChar() == 'd') {
            this.hrac.setKeyRight(true);
        }
        if (e.getKeyChar() == 'a') { 
            this.hrac.setKeyLeft(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
    }
    /**
     * Metóda keyReleased(KeyEvent e) slúži na poslanie správy objektu Hrac že hráč pustil danú klávesu (W -> keyUp (false), S -> keyDown (false), D -> keyRight (false), A -> keyLeft (false))
     */
    public void keyReleased(KeyEvent e) {
        if (e.getKeyChar() == 'w') {
            this.hrac.setKeyUp(false); 
        }
        if (e.getKeyChar() == 's') {
            this.hrac.setKeyDown(false); 
        }
        if (e.getKeyChar() == 'd') {
            this.hrac.setKeyRight(false); 
        }
        if (e.getKeyChar() == 'a') {
            this.hrac.setKeyLeft(false);
        }
    }
    /**
     * Metóda actionPerformed(ActionEvent ae) musí byť súčasťou balíka importu knižnice ActionListener.
     */
    public void actionPerformed(ActionEvent ae) {
    }
}
