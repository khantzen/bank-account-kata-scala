package fr.noether.bank.account

case class BankAccount(balance: Amount) {
  def withdraw(amount: Amount): BankAccount = applyOperation(Withdrawal(amount))

  def deposit(amount: Amount): BankAccount = applyOperation(Deposit(amount))

  def applyOperation(operation: BankOperation): BankAccount =
    new BankAccount(operation.apply(balance))



  def total(): Amount = balance
}

object BankAccount {
  def startsWith(amount: Amount): BankAccount = BankAccount(amount)
  def freshAccount() = new BankAccount(Amount.ZERO)
}

