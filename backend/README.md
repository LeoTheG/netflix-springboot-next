# Springboot app

Created following https://spring.io/quickstart

## Install Java 17

Following https://linux.how2shout.com/oracle-java-ubuntu-22-04/

1. wget https://download.oracle.com/java/17/latest/jdk-17_linux-x64_bin.deb
2. sudo apt install ./jdk-17_linux-x64_bin.deb
3. java -version

## Start

```bash
./gradlew bootRun
```

Navigate to http://localhost:8080/hello

## Troubleshooting

### Lock File / currently in use by another Gradle instance.

Stop the gradle daemon

```bash
./gradlew --stop
```

Stop all java processes

```bash
killall java
```

### Code changes not appearing

Currently you have to restart the docker container to see file changes in the backend instead of auto restarting. TODO: figure out a solution.

## Deeper Dive

Tutorial on DB connection: https://studygyaan.com/spring-boot/how-to-connect-postgresql-database-in-spring-boot-project

### JPA Repository

A JPA repository is an interface that provides access to data stored in a relational database. It is a part of the Spring Data JPA project, which provides a set of tools and extensions for working with JPA.
The JPA repository interface provides a number of methods for accessing data, such as `save()`, `find()`, `delete()`, and `count()`. These methods can be used to perform CRUD operations on data entities.
The JPA repository interface is also extensible, so you can add your own methods to it. This makes it easy to customize the way you access data.
Overall, the JPA repository interface is a powerful tool for accessing data stored in a relational database. It makes it easy to perform CRUD operations and to customize the way you access data.

### Serving public images

In Spring Boot, certain directories are automatically included in the classpath.

These include directories like src/main/resources/, among others. Spring Boot is configured by default to serve static resources (like HTML, CSS, and image files) from certain directories in the classpath.

In this application, we store public assets like GIFs and images in src/main/resources/static. In production, we would likely use a CDN to serve these assets, but for now, we can just serve them from the classpath.
