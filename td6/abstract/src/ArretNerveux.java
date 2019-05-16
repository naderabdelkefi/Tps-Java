package tec;

public class ArretNerveux extends ArretComportement{

    private ArretNerveux()
    {}
 
   
    private static ArretNerveux arretNerveux = new ArretNerveux();
     
   
    public static ArretNerveux getInstance()
    {   return arretNerveux;
    }

    protected void choixPlaceArret(Passager p, Vehicule v, int destination){
	if (p.estAssis() && v.aPlaceDebout())
	    v.arretDemanderDebout(p);
	else
	    if (p.estDebout() && v.aPlaceAssise())
		v.arretDemanderAssis(p);
    }

}
