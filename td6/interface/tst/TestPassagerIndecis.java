package tec;

public class TestPassagerIndecis extends TestPassagerAbstrait {

    protected PassagerAbstrait CreerPassager(String nom, int destination) {

	return new PassagerIndecis (nom, destination);
    }

    void testInteractionMontee() {
	PassagerIndecis p = new  PassagerIndecis("iii",5);

	FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);
	p.monterDans(faux);


	
	assert "monteeDemanderDebout" == getLastLog(faux) : "debout";
	
	faux = new FauxVehicule(FauxVehicule.DEBOUT);
	p.monterDans(faux);


	
	assert "monteeDemanderDebout" == getLastLog(faux) : "assis";


	
	faux = new FauxVehicule(FauxVehicule.PLEIN);
	p.monterDans(faux);

	
	assert 0 == faux.logs.size() : "dehors";
	
    }

    void testInteractionArret() {
	
	PassagerIndecis p = new  PassagerIndecis("eiii",5);

	FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);
	
       	p.changerEnDebout();// L'etat du passager ne change pas lors de l'appel de la fonction monteeDemander*. Cette ligne devrait etre remplacer par p.monterDans(faux);

	p.nouvelArret(faux,1);
	assert true == p.estAssis();
	
	p.nouvelArret(faux,2);
	
	assert true == p.estDebout();
	p.nouvelArret(faux,6);

	//	assert true == p.estDehors();


	assert "arretDemanderSortie" == getLastLog(faux) : "descente ";	
    }
	
    private String getLastLog(FauxVehicule f) {
	return f.logs.get(f.logs.size() -1);
    }
}
