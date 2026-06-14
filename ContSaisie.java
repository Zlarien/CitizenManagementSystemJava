import java.awt.event.*;
import javax.swing.*;

public class ContSaisie implements ActionListener{
    Mairie mairie;
    JTextField champId;
    JTextField champNom;
    JTextField champPrenom;
    JTextField champJour;
    JTextField champMois;
    JTextField champAnnee;
    JTextField champSexe;
    JLabel message;
    public ContSaisie(Mairie m, JTextField id, JTextField nom, JTextField prenom, JTextField jour, JTextField mois, JTextField annee, JTextField sexe, JLabel msg){
        mairie = m;
        champId = id;
        champNom = nom;
        champPrenom = prenom;
        champJour = jour;
        champMois = mois;
        champAnnee = annee;
        champSexe = sexe;
        message = msg;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        int id = Integer.parseInt(champId.getText());
        String nom = champNom.getText();
        String prenom = champPrenom.getText();
        String sexe = champSexe.getText();
        DateCivil dateCivil = new DateCivil(Integer.parseInt(champJour.getText()), Integer.parseInt(champMois.getText()), Integer.parseInt(champAnnee.getText()));
        if (!dateCivil.estValide()) {
        message.setText("Erreur : La date n'existe pas !");
        return;
        }
        if (mairie.chercherCitoyenParId(id) != null){
            message.setText("ID deja utilise");
        } 
        else if (sexe.equals("H")){
            Citoyen citoyen = new Homme(id, nom, prenom, dateCivil, mairie);
            mairie.ajouterCitoyen(citoyen);
            message.setText("Citoyen ajoute");
        } 
        else if (sexe.equals("F")){
            Citoyen citoyen = new Femme(id, nom, prenom, dateCivil, mairie);
            mairie.ajouterCitoyen(citoyen);
            message.setText("Citoyen ajoute");
        } 
        else{
            message.setText("Sexe invalide: mettre H ou F");
        }
    }
}