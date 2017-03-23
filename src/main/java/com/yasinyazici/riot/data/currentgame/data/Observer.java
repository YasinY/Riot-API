package com.yasinyazici.riot.data.currentgame.data;

/**
 * <p>Represents an Observable state of the game, mainly used for functions like making the League of Legends client connect to a specific game as spectator.</p>
 * @author Yasin
 */
public class Observer {

    /**
     * The unique encryption key an active game has for spectators
     */
    private String encryptionKey;

    /**
     * Creates a new {@link Observer} instance
     * @param encryptionKey the encryption key
     */
    public Observer(String encryptionKey) {
        this.encryptionKey = encryptionKey;
    }

    /**
     * Gets the encryption key of the current running game
     * @return the encryption key
     */
    public String getEncryptionKey() {
        return encryptionKey;
    }
}
