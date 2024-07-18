# Springboot Microservices w/ Docker compose

This project is an intro to springboot microservices. There are 2 applications:
1. Producer creates a random number and serves it on port 8083. Takes optional query param `Number manInt (default: 1000)` to limit the random number generator .
2. Consumer fetches a random number from Producer and displays it.

To start services run:

### `docker-compose up`

Then, visit your services at:
##### Consumer - [localhost:8080](http://localhost)
##### Producer - [localhost:8083](http://localhost) or [localhost:8083/random](http://random)
