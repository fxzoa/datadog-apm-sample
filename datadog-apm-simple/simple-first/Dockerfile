FROM amazoncorretto:11.0.6

WORKDIR /usr/jar
COPY /lib/dd-java-agent-0.47.0.jar /usr/jar/dd-java-agent.jar
COPY /target/simple-first-1.0.0.jar /usr/jar/simple-first.jar

EXPOSE 8080

CMD java -javaagent:/usr/jar/dd-java-agent.jar -Ddd.service.name=simple-first -Ddd.logs.injection=true -Ddd.integrations.enabled=false -Ddd.integration.spring-web.enabled=true -jar /usr/jar/simple-first.jar
