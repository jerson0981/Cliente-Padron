\# Evidencias finales - Cliente Padrón Electoral



\## Funcionamiento general



El Cliente Padrón Electoral fue desarrollado en Java y permite consultar información del padrón electoral mediante una interfaz gráfica.



El cliente se comunica con el servidor utilizando dos protocolos:



\- TCP

\- HTTP



\## Evidencias de funcionamiento



Durante las pruebas se verificaron los siguientes escenarios:



\### Consulta exitosa mediante TCP

Se realizó una consulta utilizando una cédula válida. El cliente recibió correctamente los datos enviados por el servidor y mostró la información de la persona en la interfaz gráfica.



\### Consulta exitosa mediante HTTP

Se realizó la consulta utilizando el protocolo HTTP y se comprobó la correcta comunicación entre el cliente y el servidor.



\### Validación de campos

El sistema valida que se ingrese una cédula y que esta contenga únicamente números.



\### Persona no encontrada

Cuando se consulta una cédula inexistente, el cliente muestra un mensaje indicando que no se encontró una persona con la cédula indicada.



\### Servidor no disponible

Cuando el servidor no se encuentra disponible, el cliente controla el error de conexión y muestra un mensaje informativo al usuario.



\## Resultado final



Las pruebas realizadas demuestran el funcionamiento del Cliente Padrón Electoral, la comunicación mediante TCP y HTTP, el procesamiento de respuestas JSON, las validaciones de entrada y el manejo de errores.

