# Student RESTful Web Service API

## URL

    https://student-web-service.herokuapp.com/
    
## BASE URI

    /api
    
## Fake Data URI (ADD)

    /api/fake/data
    
# REST API

The REST API to the student web service is described below.

## Get list of Things

### Request

`GET /api/students`

    curl -i -H 'Accept: application/json' https://student-web-service.herokuapp.com/api/students

### Response

    []
  
  
### Request

`GET /api/courses`

    curl -i -H 'Accept: application/json' https://student-web-service.herokuapp.com/api/courses

### Response

    []
    
## Get a specific Thing

### Request

`GET /api/student/:id`

    curl -i -H 'Accept: application/json' https://student-web-service.herokuapp.com/api/student/:id

### Response

    {"id":"[student-id],"name":"[student-name]","dob":"[student-date-of-birth]","email":"[student-email]","mobile":"[student-mobile-no]","course":{"id":"[course-id]","name":"[course-name]","duration":"[course-duration]","fees":"[course-fees]}}
    
    
### Request

`GET /api/course/:id`

    curl -i -H 'Accept: application/json' https://student-web-service.herokuapp.com/api/course/:id

### Response

    {"id":"[course-id]","name":"[course-name]","duration":"[course-duration]","fees":"[course-fees]}

## Get a non-existent Thing

### Request

`GET /api/student/:id`

    curl -i -H 'Accept: application/json' https://student-web-service.herokuapp.com/api/student/:id

### Response

    HTTP/1.1 404 Not Found
    
    
### Request

`GET /api/course/:id`

    curl -i -H 'Accept: application/json' https://student-web-service.herokuapp.com/api/course/:id

### Response

    HTTP/1.1 404 Not Found
    
## Create a new Thing

### Request

`POST /api/student`

    curl -i -H 'Accept: application/json' https://student-web-service.herokuapp.com/api/student
    
### Request Body
    {
      "id"     : "[student-id (numerical value only)]", // Optional in POST, but compulsory in PUT
      "name"   : "[student-name]",
      "dob"    : "[student-date-of-birth]",
      "email"  : "[student-email]",
      "mobile" : "[student-mobile-no]",
      "course" : {
                    "id"       : "[course-id][eg:- C101]",
                    "name"     : "[course-name]",
                    "duration" : "[course-duration][eg:- 3 years]",
                    "fees"     : "[course-fees][eg:- 1000/- per year]"
                 }
    }

### Response

    {"id":"[student-id],"name":"[student-name]","dob":"[student-date-of-birth]","email":"[student-email]","mobile":"[student-mobile-no]","course":{"id":"[course-id]","name":"[course-name]","duration":"[course-duration]","fees":"[course-fees]}}


### Request

`POST /api/course`

    curl -i -H 'Accept: application/json' https://student-web-service.herokuapp.com/api/course
    
### Request Body
    {
      "id"       : "[course-id][eg:- C101]", // Optional in POST, but compulsory in PUT
      "name"     : "[course-name]",
      "duration" : "[course-duration][eg:- 3 years]",
      "fees"     : "[course-fees][eg:- 1000/- per year]"
    }

### Response


    {"id":"[course-id]","name":"[course-name]","duration":"[course-duration]","fees":"[course-fees]}
    
## Change a Thing

### Request

`PUT /api/student/:id`

    curl -i -H 'Accept: application/json' https://student-web-service.herokuapp.com/api/student/:id
    
### Request Body
    {
      "id"     : "[student-id]",
      "name"   : "[student-name]",
      "dob"    : "[student-date-of-birth]",
      "email"  : "[student-email]",
      "mobile" : "[student-mobile-no]",
      "course" : {
                    "id"       : "[course-id]",
                    "name"     : "[course-name]",
                    "duration" : "[course-duration]",
                    "fees"     : "[course-fees]"
                 }
    }

### Response

    {"id":"[student-id],"name":"[student-name]","dob":"[student-date-of-birth]","email":"[student-email]","mobile":"[student-mobile-no]","course":{"id":"[course-id]","name":"[course-name]","duration":"[course-duration]","fees":"[course-fees]}}
    

### Request

`PUT /api/course/:id`

    curl -i -H 'Accept: application/json' https://student-web-service.herokuapp.com/api/course/:id
    
### Request Body
    {
      "id"       : "[course-id]",
      "name"     : "[course-name]",
      "duration" : "[course-duration]",
      "fees"     : "[course-fees]"
    }

### Response


    {"id":"[course-id]","name":"[course-name]","duration":"[course-duration]","fees":"[course-fees]}
    
## Delete a Thing

### Request

`DELETE /api/students`

    curl -i -H 'Accept: application/json' -X DELETE https://student-web-service.herokuapp.com/api/students

### Response

    HTTP/1.1 204 No Content
    
    
### Request

`DELETE /api/student/:id`

    curl -i -H 'Accept: application/json' -X DELETE https://student-web-service.herokuapp.com/api/student/:id

### Response

    HTTP/1.1 204 No Content
    
    
### Request

`DELETE /api/courses`

    curl -i -H 'Accept: application/json' -X DELETE https://student-web-service.herokuapp.com/api/courses

### Response

    HTTP/1.1 204 No Content
    
    
### Request

`DELETE /api/course/:id`

    curl -i -H 'Accept: application/json' -X DELETE https://student-web-service.herokuapp.com/api/course/:id

### Response

    HTTP/1.1 204 No Content
