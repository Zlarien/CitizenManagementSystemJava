import java.util.Vector;
/**
 * 
 */
public class Homme extends Citoyen{
    public Homme(int identifiant, String nom, String prenom, DateCivil dateNaissance, Mairie mairie) {
        super(identifiant, nom, prenom, dateNaissance, mairie);
        enfants = new Vector<Naissance>();
    }
    /**
     * 
     */
    private Vector<Naissance> enfants;
    public Vector<Naissance> getEnfants(){
        return enfants;
    }
    @Override
    public String getSexe(){
        return "Homme";
    }
}
