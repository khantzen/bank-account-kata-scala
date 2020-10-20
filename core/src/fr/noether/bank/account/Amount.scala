package fr.noether.bank.account

case class Amount(value: BigDecimal) {
  def remove(amount: Amount): Amount = Amount(value.-(amount.value))
  def add(amount: Amount): Amount = Amount(amount.value.+(value))

}

object Amount {
  val ZERO: Amount = Amount.of(0)
  def of(value: Double) = new Amount(BigDecimal.valueOf(value))
}
