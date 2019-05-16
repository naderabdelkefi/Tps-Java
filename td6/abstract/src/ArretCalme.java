package tec;

public class ArretCalme extends ArretComportement{

    private ArretCalme()
    {}
 
    
    private static ArretCalme arretCalme = new ArretCalme();
     
    
    public static ArretCalme getInstance()
    {   return arretCalme;
    }

   protected void choixPlaceArret(Passager p, Vehicule v, int destination){
    }

}
