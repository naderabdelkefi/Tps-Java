package tec;

public class PassagerIndecis extends PassagerAbstrait{

  public PassagerIndecis(String nom, int destination){
	super(nom,destination);
  }

  void choixPlaceMontee(Vehicule v){
  	  if(v.aPlaceDebout()){
  		  v.monteeDemanderDebout(this);
  	  }
  }
  void choixPlaceArret(Vehicule v, int arret)
    {
      if(arret < getDestination()){

       if(estDebout() && v.aPlaceAssise()){
  		  changerEnAssis();
  	  }
       else if(estAssis() && v.aPlaceDebout()){
  		  changerEnDebout();
  	  }
       }
     }

}
