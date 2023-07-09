package com.novasoftworks.sendbox.models

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import scala.util.{Try, Success, Failure}

class EmailSpec extends AnyFlatSpec with Matchers {

  "Creating email" should "succeed when  given all and valid arguments" in {
    val email = Email(
      from = "sender@example.com",
      to = "recipient@example.com",
      subject = "Hello",
      body = "This is the body of the email",
      cc = Some("cc@example.com"),
      cci = Some("cci@example.com")
    )

    email.from shouldEqual "sender@example.com"
    email.to shouldEqual "recipient@example.com"
    email.subject shouldEqual "Hello"
    email.body shouldEqual "This is the body of the email"
    email.cc shouldBe Some("cc@example.com")
    email.cci shouldBe Some("cci@example.com")
  }

  it should "throw IllegalArgumentException when 'from' is empty" in {
    assertThrows[IllegalArgumentException] {
      Email(from = "", to = "recipient@example.com", subject = "Hello", body = "This is the body of the email")
    }
  }

  it should "throw IllegalArgumentException when 'to' is empty" in {
    assertThrows[IllegalArgumentException] {
      Email(from = "sender@example.com", to = "", subject = "Hello", body = "This is the body of the email")
    }
  }

  it should "throw IllegalArgumentException when 'subject' is empty" in {
    assertThrows[IllegalArgumentException] {
      Email(from = "sender@example.com", to = "recipient@example.com", subject = "", body = "This is the body of the email")
    }
  }

  it should "throw IllegalArgumentException when 'body' is empty" in {
    assertThrows[IllegalArgumentException] {
      Email(from = "sender@example.com", to = "recipient@example.com", subject = "Hello", body = "")
    }
  }
}
