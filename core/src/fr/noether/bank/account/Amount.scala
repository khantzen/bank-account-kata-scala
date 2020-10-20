package fr.noether.bank.account

import scala.math.BigDecimal.RoundingMode


case class Amount(value: BigDecimal) {
  def add(amount: Amount): Amount = Amount(amount.value.+(value))

}

object Amount {
  val ZERO: Amount = Amount.of(0)
  def of(value: Double) = new Amount(BigDecimal.valueOf(value))
}
