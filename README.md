# HELLO NURLAN AGAI!
![SPRING FRAMEWORK](https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto/gigs/112684722/original/b94ed9fb929fa06098236596189678e329836457/create-java-spring-framework-application.png)

# Library Management REST API

> Library Management REST API using Spring boot framework, Hibernate, MySQL, JavaMailSender, Spring Security. This assignment is based on developing a Library Management REST API using “Java
Programming Language”. For REST API I used Spring Boot Framework because Spring simplifies integration with other Java frameworks like JPA/Hibernate ORM, to connect POJO(Plain Old Java Object) Entities to the database I used Spring data JPA which contains Hibernate ORM(Object Relational Mapping) framework. As a database I used MySQL database because it is one of the world’s most popular databases and it is open source, reliable and easy to manage. 


**AUTHOR: TIMUR KASENOV COM-18**

**ERD**

![ERD](https://i.imgur.com/jni5ykN.png)


- HOW TO START?

First of all you need to clone my github repository to your machine.

Change mysql username and password as per your installation**

+ open `src/main/resources/application.properties`

+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation.

 After that you must create library database in your MySQL server. For that you need to connect to your database server by terminal:

~$     mysql -u root -p

Create Mysql database**
```bash
create database library;
```

And the last step is configure access to Gmail from external mail clients (SMTP). If you do not configure on your Gmail account yet, please follow the instructions below to do so:

https://support.google.com/mail/answer/7126229?hl=ru

After configuration open Mail class in a service package and change these variables to your own email and password. 


Build and run the app using maven**

```bash
mvn package
java -jar target/spring-boot-rest-api-tutorial-0.0.1-SNAPSHOT.jar

```

Alternatively, you can run the app without packaging it using -

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:8080>.

PROJECT REPORT:
https://docs.google.com/document/d/10PWxCJ_83oHKdySOC8NQt2OIJDKY4ipcVPmmjTuG98M/edit?usp=sharing
