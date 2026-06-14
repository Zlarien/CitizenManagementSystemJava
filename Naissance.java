/**
 * 
 */
public class Naissance extends EvenementCivil{
    public Naissance(int numeroActe, DateCivil dateEvenement, Femme m, Homme p, Citoyen b, Mairie ma){
        super(numeroActe, dateEvenement);
        mere = m;
        pere = p;
        bebe = b;
        mairie = ma;
    }
    /**
     * 
     */
    private Femme mere;
    /**
     * 
     */
    private Homme pere;
    /**
     * 
     */
    private Citoyen bebe;
    /**
     * 
     */
    private Mairie mairie;
    public Femme getMere(){
        return mere;
    }
    public Homme getPere(){
        return pere;
    }
    public Citoyen getBebe(){
        return bebe;
    }
    public Mairie getMairie(){
        return mairie;
    }
}
