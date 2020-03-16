# JokenPO
Project to judge a Joken PO game with JAVA language. 
The application reads JSON file that contains the games and put result on console.

### Depends
- JAVA [https://jdk.java.net/]
- Maven 3.3 [https://maven.apache.org/download.cgi]
- Docker and docker-compose (Optional) [https://docs.docker.com/compose/install]

## Installation

### Native SO
##### Downloading the project
```bash
git clone https://github.com/renanpigato/JokenPo.git
```
##### Run tests and Compile
```bash
mvn clean dependency:copy-dependencies package -e
```
##### Running application
```bash
java -cp target/JokenPo-1.0.0.jar:target/dependency/* Main
```

### Using Docker
##### Downloading the project
```bash
git clone https://github.com/renanpigato/JokenPo.git
```
##### Initialize the container whith dependencies
```bash
docker-compose -f docker/docker-compose.yml up -d
docker exec -it jokenpo bash
```
##### Run tests and Compile on container
```bash
mvn clean dependency:copy-dependencies package -e
```
##### Running application
```bash
/opt/java/jdk/jdk-13.0.2/bin/java -cp target/JokenPo-1.0.0.jar:target/dependency/* Main
```