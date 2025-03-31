Here’s the content formatted for a README.md file:

# API Endpoints for Calendar & Meeting Management

This document provides an overview of the API endpoints for managing employees, scheduling meetings, and checking for conflicts or free time slots.

## Endpoints

### 1. Create Employee
- **Method**: `POST`
- **Endpoint**: `/api/employees`
- **Request Body** (example):
  ```json
  {
    "name": "John Doe",
    "email": "john.doe@example.com"
  }

	•	Expected Response:
	•	Status: 201 Created
	•	Body:

{
  "id": 1,
  "name": "John Doe",
  "email": "john.doe@example.com"
}



2. Get Employee by ID
	•	Method: GET
	•	Endpoint: /api/employees/{id}
	•	Request Parameters:
	•	id: The ID of the employee (e.g., 1)
	•	Expected Response:
	•	Status: 200 OK (if employee exists)
	•	Body:

{
  "id": 1,
  "name": "John Doe",
  "email": "john.doe@example.com"
}


	•	Status: 404 Not Found (if employee does not exist)

3. Schedule a Meeting
	•	Method: POST
	•	Endpoint: /api/meetings
	•	Request Body (example):

{
  "title": "Project Kickoff",
  "description": "Initial project discussion",
  "organizerId": 1,
  "participantIds": [2, 3],
  "timeSlot": {
    "startTime": "2025-04-01T10:00:00",
    "endTime": "2025-04-01T10:30:00"
  }
}


	•	Expected Response:
	•	Status: 201 Created
	•	Body:

{
  "id": 1,
  "title": "Project Kickoff",
  "description": "Initial project discussion",
  "organizerId": 1,
  "participantIds": [2, 3],
  "timeSlot": {
    "startTime": "2025-04-01T10:00:00",
    "endTime": "2025-04-01T10:30:00"
  }
}



4. Check for Meeting Conflicts
	•	Method: POST
	•	Endpoint: /api/meetings/check-conflicts
	•	Request Body (example):

{
  "title": "Project Kickoff",
  "description": "Initial project discussion",
  "organizerId": 1,
  "participantIds": [2, 3],
  "timeSlot": {
    "startTime": "2025-04-01T10:00:00",
    "endTime": "2025-04-01T10:30:00"
  }
}


	•	Expected Response:
	•	Status: 200 OK
	•	Body:

{
  "1": [
    {
      "id": 1,
      "title": "Project Kickoff",
      "description": "Initial project discussion",
      "organizerId": 1,
      "participantIds": [2, 3],
      "timeSlot": {
        "startTime": "2025-04-01T10:00:00",
        "endTime": "2025-04-01T10:30:00"
      }
    }
  ]
}



5. Find Free Time Slots for Employees
	•	Method: GET
	•	Endpoint: /api/calendars/free-slots
	•	Request Parameters:
	•	employeeId1: The ID of the first employee (e.g., 1)
	•	employeeId2: The ID of the second employee (e.g., 2)
	•	durationMinutes: The duration of the slot in minutes (optional, default is 30)
	•	Example Request:
	•	/api/calendars/free-slots?employeeId1=1&employeeId2=2&durationMinutes=30
	•	Expected Response:
	•	Status: 200 OK
	•	Body (example):

[
  {
    "startTime": "2025-04-01T09:00:00",
    "endTime": "2025-04-01T09:30:00"
  },
  {
    "startTime": "2025-04-01T14:00:00",
    "endTime": "2025-04-01T14:30:00"
  }
]



Summary of Endpoints:
	1.	Create Employee: POST /api/employees
	2.	Get Employee by ID: GET /api/employees/{id}
	3.	Schedule a Meeting: POST /api/meetings
	4.	Check for Meeting Conflicts: POST /api/meetings/check-conflicts
	5.	Find Free Time Slots: GET /api/calendars/free-slots

