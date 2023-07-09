package com.novasoftworks.sendbox.smtp

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class SmtpConfigSpec extends AnyFlatSpec with Matchers {

  "Creating SmtpConfig" should "succeed when given all and valid arguments" in {
    val config = SmtpConfig(
      host = "smtp.example.com",
      port = 587,
      username = Some("user"),
      password = Some("password"),
      timeout = 5000
    )

    config.host shouldEqual "smtp.example.com"
    config.port shouldEqual 587
    config.username shouldEqual Some("user")
    config.password shouldEqual Some("password")
    config.timeout shouldEqual 5000
    config.requireAuth shouldEqual true
  }

  it should "throw IllegalArgumentException when host is empty" in {
    assertThrows[IllegalArgumentException] {
      SmtpConfig(
        host = "",
        port = 587,
        username = Some("user"),
        password = Some("password"),
        timeout = 5000
      )
    }
  }

  it should "throw IllegalArgumentException when port is negative" in {
    assertThrows[IllegalArgumentException] {
      SmtpConfig(
        host = "smtp.example.com",
        port = -1,
        username = Some("user"),
        password = Some("password"),
        timeout = 5000
      )
    }
  }

  it should "throw IllegalArgumentException when password is defined without username" in {
    assertThrows[IllegalArgumentException] {
      SmtpConfig(
        host = "smtp.example.com",
        port = 587,
        username = None,
        password = Some("password"),
        timeout = 5000
      )
    }
  }

  it should "have username set to None by default" in {
    val config = SmtpConfig("host", 25)
    config.username shouldBe None
  }

  it should "have password set to None by default" in {
    val config = SmtpConfig("host", 25)
    config.password shouldBe None
  }

  it should "throw IllegalArgumentException when timeout is negative" in {
    assertThrows[IllegalArgumentException] {
      SmtpConfig(
        host = "smtp.example.com",
        port = 587,
        username = Some("user"),
        password = Some("password"),
        timeout = -1
      )
    }
  }

  it should "have timeout set to 1000 by default" in {
    val config = SmtpConfig("host", 25)
    config.timeout shouldBe 1000
  }
}
