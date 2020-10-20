package fr.noether.bank.account

case class BankAccount(balance: Amount, historic: BankHistoric) {
  def withdraw(amount: Amount): BankAccount = applyOperation(Withdrawal(amount))

  def deposit(amount: Amount): BankAccount = applyOperation(Deposit(amount))

  def applyOperation(operation: BankOperation): BankAccount =
    new BankAccount(balance, historic.append(operation))

  def historicIsEmpty: Boolean = historic.isEmpty

  def total(): Amount = historic.totalAmount(balance)
}

object BankAccount {
  def startsWith(amount: Amount): BankAccount = BankAccount(amount, BankHistoric.empty())
  def freshAccount() = new BankAccount(Amount.ZERO, BankHistoric.empty())
}

