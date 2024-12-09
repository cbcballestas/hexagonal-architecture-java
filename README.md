# Hexagonal Architecture Java (Shop - carrito de compras)
Implementación de arquitectura hexagonal para aplicación: Shop - carrito de compras

## Requirements
- [JDK 21](https://adoptium.net/es/?variant=openjdk21)
- [Maven 3](https://maven.apache.org/)
- Docker

## Aspectos a tener en cuenta ⚠

- En la carpeta `postman` se encuentran los endpoints a revisar ( Arquitectura Hexagonal.postman_collection.json)

- La aplicación cuenta con dos modos de ejecución: `inmemory` y `mysql`. si desea ejecutar la aplicación con la persistencia
  orientada a base de datos, debe configurar el Launcher con el profile `mysql` usando el siguiente parámetro:

``` shell
 -Dspring.profiles.active=mysql
```  
  De lo contrario cambiar el valor del parámetro a `inmemory` ( para orientar la persistencia a memoria )
``` shell
 -Dspring.profiles.active=inmemory
```  

- Antes de ejecutar la aplicación ( Con la persistencia orientada a mysql) se recomienda ejecutar el siguiente comando para crear un container
  en docker con MySQL.

``` shell
docker run --name hexagon-mysql -d -p3306:3306 -e MYSQL_DATABASE=shop -e MYSQL_ROOT_PASSWORD=test mysql:8.1
```

## Run application

There are several ways to run a Spring Boot application in your local machine. The most common way is executing `main` method in `com.mitocode.shop.bootstrap.Launcher` class from your IDE

Alternative you can use [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/maven-plugin/reference/htmlsingle), just running:

```shell
mvn spring-boot:run
```
