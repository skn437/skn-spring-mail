# SKN Reactive Spring Boot Mail Library

## **_Introduction:_**

### This is a simple Java Reactive Spring Boot Library for sending mails

### I made this library so that I can use it in most of my spring boot projects without writing the same codes over and over again

### The main API Classes of this library are `MailSenderService` which has 4 methods to send mails & `MailSenderRequestBody` which holds the blueprint for `@RequestBody` annotated params in controllers

&nbsp;

## **_Details:_**

### **(1) `MailSenderService` Class:**

- It needs to be instantiated first
- It must be used in controller POST requests
- It has 4 methods to send mails
- These 4 methods throw `MessagingException` if sending error occurs
- The modes to send mails:
  - Basic Mail
  - Basic Mail With Attachment
  - Mail With HTML Template
  - Mail With HTML Template & Attachment

### **(2) `MailSenderRequestBody` Class:**

- It is the blueprint for `@RequestBody` annotated params in controllers
- In controller POST requests, the request body must match the blueprint of it

&nbsp;

## **_Requirements:_**

- 💀 Minimum Java Version: `21`
- 💀 Minimum Maven Version: `3.9.6`
- 💀 Minimum Spring Boot (Reactive/Web Flux) Version: `3.2.3`

&nbsp;

## **_Usage:_**

### For `Maven`, inside `dependencies` tag of `pom.xml`, copy the following

> ```xml
> <dependency>
>  <groupId>best.skn</groupId>
>  <artifactId>skn-spring-mail</artifactId>
>  <version>1.0.0</version>
> </dependency>
> ```

### Write the following in the terminal

> ```zsh
> mvn install
> ```

### Inside your Java Code, import the package like this for `MailSenderService`

> ```java
> import best.skn.mail.services.MailSenderService;
> ```

### Inside your Java Code, import the package like this for `MailSenderRequestBody`

> ```java
> import best.skn.mail.entities.MailSenderRequestBody;
> ```

### In controller POST requests, use it like the following

> ```java
> @Autowired
> private MailSenderService mailSender;
>
> @PostMapping
> public Mono<String> sendMail(@RequestBody MailSenderRequestBody requestBody) throws MessagingException {
>  return this.mailSender.sendMail(
>   requestBody.getFrom(),
>   requestBody.getTo(),
>   requestBody.getSubject(),
>   requestBody.getBody()
>  );
> }
> ```

&nbsp;

## **_Dedicated To:_**

- 🌹`Tanjila Hasan Trina`: The one & only love of my life. She is the reason my life got a meaning. I'm really blessed that she came into my life.
- 👩‍🎨`Prodipta Das Logno` & 🧛‍♀️`Atoshi Sarker Prithula`: The two most special ladies of my life. I can't thank them enough for always treasuring me a lot.
