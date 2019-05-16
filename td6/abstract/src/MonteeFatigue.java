package tec;
class MonteeFatigue extends PassagerAbstrait { 

    abstract void choixPlaceMontee(Vehicule v){

	if(v.aPlaceAssise()){
		  v.monteeDemanderAssis(this);
	  }
    }

}
