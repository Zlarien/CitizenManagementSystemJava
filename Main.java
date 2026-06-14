public class Main {
    public static void main(String[] args){
        Mairie mairie = new Mairie("Mairie d'Evry-Courcouronnes", "1 Place de la Republique", "Evry");
        DateCivil dateHomme = new DateCivil(1, 1, 1990);
        DateCivil dateFemme = new DateCivil(2, 2, 1992);
        Homme homme = new Homme(1, "Dupont", "Denis", dateHomme, mairie);
        Femme femme = new Femme(2, "Dupont", "Denise", dateFemme, mairie);
        mairie.ajouterCitoyen(homme);
        mairie.ajouterCitoyen(femme);

        //Deces acte = new Deces(1, new DateCivil(16, 5, 2026), homme, mairie);
        //mairie.ajouterDeces(acte);
        //homme.setActeDeces(acte);
        VuePrincipale vul = new VuePrincipale(mairie);
        vul.show();
        vul.pack();
        
    }
}
