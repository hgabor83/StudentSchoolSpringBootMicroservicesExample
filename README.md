# StudentSchoolSpringBootMicroservicesExample
StudentSchoolSpringBootMicroservicesExample

Example project of Spring Boot Microservices with the following services School and Student

Try it out:

Post:
http://localhost:8081/schools/
{
	"id":"1",
	"name":"School1"
}

Post:
http://localhost:8082/students/
{
	"id":"1",
	"name":"Joe",
	"schoolId":"1"
}

Get:
http://localhost:8082/students/1
This will give back the student 1 with the related school
{
    "student": {
        "id": 1,
        "name": "Joe",
        "schoolId": 1
    },
    "school": {
        "id": 1,
        "name": "School1"
    }
}
