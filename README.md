# SG_G1 :robot: Desarrollo con SpringBoot - Links para Postman

**US 0001** *localhost:8080/api/v1/hotels*

**US 0002** *localhost:8080/api/v1/hotelss?dateFrom=17/04/2022&dateTo=23/05/2022&destination=Tucumán*

**US 0003** *localhost:8080/api/v1/booking*

<sub> 
{
  "userName" : "arjona@gmail.com",
  "booking": {
    "dateFrom" : "17/04/2022",
    "dateTo": "23/05/2022",
    "destination": "Tucumán",
    "hotelCode" : "SH-0002",
    "peopleAmount" : 2,
    "roomType" : "DOUBLE",
    "people" : [
      {
        "dni" : "12345678",
        "name": "Pepito",
        "lastName": "Gomez",
        "birthday":"10/11/1982",
        "mail": "arjona@gmail.com"
      },
      {
        "dni" : "12345578",
        "name": "Pepito",
        "lastName": "Gomez",
        "birthday":"10/11/1982",
        "mail": "arjona@gmail.com"
      }
    ],
    "paymentMethod" : {
      "type" : "CREDIT",
      "number": "1234-1234-1234-1234",
      "dues" : 6
    }
    }}
</sub>

#
**US 0004** *localhost:8080/api/v1/flights*

**US 0005** *localhost:8080/api/v1/flightss?dateFrom=10/02/2022&dateTo=21/02/2022&origin=Puerto Iguazú&destination=Bogotá*

**US 0006** *localhost:8080/api/v1/flight-reservation*

<sub>
{
  "userName" : "arjona@gmail.com",
  "flightReservation": {
    "dateFrom" : "10/02/2022",
    "dateTo": "17/02/2022",
    "origin": "Buenos Aires",
    "destination": "Tucumán",
    "flightNumber" : "BATU-5536",
    "seats" : 2,
    "seatType" : "ECONOMY",
    "people" : [
      {
        "dni" : "12345678",
        "name": "Pepito",
        "lastName": "Gomez",
        "birthday":"10/11/1982",
        "mail": "arjona@gmail.com"
      },
      {
        "dni" : "12345578",
        "name": "Pepito",
        "lastName": "Gomez",
        "birthday":"10/11/1982",
        "mail": "arjona@gmail.com"
      }
    ],
    "paymentMethod" : {
      "type" : "CREDIT",
      "number": "1234-1234-1234-1234",
      "dues" : 6
    }

  }
}
</sub>
