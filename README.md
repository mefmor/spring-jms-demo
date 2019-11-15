# spring-jms-demo
This project provides an example of how to test a JMS service.

This sample based on the article [MQ JMS application development with Spring Boot](sochttps://developer.ibm.com/tutorials/mq-jms-application-development-with-spring-boot/)

In this test we work with real IBM MQ queue, for this purposes before use run it in the Docker:
```shell script
docker run ‑‑env LICENSE=accept ‑‑env MQ_QMGR_NAME=QM1 
           ‑‑publish 1414:1414 
           ‑‑publish 9443:9443 
           ‑‑detach 
           ibmcom/mq
```

Check that the server is running using **docker ps**
```shell script
$ docker ps
CONTAINER ID        IMAGE               COMMAND             CREATED             STATUS              PORTS                                            NAMES
3a225c721428        ibmcom/mq           "runmqdevserver"    4 hours ago        Up 4 hours         0.0.0.0:1414‑>1414/tcp, 0.0.0.0:9443‑>9443/tcp   reverent_bartik
```

Connection parameters can be find in **application.properties**