package jeu2.model;

public enum PlayerEnum {
    BLUE,
    YELLOW,
    RED,
    GREEN;

    private static PlayerEnum[] vals = values();

    public PlayerEnum next()
    {
        return vals[(this.ordinal()+1) % vals.length];
    }
}
