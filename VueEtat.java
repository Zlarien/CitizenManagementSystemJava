import javax.swing.*;
import java.awt.*;
public class VueEtat extends JFrame{
    Mairie mairie;
    JLabel labelId = new JLabel("ID Citoyen");
    JLabel labelNom = new JLabel("Nom");
    JLabel labelPrenom = new JLabel("Prenom");
    JLabel labelEtat = new JLabel("Etat civil");
    JTextField champId = new JTextField();
    JLabel affNom = new JLabel("------");
    JLabel affPrenom = new JLabel("------");
    JLabel affEtat = new JLabel("------");
    JButton boutonAfficher = new JButton("Afficher");

    public VueEtat(Mairie m){
        mairie = m;
        setTitle("Etat d une personne");
        JPanel aff = new JPanel();
        aff.setLayout(new GridLayout(4, 2));
        aff.add(labelId);
        aff.add(champId);
        aff.add(labelNom);
        aff.add(affNom);
        aff.add(labelPrenom);
        aff.add(affPrenom);
        aff.add(labelEtat);
        aff.add(affEtat);
        setLayout(new BorderLayout());
        add(aff, BorderLayout.CENTER);
        add(boutonAfficher, BorderLayout.SOUTH);
        ContEtat ct = new ContEtat(mairie, champId, affNom, affPrenom, affEtat);
        boutonAfficher.addActionListener(ct);
    }
}
