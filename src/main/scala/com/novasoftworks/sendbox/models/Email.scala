package com.novasoftworks.sendbox.models

/** Represents an email message.
  *
  * @param from
  *   The email address of the sender.
  * @param to
  *   The email addresses of the recipients (comma-separated).
  * @param subject
  *   The subject of the email.
  * @param body
  *   The body content of the email.
  * @param cc
  *   The email addresses to be included in the "cc" (carbon copy) field (comma-separated,
  *   optional).
  * @param bcc
  *   The email addresses to be included in the "bcc" (blind carbon copy) field (comma-separated,
  *   optional).
  */
final case class Email(
    from: String,
    to: String,
    subject: String,
    body: String,
    cc: Option[String] = None,
    bcc: Option[String] = None
) {
  require(from.nonEmpty, "Sender email address must not be empty.")
  require(to.nonEmpty, "Recipient email address must not be empty.")
  require(subject.nonEmpty, "Email subject must not be empty.")
  require(body.nonEmpty, "Email body must not be empty.")
}
