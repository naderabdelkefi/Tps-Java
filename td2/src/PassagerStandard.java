
public class PassagerStandard implements Passager {
	
	private String nom;
	private int destination;
	private Position position;
	
	public PassagerStandard(String nom, int destination){
		this.nom = nom;
		this.destination = destination;
		position = new Position();
	}
	
	/**
   * fournit le nom de du passager.
   */
  public String nom(){
	  return this.nom;
    }
  /**
   * Le passager est-il en dehors d'un véhicule ?
   * @return vrai si la position du passager est dehors.
   */
  public boolean estDehors(){
	  return position.estDehors();
    }
  
  /**
   * Le passager est-il assis dans un véhicule ?
   * @return vrai si la position du passager est assis.
   */
  public boolean estAssis(){
	  return position.estAssis();
	}
  
  /**
   * Le passager est-il debout dans un véhicule?
   * @return vrai si la position du passager est debout.
   */
  public boolean estDebout(){
	  return position.estDebout();
	}
  /**
   * Change la position du passager en dehors.
   * Cette méthode est appélee par un véhicule.
   */
  public void changerEnDehors(){
	  position = position.dehors();
	}
  
  /**
   * Change la position du passager en assis. 
   * Cette méthode est appélee par un véhicule.
   */
  public void changerEnAssis(){
	  position = position.assis();
	}
  
  /**
   * Change la position du passager en debout.
   * Cette méthode est appélee par un véhicule.
   */
  public void changerEnDebout(){
	  position = position.debout();
	}

  /**
   * Cette méthode réalise le caractère à la montée du passager.
   * Elle est appelée par le client.
   *
   * @param v le véhicule dans lequel va monter le passager.
   */
     public void monterDans(Vehicule v){
	  if(v.aPlaceAssise()){
		  v.monteeDemanderAssis(this);
	  }
	  else if(v.aPlaceDebout()){
		  v.monteeDemanderDebout(this);
	  }
	  }
  
  /**
   * Cette méthode réalise le caractère à un arrêt du passager. 
   * Elle est appelée par le véhicule dans lequel est monté le passager. 
   *
   * @param v le vehicule dans lequel se trouve le passager.
   * @param numeroArret numéro de l'arrêt courant.
   */
  public void nouvelArret(Vehicule v, int numeroArret){
	  if(numeroArret >= destination){
		  v.arretDemanderSortie(this);
	  }
	}
	
}	
