package fr.noether.bank.account

case class BankAccount(amount: Amount)

object BankAccount {
  def freshAccount() = new BankAccount(Amount.ZERO)

}

