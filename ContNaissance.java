import java.awt.event.*;
import javax.swing.*;

public class ContNaissance implements ActionListener{
    Mairie mairie;
    JTextField champIdBebe;
    JTextField champNom;
    JTextField champPrenom;
    JTextField champJour;
    JTextField champMois;
    JTextField champAnnee;
    JTextField champSexe;
    JTextField champIdMere;
    JTextField champIdPere;
    JLabel message;
    public ContNaissance(Mairie m, JTextField idBebe, JTextField nom, JTextField prenom, JTextField jour, JTextField mois, JTextField annee, JTextField sexe, JTextField idMere, JTextField idPere, JLabel msg){
        mairie = m;
        champIdBebe = idBebe;
        champNom = nom;
        champPrenom = prenom;
        champJour = jour;
        champMois = mois;
        champAnnee = annee;
        champSexe = sexe;
        champIdMere = idMere;
        champIdPere = idPere;
        message = msg;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        int idBebe = Integer.parseInt(champIdBebe.getText());
        String nom = champNom.getText();
        String prenom = champPrenom.getText();
        DateCivil date = new DateCivil(Integer.parseInt(champJour.getText()), Integer.parseInt(champMois.getText()), Integer.parseInt(champAnnee.getText()));
        String sexe = champSexe.getText();
        int idMere = Integer.parseInt(champIdMere.getText());
        int idPere = Integer.parseInt(champIdPere.getText());
        Femme mere = null;
        Homme pere = null;
        Citoyen bebe = null;
        if (!date.estValide()) {
            message.setText("Date de l'acte invalide");
            return;
        }
        
        Citoyen cMere = mairie.chercherCitoyenParId(idMere);
        if (cMere == null || !(cMere instanceof Femme)) {
            message.setText("Mere introuvable ou ID invalide");
            return;
        }
        else{
             mere = (Femme) cMere;
        }
        if(idPere != 0){ // on peut enregistrer une naissance sans pere
            Citoyen cPere = mairie.chercherCitoyenParId(idPere);
            if(!(cPere == null || !(cPere instanceof Homme))){
                pere = (Homme) cPere;
            }
        }
        
        if (mairie.chercherCitoyenParId(idBebe) != null){
            message.setText("ID bebe deja utilise"); 
            return; 
        }
        if (mere == null){ 
            message.setText("Mere introuvable");
            return;
        }
        if(mere.getEtatCivil() == EtatCivil.DECEDE){
            message.setText("Mere decedee");
            return;
        }
        //if (pere.getEtatCivil() == EtatCivil.DECEDE){
        //    message.setText("Pere decede");
        //    return;
        //}// il peut avoir un enfant sans pere vivant donc je ne l'insere pas 
        else if (sexe.equals("H")){
            bebe = new Homme(idBebe, nom, prenom, date, mairie);
        }

        else if (sexe.equals("F")){
            bebe = new Femme(idBebe, nom, prenom, date, mairie);
        }
        else{
            message.setText("Sexe invalide: H ou F");
            return;
        }
        Naissance naissance = new Naissance(mairie.getNaissances().size() + 1, date, mere, pere, bebe, mairie);
        mairie.ajouterNaissance(naissance);
        mairie.ajouterCitoyen(bebe);
        mere.getEnfants().add(naissance);
        if (pere != null){
            pere.getEnfants().add(naissance);
        }
        message.setText("Naissance enregistre");



    }
}