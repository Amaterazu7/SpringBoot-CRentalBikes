# Spring boot CRentalBikes

Este es un proyecto creado en **spring-boot**. Para su visualización sugiero que se cree una base de datos en mysql llamada "**test**", todos datos de configuración del base se encuentran en el **application.properties** del proyecto, en caso de ser necesario. 
 Además, sugiero que se ejecute el proyecto como aplicación springboot que por default se puedrá visualizar desde "http://localhost:8080/" y, ahí dentro ir a la sección "**Pack**" ("http://localhost:8080/pack") generar los 3 packs del enunciado con sus correspondientes datos, ejmplo: "Rental by hour, Rental by day &Rental by week" y sus precios. Y luego generar al menos uno o dos "**Customers**" desde su sección ("http://localhost:8080/customer").

## El diseño

This design is a spring boot REST + JPA + hibernate + MySQL example. Here I created a REST application that  be perform CRUD operation using MySQL. Spring boot provides default database configurations when it scans Spring Data JPA in classpath. Spring boot uses spring-boot-starter-data-jpa starter to configure spring JPA with hibernate. For data source we need to configure data source properties starting with **spring.datasource.** in **application.properties** and spring boot JPA will configure data source automatically. To run the application I created a class with main() method that be call SpringApplication.run() to start the application with embedded tomcat. The class with main() method was annotated with @SpringBootApplication.

## Las prácticas aplicadas

El desarrollo lo realicé sobre una arquitectura MVC. Para así, separar la lógica de los Controladores que mapean las consultas REST, el Modelo de datos usando Spring Data Repositories para la persistencia de los datos y consultas y, la Vista sobre jsp, la cual le adicione AngularJS y Bootswatch. Además para realizar algunos test use TDD (llegando a un Coverage del 28% sobre los ControllersRest) con JUnit y Mockito.
> **Nota:** Todo lo que aplique de test es exclusivamente reciente ya que nunca realice estos test en el marco laboral, lo que ví fue exclusivamente académico y algo más por investigación propia.
	
## ¿Como correr los tests?

Para correr los test, yo sugiero que se ejecute la aplicación y se agreguen datos a la misma. Por otro lado, también hay algunos datos que funcionan como entradas de las pruebas a realizar y se pueden modificar desde los archivos test*.java. 
