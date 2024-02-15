# Day-2

This document provides an overview of the API endpoints, status codes, content negotiation, and annotations used in the project.

## Status Codes

The API uses the following status codes to indicate the outcome of a request:

- `200 OK`: The request was successful.
- `201 Created`: The request has been fulfilled and a new resource has been created.
- `400 Bad Request`: The request could not be understood or was missing required parameters.
- `401 Unauthorized`: Authentication failed or user does not have permissions for the requested operation.
- `404 Not Found`: The requested resource could not be found.
- `500 Internal Server Error`: An unexpected error occurred on the server.

## Content Negotiation

The API supports content negotiation to allow clients to specify the desired representation of the response. The following content types are supported:

- `application/json`: JSON format for data exchange.
- `application/xml`: XML format for data exchange.
- `text/plain`: Plain text format.

To specify the desired content type, include the `Accept` header in your request.

## Annotations

The API uses annotations to provide additional information about the API endpoints. The following annotations are used:

- `@GetMapping`: Maps HTTP GET requests to a specific endpoint.
- `@PostMapping`: Maps HTTP POST requests to a specific endpoint.
- `@PutMapping`: Maps HTTP PUT requests to a specific endpoint.
- `@DeleteMapping`: Maps HTTP DELETE requests to a specific endpoint.
- `@PathVariable`: Binds a method parameter to a path variable in the request URL.
- `@RequestBody`: Binds the request body to a method parameter.

For more detailed information about each endpoint and its usage, please refer to the API documentation.
