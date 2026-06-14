import java.awt.event.*;
import javax.swing.*;

public class ContEtat implements ActionListener{
    Mairie mairie;
    JTextField champId;
    JLabel affNom;
    JLabel affPrenom;
    JLabel affEtat;

    public ContEtat(Mairie m, JTextField id, JLabel nom, JLabel prenom, JLabel etat){
        mairie = m;
        champId = id;
        affNom = nom;
        affPrenom = prenom;
        affEtat = etat;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        Citoyen c = mairie.chercherCitoyenParId(Integer.parseInt(champId.getText()));
        if (c == null){
            affNom.setText("------");
            affPrenom.setText("------");
            affEtat.setText("------");
        }
        else{
            affNom.setText(c.getNom());
            affPrenom.setText(c.getPrenom());
            affEtat.setText("" + c.getEtatCivil());
        }
    }
}