package fr.noether.bank.account.operation

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

case class OperationDate(time: LocalDateTime)

object OperationDate {
  def now(): OperationDate = new OperationDate(LocalDateTime.now())

  def from(dateStr: String) =
    new OperationDate(LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd H:m:s")))
}

