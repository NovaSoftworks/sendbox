package com.novasoftworks.sendbox.smtp

import com.novasoftworks.sendbox.Sendbox
import com.novasoftworks.sendbox.models.Email

import jakarta.mail._
import jakarta.mail.internet.{InternetAddress, MimeMessage}
import java.util.Properties

import scala.util.{Try, Success, Failure}

/** Implementation of the Sendbox trait that uses SMTP protocol for sending emails.
  *
  * @param smtpTransport
  *   The SMTP transport for sending the MimeMessage.
  * @param smtpConfig
  *   The SMTP configuration for establishing the connection.
  */
class SmtpSendbox(val smtpTransport: SmtpTransport, val smtpConfig: SmtpConfig) extends Sendbox {
  private val session: Session = createSession()

  /** Sends an email using the SMTP protocol.
    *
    * @param email
    *   The email to be sent.
    * @return
    *   A `Try` indicating the success or failure of the send operation.
    */
  override def send(email: Email): Try[Unit] = Try {
    val message = new MimeMessage(session)
    message.setFrom(new InternetAddress(email.from))
    message.addRecipient(Message.RecipientType.TO, new InternetAddress(email.to))

    message.setSubject(email.subject)
    message.setText(email.body)

    message.addHeader("Content-Type", "text/HTML")

    smtpTransport.send(message)
  }

  /** Creates an SMTP session based on the SMTP configuration.
    *
    * @return
    *   The created SMTP session.
    */
  private def createSession(): Session = {
    val props = new Properties()
    props.put("mail.smtp.host", smtpConfig.host)
    props.put("mail.smtp.port", smtpConfig.port.toString)
    props.put("mail.smtp.timeout", smtpConfig.timeout.toString)

    if (smtpConfig.requireAuth) {
      props.put("mail.smtp.auth", "true")

      Session.getInstance(
        props,
        new Authenticator {
          override def getPasswordAuthentication: PasswordAuthentication = {
            new PasswordAuthentication(
              smtpConfig.username.getOrElse(""),
              smtpConfig.password.getOrElse("")
            )
          }
        }
      )
    } else { Session.getInstance(props) }
  }
}

object SmtpSendbox {

  /** Creates a new instance of `SmtpSendbox` with the specified SMTP configuration.
    *
    * @param smtpConfig
    *   The SMTP configuration.
    * @return
    *   A new instance of `SmtpSendbox`.
    */
  def apply(smtpTransport: SmtpTransport, smtpConfig: SmtpConfig): SmtpSendbox = {
    new SmtpSendbox(smtpTransport, smtpConfig)
  }
}
