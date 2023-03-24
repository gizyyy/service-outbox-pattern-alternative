# service-outbox-pattern-alternative

An alternative outbox pattern implementation

Project uses Mongo Change Streams and Reactive Mongo to track DB changes in order to implement an outbox pattern around DDD approach.

This project subjects a use case that I faced in real life project.

### Scenario:

Service supposed to listen an event from outside world.
Supposed to make some projection or calculations around it and create it's own aggregate and persist.
This aggregate is a domain object which is inside of this service's bounded context responsibilty.
Service is supposed to inform outside world about the aggregate which is persisted. 
This out of box solution of mongo change streams help implementation, without creating a transaction around the persistence

### Installing
1. Clone this repository anywhere on your machine:
```
git clone git@github.com:gizyyy/service-outbox-pattern-alternative.git
```

2. Run docker compose build
```
docker-compose up -d --build
```

## Installing dependencies
```bash
./gradlew build
```

## Tests and checks
To run all tests:
```bash
./gradlew test
```

