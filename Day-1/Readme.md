# Employee Management API

This project is a simple RESTful API for managing employees. It is built with Spring Boot and uses the following concepts:

## Concepts

Spring Boot
Spring Boot is an open-source Java-based framework used to create a microservice. It is developed by Pivotal Team and is used to build stand-alone and production-ready Spring applications.

## RESTful API

A RESTful API is an architectural style for an application program interface (API) that uses HTTP requests to access and use data.

## Annotations

Annotations are a form of metadata and provide data about a program that is not part of the program itself. They have no direct effect on the operation of the code they annotate.

@RestController: This annotation is used to define a controller and indicates that the return value of the methods should be a direct response.
@RequestMapping: This annotation is used to map web requests onto specific handler classes and/or handler methods.
@GetMapping: This annotation is used to handle GET type of request method.
@PostMapping: This annotation is used to handle POST type of request method.
@PutMapping: This annotation is used to handle PUT type of request method.
@PatchMapping: This annotation is used to handle PATCH type of request method.
@DeleteMapping: This annotation is used to handle DELETE type of request method.
@PathVariable: This annotation is used to extract the value from the URI.
@RequestBody: This annotation is used to bind the HTTP request body with a domain object in method parameter.

## ArrayList

ArrayList is a part of collection framework and is present in java.util package. It provides us with dynamic arrays in Java.

## CRUD Operations

CRUD stands for Create, Read, Update and Delete. These are the four basic functions of persistent storage.

## Endpoints

GET /employees/: Get all employees.
POST /employees/: Add a new employee.
PUT /employees/{id}: Update an existing employee.
PATCH /employees/{id}: Update the salary of an existing employee.
DELETE /employees/{id}: Delete an existing employee.
