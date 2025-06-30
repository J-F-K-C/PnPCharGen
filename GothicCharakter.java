
/**
 * Beschreiben Sie hier die Klasse GothicCharakter.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
import java.util.Random;

public class GothicCharakter {
    private String name;
    private String gilde;
    private int staerke;
    private int geschicklichkeit;
    private int mana;

    // Listen mit möglichen Werten
    private static final String[] GILDEN = {"Miliz", "Söldner", "Feuermagier"};

    // Konstruktor
    public GothicCharakter(String gilde) {
        this.gilde = gilde;
    }

    // Methode zur zufälligen Generierung eines Gothic-Charakters
    public static GothicCharakter generiereZufaelligenCharakter() {
        Random random = new Random();

        String name = "Held";  // Name könnte später aus einer Liste kommen
        String gilde = GILDEN[random.nextInt(GILDEN.length)];

        return new GothicCharakter(gilde);
    }

    // Methode zur Darstellung des Charakters
    public String toString() {
        return "Gilde: " + gilde;

    }
}
