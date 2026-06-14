import javax.swing.*;
import java.awt.*;
public class VueSaisie extends JFrame{
    Mairie mairie;
    JLabel labelId = new JLabel("ID");
    JLabel labelNom = new JLabel("Nom");
    JLabel labelPrenom = new JLabel("Prenom");
    JLabel labelJour = new JLabel("Jour");
    JLabel labelMois = new JLabel("Mois");
    JLabel labelAnnee = new JLabel("Annee");
    JLabel labelSexe = new JLabel("Sexe H/F");
    JLabel message = new JLabel(" ");
    JTextField champId = new JTextField();
    JTextField champNom = new JTextField();
    JTextField champPrenom = new JTextField();
    JTextField champJour = new JTextField();
    JTextField champMois = new JTextField();
    JTextField champAnnee = new JTextField();
    JTextField champSexe = new JTextField();
    JButton boutonValider = new JButton("Valider");

    public VueSaisie(Mairie m){
        mairie = m;
        setTitle("Vue Saisie");
        GridLayout layoutFenetre = new GridLayout(9, 2);
        setLayout(layoutFenetre);
        add(labelId);
        add(champId);
        add(labelNom);
        add(champNom);
        add(labelPrenom);
        add(champPrenom);
        add(labelJour);
        add(champJour);
        add(labelMois);
        add(champMois);
        add(labelAnnee);
        add(champAnnee);
        add(labelSexe);
        add(champSexe);
        add(message);
        add(boutonValider);
        add(new JLabel(""));
        add(new JLabel(""));
        ContSaisie ct = new ContSaisie(mairie, champId, champNom, champPrenom, champJour, champMois, champAnnee, champSexe, message);
        boutonValider.addActionListener(ct);
    }
}
