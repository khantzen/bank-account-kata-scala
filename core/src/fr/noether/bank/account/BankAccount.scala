package fr.noether.bank.account

case class BankAccount(balance: Amount) {
  def deposit(amount: Amount): BankAccount = new BankAccount(balance.add(amount))
  def total(): Amount = balance
}

object BankAccount {
  def startsWith(amount: Amount): BankAccount = BankAccount(amount)
  def freshAccount() = new BankAccount(Amount.ZERO)
}

