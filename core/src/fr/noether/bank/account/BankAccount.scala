package fr.noether.bank.account

import fr.noether.bank.account.operation.{BankOperation, Deposit, OperationDate, Withdrawal}
import fr.noether.bank.account.reporting.{BankHistoric, BankReport}

case class BankAccount(initialBalance: Amount, historic: BankHistoric) {
  def withdraw(amount: Amount, date: OperationDate): BankAccount = applyOperation(Withdrawal(amount, date))

  def deposit(amount: Amount, date: OperationDate): BankAccount = applyOperation(Deposit(amount, date))

  def applyOperation(operation: BankOperation): BankAccount =
    new BankAccount(initialBalance, historic.append(operation))

  def total(): Amount = historic.totalAmount(initialBalance)

  def report(): BankReport = historic.toBankReport(initialBalance)

  def historicIsEmpty: Boolean = historic.isEmpty
}

object BankAccount {
  def startsWith(amount: Amount): BankAccount = BankAccount(amount, BankHistoric.empty())
  def freshAccount() = new BankAccount(Amount.ZERO, BankHistoric.empty())
}

