package tec;


public class TestPassagerStresse extends TestPassagerAbstrait {

    protected PassagerAbstrait CreerPassager(String nom, int destination) {

	return new PassagerStresse (nom, destination);
    }

    void testInteractionMontee() {
	PassagerStresse p = new PassagerStresse("yyy", 5);


	FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);
	p.monterDans(faux);

	
	assert "monteeDemanderAssis" == getLastLog(faux) : "assis";    
    
	faux = new FauxVehicule(FauxVehicule.DEBOUT);
	p.monterDans(faux);

	
	assert "monteeDemanderDebout" == getLastLog(faux) : "debout";    

	faux = new FauxVehicule(FauxVehicule.PLEIN);
	p.monterDans(faux);

	
	assert 0 == faux.logs.size() : "pas de place";        
  }
    void testInteractionArret() {
	
	PassagerStresse p = new PassagerStresse("yyy", 5);
	FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);

	p.changerEnAssis();

	assert true == p.estAssis();
	
	p.nouvelArret(faux,2);
	assert true == p.estDebout();

	p.nouvelArret(faux,5);

	assert "arretDemanderSortie" == getLastLog(faux) : "descente ";	


    }
    
    private String getLastLog(FauxVehicule f) {
	return f.logs.get(f.logs.size() -1);
    }
    
    
}
