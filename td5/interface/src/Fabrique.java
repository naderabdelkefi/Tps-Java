package tec;

public final class Fabrique { 

    private Fabrique(){}

    public static Usager fairePassagerStandard(String nom,int destination){
	return new PassagerStandard ( nom, destination);}

    public static Transport faireAutobus(int nbPA,int nbPD) {
	return new Autobus(nbPA,nbPD); }

}
