package com.yasinyazici.riot.data.champion.impl;

/**
 * <p>Represents the advanced informations about the champion</p>
 * @author Yasin
 */
public class ChampionData {

    /**
     * The defense attribute of the champion (on how well it's good for defense)
     */
    private int defense;

    /**
     * The magic attribute of the champion (on how well it's good for magic)
     */
    private int magic;

    /**
     * The difficulty attribute of the champion (how hard it is to play the champion)
     */
    private int difficulty;

    /**
     * The attack attribute of the champion (how good it scales with dealing damage)
     */
    private int attack;

    /**
     * Creates a new {@link ChampionData} instance
     * @param defense the defense attribute for the champion
     * @param magic the magic attribute for the champion
     * @param difficulty the difficulty attribute for the champion
     * @param attack the attack attribute for the champion
     */
    public ChampionData(int defense, int magic, int difficulty, int attack) {
        this.defense = defense;
        this.magic = magic;
        this.difficulty = difficulty;
        this.attack = attack;
    }

    /**
     * Gets the defense attribute of the champion
     * @return the defense attribute
     */
    public int getDefense() {
        return defense;
    }

    /**
     * Gets the magic attribute of the champion
     * @return the magic attribute
     */
    public int getMagic() {
        return magic;
    }

    /**
     * Gets the difficulty attribute of the champion
     * @return the difficulty attribute
     */
    public int getDifficulty() {
        return difficulty;
    }

    /**
     * Gets the attack attribute of the champion
     * @return the attack attribute
     */
    public int getAttack() {
        return attack;
    }
}
