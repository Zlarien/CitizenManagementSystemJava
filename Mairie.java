import java.util.Vector;
/**
 * 
 */
public class Mairie {
    public Mairie(String n, String a, String v){
        nom = n;
        adresse = a;
        ville = v;
        citoyens = new Vector<Citoyen>();
        mariages = new Vector<Mariage>();
        naissances = new Vector<Naissance>();
        deces = new Vector<Deces>();
    }
    /**
     * 
     */
    private String nom;
    /**
     * 
     */
    private String adresse;
    /**
     * 
     */
    private String ville;
    /**
     * 
     */
    private Vector<Citoyen> citoyens;
    /**
     * 
     */
    private Vector<Mariage> mariages;
    /**
     * 
     */
    private Vector<Naissance> naissances;
    /**
     * 
     */
    private Vector<Deces> deces;
    public String getNom(){
        return nom;
    }
    public String getAdresse(){
        return adresse;
    }
    public String getVille(){
        return ville;
    }
    public Vector<Citoyen> getCitoyens(){
        return citoyens;
    }
    public Vector<Mariage> getMariages(){
        return mariages;
    }
    public Vector<Naissance> getNaissances(){
        return naissances;
    }
    public Vector<Deces> getDeces(){
        return deces;
    }
    public Citoyen chercherCitoyenParId(int id){
        for (int i = 0; i < citoyens.size(); i++) {
            if (citoyens.get(i).getIdentifiant() == id) {
                return citoyens.get(i);
            }
        }
        return null;
    }
    public void ajouterCitoyen(Citoyen c){
        citoyens.add(c);
    }
    public void ajouterMariage(Mariage mariage){
        mariages.add(mariage);
    }
    public void ajouterNaissance(Naissance naissance){
        naissances.add(naissance);
    }
    public void ajouterDeces(Deces d){
        deces.add(d);
    }
}
