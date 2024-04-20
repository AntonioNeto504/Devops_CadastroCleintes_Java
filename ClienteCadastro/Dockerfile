
FROM openjdk:11

WORKDIR /app

COPY ./*.java /app/

RUN javac *.java

ENV CLASSPATH /app

CMD ["java", "Main"]
