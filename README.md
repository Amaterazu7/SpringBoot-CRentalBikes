# Spring boot CRentalBikes

This development was created in spring-boot. In order to visualise it I suggest creating a database MySQL called "**test**", All data source settings are found in the **application.properties** of the project, in case to be needed. 
Furthermore, I suggest running this development as spring boot application which will be defaultly visualised from this link "http://localhost:8080/" once there, you will need to go to the section **pack** ("http://localhost:8080/pack") and generate the 3 packs with its appropriate data and prizes, for example: "Rental by hour, Rental by day &Rental by week". Finally, you will generate at least one or two **customers** from its selection("http://localhost:8080/customer"). 

## Development practices applied

This development was created through MVC architecture so in that way I could separate the logic of the controllers that mapping request REST, the data model using Spring Data Repositories to data and requests persistence and the view through jsp, which will perform angular and bootswatch operation.

## The Design

This design is a spring boot REST + JPA + hibernate + MySQL example. Here I created a REST application that be perform CRUD operation using MySQL. Spring boot provides default database configurations when it scans Spring Data JPA in classpath. Spring boot uses spring-boot-starter-data-jpa starter to configure spring JPA with hibernate. For data source I was need to configure data source properties starting with **spring.datasource.** in **application.properties** and then spring data JPA will configure data source automatically and I worked with an Interface for each model with the structure heredated by CrudRepository. To run the application I created a class with main() method that be call SpringApplication.run() to start the application with embedded tomcat. The class with main() method was annotated with @SpringBootApplication.
	
## How Run the tests?

To run the tests I suggest executing the application and adding all data to it. There are also some data that work as entries to the tests and can be configured in **test*.java**. In addition to this, to run some of the tests I used TDD (up to a %28 of coverage over the controllersREST) with JUnit y Mockito.
> **Note:** Todo lo que aplique de test es exclusivamente reciente ya que nunca realice estos test en el marco laboral, lo que ví fue exclusivamente académico y algo más por investigación propia.
