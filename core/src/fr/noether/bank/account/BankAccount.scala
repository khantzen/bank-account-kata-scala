package fr.noether.bank.account

case class BankAccount(balance: Amount) {
  def total(): Amount = balance
}

object BankAccount {
  def startsWith(amount: Amount): BankAccount = BankAccount(amount)
  def freshAccount() = new BankAccount(Amount.ZERO)
}

