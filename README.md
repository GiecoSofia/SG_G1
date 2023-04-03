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
