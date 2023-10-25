# TODO-list

A simple Java Spring Boot application, MySQL runs as a container, using ReactJS as frontend, using docker container as proxy server

### Table Content
* Background
   * Installation Environmental Dependence
   * Database Deploy Procedure
* Instructions for use
   * Database Information
   * TODO List
   * Docker Container
   * Video Tour
* Description of the catalogue structure
* Change Log

***

## Installation Environmental Dependence

1. Java 8.0
2. MySQL 8.0
3. NodeJs 18.18.0
4. VM with docker compose

## Database Deploy Procedure
- IDEA support MySQL RDDMS, config properties of DB server before visit MySQL in IDE
- Confirm hostname and password, then connect to DB instance
- Update Database pointer: Convert application.yml and track data source location pointer to as solution, ensure that the contents of the 2 configuration files are in sync

*We prefer to use Entity Framework migration*



## Database Information

| name      | done | create_time     |
| :---        |    :----:   |          ---: |
| 567      | false       | 2023-09-29 11:21:37   |

## TODO List
- support by view item for TODO list
- support by add single item for TODO list
- support by delete single item for TODO list
- support by batch selection for TODO list
- support by batch deletion for TODO list

## Docker Container
- Create Docker file to build a Docker image, the image contains mysql 8.0 and nginx
- Edit compose file to solve port mapping destination and nginx file calling privilege
- Build application and start it on VM

## Video Tour


https://github.com/Tommygiant/TODO-list/assets/78850099/076bfef1-e9c3-4337-aa3f-11b474660aff




***

### When you open this framework project using `IDEA` you will see the following structure.

![react-front](https://github.com/Tommygiant/TODO-list/assets/78850099/c0f51e8f-793e-4f97-a729-06b81d21a2ab)



`src/App.js: ` It includes all front-end operations and page render for 4 major components

`components/Footer.js：` It includes interface logic and page render for footer

`components/Header.js：` It includes interface logic and page render for header

`components/Item.js：` It includes interface logic and hover display

`components/List.js：` It includes interface logic and page render for list

`src/index.js: ` Entry of front-end 

![springboot-backend](https://github.com/Tommygiant/TODO-list/assets/78850099/73d6e536-941d-46b8-b40b-830e333e0bee)



`mapper/TaskMapper.xml：` configuration file for mybatis plus package and define form of mapping result

`application.yml：` configuration file for DB

`common/Result：` Define class Result, which is the object response to front-end

`controller/TaskController：` It includes all back-end operations

`entity Folder：` It includes interaction with DB and attributes of DB object

`service Folder：` It has implementation of business logic of all back-end API 


## Change Log

### v0.0 (2023/09/26 13:00 +00:00)
- Design TODO list document
- Set up database configuration file
- Inject maven and spring boot dependence


### v0.1 (2023/09/27 13:00 +00:00)
- Set up mybatis plus and configuration file 
- Modify constructuion to design front page display and database information
- Design controller to connect API
- Design entity and task serivce

### v0.2 (2023/09/28 09:00 +00:00)
- Deployment page optimisation
- Modify page components
- Design interface logic
- Modify README
- Version Testing

### v0.3 (2023/09/29 11:00 +00:00)
- VM setup
- Build application and package it to VM
- Create Dockerfile and edit compose file
- Version Testing

### v0.4 (2023/10/02 18:00 +00:00)
- Overwrite Dockerfile for front-end and back-end
- Fix DB initial problem in docker
