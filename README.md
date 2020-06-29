# springboot-mongo-backend

### Getting started

Backend for Spring Boot with MongoDB project on distributed databases

This is an example project showing mongoDB and springboot integration. It is a simple application for managing medical examinations.

### Requirements:
```
Java 8
Maven 3
Mongo database
```

#### To create database simply run following:

To run mongo commands in interactive mode, create database "myDatabase" and collection "col":

```
mongod
use myDatabase
db.createCollection("col")
```

### Usage:
```
mvn spring-boot:run
```

### Development

#### QueryHandling.java contains all endpoints

You can add your own endpoints or change existing

#### Constants.java contains persistence properties

You can add other Mongo database or configure host/port, simply change settings in this Class.
