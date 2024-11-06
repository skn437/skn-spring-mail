# SKN Reactive Spring Boot Mail Library

<img width="150px" src="https://firebasestorage.googleapis.com/v0/b/skn-ultimate-project-la437.appspot.com/o/GitHub%20Library%2F04-Spring%20Boot-SSM.svg?alt=media&token=52fedfd3-921c-413b-992c-db9d84eecd2e" alt="java" />

> Java

[![Maven Central](https://img.shields.io/maven-central/v/best.skn/skn-spring-mail)](https://central.sonatype.com/artifact/best.skn/skn-spring-mail) [![Javadoc](https://javadoc.io/badge2/best.skn/skn-spring-mail/2.1.0/javadoc.svg)](https://javadoc.io/doc/best.skn/skn-spring-mail/2.1.0) [![Apache License 2.0](https://img.shields.io/badge/License-Apache_2.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

&nbsp;

## **_JavaDocs:_**

### Read the Javadoc for the main Service APIs

- [MailSenderService API](https://javadoc.io/doc/best.skn/skn-spring-mail/latest/best/skn/mail/services/MailSenderService.html)
- [MailSenderRequestInfo API](https://javadoc.io/doc/best.skn/skn-spring-mail/latest/best/skn/mail/models/MailSenderRequestInfo.html)
- [MailSenderInputStream API](https://javadoc.io/doc/best.skn/skn-spring-mail/latest/best/skn/mail/models/MailSenderInputStream.html)
- [MailSenderHtmlTemplate API](https://javadoc.io/doc/best.skn/skn-spring-mail/latest/best/skn/mail/models/MailSenderHtmlTemplate.html)

&nbsp;

## **_Introduction:_**

### This is a simple Java Reactive Spring Boot Library for sending mails

### I made this library so that I can use it in most of my spring boot reactive projects without writing the same codes over and over again

### The main API Classes of this library are `MailSenderService` which has 4 methods to send mails, `MailSenderRequestInfo` which holds the blueprint for `@RequestBody/@RequestPart` annotated params, `MailSenderInputStream` which holds the blueprint for processing proper input stream info & `MailSenderHtmlTemplate` which holds the blueprint for processing proper thymeleaf HTML template info. These APIs are for controllers

&nbsp;

## **_Details:_**

### **(1) `MailSenderService` Class:**

- It needs to be instantiated first
- It must be used in controller POST requests
- It has 4 methods to send mails
- These 4 methods throw `MessagingException` if sending error occurs
- 2 methods out of 4 also throw `IOException` if file attachment error occurs
- The modes to send mails:
  - Basic Mail (It throws `MessagingException`)
  - Basic Mail With Attachment (It throws `MessagingException` & `IOException`)
  - Mail With HTML Template (It throws `MessagingException`)
  - Mail With HTML Template & Attachment (It throws `MessagingException` & `IOException`)

### **(2) `MailSenderRequestInfo` Class:**

- It is the blueprint for `@RequestBody/@RequestPart` annotated params in controllers
- In controller POST requests, the request body or request part must match the blueprint of it

### **(3) `MailSenderInputStream` Class:**

- It is the blueprint for processing proper input stream info in controllers
- In controller POST requests, it will receive `MultipartFile` type as `@RequestPart`
- Then this API instance should be created with the input stream

### **(4) `MailSenderHtmlTemplate` Class:**

- It is the blueprint for processing proper thymeleaf HTML template info in controllers
- The project should have a Thymeleaf Html Template already
- Then this API instance should be created with the template name and the variable name inside that template

&nbsp;

## **_Requirements:_**

- 💀 Minimum Java Version: `21`
- 💀 Minimum Spring Boot Version: `3.3.5`
- 💀 Spring Web Flux (Reactive Spring Boot)
- 💀 Spring Java Mail Sender
- 💀 Spring Thymeleaf

&nbsp;

## **_Usage:_**

### For `Maven`, inside `dependencies` tag of `pom.xml`, copy the following

> ```xml
> <dependency>
>   <groupId>best.skn</groupId>
>   <artifactId>skn-spring-mail</artifactId>
>   <version>2.1.0</version>
> </dependency>
> ```

### For `Gradle`, inside `dependencies` block of `build.gradle.kts`, copy the following

> ```kotlin
> implementation("best.skn:skn-spring-mail:2.1.0")
> ```

### First create a configuration class

> ```java
> @Configuration
> @Import(best.skn.mail.configurations.MailSenderConfiguration.class)
> public class MailSenderConfiguration {}
> ```

### Inside your Java Code, import the package like this for `MailSenderService`

> ```java
> import best.skn.mail.services.MailSenderService;
> ```

### Inside your Java Code, import the package like this for `MailSenderRequestInfo`, `MailSenderInputStream` & `MailSenderHtmlTemplate`

> ```java
> import best.skn.mail.models.*;
> ```

### In controller POST requests, use it like the following (Just an example)

> ```java
> @Autowired
> private MailSenderService mailSender;
>
> @PostMapping("/endpoint-for-basic-mail")
> public Mono<String> sendMail(@RequestBody MailSenderRequestInfo info)
> throws MessagingException {
>   return this.mailSender.sendMail(info);
> }
>
> @PostMapping("/endpoint-for-mail-with-attachment")
> public Mono<String> sendMailWithAttachment(
>   @RequestPart MailSenderRequestInfo info,
>   @RequestPart MultipartFile file
> ) throws MessagingException, IOException {
>   MailSenderInputStream stream = new MailSenderInputStream(
>     "output file location here",
>     file.getInputStream()
>   );
>
>   return this.mailSender.sendMailWithAttachment(info, stream);
> }
>
> @PostMapping("/endpoint-for-mail-with-html-template")
> public Mono<String> sendMailWithHtmlTemplate(
>   @RequestBody MailSenderRequestInfo info
> ) throws MessagingException {
>   // you must have "mail.html" in `resources/templates` and the template must have a `message` variable
>   MailSenderHtmlTemplate template = new MailSenderHtmlTemplate(
>     "mail.html",
>     "message"
>   );
>
>   return this.mailSender.sendMailWithHtmlTemplate(info, template);
> }
>
> @PostMapping("/endpoint-for-mail-with-html-template-and-attachment")
> public Mono<String> sendMailWithHtmlTemplateAndAttachment(
>   @RequestPart MailSenderRequestInfo info,
>   @RequestPart MultipartFile file
> ) throws MessagingException, IOException {
>   // you must have "mail.html" in `resources/templates` and the template must have a `message` variable
>   MailSenderHtmlTemplate template = new MailSenderHtmlTemplate(
>     "mail.html",
>     "message"
>   );
>
>   MailSenderInputStream stream = new MailSenderInputStream(
>     "output file location here",
>     file.getInputStream()
>   );
>
>   return this.mailSender.sendMailWithHtmlTemplateAndAttachment(info, template, stream);
> }
> ```

### When requesting the API from `Postman` or `Frontend Framework` for mails without attachment, the request body `json` format can be like the following-

> ```json
> {
>   "from": "sender email address",
>   "to": "receiver email address",
>   "subject": "mail subject",
>   "body": "mail body"
> }
> ```

### When requesting the API from `Postman` or `Frontend Framework` for mails with attachment, the request should be made with `form-data` format as it will be processed with `@RequestPart`

&nbsp;

## **_Dedicated To:_**

- 👩‍🎨`Prodipta Das Logno` & 🧛‍♀️`Atoshi Sarker Prithula`: The two most special ladies of my life. My best wishes will always be with you two. May you two always be happy.
- 💯`My Parents`: The greatest treasures of my life ever.

&nbsp;

## **_License:_**

Copyright (C) 2024 SKN Shukhan

Licensed under the Apache License, Version 2.0
