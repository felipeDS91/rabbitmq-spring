<h1 align="center">
  <img
    alt="Logo"
    src="https://res.cloudinary.com/dixtjpk8s/image/upload/v1615490614/Projects/1_OVeZ2pRMbcEQL0N3vMYpGA_fzaj5f.png" width="250px"
  />
</h1>

<h3 align="center">
  RabbitMQ with Spring Boot
</h3>

<p align="center">
  <img alt="GitHub top language" src="https://img.shields.io/github/languages/top/felipeDS91/rabbitmq-spring?color=%230484ff">
  
  <a href="https://www.linkedin.com/in/felipe-douglas-dev/" target="_blank" rel="noopener noreferrer">
    <img alt="Made by" src="https://img.shields.io/badge/made%20by-felipe%20douglas-%230484ff">
  </a>

  <img alt="Repository size" src="https://img.shields.io/github/repo-size/felipeDS91/rabbitmq-spring?color=%230484ff">
  
  <a href="https://github.com/FelipeDS91/rabbitmq-spring/commits/master">
    <img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/FelipeDS91/rabbitmq-spring?color=%230484ff">
  </a>

  <a href="https://github.com/FelipeDS91/rabbitmq-spring/issues">
    <img alt="Repository issues" src="https://img.shields.io/github/issues/FelipeDS91/rabbitmq-spring?color=%230484ff">
  </a>

  <a href="#-about-the-project">About the project</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-technologies">Technologies</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-getting-started">Getting started</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
</br>


## 👨🏻‍💻 About the project

This project is an introductory example of how to use RabbitMQ with Java using Spring Boot.
Here, we have 2 main applications, a producer and a consumer.
At the producer, we have the http://localhost:8081/ send endpoint that accepts a POST request with a json that should contain a message. As in the example below:

```bash
{
    "text": "teste"
}
```

Once this message is sent, the consumer will receive that message and process it. If the content of the "text" field is equal to "test" an error will be generated and this message will be forwarded to a queue called dl.producer.aula-spring (Dead Letter).
This project also has a Schedule configured with a service that tries to republish the messages that gave an error, returning the messages to the main queue. This republish tries to resend these messages 3 times and on the 4th time it sends this message to the pl.producer.aula-spring (Parking Letter) queue, we can manually check these messages.
In parallel to this schedule, we also have the possibility to activate the republish service by consuming the consumer's endpoint at http://localhost:8082/ repost with a GET request.


## 🚀 Technologies

- [Java](https://www.java.com/pt_BR/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Docker](https://docs.docker.com/)

## 💻 Getting started

### Requirements
 - [Java](https://www.java.com/pt_BR/)
 - [Docker](https://docs.docker.com/)
 - [Spring Tools Suite](https://spring.io/tools)

**Clone the project and access the folder**

```bash
$ git clone https://github.com/felipeDS91/rabbitmq-spring.git && cd rabbitmq-spring
```

**Follow the steps below**

```bash
# Start a RabbitMQ container using the following command
$ docker run -d -p 15672:15672 -p 5672:5672 --name rabbitmq rabbitmq:3-management
```

>To check if the RabbitMQ is working properly,  access http://localhost:15672/ e with this default credentials bellow: 
```bash
	username = guest 
	password = guest
```

Finally, just run both projects with the STS (Spring Tools Suite).


Made with 💜&nbsp; by Felipe Douglas 👋 [See my linkedin](https://www.linkedin.com/in/felipe-douglas-dev/)
