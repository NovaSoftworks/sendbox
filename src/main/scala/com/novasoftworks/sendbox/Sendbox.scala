package com.novasoftworks.sendbox

import com.novasoftworks.sendbox.models.Email
import com.novasoftworks.sendbox.smtp._

import scala.util.Try

/** A trait representing a sendbox for sending emails. */
trait Sendbox {

  /** Sends an email.
    *
    * @param email
    *   The email to send.
    * @return
    *   A `Try` indicating whether the email sending was successful or resulted in a failure.
    */
  def send(email: Email): Try[Unit]
}

/** A factory object for creating instances of `Sendbox`. */
object Sendbox {

  /** Creates a `Sendbox` instance with the provided SMTP configuration.
    *
    * @param config
    *   The SMTP configuration.
    * @return
    *   A new `Sendbox` instance.
    */
  def apply(config: SmtpConfig): Sendbox = SmtpSendbox(SmtpTransport(), config)
}
