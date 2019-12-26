# HELLO NURLAN AGAI!
<a href="https://banner2.cleanpng.com/20180713/otv/kisspng-spring-framework-software-framework-modelview-pepper-robot-5b48c128f2f1c1.7505867115314946969951.jpg" alt="Spring logo"></a>

# Library Management REST API

> Library Management REST API using Spring boot framework, Hibernate, MySQL, JavaMailSender, Spring Security. This assignment is based on developing a Library Management REST API using “Java
Programming Language”. For REST API I used Spring Boot Framework because Spring simplifies integration with other Java frameworks like JPA/Hibernate ORM, to connect POJO(Plain Old Java Object) Entities to the database I used Spring data JPA which contains Hibernate ORM(Object Relational Mapping) framework. As a database I used MySQL database because it is one of the world’s most popular databases and it is open source, reliable and easy to manage. 


**AUTHOR: TIMUR KASENOV COM-18**

**ERD**

<a href="https://imgur.com/jni5ykN" alt="Entities Relationship Diagram"></a>


- HOW TO START?

- First of all you need to clone my github repository to your machine. Then open this project in Intellij IDEA.

- Now your need to change some setting in application. Fill in abandoned fields with your MySQL server’s username and password. After that you must create library database in your MySQL server. For that you need to connect to your database server by terminal:

~$     mysql -u root -p

- and then use this command for creating library database:

 CREATE DATABASE library;

- And the last step is configure access to Gmail from external mail clients (SMTP). If you do not configure on your Gmail account yet, please follow the instructions below to do so:

https://support.google.com/mail/answer/7126229?hl=ru

-After configuration open Mail class in a service package and change these variables to your own email and password. 


- Now Run the project in IntelliJIDEA. Should boot correctly.
