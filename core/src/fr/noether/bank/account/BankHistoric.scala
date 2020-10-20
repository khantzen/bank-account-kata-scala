package fr.noether.bank.account

case class BankHistoric(operations: Seq[BankOperation]) {
  def append(operation: BankOperation): BankHistoric = new BankHistoric(operations ++ Seq(operation))

  def totalAmount(initialBalance: Amount): Amount = operations
    .foldLeft(initialBalance)( (acc, operation) => operation.apply(acc))

  def isEmpty: Boolean = operations.isEmpty
  def contains(deposit: BankOperation): Boolean = operations.contains(deposit)
}

object BankHistoric {
  def empty(): BankHistoric = new BankHistoric(Seq())
}
