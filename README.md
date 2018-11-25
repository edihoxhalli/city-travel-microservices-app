# city-travel-microservices-app
BFS + Dijkstra's Algorithm implementations as a Microservice Oriented Architecture

Installation

The repository contains 3 different maven projects. In your terminal of choice execute "mvn clean install" once you are inside each of the directories. 

After this completes successfully, execute "mvn spring-boot:run", first for eureka-service and then for the two other services. 

By now you should have the three services up and running. There is a setup file for a Postman Collection named "new-city-travel.postman_collection.json". Import that file into Postman. It contains example requests to the CRUD Service as well as the Calculations Service. 

