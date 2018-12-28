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
- ConferenceRooms
- ConferenceRoomReservations
- Organizations

* GET
  ```
  http://localhost:8080/{address}
  ```
  example:
  ```
  http://localhost:8080/Organizations
  ```

* POST
  Everything is the same as in GET request.

* PUT
  ```
  http://localhost:8080/{address}/{id}
  ```
  example:
  ```
  http://localhost:8080/ConferenceRooms/2
  ```
* DELETE
  ```
  http://localhost:8080/{address}/{id}
  ```
  example:
  ```
  http://localhost:8080/ConferenceRoomReservations/2
  ```

*LEGEND:*<br/>
{id} - You should specify which id you want here for example:<br/>
  http://localhost:8080/Organizations/3<br/>
  In the link above 3 is {id}.

{address} - You should choose one of the specified addresses<br/> 
(ConferenceRooms, ConferenceRoomReservations, Organizations).

## Sending requests with cURL
There are 4 embedded organizations, conference rooms and conference room reservations.
In this project we use json format to get our data.
If you want to get response after making changes with POST, PUT, DELETE use GET request.
### 3.1. GET

```
curl {your address}
```
example:
```
curl http://localhost:8080/Organizations
```
response:
```
[
  {"id":1,"organizationName":"IBM"},
  {"id":2,"organizationName":"Google"},
  {"id":3,"organizationName":"Red Hat"},
  {"id":4,"organizationName":"Oracle"}
]
 ```
###  3.1.1 GET with specified id

```
curl {your address}
```
example:
```
curl http://localhost:8080/Organizations/2
```
response:
```
{"id":2,"organizationName":"Google"}
```
### 3.2. POST

You have to specify your header if you want to use json, because default header
to all POST requests is: Content-Type: application/x-www-form-urlencoded.
If you are using windows command prompt you have to use double quotes instead of
single ones, and escape them everytime you will use them with "\".

```
curl -d "{json}" -H "Content-Type: {type of your format}" {your address}
```
example:
```
curl -d "{\"organizationName\":\"Apple\"}" -H "Content-Type: application/json"
http://localhost:8080/Organizations
```
*GET request*

response:
```
[
  {"id":1,"organizationName":"IBM"},
  {"id":2,"organizationName":"Google"},
  {"id":3,"organizationName":"Red Hat"},
  {"id":4,"organizationName":"Oracle"},
  {"id":5,"organizationName":"Apple"}
]
```
### 3.3. PUT

```
curl -d "{json}" -H "Content-Type: application/json" -X PUT {your address}
```
example:
```
curl -d "{\"id\":2,\"organizationName\":\"Intive\"}" -H "Content-Type: application/json"
-X PUT http://localhost:8080/Organizations/2
```

*GET request*

response:
```
[
  {"id":1,"organizationName":"IBM"},
  {"id":2,"organizationName":"Intive"},
  {"id":3,"organizationName":"Red Hat"},
  {"id":4,"organizationName":"Oracle"},
]
```

### 3.4. DELETE

```
curl -X DELETE {your address}
```
example:
```
curl -X DELETE http://localhost:8080/Organizations/3
```

*GET request*

response:
```
[
  {"id":1,"organizationName":"IBM"},
  {"id":2,"organizationName":"Intive"},
  {"id":4,"organizationName":"Oracle"},
]
```

## Built With
* [Gradle](https://gradle.org/) - Dependency Management
## Authors

* **Hubert Kulas** - *Whole project* - [hkulas](https://github.com/hkulas)
