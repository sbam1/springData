FROM java:8
LABEL maintainer="bamsuseelgapinc@gmail.com"
VOLUME /tmp
EXPOSE 8080
COPY build/libs/springData-0.0.1-SNAPSHOT.jar springData-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","springData-0.0.1-SNAPSHOT.jar"]