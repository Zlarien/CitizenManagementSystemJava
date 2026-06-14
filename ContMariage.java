import java.awt.event.*;
import javax.swing.*;

public class ContMariage implements ActionListener{
    Mairie mairie;
    JTextField champId1;
    JTextField champId2;
    JTextField champJour;
    JTextField champMois;
    JTextField champAnnee;
    JLabel message;

    public ContMariage(Mairie m, JTextField id1, JTextField id2, JTextField jour, JTextField mois, JTextField annee, JLabel msg){
        mairie = m;
        champId1 = id1;
        champId2 = id2;
        champJour = jour;
        champMois = mois;
        champAnnee = annee;
        message = msg;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        int id1 = Integer.parseInt(champId1.getText());
        int id2 = Integer.parseInt(champId2.getText());
        Citoyen c1 = mairie.chercherCitoyenParId(id1);
        Citoyen c2 = mairie.chercherCitoyenParId(id2);
        DateCivil date = new DateCivil(Integer.parseInt(champJour.getText()), Integer.parseInt(champMois.getText()), Integer.parseInt(champAnnee.getText()));
        if (!date.estValide()) {
            message.setText("Date de mariage invalide");
            return;
        }
        if (c1 == null || c2 == null){
            message.setText("ID introuvable");
        } 
        else if (!c1.estMajeur() || !c2.estMajeur()){
            message.setText("Les deux doivent etre majeurs");
        } 
        else if (c1.getEtatCivil() == EtatCivil.MARIE || c2.getEtatCivil() == EtatCivil.MARIE){
            message.setText("Un citoyen est deja marie");
        } 
        else if(c1.getEtatCivil() == EtatCivil.DECEDE || c2.getEtatCivil() == EtatCivil.DECEDE){
            message.setText("Un citoyen est decede");
        }
        else{
            Mariage mariage = new Mariage(mairie.getMariages().size() + 1, date, c1, c2, mairie);
            mairie.ajouterMariage(mariage);
            c1.ajouterMariage(mariage);
            c2.ajouterMariage(mariage);
            message.setText("Mariage enregistre");
        }
    }
}