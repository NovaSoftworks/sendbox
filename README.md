# Sendbox Library

Sendbox is a lightweight Scala library that facilitates sending emails built on top of the Jakarta Mail API

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![Scala version](https://img.shields.io/badge/scala-2.12.12-red.svg)](https://www.scala-lang.org/)
[![Documentation](https://img.shields.io/badge/docs-latest-brightgreen.svg)][documentation]

## Why?

Many projects and applications have simple needs when it comes to email sending. They require a lightweight and easy-to-use solution without the need for complex email service integrations or heavy dependencies. Sendbox is designed to address these simple needs by providing a simple and intuitive API for sending emails using the SMTP protocol. It aims to offer a lightweight and dependency-free solution for sending emails without unnecessary complexity.

## Features

- Simple and intuitive API for sending emails
- Support for SMTP-based email sending
- Lightweight and easy to integrate

## Getting Started

### Prerequisites

- Scala 2.12 or higher

### Installation

Add the following dependency to your `build.sbt` file:

    libraryDependencies += "com.novasoftworks.sendbox" %% "sendbox-core" % "0.1-SNAPSHOT"

### Usage

```scala
import com.novasoftworks.sendbox.Sendbox
import com.novasoftworks.sendbox.models.Email
import com.novasoftworks.sendbox.smtp.SmtpConfig

val smtpConfig = SmtpConfig(/* configuration values */)
val sendbox = Sendbox(smtpConfig)

val email = Email(/* email details */)
sendbox.send(email)

```

For more details and examples, please refer to the [documentation].

## Found a bug?
If you find a bug or unexpected behavior while using Sendbox, please open an [issue][issues]. Provide a clear description of the problem, including steps to reproduce it if possible. Contributions to fix the bug are also welcome!


## Contributing
Found a bug? 
Contributions are welcome! Read the [contribution guidelines] for more information on how to get involved.

## License
This project is licensed under the MIT License - see the [LICENSE] file for details.

[documentation]: https://novasoftworks.github.io/sendbox/
[repository]: https://github.com/NovaSoftworks/sendbox
[issues]: https://github.com/NovaSoftworks/sendbox/issues
[contribution guidelines]: CONTRIBUTING.md
[LICENSE]: LICENSE