package tec;

public abstract class PassagerAbstrait extends Passager implements Usager {

	private String nom;
	private int destination;
	private Position position;

	public PassagerAbstrait(String nom, int destination){
		this.nom = nom;
		this.destination = destination;
		position = Position.creer();
	}

	public int getDestination(){
		return destination;
	}

	/**
   * fournit le nom de du passager.
   */
   String nom(){
	  return this.nom;
    }
  /**
   * Le passager est-il en dehors d'un véhicule ?
   * @return vrai si la position du passager est dehors.
   */
    boolean estDehors(){
	  return position.estDehors();
    }

  /**
   * Le passager est-il assis dans un véhicule ?
   * @return vrai si la position du passager est assis.
   */
    boolean estAssis(){
	  return position.estAssis();
	}

  /**
   * Le passager est-il debout dans un véhicule?
   * @return vrai si la position du passager est debout.
   */
    boolean estDebout(){
	  return position.estDebout();
	}
  /**
   * Change la position du passager en dehors.
   * Cette méthode est appélee par un véhicule.
   */
    void changerEnDehors(){
	  position = position.dehors();
	}

  /**
   * Change la position du passager en assis.
   * Cette méthode est appélee par un véhicule.
   */
    void changerEnAssis(){
	  position = position.assis();
	}

  /**
   * Change la position du passager en debout.
   * Cette méthode est appélee par un véhicule.
   */
    void changerEnDebout(){
	this.position=position.debout();
	}

  /**
   * Cette méthode réalise le caractère à la montée du passager.
   * Elle est appelée par le client.
   *
   * @param v le véhicule dans lequel va monter le passager.
   */
    final public void monterDans(Transport t){

	Vehicule v = (Vehicule) t;
	choixPlaceMontee(v);
	  /*if(v.aPlaceAssise()){
		  v.monteeDemanderAssis(this);
	  }
	  else if(v.aPlaceDebout()){
		  v.monteeDemanderDebout(this);
	  }*/
	  }

  /**
   * Cette méthode réalise le caractère à un arrêt du passager.
   * Elle est appelée par le véhicule dans lequel est monté le passager.
   *
   * @param v le vehicule dans lequel se trouve le passager.
   * @param numeroArret numéro de l'arrêt courant.
   */
    final void nouvelArret(Vehicule v, int numeroArret){
	if(numeroArret >= destination){
		 v.arretDemanderSortie(this);
	  }
	choixPlaceArret(v,numeroArret);
	  
	}


    public String toString(){
	if (estDehors()){
	    return nom + "<endehors>";
	}
	if (estAssis()){
	    return nom + "<assis>";
	}
	if (estDebout()){
	    return nom + "<debout>";
	}
	else{
	    return "Error";
	}
    }

    abstract void choixPlaceMontee(Vehicule v);
    abstract void choixPlaceArret(Vehicule v, int arret);
}
