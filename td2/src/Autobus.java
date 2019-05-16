



class Autobus implements Vehicule {

    private int nbPlaceAssise;
    private int nbPlaceDebout;
    private int arret;
    private  Passager [] autobus;

    public Autobus(int nbPA, int nbPD) {
	nbPlaceAssise = nbPA;
	nbPlaceDebout = nbPD;

	arret = 0;
	autobus = new Passager [nbPlaceAssise + nbPlaceDebout];

	for(int i = 0; i < this.autobus.length; i ++) {
            this.autobus[i] = null;
        }
	
    }

    private int cherchePlaceLibre() {
	for (int i = 0;i < autobus.length;i++)
	    if (autobus[i] == null)
		return i;
	return -1;
    }

    
    public boolean aPlaceAssise() {
	if ( nbPlaceAssise > 0)	  
	    return true;
	else
	    return false;
    }
    public boolean aPlaceDebout(){
      if ( nbPlaceDebout > 0)	  
	    return true;
	else
	    return false;
    }
    public void arretDemanderAssis(Passager p){
	if(p.estDehors())
	    return;
	if (aPlaceAssise()) {
	    p.changerEnAssis();
	    nbPlaceAssise--;
	    nbPlaceDebout++;
	}}
    public void arretDemanderDebout(Passager p){
	if(p.estDehors())
	    return;
	else if (aPlaceDebout()) {
	    p.changerEnDebout();
	    nbPlaceAssise++;
	    nbPlaceDebout--;
	}

    }
    public void arretDemanderSortie(Passager p){
	if(p.estDehors())
	    return;
	int j = 0;
	for (int i = 0; i < autobus.length - 1; i++) {
	  
	    if(autobus[i] != null) { 
		if(autobus[i] == p)
		j = i;
	    
	    }}
	p.changerEnDehors();
	
	if(p.estDebout()) {
	    autobus[j] = null;
	    
	    nbPlaceDebout++;	
	}
	else if(p.estAssis()) {
	    autobus[j] = null;
	   
	    nbPlaceAssise++;
	       
	    
	}
	    
	
    }
    public void monteeDemanderAssis(Passager p){
	if (p.estDehors()) {
	    if (aPlaceAssise()) {
		
		autobus[cherchePlaceLibre()] = p;
		p.changerEnAssis();
		
		nbPlaceAssise--;
	    }
	    
	}
	
    }
    public void monteeDemanderDebout(Passager p){
	if(p.estDehors()) {	
	    if (aPlaceDebout()) {
		autobus[cherchePlaceLibre()] = p;
		p.changerEnDebout();		
		nbPlaceDebout--;
	    }
	   
	}
       
	   
    }
    public void allerArretSuivant() {
	arret++;	
	
	for (int i = 0; i < autobus.length;i++) {
	    if(autobus[i] != null) 
		autobus[i].nouvelArret(this,arret);
	    }

    }
    public String toString(){return "trump";}
			  

    
}
