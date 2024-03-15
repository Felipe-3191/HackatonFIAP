FROM eclipse-temurin:17-jdk-alpine as build
ARG MVN_OPTIONS="-Dspring.profiles.active=prod"
ARG MVN_PROFILE
WORKDIR /workspace/app


COPY mvnw . 
COPY .mvn .mvn
COPY pom.xml . 
COPY src src

RUN ./mvnw install -DskipTests ${MVN_OPTIONS} ${MVN_PROFILE} 
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ARG DEPENDENCY=/workspace/app/target/dependency

COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

ENTRYPOINT ["java","-cp","app:app/lib/*","-Dspring.profiles.active=prod" ,"com.fiap.Hackaton.HackatonApplication"]
