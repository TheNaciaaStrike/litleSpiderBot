#!/bin/bash
JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64/
export JAVA_HOME
export PATH=$JAVA_HOME/bin:$PATH
mvn -B test --file pom.xml
java -jar ./target/litleSpiderBot-0.0.1-SNAPSHOT.jar
