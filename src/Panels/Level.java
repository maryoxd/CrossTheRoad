package Panels;

/**
 * Enum Level slúži na nastavovanie daného hracieho levelu, od ktorého závisí ktoré objekty sa budú vykreslovať.
 * A v niektorých prípadoch aj to, ako sa bude hráč pohybovať.
 */
public enum Level {
    LEVEL1(1),
    LEVEL2(2),
    LEVEL3(3),
    KONECNYLEVEL(4);

    private int level;
    /**
     * Level si pýta hodnotu nového Levela, pomocou ktorého je možné nastaviť požadovaný level.
     */
    Level(int level) {
        this.level = level;
    }
    /**
     * Metóda getLevel() slúži na vrátenie hodnoty LEVEL.
     */
    public int getLevel() {
        return this.level;
    }
    /**
     * Metóda zvysLevel() slúži na nastavenie LEVELU o +1.
     */
    public void zvysLevel() {
        this.level = this.level + 1;
    }
    /**
     * Metóda zistiLevel() slúži na zistenie, či je momentálny LEVEL 1.
     */
    public boolean zistiLevel() {
        if (this.getLevel() == 1) {
            return true;
        }
        return false;
    }
}
