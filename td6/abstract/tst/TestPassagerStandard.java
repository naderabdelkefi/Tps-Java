package tec;


public class TestPassagerStandard extends TestPassagerAbstrait{


    TestPassagerStandard(){
	return;
    }
    
    protected PassagerAbstrait creerPassager(String nom, int destination) {
	
	return new PassagerStandard(nom, destination);
    }
    public void testInteractionMontee() {
	PassagerStandard p = new PassagerStandard("yyy", 5);
	
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

    public void testInteractionArret() {
	PassagerStandard p = new PassagerStandard("yyy", 5);
    
	FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);

	p.nouvelArret(faux, 1);
	assert 0 == faux.logs.size() : "pas a destination";

	p.nouvelArret(faux, 5);
	assert "arretDemanderSortie" == getLastLog(faux) : "destination";    
  }
    private String getLastLog(FauxVehicule f) {
	return f.logs.get(f.logs.size() -1);
  }

}
