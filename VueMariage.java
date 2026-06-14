import javax.swing.*;
import java.awt.*;
public class VueMariage extends JFrame{
    Mairie mairie;
    JLabel labelId1 = new JLabel("ID Epoux 1");
    JLabel labelId2 = new JLabel("ID Epoux 2");
    JLabel labelJour = new JLabel("Jour");
    JLabel labelMois = new JLabel("Mois");
    JLabel labelAnnee = new JLabel("Annee");
    JLabel message = new JLabel(" ");
    JTextField champId1 = new JTextField();
    JTextField champId2 = new JTextField();
    JTextField champJour = new JTextField();
    JTextField champMois = new JTextField();
    JTextField champAnnee = new JTextField();
    JButton boutonValider = new JButton("Valider");
    public VueMariage(Mairie m){
        mairie = m;
        setTitle("Vue Mariage");
        GridLayout layoutFenetre = new GridLayout(7, 2);
        setLayout(layoutFenetre);
        add(labelId1);
        add(champId1);
        add(labelId2);
        add(champId2);
        add(labelJour);
        add(champJour);
        add(labelMois);
        add(champMois);
        add(labelAnnee);
        add(champAnnee);
        add(message);
        add(boutonValider);
        add(new JLabel(""));
        add(new JLabel(""));
        ContMariage ct = new ContMariage(mairie, champId1, champId2, champJour, champMois, champAnnee, message);
        boutonValider.addActionListener(ct);
    }
}
