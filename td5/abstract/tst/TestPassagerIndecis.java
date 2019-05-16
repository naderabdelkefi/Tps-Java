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
	p.monterDans(faux);
	p.nouvelArret(faux,1);
	System.out.print(p.estAssis()+" " + getLastLog(faux) +" \n");
	p.nouvelArret(faux,5);
	System.out.print(p.estDehors()+" " + getLastLog(faux) +" \n");
	assert "arretDemanderSortie" == getLastLog(faux) : "descente ";

	

	
    }
	







    private String getLastLog(FauxVehicule f) {
	return f.logs.get(f.logs.size() -1);
    }
}
