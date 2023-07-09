---
layout: default
title: Getting started
nav_order: 2
description: "Get started with Sendbox with a step by step example."
---

# Getting Started with Sendbox

---
<details open markdown="block">
  <summary>
    Table of contents
  </summary>
  {: .text-delta }
1. TOC
{:toc}
</details>
---

This guide will walk you through the process of getting started with Sendbox - a lightweight email sending library for Scala.

## Installation

To use Sendbox in your Scala project, you need to add it as a dependency in your build configuration. Here's an example using sbt:

```scala
libraryDependencies += "com.novasoftworks.sendbox" %% "sendbox-core" % "x.x.x"
```

Remember to replace "x.x.x" with the desired version of Sendbox.
{: .warning}

## Sending an Email

To send an email with Sendbox, you need to configure the SMTP settings and create an instance of the Sendbox class. Here's a simple example:

```scala
import com.novasoftworks.sendbox.models.Email
import com.novasoftworks.sendbox.Sendbox
import com.novasoftworks.sendbox.smtp.SmtpConfig

// Create Sendbox instance from SMTP settings
val sendbox = Sendbox(SmtpConfig(
  host = "smtp.example.com",
  port = 587,
  username = Some("your_username"),
  password = Some("your_password")
))

// Send an email
sendbox.send(Email(
  from = "sender@example.com",
  to = "recipient@example.com",
  subject = "Hello, Sendbox!",
  body = "This is the content of the email."
))
```

Make sure to replace the SMTP settings with your own configuration.
{: .warning}

That's it! With just a few lines of code, you can send emails using Sendbox in your Scala application.

## Next Steps
Now that you have sent your first email with Sendbox, you can explore the advanced features and customization options. Refer to the [SMTP] guide for more information on configuring SMTP settings, handling authentication, managing timeouts, and more.

[SMTP]: smtp.html