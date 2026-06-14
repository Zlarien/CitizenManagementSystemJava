public class DateCivil {
    private int jour;
    private int mois;
    private int annee;
    public static int anneeActuelle = 2026;

    public DateCivil(int j, int m, int a){
        jour = j;
        mois = m;
        annee = a;
    }
    public int getJour(){
        return jour;
    }
    public int getMois(){
        return mois;
    }
    public int getAnnee(){
        return annee;
    }
    public boolean estValide(){
        if(annee < 0 || mois < 1 || mois > 12 || jour < 1|| annee > anneeActuelle || jour > 31){
            return false;
        }
        if ((mois == 4 || mois == 6 || mois == 9 || mois == 11) && jour > 30) {
            return false;
        }
        if(mois==2){
            // Bissextile si divisible par 4 (mais pas par 100), 
            // sauf si c'est un multiple de 400.
            boolean estBissextile = (annee % 4 == 0 && annee % 100 != 0) || (annee % 400 == 0);
                if(estBissextile&&jour>29){
                    return false;
                }
                else if(!estBissextile&&jour>28){
                    return false;
                }
        }
        return true;
    }
    @Override
    public String toString(){
        return jour + "/" + mois + "/" + annee;
    }
}