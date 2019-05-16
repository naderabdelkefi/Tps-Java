package tec;

public class ArretPrudent extends ArretComportement{

    private ArretPrudent()
    {}
 
    private static ArretPrudent arretPrudent = new ArretPrudent();
     
   
    public static ArretPrudent getInstance()
    {   return arretPrudent;
    }

    protected void choixPlaceArret(Passager p, Vehicule v, int destination){

	if (p.getDistance(destination) <= 3){
	    if (v.aPlaceDebout() && !p.estDebout())
		v.arretDemanderDebout(p);
	}

	else if (p.getDistance(destination) > 3){
		if (v.aPlaceAssise() && !p.estAssis())
		    v.arretDemanderAssis(p);
	    }

    }
}
