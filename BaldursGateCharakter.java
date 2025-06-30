
/**
 * Charaktererstellung für Baldurs Gate 1&2 sowie Icewind Dale
 * 
 * @author Jan Kemper-Cusimano 
 * @version 29.06.2025
 */
import java.util.List;
import java.util.Random;

public class BaldursGateCharakter {
    private Geschlecht geschlecht;
    private Rasse rasse;
    private List<Klasse> klassen;
    private List<Fertigkeit> fertigkeiten;

    public BaldursGateCharakter(Geschlecht geschlecht, Rasse rasse, List<Klasse> klassen, List<Fertigkeit> fertigkeiten) {
        if (!istGueltigeKombination(rasse, klassen, fertigkeiten)) {
            throw new IllegalArgumentException("Ungültige Kombination aus Rasse, Klasse oder Fertigkeiten!");
        }

        this.geschlecht = geschlecht;
        this.rasse = rasse;
        this.klassen = klassen;
        this.fertigkeiten = fertigkeiten;
    }

    public static boolean istGueltigeKombination(Rasse rasse, List<Klasse> klassen, List<Fertigkeit> fertigkeiten) {
        // 1. Einschränkungen für Rasse & Klasse
        if (klassen.contains(Klasse.Zwergischer_Verteidiger) && rasse != Rasse.Zwerg) return false; // Nur Zwerge können zwergische Verteidiger sein
        
        if (rasse != Rasse.Mensch) {
            if (klassen.contains(Klasse.Paladin) || klassen.contains(Klasse.Ritter) || klassen.contains(Klasse.Inquisitor) || klassen.contains(Klasse.Geisterjäger) || klassen.contains(Klasse.Finsterer_Streiter)){
                return false; // Nur Menschen können Paladine oder Ritter sein
            }
        }
        
        // 2. Einschränkungen für Waffenfähigkeiten der Klassen
        if ((klassen.contains(Klasse.Ritter) || klassen.contains(Klasse.Kensai)) && (fertigkeiten.contains(Fertigkeit.Langbogen) || (fertigkeiten.contains(Fertigkeit.Armbrust) || fertigkeiten.contains(Fertigkeit.Kurzbogen) || fertigkeiten.contains(Fertigkeit.Schleuder)))) {
            return false; // Ritter & Kensai können keine Fernkampfwaffen führen
        }
        
        if ((klassen.contains(Klasse.Mönch) || klassen.contains(Klasse.Sonnenseelenmönch) || klassen.contains(Klasse.Mönch_des_dunklen_Mondes)) && (fertigkeiten.contains(Fertigkeit.Langbogen) || fertigkeiten.contains(Fertigkeit.Kurzbogen) || fertigkeiten.contains(Fertigkeit.Armbrust))) {
        return false;
        }
        
        return true;
    }

    public static BaldursGateCharakter generiereZufaelligenCharakter() {
        Random random = new Random();

        while (true) {
            Geschlecht geschlecht = Geschlecht.values()[random.nextInt(Geschlecht.values().length)];
            Rasse rasse = Rasse.values()[random.nextInt(Rasse.values().length)];

            List<Klasse> klassen = List.of(Klasse.values()[random.nextInt(Klasse.values().length)]);

            List<Fertigkeit> fertigkeiten = List.of(
                    Fertigkeit.values()[random.nextInt(Fertigkeit.values().length)]
            );

            if (istGueltigeKombination(rasse, klassen, fertigkeiten)) {
                return new BaldursGateCharakter(geschlecht, rasse, klassen, fertigkeiten);
            }
        }
    }

    @Override
    public String toString() {
        return "Baldur's Gate 1&2 /Icewind Dale Charakter:\n" +
                "Geschlecht: " + geschlecht + "\n" +
                "Rasse: " + rasse + "\n" +
                "Klasse: " + klassen + "\n" +
                "Fertigkeiten: " + fertigkeiten;
    }
}


