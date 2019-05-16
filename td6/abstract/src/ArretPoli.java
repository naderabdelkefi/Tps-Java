package tec;

public class ArretPoli extends ArretComportement{

    private ArretPoli()
    {}
 
    private static ArretPoli arretPoli = new ArretPoli();
     
    public static ArretPoli getInstance()
    {   return arretPoli;
    }

    protected void choixPlaceArret(Passager p, Vehicule v, int destination){
	if (! v.aPlaceAssise() && p.estAssis() && v.aPlaceDebout())
	    v.arretDemanderDebout(p);
    }

}
