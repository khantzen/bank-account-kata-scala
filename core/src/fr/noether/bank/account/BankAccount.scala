package fr.noether.bank.account

case class BankAccount(amount: Amount)

object BankAccount {
  def startsWith(amount: Amount): BankAccount = BankAccount(amount)
  def freshAccount() = new BankAccount(Amount.ZERO)
}

