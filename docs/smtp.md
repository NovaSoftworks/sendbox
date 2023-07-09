---
layout: default
title: SMTP
nav_order: 3
description: "All you need to know about using SMTP with Sendbox."
---

# SMTP Configuration

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

Sendbox provides a simple and flexible way to configure SMTP settings for sending emails. This guide will walk you through the available configuration options.

## SmtpConfig

The `SmtpConfig` class is used to configure the SMTP settings for the Sendbox instance. It has the following properties:

- `host`: The SMTP server host.
- `port`: The SMTP server port.
- `username`: (Optional) The username for SMTP authentication.
- `password`: (Optional) The password for SMTP authentication.
- `timeout`: The timeout for SMTP operations (default is 1000 milliseconds).

### Example Usage

Here's an example of configuring the SMTP settings using `SmtpConfig`:

```scala
val smtpConfig = SmtpConfig(
  host = "smtp.example.com",
  port = 587,
  username = Some("your_username"),
  password = Some("your_password"),
  timeout = 2000
)
```

In this example, we configure the SMTP server to smtp.example.com on port 587 with authentication using the provided username and password. We also set the timeout to 2000 milliseconds.

If you don't require authentication or custom timeout, you can omit username, password amd/or timeout parameters:
```scala
val smtpConfig = SmtpConfig(
  host = "smtp.example.com",
  port = 587
)
``` 

## Sending Emails

Once you have configured the SMTP settings using SmtpConfig, you can create an instance of the Sendbox class and use it to send emails. Refer to the [Getting Started] guide for more information on sending emails with Sendbox.

[Getting Started]: getting-started.html