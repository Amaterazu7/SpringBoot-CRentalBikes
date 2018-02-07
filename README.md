# Spring boot CRentalBikes

This development was created in spring-boot. In order to visualise it I suggest creating a database MySQL called "**test**", All data source settings are found in the **application.properties** of the project, in case to be needed. 
Furthermore, I suggest running this development as spring boot application which will be defaultly visualised from this link "http://localhost:8080/" once there, you will need to go to the section **pack** ("http://localhost:8080/pack") and generate the 3 packs with its appropriate data and prizes, for example: "Rental by hour, Rental by day &Rental by week". Finally, you will generate at least one or two **customers** from its selection("http://localhost:8080/customer"). 

## The Design

This design is a spring boot REST + JPA + hibernate + MySQL example. Here I created a REST application that  be perform CRUD operation using MySQL. Spring boot provides default database configurations when it scans Spring Data JPA in classpath. Spring boot uses spring-boot-starter-data-jpa starter to configure spring JPA with hibernate. For data source I was need to configure data source properties starting with **spring.datasource.** in **application.properties** and then spring boot JPA will configure data source automatically. To run the application I created a class with main() method that be call SpringApplication.run() to start the application with embedded tomcat. The class with main() method was annotated with @SpringBootApplication.

## development practices applied

El desarrollo lo realicé sobre una arquitectura MVC. Para así, separar la lógica de los Controladores que mapean las consultas REST, el Modelo de datos usando Spring Data Repositories para la persistencia de los datos y consultas y, la Vista sobre jsp, la cual le adicione AngularJS y Bootswatch. Además para realizar algunos test use TDD (llegando a un Coverage del 28% sobre los ControllersRest) con JUnit y Mockito.
> **Nota:** Todo lo que aplique de test es exclusivamente reciente ya que nunca realice estos test en el marco laboral, lo que ví fue exclusivamente académico y algo más por investigación propia.
	
## How Run the tests?

Para correr los test, yo sugiero que se ejecute la aplicación y se agreguen datos a la misma. Por otro lado, también hay algunos datos que funcionan como entradas de las pruebas a realizar y se pueden modificar desde los archivos test*.java. 
