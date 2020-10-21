package fr.noether.bank.account

case class BankAccount(balance: Amount, historic: BankHistoric) {
  def report(): BankReport = BankReport.empty()
    .append(ReportEntry(OperationType.DEPOSIT, OperationDate.from("2020-10-14 22:32:34"), Amount.of(150), Amount.of(250)))
    .append(ReportEntry(OperationType.DEPOSIT, OperationDate.from("2020-10-22 23:33:35"), Amount.of(250), Amount.of(500)))

  def withdraw(amount: Amount, date: OperationDate): BankAccount = applyOperation(Withdrawal(amount, date))

  def deposit(amount: Amount, date: OperationDate): BankAccount = applyOperation(Deposit(amount, date))

  def applyOperation(operation: BankOperation): BankAccount =
    new BankAccount(balance, historic.append(operation))

  def historicIsEmpty: Boolean = historic.isEmpty

  def total(): Amount = historic.totalAmount(balance)
}

object BankAccount {
  def startsWith(amount: Amount): BankAccount = BankAccount(amount, BankHistoric.empty())
  def freshAccount() = new BankAccount(Amount.ZERO, BankHistoric.empty())
}

