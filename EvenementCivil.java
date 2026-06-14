/**
 * 
 */
public abstract class EvenementCivil{
    public EvenementCivil(int numero, DateCivil date){
        numeroActe = numero;
        dateEvenement = date;
    }
    /**
     * 
     */
    private int numeroActe;
    /**
     * 
     */
    private DateCivil dateEvenement;
    
    public int getNumeroActe(){
        return numeroActe;
    }
    public DateCivil getDateEvenement(){
        return dateEvenement;
    }
}
