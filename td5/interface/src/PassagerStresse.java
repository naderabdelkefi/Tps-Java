package tec;

public class PassagerStresse extends PassagerAbstrait{

  public PassagerStresse(String nom, int destination){
	super(nom,destination);
  }
  void choixPlaceMontee(Vehicule v){
    if(v.aPlaceAssise()){
	v.monteeDemanderAssis(this);
    }
    else if(v.aPlaceDebout()){
	v.monteeDemanderDebout(this);
    }
  }
  void choixPlaceArret(Vehicule v, int arret){
    if ((getDestination()-arret)<=3){
      if(estAssis() && v.aPlaceDebout()){
  		changerEnDebout();
      }
    }
  }

}
