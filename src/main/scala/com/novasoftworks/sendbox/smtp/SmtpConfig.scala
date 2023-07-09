package com.novasoftworks.sendbox.smtp

/** Configuration for SMTP server connection.
  *
  * @param host
  *   The SMTP server host.
  * @param port
  *   The SMTP server port.
  * @param username
  *   The username for SMTP authentication (optional).
  * @param password
  *   The password for SMTP authentication (optional).
  * @param timeout
  *   The timeout for SMTP server connection in milliseconds (optional, default: 1000).
  */
final case class SmtpConfig(
    host: String,
    port: Int,
    username: Option[String] = None,
    password: Option[String] = None,
    timeout: Int = 1000
) {

  require(host.nonEmpty, "SMTP host must not be empty.")
  require(port > 0, "SMTP host port must not be negative.")
  require(timeout > 0, "Timeout must not be negative.")
  require(username.isDefined || password.isEmpty, "Password must not be defined without username.")

  def requireAuth: Boolean = username.isDefined
}
