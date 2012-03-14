JAVAC = javac
JAVACFLAGS = -classpath $(BUKKIT_JAR) -d bin
JAR = jar
JARFLAGS = cf
SOURCE = src/SetSpawn.java
NAME = setspawn
VERSION = 0.1

all: jar

classes:
	$(JAVAC) $(JAVACFLAGS) $(SOURCE)

jar: classes
	cp src/plugin.yml bin/
	$(JAR) $(JARFLAGS) $(NAME)-$(VERSION).jar -C bin net bin/plugin.yml

clean:
	-rm -r bin/* $(NAME)-$(VERSION).jar

.PHONY: all classes jar clean

