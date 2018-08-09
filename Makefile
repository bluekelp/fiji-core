.PHONY: all clean run

MVN=mvn

all: 
	$(MVN) compile

run:
	$(MVN) exec:java

clean:
	$(MVN) clean
