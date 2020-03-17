![Java CI with Maven](https://github.com/renanpigato/JokenPo/workflows/Java%20CI%20with%20Maven/badge.svg?branch=master)

# JokenPO
Project to judge a Joken PO game with JAVA language. 
The application reads JSON file that contains the games and put result on console.

### Depends
- JAVA [https://jdk.java.net/]
- Maven 3.3 [https://maven.apache.org/download.cgi]
- Docker and docker-compose (Optional) [https://docs.docker.com/compose/install]

## Installation

### Native SO
##### Downloading the project and rename game's file
```Shell
git clone https://github.com/renanpigato/JokenPo.git
mv game.json.dist game.json
```
##### Run tests and Compile
```Shell
mvn clean dependency:copy-dependencies package -e
```
##### Running application
```Shell
java -cp target/JokenPo-1.0.0.jar:target/dependency/* Main
```

### Using Docker
##### Downloading the project and rename game's file
```Shell
git clone https://github.com/renanpigato/JokenPo.git
mv game.json.dist game.json
```
##### Initialize the container whith dependencies
```Shell
docker-compose -f docker/docker-compose.yml up -d
docker exec -it jokenpo bash
```
##### Run tests and Compile on container
```Shell
mvn clean dependency:copy-dependencies package -e
```
##### Running application
```Shell
/opt/java/jdk/jdk-13.0.2/bin/java -cp target/JokenPo-1.0.0.jar:target/dependency/* Main
```

## Tests
Tests are built on JUnit 5, the coverage is on 61,9%.
