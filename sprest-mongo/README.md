# Golden Eagle Fitness database management

## This project is currently hosting line by [Heroku](https://www.heroku.com/)
**Project link:**
https://gef-db.herokuapp.com/workout

## To run the Spring Boot

- Run SpRestMongoApplication.java

## To test the router methods

- Use Postman with these endpoints

## GET Request
**To get all workout programs:**
```
http://localhost:8080/workout
```
**To get specific a workout program:**
```
http://localhost:8080/{label}
```

## POST Request
```
http://localhost:8080/workout
```

## Delete Request
- will be implemented if necessary

## Patch Request
**For IdSeq:**
```
http://localhost:8080/id/init
```