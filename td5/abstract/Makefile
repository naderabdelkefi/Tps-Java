all :
	javac -d build src/*.java
	java -cp build Simple

test :
	javac -d build src/*.java
	javac -cp build -d build tst/*.java
	java -ea -cp build tec.TestPosition
	java -ea -cp build tec.TestAutobus
	java -ea -cp build tec.TestJauge
	java -ea -cp build tec.TestPassagerStandard

clean:
	rm -rf build/*
