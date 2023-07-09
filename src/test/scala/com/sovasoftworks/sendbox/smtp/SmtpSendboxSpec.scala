package com.novasoftworks.sendbox.smtp

import com.novasoftworks.sendbox.models.Email

import jakarta.mail._
import org.scalamock.scalatest.MockFactory
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import scala.util.{Success, Failure}

class SmtpSendboxSpec extends AnyFlatSpec with Matchers with MockFactory {
  "SmtpSendbox" should "send an email successfully" in {
    val mockSmtpTransport = mock[SmtpTransport]
    val smtpConfig        = SmtpConfig("smtp.host", 587, Some("username"), Some("password"))
    val smtpSendbox       = SmtpSendbox(mockSmtpTransport, smtpConfig)
    val email             = Email("sender@example.com", "recipient@example.com", "Subject", "Body")

    (mockSmtpTransport.send _).expects(*).once()

    smtpSendbox.send(email) shouldBe Success(())
  }

  it should "return a Failure when send fails" in {
    val mockSmtpTransport = mock[SmtpTransport]
    val smtpConfig        = SmtpConfig("smtp.host", 587, Some("username"), Some("password"))
    val smtpSendbox       = SmtpSendbox(mockSmtpTransport, smtpConfig)
    val email             = Email("sender@example.com", "recipient@example.com", "Subject", "Body")

    (mockSmtpTransport.send _).expects(*).throwing(new RuntimeException("Failed to send email"))

    smtpSendbox.send(email) shouldBe a[Failure[_]]
  }

  it should "create a session with authentication when required" in {
    val smtpConfig =
      SmtpConfig("smtp.host", 587, Some("username"), Some("password"), timeout = 2000)
    val smtpSendbox = SmtpSendbox(new SmtpTransport, smtpConfig)

    val session = invokePrivateMethod(smtpSendbox, "createSession").asInstanceOf[Session]
    val props   = session.getProperties

    props.getProperty("mail.smtp.auth") shouldBe "true"
    props.getProperty("mail.smtp.timeout") shouldBe "2000"
  }

  it should "create a session without authentication when not required" in {
    val smtpConfig  = SmtpConfig("smtp.host", 587, timeout = 2000)
    val smtpSendbox = SmtpSendbox(new SmtpTransport, smtpConfig)

    val session = invokePrivateMethod(smtpSendbox, "createSession").asInstanceOf[Session]
    val props   = session.getProperties

    props.getProperty("mail.smtp.auth", "false") shouldBe "false"
    props.getProperty("mail.smtp.timeout") shouldBe "2000"
  }

  private def invokePrivateMethod(obj: AnyRef, methodName: String, args: AnyRef*): Any = {
    val method = obj.getClass.getDeclaredMethod(methodName, args.map(_.getClass): _*)
    method.setAccessible(true)
    method.invoke(obj, args: _*)
  }
}
