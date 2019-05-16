package tec;

class TestPosition{

    public void testExterieur() {
        System.out.println("Début de TestExterieur");
        Position position = Position.creer().dehors();

        assert position.estAssis() == false;
        assert position.estDebout() == false;
        assert position.estDehors() == true;
        assert position.estInterieur() == false ;
        System.out.println("Fin de TestExterieur");


    }
    public void testAssis() {
       System.out.println("Début de TestAssis");
        Position position = Position.creer().assis();
        assert (position.estAssis() == true) ;
        assert position.estDebout() == false;
        assert position.estDehors() == false;
        assert position.estInterieur() == true;
        System.out.println("Fin de TestAssis");

    }
    public void testDebout() {
        System.out.println("Début de TestDebout");
        Position position = Position.creer().debout();
        assert position.estAssis() == false;
        assert (position.estDebout() == true);
        assert position.estDehors() == false;
        assert position.estInterieur() == true;
        System.out.println("Fin de TestDebout");
    }

    public void testDehors() {
        System.out.println("Début de TestDehors");
        Position position = Position.creer().dehors();
        assert position.estAssis() == false;

        assert (position.estDehors() == true);
        assert position.estInterieur() == false;
        System.out.println("Fin de TestDehors");


    }


    public static  void main(String[] args){

        boolean estMisAssertion = false;
        assert estMisAssertion = true;

        if(!estMisAssertion)
            {
            System.out.println("Execution impossible sans l'option -ea");
            return;
            }

        new TestPosition().testExterieur();
        new TestPosition().testAssis();
        new TestPosition().testDebout();
        new TestPosition().testDehors();
    }



}
