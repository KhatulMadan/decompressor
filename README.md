#DECOMPRESSOR
================

Java micro service that decompresses the files downloaded from GoogleDrive.

# Overview

This micro service downloads the file and automatically decompresses it. Supported types of compression:
- Zip.
- BZip2.
- GZip.

If the file is not compressed or compression is not supported the app will let you know about this.

# How to Start

Go to http://localhost:8181/decompress?name= and provide the link to the file.

      Example: http://localhost:8181/decompress?name=https://drive.google.com/open?id=...
   
# Built With  

* [Java](http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html)  
* [Maven](https://maven.apache.org/) - Dependency Management  
* [Spring Boot](https://projects.spring.io/spring-boot/) - Web Framework 
* [JUnit](http://junit.org) / [Mockito](http://site.mockito.org) - Test










 
