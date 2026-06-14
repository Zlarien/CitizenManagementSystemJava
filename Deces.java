/**
 * 
 */
public class Deces extends EvenementCivil{
    public Deces(int numeroActe, DateCivil dateEvenement, Citoyen d, Mairie m){
        super(numeroActe, dateEvenement);
        defunt = d;
        mairie = m;
    }
    /**
     * 
     */
    private Citoyen defunt;
    /**
     * 
     */
    private Mairie mairie;
    public Citoyen getDefunt(){
        return defunt;
    }
    public Mairie getMairie(){
        return mairie;
    }
}
