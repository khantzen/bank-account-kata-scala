package fr.noether.bank.account

class Amount(value: BigDecimal)

object Amount {
  def of(value: BigDecimal) = new Amount(new BigDecimal(java.math.BigDecimal.ZERO))

  val ZERO = Amount.of(0)

}
