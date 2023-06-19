FROM eclipse-temurin:20-jdk

WORKDIR /app

COPY .mvn/ .mvn
COPY pom.xml ./

RUN chmod +x .mvn/wrapper/maven-wrapper.jar
RUN mvn dependency:go-offline

COPY src ./src

RUN mvn package -DskipTests

CMD ["mvn", "spring-boot:run"]
