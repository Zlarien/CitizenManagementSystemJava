/**
 * 
 */
public class Mariage extends EvenementCivil{
    public Mariage(int numeroActe, DateCivil dateEvenement, Citoyen e1, Citoyen e2, Mairie m){
        super(numeroActe, dateEvenement);
        epoux1 = e1;
        epoux2 = e2;
        mairie = m;
    }
    /**
     * 
     */
    private Citoyen epoux1;
    /**
     * 
     */
    private Citoyen epoux2;
    /**
     * 
     */
    private Mairie mairie;
    /**
     * 
     */
    private boolean divorce;
    public Citoyen getEpoux1(){
        return epoux1;
    }
    public Citoyen getEpoux2(){
        return epoux2;
    }
    public Mairie getMairie(){
        return mairie;
    }
    public boolean isDivorce(){
        return divorce;
    }
    public void setDivorce(boolean d){
        divorce = d;
    }
}
