NOMBRE DEL SERVICIO: mercadolibre-mutantes-service
-api realizada para el Challenge Técnico con Mercadolibre, este api se Encuentra desplegada en un EC2 de AWS 
 con la siguiente url "http://3.131.137.77:80", y expone las capacidades:
  -http://3.131.137.77:80/mutant
  -http://3.131.137.77:80/stats
  

COMENZANDO
-para obtener una copia del proyecto ejecuta en tu consola:
>git clone https://github.com/johanforero77/mercadolibre-mutantes-service.git

PRE-REQUISITOS
-IDE con plugin de SpringBoot
-java-1.8
-maven
-git

INSTALACIÓN
-después de clonar el proyecto puedes generar el .jar al ejecutar el siguiente comando en
 la carpeta principal del proyecto
>mvn instal
-en la carpeta target encontrara el .jar el cual puedes ejecutar con:
>java -jar "nombre del jar

EJECUTANDO LAS PRUEBAS
-para la realización de pruebas automáticas con JUnit, después de clonar el proyecto
 en el package /src/test/java/com/mercadolibre/app/mutantes/ clase "MercadolibreMutantesApplicationTests.java"
 dar clic derecho y luego run as JUnit Test.

ANALIZANDO LAS PRUEBAS
- en las pruebas se validan cinco casos los cuales son:
 -mutante con coincidencia de más de 4 alelos horizontales
 -mutante con coincidencia de más de 4 alelos verticales
 -mutante con coincidencia de más de 4 alelos en diagonal de derecha a izquierda
 -mutante con coincidencia de más de 4 alelos en diagonal de izquierda a derecha
 -humano sin ninguna coincidencia de más de 4 alelos
  
DESPLIEGUE
 -para hacer el despliegue basta con ejecutar el jar, el proyecto tiene por defecto el puerto
  80 para recibir peticiones
  
Construido con
-SpringBoot 2.4.4
-java-1.8
-JUnit
-H2 Database Engine
-JPA
