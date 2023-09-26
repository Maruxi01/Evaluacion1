# Evaluation 1 - ICC735

## Description
The project consists of the creation of an API that offers video game recommendations based on various criteria. Game data is stored in JSON files, which are loaded into the system at startup.

## How to run
First of all, these are the requirements to run this project:
- Java 17

### Clone the repository
Open your terminal and run the following command: <br>
````shell
git clone https://github.com/Maruxi01/Evaluacion1.git
````
Then, go to the project folder: 
````shell
cd Evaluacion1
````

### Run the project
To run the project, you can use the following command:
`./mvnw spring-boot:run`
or in Windows:
`mvnw.cmd spring-boot:run`
You can also run the project from your IDE of choice.

### Use the API
This project uses Swagger to document the API. To access it, go to the following URL:
`http://localhost:8080/swagger-ui.html`
There you can see all the endpoints and test them.


## The API provides four main endpoints

### Recommend 2 random games for a specific console: 
HTTP Method: GET <br>
Route: `/consoles/{consoleAbreviation}/randomGames` 
````shell
http://localhost:8080/consoles/{consoleAbreviation}/randomGames
````

### Recommend 3 random games for a specific genre:
HTTP Method: POST <br>
Route: `/genres/random_games` 
````shell
http://localhost:8080/genres/random_games
````

### Recommend 1 random game for a specific console and genre: 
HTTP Method: POST <br>
Route: `/consoles/{consoleAbreviation}/genre/random_game`
````shell
http://localhost:8080/consoles/{consoleAbreviation}/genre/random_game
````
### Search for a game by name:
HTTP Method: GET <br>
Route: `/game`
````shell
http://localhost:8080/game
````

## Members
- Mara Villagrán
- Daira Acuña
- Tomás Valdés
- Esteban Llanos
