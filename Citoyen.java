import java.util.Vector;
/**
 * 
 */
public abstract class Citoyen {
    public Citoyen(int id, String n, String p, DateCivil d, Mairie m){
        identifiant = id;
        nom = n;
        prenom = p;
        dateNaissance = d;
        mairie = m;
        listMariage = new Vector<Mariage>();
    }
    /**
     * 
     */
    private int identifiant;
    /**
     * 
     */
    private String nom;
    /**
     * 
     */
    private String prenom;
    /**
     * 
     */
    private DateCivil dateNaissance;
    /**
     * 
     */
    private Mairie mairie;
    /**
     * 
     */
    private Deces acteDeces;
    /**
     * 
     */
    private Vector<Mariage> listMariage;
    public int getIdentifiant(){
        return identifiant;
    }
    public String getNom(){
        return nom;
    }
    public String getPrenom(){
        return prenom;
    }
    public DateCivil getDateNaissance(){
        return dateNaissance;
    }
    public Mairie getMairie(){
        return mairie;
    }
    public Deces getActeDeces(){
        return acteDeces;
    }
    public void setActeDeces(Deces d){
        acteDeces = d;
    }
    public Vector<Mariage> getListMariage(){
        return listMariage;
    }
    public boolean estMajeur(){
        return DateCivil.anneeActuelle - dateNaissance.getAnnee() >= 18;
    }
    public void ajouterMariage(Mariage mariage){
        listMariage.add(mariage);
    }
    public boolean estMarie() {
        for (int i = 0; i < listMariage.size(); i++){
            if (!listMariage.get(i).isDivorce()){
                return true;
            }
        }
        return false;
    }
    public EtatCivil getEtatCivil(){
        if (acteDeces != null){
            return EtatCivil.DECEDE;
        }
        for (int i = 0; i < listMariage.size(); i++){
            if (!listMariage.get(i).isDivorce()){
                Citoyen conjoint;
                if (listMariage.get(i).getEpoux1() == this){
                    conjoint = listMariage.get(i).getEpoux2();
                }
                else{
                    conjoint = listMariage.get(i).getEpoux1();
                }
                if(conjoint.getActeDeces()==null){ // si le conjoint n'est pas decede alors le citoyen est marie
                    return EtatCivil.MARIE;
                }
                
            }
        }
        if (listMariage.size() > 0){ // car on a deja testé si il était marié 
            return EtatCivil.DIVORCE;
        }
        return EtatCivil.CELIBATAIRE; // si non marié ni divorcé ni decedé alors celibataire
    }
    public int getConjointId() {
        for (int i = 0; i < listMariage.size(); i++){
            if (!listMariage.get(i).isDivorce()) { // si il est marié alors on retourne l'id de son conjoint
                if (listMariage.get(i).getEpoux1() == this){ 
                    return listMariage.get(i).getEpoux2().getIdentifiant();
                }
                else{
                    return listMariage.get(i).getEpoux1().getIdentifiant();
                }
            }
        }
        return -1; // -1 ou 0 permet de savoir les ids qui marchent pas 
    }
    public abstract String getSexe();
    @Override
    public String toString(){
        String conjoint = "Aucun";
        if (getConjointId() != -1){
            conjoint = "" + getConjointId();
        }
        return identifiant + " - " + prenom + " " + nom + " - " + getSexe() + " - " + getEtatCivil() + " - Conjoint: " + conjoint;
    }
}
