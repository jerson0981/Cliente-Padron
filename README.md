\# Cliente de Padrón Electoral



Aplicación cliente desarrollada en Java para realizar consultas al servidor del Padrón Electoral de Costa Rica.



\## Funcionamiento



El cliente permite ingresar una cédula y realizar la consulta mediante dos protocolos:



\- TCP, utilizando el puerto 5000.

\- HTTP, utilizando el puerto 8080.



Los resultados obtenidos se muestran mediante una interfaz gráfica desarrollada en Java.



\## Arquitectura



El proyecto está organizado en diferentes capas y componentes:



\- Presentación: interfaz gráfica del usuario.

\- Lógica: procesamiento de las consultas.

\- Comunicación: clientes TCP y HTTP.

\- DTO: representación de personas y errores.

\- Utilidades: configuración y procesamiento JSON.



\## Manejo de errores



El cliente controla diferentes situaciones, entre ellas:



\- Cédula vacía.

\- Formato de cédula incorrecto.

\- Persona no encontrada.

\- Servidor no disponible.

\- Errores de comunicación.



El cliente utiliza Gson para procesar las respuestas JSON recibidas desde el servidor.

