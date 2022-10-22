From openjdk:8
Expose 8095
ADD /target/projetERP-0.0.1-SNAPSHOT.jar projetERP-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","projetERP-0.0.1-SNAPSHOT.jar"]