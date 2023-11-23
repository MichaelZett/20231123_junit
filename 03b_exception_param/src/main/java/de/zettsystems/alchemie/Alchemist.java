package de.zettsystems.alchemie;

public class Alchemist {
    public Gold convertToGold(Rohstoff input) {
        return new Gold(input.menge());
    }
}
