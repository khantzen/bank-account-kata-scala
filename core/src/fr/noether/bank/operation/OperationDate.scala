package fr.noether.bank.operation

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

case class OperationDate(time: LocalDateTime) {
  override def toString: String =
    time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd H:m:s"))
}

object OperationDate {
  def now(): OperationDate = new OperationDate(LocalDateTime.now())

  def from(dateStr: String) =
    new OperationDate(LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd H:m:s")))
}

