FROM maven:3.6.2-jdk-14
COPY . .
RUN mvn package 
CMD ["java","-cp", "target/AppForTwitter-1.0-SNAPSHOT-jar-with-dependencies.jar", "TwitterApp"]
