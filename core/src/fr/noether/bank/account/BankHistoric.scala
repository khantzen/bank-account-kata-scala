package fr.noether.bank.account

case class BankHistoric(operations: Seq[BankOperation]) {
  def append(operation: BankOperation): BankHistoric = new BankHistoric(operations ++ Seq(operation))

  def totalAmount(initialBalance: Amount): Amount = operations
    .foldLeft(initialBalance)((acc, operation) => operation.apply(acc))

  def toBankReport(initialBalance: Amount): BankReport = operations
    .sortBy(_.operationDate.time)
    .foldLeft(BankReport.withInitialAmount(initialBalance))(
      (acc, operations) => acc.append(
        ReportEntry(
          operations.operationType,
          operations.operationDate,
          operations.amount,
          operations.apply(acc.lastAmount())
        )))

  def isEmpty: Boolean = operations.isEmpty
  def contains(deposit: BankOperation): Boolean = operations.contains(deposit)
}

object BankHistoric {
  def empty(): BankHistoric = new BankHistoric(Seq())
}
