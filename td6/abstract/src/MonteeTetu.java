package tec;
class MonteeTetu extends PassagerAbstrait { 
 abstract void choixPlaceMontee(Vehicule v){

	if(v.getNbPlacesDebout==0){
		  v.monteeDemanderDebout(this);
	  }
    }

}
