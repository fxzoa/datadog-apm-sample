FROM amazoncorretto:11.0.6

WORKDIR /usr/jar
COPY /lib/dd-java-agent-0.47.0.jar /usr/jar/dd-java-agent.jar
COPY /target/first-service-1.0.0.jar /usr/jar/first-service.jar

EXPOSE 8080

CMD java -javaagent:/usr/jar/dd-java-agent.jar -Ddd.trace.analytics.enabled=true -Ddd.service.name=first-service -Ddd.logs.injection=true -Ddd.integrations.enabled=true -Ddd.integration.spring-web.enabled=true -jar /usr/jar/first-service.jar
