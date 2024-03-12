# SKN Reactive Spring Boot Mail Library

[![Maven Central](https://img.shields.io/maven-central/v/best.skn/skn-spring-mail)](https://central.sonatype.com/artifact/best.skn/skn-spring-mail) [![Javadoc](https://javadoc.io/badge2/best.skn/skn-spring-mail/1.2.2/javadoc.svg)](https://javadoc.io/doc/best.skn/skn-spring-mail/1.2.2) [![Apache License 2.0](https://img.shields.io/badge/License-Apache_2.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

&nbsp;

## **_JavaDocs:_**

### Read the Javadoc for the main Service API: [MailSenderService API](https://javadoc.io/doc/best.skn/skn-spring-mail/latest/best/skn/mail/services/MailSenderService.html)

### Read the Javadoc for the main Entity API: [MailSenderRequestBody API](https://javadoc.io/doc/best.skn/skn-spring-mail/latest/best/skn/mail/entities/MailSenderRequestBody.html)

&nbsp;

## **_Introduction:_**

### This is a simple Java Reactive Spring Boot Library for sending mails

### I made this library so that I can use it in most of my spring boot reactive projects without writing the same codes over and over again

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
>  <version>1.2.2</version>
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

### First create a configuration class, and construct a bean

> ```java
> @Configuration
> public class MailSenderConfiguration {
> 	@Bean
> 	MailSenderService mailSenderService() {
> 		MailSenderService mailSender = new MailSenderService();
> 		return mailSender;
> 	}
> }
> ```

### Inside your Java Code, import the package like this for `MailSenderRequestBody`

> ```java
> import best.skn.mail.entities.MailSenderRequestBody;
> ```

### In controller POST requests, use it like the following (Just an example)

> ```java
> @Autowired
> private MailSenderService mailSender;
>
> @PostMapping
> public Mono<String> sendMail(@RequestBody MailSenderRequestBody requestBody) throws MessagingException {
> 	return this.mailSender.sendMail(
> 		requestBody.getFrom(),
> 		requestBody.getTo(),
> 		requestBody.getSubject(),
> 		requestBody.getBody()
> 	);
> }
> ```

### When requesting the API from `Postman` or `Frontend Framework`, the request body `json` format can be like the following

```json
{
	"from": "<sender email address>",
	"to": "<receiver email address>",
	"subject": "<mail subject>",
	"body": "<mail body>",
	"filePath": "<attachment file path>",
	"templateName": "<html template name>"
}
```

### In the `json` request body, the fields: `from`, `to`, `subject` & `body` are hard requirements to pass

### For `filePath` & `templateName` fields, if any of those are not sent as they are not hard requirements, the default value sent to the API will be `null`

### For instructions for `Gradle` & others: Visit [Maven Central](https://central.sonatype.com/artifact/best.skn/skn-spring-mail)

&nbsp;

## **_Dedicated To:_**

- 🌹`Tanjila Hasan Trina`: The one & only love of my life. She is the reason my life got a meaning. I'm really blessed that she came into my life. Though we are not present in the same place now, but my heart feels her presence always. No other girl can replace her in my life ever, it's a promise to myself and I know it.
- 👩‍🎨`Prodipta Das Logno` & 🧛‍♀️`Atoshi Sarker Prithula`: The two most special ladies of my life. I can't thank them enough for always treasuring me a lot.
