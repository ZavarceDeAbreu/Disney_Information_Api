# Disney_Information_Api

## Presentation
Api that allows you to navigate through the characters of the Disney world and their movies.

# Main functionalities.
Crud.

### Technologies.
- Java 11.
- Spring Boot 2.6.3.
- hibernate.
- MySql.
- Lombok.
- JWT.
- spring-security.


### Installation procedure.
Steps to run the code.
- Download the project or clone it.
- import the project to the IDE.
- create database db_disney_information_api.
- run spring boot app.
- load into roles table:

| user_id      | name           |
|   :---:      |     :---:      | 
| 1            | ROLE_USER      |
| 2            | ROLE_ADMIN     | 


- load into user_entity table:

| user_id      | email          | name           | name           | paswword       | username       |
|   :---:      |     :---:      |     :---:      |     :---:      |     :---:      |     :---:      |
| 1            |USER1@GMAIL.COM | ROLE_USER      | user           | 12345          | user           |
| 2            |ADMIN@GMAIL.COM | ROLE_USER      | admin          | 12345          | admin          | 


- load into userRole table:

| user_id      | rol_id         |
|   :---:      |     :---:      | 
| 1            | 1              |
| 2            | 2              | 



# Links of interest.
Documentacion Postman.
- */genre*. [Link](https://documenter.getpostman.com/view/20086606/UzJHQcwR).
- */characters*. [Link](https://documenter.getpostman.com/view/20086606/UzJHQcwQ).
- */movies*. [Link](https://documenter.getpostman.com/view/20086606/UzJHQd1m).
- */movies*. [Link](https://documenter.getpostman.com/view/20086606/UzJHQd1m).
- */auth*. [Link](https://documenter.getpostman.com/view/20086606/UzJHQd6B).

# Aspects pending improvement.
A continuación se definen aspectos que requieren tenerse en cuenta para próximas actualizaciones.
- improve api accessibility.
- modify add and remove characters from a movie. 
- add SendGrid.
- add tests.
