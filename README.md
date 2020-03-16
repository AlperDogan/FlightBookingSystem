# Flight Booking System Backend Services with Spring Boot and H2 Database

## Explanation
This project is developed by Spring Boot, H2 Database.

It has 6 Entities(DB Documnets)
1)Company
2)Airport
3)Route
4)Client
5)Booking
6)Flight

Initial assumed data of Company,Airport and Route DB save with project startup.

Main method of project is buyTicket method of BookingController,
This method takes Client args(identiyNumber,name,surname,phone,nationality) and requested flight number.
if this Client that has identiyNumber isn't exist, it will create or if isn't exist,it update.
if releated flight has a quota,the flight booking count and if necessary price values are update,
last step booking created,and buying ticket process completed.

Unit Tests are developed for BookingServiceImpl and FlightServiceImpl that has logic.

In addition added Postman Request for methods of RestControllers.