# carsDemo

 ## Database Schema
 Database Name: cars_db
 
 Table Name: cars
 
 column Entries:
 
 ```
	Long id
	String car_name
	String color
	String manufacture_name
	String model
	Integer year
```
## Methods Executed
	
### Post Call :
To insert new car details into the database.

Method: POST

URI: localhost:8080/api/car/

Requirements:
car Object in request body in raw(json) format.
	
	
		{
		"carName": "i20",
		"manufactureName": "hyundai",
		"model": "suv",
		"year": "2010",
		"color": "white"
		}
	
	
### Put Call : 
To Update existing car details using car id.

Method: PUT

URI: localhost:8080/api/car/{id}

Requirements:
car Object in request body in raw(json) format.
	
	
		{
		"carName": "i20",
		"manufactureName": "hyundai",
		"model": "suv",
		"year": "2010",
		"color": "white"
		}
	

### Get Call : 
To Get all the existing cars in database.

Method: GET

URI: localhost:8080/api/car/

Requirements:
no body required.
	
### Get Call using Id :
To get a car with specific id:

Method: GET

URI: localhost:8080/api/car/{id}

Requirements:
no body required.
	
### Get call with any column :
To get cars with the given specifications.

Method: GET

URI: localhost:8080/api/car/getCars

Requirements:
Request json body with one or many required fields
	
	
		{
		"manufactureName": "hyundai",
		"year": "2010",
		}
	
This Methos return me all the cars with manufactureName = hyundai and year = 2010
	
### Delete Call:
To Delete a car with specific id

Method: DELETE

URI: localhost:8080/api/car/{id}

Requirements:
no body required.

## Postman collections 
collection of all the service calls is stored in Cars_Demo.postman_collection.json
