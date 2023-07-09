package com.novasoftworks.sendbox.smtp

import jakarta.mail.Transport
import jakarta.mail.internet.MimeMessage

class SmtpTransport {
  def send(message: MimeMessage): Unit = Transport.send(message)
}

object SmtpTransport {
  def apply(): SmtpTransport = new SmtpTransport()
}
