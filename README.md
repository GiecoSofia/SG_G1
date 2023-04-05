<<<<<<< HEAD
# S3_G1 :robot:

```
Implementación de una base de datos RELACIONAL

OPERACIONES/ACCIONES TÉCNICAS Y FUNCIONALES  NECESARIAS
Configuración de conexión de base de datos y dependencias
Mapeo de entidades JPA + Hibernate
Se debe permitir el alta, baja, modificación y consulta de vuelos.
Se debe permitir el alta, baja, modificación y consulta de hoteles
Se debe permitir el alta, baja, modificación y consulta de reservas.

ROLES Y PERMISOS
Para esta US aún no se aplicarán roles o permisos de ningún tipo. Se deberán generar únicamente los endpoints correspondientes.

VALIDACIONES NECESARIAS
Para bajas y modificaciones debe existir el hotel, reserva o vuelo correspondiente. Caso contrario, se debe retornar el correspondiente status code y msje.
Para las consultas, en caso de no encontrar resultados se debe informar dicha situación mediante un mensaje.
Para altas, validar que no exista anteriormente una reserva con idénticas características.
Antes de dar de baja un vuelo o un hotel, validar que no se encuentre actualmente en una reserva. En caso de que sea así, no se podrá eliminar el registro, sin antes haber cancelado/eliminado la reserva.

```
:arrow_right::arrow_right::arrow_right:[Postman Collection](https://warped-crescent-741494.postman.co/workspace/SG_G1~aacb0340-36c9-41da-b086-22bb6ee5790b/collection/26247361-c0eadac5-a509-45ee-ba87-273a677926b5?action=share&creator=26106561)
=======
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
>>>>>>> a38a3bd2be27bfe4039d80f5cbe948db52e131ed
