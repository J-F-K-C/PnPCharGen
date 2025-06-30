
/**
 * Beschreiben Sie hier die Klasse CharakterGeneratorGUI.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CharakterGeneratorGUI extends JFrame {

    public CharakterGeneratorGUI() {
        // Fenstereinstellungen
        setTitle("Charakter Generator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Buttons für verschiedene Universen
        JButton btnBaldursGate = new JButton("Baldur's Gate");
        JButton btnGothic = new JButton("Gothic");

        // ActionListener für die Buttons
        btnBaldursGate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BaldursGateCharakter charakter = BaldursGateCharakter.generiereZufaelligenCharakter();
                JOptionPane.showMessageDialog(null, charakter.toString(), "Baldur's Gate 1&2 /Icewind Dale Charakter", JOptionPane.INFORMATION_MESSAGE);
            }
        });


        btnGothic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 GothicCharakter charakter = GothicCharakter.generiereZufaelligenCharakter();
                JOptionPane.showMessageDialog(null, charakter.toString(), "Gothic Charakter", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Buttons zum Fenster hinzufügen
        add(btnBaldursGate);
        add(btnGothic);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CharakterGeneratorGUI gui = new CharakterGeneratorGUI();
            gui.setVisible(true);
        });
    }
}
