# Patronage 2018/2019 Back-end (JAVA)

This is REST API with CRUD operations.
Reservation system for conference rooms.

## How to build and run
You need to build your app.

```
gradlew build
```

Then you need to run it.

```
gradlew bootRun
```

## You can send requests at given addresses
There are three specified addresses:
- rooms
- roomReservations
- organizations

* GET
  ```
  http://localhost:8080/{address}
  ```
  example:
  ```
  http://localhost:8080/organizations
  ```

* POST
  Everything is the same as in GET request.

* PUT
  ```
  http://localhost:8080/{address}/{id}
  ```
  example:
  ```
  http://localhost:8080/organizations/2
  ```
* DELETE
  ```
  http://localhost:8080/{address}/{id}
  ```
  example:
  ```
  http://localhost:8080/organizations/2
  ```

*LEGEND:*<br/>
{id} - You should specify which id you want here for example:<br/>
  http://localhost:8080/organizations/3<br/>
  In the link above 3 is {id}.

{address} - You should choose one of the specified addresses<br/> 
(ConferenceRooms, ConferenceRoomReservations, Organizations).

## Sending requests with cURL
In this project we use json format to get our data.
If you want to get response after making changes with POST, PUT, DELETE use GET request.
### 3.1. POST

You have to specify your header if you want to use json, because default header
to all POST requests is: Content-Type: application/x-www-form-urlencoded.
If you are using windows command prompt you have to use double quotes instead of
single ones, and escape them everytime you will use them with "\".

```
curl -d "{json}" -H "Content-Type: {type of your format}" {your address}
```
example:
```
curl -d "{\"organizationName\": \"IBM\",\"rooms\":[{\"roomName\": \"BlueRoom\", 
\"idOfRoom\": \"22\",\"floor\": 1,\"available\": true,\"standingPlaces\": 20,
\"seats\": 30,\"hangingPlaces\": 0,\"roomEquipment\": {\"projectorName\": \"Alfa\",
\"internalNumber\": 56,\"externalNumber\": \"+12 123456789\",\"connectionType\": \"Bluetooth\",
\"therePhone\": true}"}"]}" -H "Content-Type: application/json" http://localhost:8080/organizations
```
response:
```
{"id":1,"organizationName":"IBM","rooms[
{"id":1,"roomName":"BlueRoom","idOfRoom":"22","floor":1,"available":true,
"standingPlaces":20,"seats":30,"hangingPlaces":0,"roomEquipment":{
"id":1,"projectorName":"Alfa","internalNumber":56,"externalNumber":"+12 123456789",
"connectionType":"Bluetooth","therePhone":true}
}]}
 ```
###  3.1.1 GET with specified id

```
curl {your address}
```
example:
```
curl http://localhost:8080/organizations/1
```
response:
```
{"id":1,"organizationName":"IBM","rooms[
{"id":1,"roomName":"BlueRoom","idOfRoom":"22","floor":1,"available":true,
"standingPlaces":20,"seats":30,"hangingPlaces":0,"roomEquipment":{
"id":1,"projectorName":"Alfa","internalNumber":56,"externalNumber":"+12 123456789",
"connectionType":"Bluetooth","therePhone":true}
}]}
```
### 3.2. GET

```
curl {your address}
```
example:
```
curl http://localhost:8080/organizations
```

response:
```
{"id":1,"organizationName":"IBM","rooms[
{"id":1,"roomName":"BlueRoom","idOfRoom":"22","floor":1,"available":true,
"standingPlaces":20,"seats":30,"hangingPlaces":0,"roomEquipment":{
"id":1,"projectorName":"Alfa","internalNumber":56,"externalNumber":"+12 123456789",
"connectionType":"Bluetooth","therePhone":true}
}]}
```
### 3.3. PUT

```
curl -d "{json}" -H "Content-Type: application/json" -X PUT {your address}
```
example:
```
curl -d "{\"organizationName\": \"Intive\",\"rooms\":[{\"roomName\": \"WideRoom\",
\"idOfRoom\": \"1234\",\"floor\": 4,\"available\": true,\"standingPlaces\": 25,
\"seats\": 40,\"hangingPlaces\": 6,\"roomEquipment\": {\"projectorName\": \"Beta\",
\"internalNumber\": 87,\"externalNumber\": \"+14 987654321\",\"connectionType\": \"USB\",
\"therePhone\": true}"}"]}" -H "Content-Type: application/json"
-X PUT http://localhost:8080/organizations/1

```


response:
```
{"id":1,"organizationName":"Intive","rooms[
{"id":2,"roomName":"WideRoom","idOfRoom":"1234","floor":4,"available":true,
"standingPlaces":25,"seats":40,"hangingPlaces":6,"roomEquipment":{
"id":2,"projectorName":"Beta","internalNumber":87,"externalNumber":"+14 987654321",
"connectionType":"USB","therePhone":true}
}]}
```

### 3.4. DELETE

```
curl -X DELETE {your address}
```
example:
```
curl -X DELETE http://localhost:8080/organizations/1
```

*GET request*

response:
```
[]
```

## Built With
* [Gradle](https://gradle.org/) - Dependency Management
## Authors

* **Hubert Kulas** - *Whole project* - [hkulas](https://github.com/hkulas)
