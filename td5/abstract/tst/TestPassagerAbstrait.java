package tec;

abstract class TestPassagerAbstrait {
    

    abstract protected PassagerAbstrait CreerPassager(String nom, int destination);

    public static void main (String[] args) {
	boolean estMisAssertion = false;
	assert estMisAssertion = true;

	if (!estMisAssertion) {
	    System.out.println("Execution impossible sans l'option -ea");
	    return;
	}
	
    int nbTest = 0;
    
    //************ Verifier l'instanciation *************
    System.out.print('.'); nbTest++;

    new TestPassagerStandard().testInstanciation();


    
    //********* Verifier changement d'etat **************

    System.out.print('.'); nbTest++;
    new TestPassagerStandard().testGestionEtat();


    //********* Verifier les interactions  *************
    System.out.print('.'); nbTest++;
    new TestPassagerStandard().testInteractionMontee();


    
    System.out.print('.'); nbTest++;
    new TestPassagerStandard().testInteractionArret();

   

    
    System.out.println("(" + nbTest + "):OK: " + "tec.PassagerStandard");


    //************ Verifier l'instanciation *************
    System.out.print('.'); nbTest++;

   
    new TestPassagerIndecis().testInstanciation();
   
    
    //********* Verifier changement d'etat **************

    System.out.print('.'); nbTest++;
   
    new TestPassagerIndecis().testGestionEtat();
   
    //********* Verifier les interactions  *************
    System.out.print('.'); nbTest++;
   
    new TestPassagerIndecis().testInteractionMontee();
   
    
    System.out.print('.'); nbTest++;
   
    new TestPassagerIndecis().testInteractionArret();
   

    
    System.out.println("(" + nbTest + "):OK: " + "tec.PassagerIndecis");


    //************ Verifier l'instanciation *************
    System.out.print('.'); nbTest++;

   
   
    new TestPassagerStresse().testInstanciation();
    
    //********* Verifier changement d'etat **************

    System.out.print('.'); nbTest++;
   
   
     new TestPassagerStresse().testInstanciation();
    //********* Verifier les interactions  *************
    System.out.print('.'); nbTest++;
   
   
    new TestPassagerStresse().testInteractionMontee();
    
    System.out.print('.'); nbTest++;
   
   
    new TestPassagerStresse().testInteractionArret();

    
    System.out.println("(" + nbTest + "):OK: " + "tec.PassagerStresse");
  }

  //********************************************************
  /* Etat apres instanciation
   * Un seul cas 
   */  
  public void testInstanciation() {
    PassagerAbstrait p = CreerPassager("xxx", 3);

    assert false == p.estAssis();
    assert false == p.estDebout();
    assert true == p.estDehors();
  }

  /* Gestion des changement d'état.
   * 
   * Changer Debout puis Dehors puis assis. 
   */
  public void testGestionEtat() {
    PassagerStandard p = new PassagerStandard("yyy", 3);

    p.changerEnDebout();
    assert false == p.estAssis();
    assert true == p.estDebout();
    assert false == p.estDehors();

    p.changerEnDehors();
    assert false == p.estAssis();
    assert false == p.estDebout();
    assert true == p.estDehors();

    p.changerEnAssis();
    assert true == p.estAssis();
    assert false == p.estDebout();
    assert false == p.estDehors();
  }  
 
  /* Interaction a la montee
   * Trois cas
   *  - des places assises et debout
   *  - pas de place assise
   *  - aucune place. 
   */
    abstract void testInteractionMontee();

  /* Interaction a un arret
   * Deux cas
   *  - numero d'arret < a la destination
   *  - numero d'arret >= a la destination 
   */
    abstract  void testInteractionArret();
    
 
}
