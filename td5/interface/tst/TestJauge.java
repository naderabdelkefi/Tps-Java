package tec;

class TestJauge {

	public void testDansIntervalle() {
		Jauge jauge = new Jauge(67899, 100);
		assert jauge.estVert();
		assert ! jauge.estRouge();
	}

	public void testPasDansIntervalle() {
		Jauge jauge = new Jauge(67899, 70000);
		assert ! jauge.estVert();
		assert jauge.estRouge();
	}

	public void testDepartMax() {
		Jauge jauge = new Jauge(500, 500);
		assert ! jauge.estVert();
		assert jauge.estRouge();
	}

	public void testDepartNegatif() {
		Jauge jauge = new Jauge(500, -50);
		assert ! jauge.estVert();
	
	}

	public void testDepartZero() {
		Jauge jauge = new Jauge(0, 0);
		assert jauge.estRouge();
		assert ! jauge.estVert();

		jauge = new Jauge(100, 0);
		assert ! jauge.estRouge();
		assert jauge.estVert();
	}

	public void testIncrementer() {
		Jauge jauge = new Jauge(16, 0);

		for(int i=0;i<15;i++){
			jauge.incrementer();
			assert jauge.estVert();
			assert ! jauge.estRouge();
		}
		jauge.incrementer();
		assert ! jauge.estVert();
	       	assert jauge.estRouge();
	}

	public void testDecrementer() {
		Jauge jauge = new Jauge(100, 0);
		assert jauge.estVert();
		assert ! jauge.estRouge();

		jauge.decrementer();

		assert  jauge.estVert();
		assert ! jauge.estRouge();



	}

	public static void main(String [] args) {
		boolean estMisAssertion = false;
		assert estMisAssertion = true;

		if (!estMisAssertion) {
			System.out.println("Execution impossible sans l'option -ea");
			return;
		}

		new TestJauge().testDansIntervalle();
		new TestJauge().testPasDansIntervalle();
		new TestJauge().testDepartMax();
		new TestJauge().testDepartNegatif();
		new TestJauge().testDepartZero();
		new TestJauge().testIncrementer();
		new TestJauge().testDecrementer();
	}
}
