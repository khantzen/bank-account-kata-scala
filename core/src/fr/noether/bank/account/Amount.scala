package fr.noether.bank.account

case class Amount(value: BigDecimal)

object Amount {
  val ZERO: Amount = Amount.of(0)
  def of(value: Double) = new Amount(BigDecimal.valueOf(value))
}
