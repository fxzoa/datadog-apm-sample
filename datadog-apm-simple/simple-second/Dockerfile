FROM amazoncorretto:11.0.6

WORKDIR /usr/jar
COPY /lib/dd-java-agent-0.47.0.jar /usr/jar/dd-java-agent.jar
COPY /target/simple-second-1.0.0.jar /usr/jar/simple-second.jar

EXPOSE 8080

CMD java -javaagent:/usr/jar/dd-java-agent.jar -Ddd.service.name=simple-second -Ddd.logs.injection=true -jar /usr/jar/simple-second.jar
