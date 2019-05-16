JFLAGS=-ea
JC=javac
Classpath=./td1

all: test

test:
	$(JC) -cp ./tst:./src ./src/*.java ./tst/*.java
	java $(JFLAGS) -cp ./tst:./src TestJauge
	java $(JFLAGS) -cp ./tst:./src TestPosition
	java $(JFLAGS) -cp ./tst:./src TestPassagerStandard
	java $(JFLAGS) -cp ./tst:./src TestAutobus

clean:
	rm -f ./tst/*.class ./src/*.class
