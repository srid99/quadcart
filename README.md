quadcart
========

A simple shopping cart application.

This application can be used as a reference for an enterprise Java application.


=== Technology stack:

1. Spring framework for IoC
2. Spring MVC with JSP and Tiles
3. Spring data with Hibernate as JPA adaptor
4. JQuery used for client side DOM and AJAX operations
5. Underscore used for client side templating
6. Maven as build tool
7. Selenium for integration testing
8. Logback for logging


=== How to start the application ?

Use the below maven command to start tomcat server. You need JDK6 and Maven installed in your machine.

    $ mvn clean install tomcat:run

By default maven tomcat plugin uses the port 8080. If you like to run in a different port then you can use below command.

    $ mvn clean install tomcat:run -Dmaven.tomcat.port=9000

If the server started sucessfuly then you must be able to access the application using http://localhost:8080/quadcart-web/


=== How to run selenium test ?

Use the below command to run the selenium suite. Make sure the application is up and running before you run the suite.

    $ mvn test -Pselenium
