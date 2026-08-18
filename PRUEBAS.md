\# Pruebas del Cliente Padrón Electoral



\## Objetivo



Verificar el correcto funcionamiento del cliente del padrón electoral y su comunicación con el servidor mediante los protocolos TCP y HTTP.



\## Pruebas realizadas



\### 1. Consulta mediante TCP

Se realizó una consulta utilizando una cédula válida mediante el protocolo TCP.



Resultado: La aplicación mostró correctamente los datos de la persona consultada.



\### 2. Consulta mediante HTTP

Se realizó la misma consulta utilizando el protocolo HTTP.



Resultado: La aplicación recibió y mostró correctamente la información enviada por el servidor.



\### 3. Validación de cédula vacía

Se intentó realizar una consulta sin ingresar una cédula.



Resultado: El sistema mostró un mensaje indicando que se debe ingresar una cédula.



\### 4. Validación de caracteres

Se ingresaron caracteres no numéricos en el campo de cédula.



Resultado: El sistema indicó que la cédula debe contener solamente números.



\### 5. Persona no encontrada

Se realizó una consulta utilizando una cédula inexistente.



Resultado: El sistema informó que no se encontró una persona con la cédula indicada.



\### 6. Servidor no disponible

Se realizó una consulta con el servidor detenido.



Resultado: El cliente manejó el error de conexión y mostró el mensaje "No se pudo conectar con el servidor".



\## Resultado general



Las pruebas realizadas permitieron comprobar el funcionamiento de la interfaz gráfica, las validaciones de entrada, el manejo de errores y la comunicación mediante TCP y HTTP.

