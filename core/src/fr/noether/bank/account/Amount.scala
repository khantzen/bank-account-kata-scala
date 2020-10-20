package fr.noether.bank.account

case class Amount(value: BigDecimal)

object Amount {
  def of(value: Double) = new Amount(BigDecimal.valueOf(value))

  val ZERO = Amount.of(0)

}
