package tec;

public class ArretAgoraphobe extends ArretComportement{

    private ArretAgoraphobe()
    {}
 

    private static ArretAgoraphobe arretAgoraphobe = new ArretAgoraphobe();
     

    public static ArretAgoraphobe getInstance()
    {   return arretAgoraphobe;
    }

    protected void choixPlaceArret(Passager p, Vehicule v, int destination){
	if ( ! v.aPlaceAssise() && ! v.aPlaceDebout())
  v.arretDemanderSortie(p);
    }

}
