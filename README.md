# CSCI 3155 Miniproject

## Requirements
* Maven
    * `$ sudo apt install maven`

* JDK
    * `$ apt-get install default-jdk`

## Build
`$ mvn clean package -DskipTests=true`

## Run
`$ java -jar target/*.jar`
* (CTRL-C to shut down server)

## Configuration with Dependency Injection
1. Start the server with `run_bird.sh` or `run_lion.sh`, this will export the appropriate environment variable.
2. Make a `GET` call to `http://localhost:8080/api/animal`
3. Expected responses:
    * Bird configuration 
    ```json
    {
        "message": "Chirp! Chirp!"
    }
    ```
    * Lion configuration:
    ```json
    {
        "message": "ROAR!!"
    }
    ```
