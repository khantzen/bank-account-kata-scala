package fr.noether.bank.account

case class BankAccount(startAmount: Amount)

object BankAccount {
  def startsWith(amount: Amount): BankAccount = BankAccount(amount)
  def freshAccount() = new BankAccount(Amount.ZERO)
}

