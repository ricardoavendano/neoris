# Prueba Neoris
Ricardo Avendaño Casas

Para ejecutar el proyecto se deben realizar los siguientes pasos
1. descargar fuente de github: git clone https://github.com/ricardoavendano/neoris.git
2. El proyecto esta desarrollado con java 17, ir al directorio donde se encuentra el fuente y crear jar: mvn clean install (se crea la carpeta target)
3. Ir al directorio donde se encuentra el fuente y dirigirse a la carpeta target; por linea de comandos ejecutar jar: java -jar NeorisMS-0.0.1-SNAPSHOT.jar
4. La aplicacion ya se encuentra desplegada localmente en la url (http://localhost:8080)
5. Ingreso a la BD H2
   url: http://localhost:8080/api/h2-console/login.jsp
   JDBC URL: jdbc:h2:mem:neoris
   User name: neoris
   Password: neoris

   Tablas: BRAND, PRICES
6. Ejecución Sonar y pruebas unitarias

   - Jacoco: al ejecutar mvn clean instal se crea la siguiente ruta donde se puede consultar el reporte de jacoco: ../target/site/jacoco/index.html
   - Sonar: en el proyecto esta el file sonar-project.properties, para ejecutarlo se recomienda tener la imagen de sonarqube en Docker, se ejecuta con el siguiente comando: sonar-scanner -Dproject.settings=sonar-project.properties

Tablas: BRAND, PRICES
7. Uso de Swagger y pruebas
   http://localhost:8080/api/swagger-ui.html#/


	- Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
		- curl --location --request GET 'http://localhost:8080/api/price?applicationDate=2020-06-14-10.00.00&productId=35455&brandId=1'

	- Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
		- curl --location --request GET 'http://localhost:8080/api/price?applicationDate=2020-06-14-16.00.00&productId=35455&brandId=1'

	- Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
		- curl --location --request GET 'http://localhost:8080/api/price?applicationDate=2020-06-14-21.00.00&productId=35455&brandId=1'

	- Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
		- curl --location --request GET 'http://localhost:8080/api/price?applicationDate=2020-06-15-10.00.00&productId=35455&brandId=1'

	- Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
		- curl --location --request GET 'http://localhost:8080/api/price?applicationDate=2020-06-16-21.00.00&productId=35455&brandId=1'