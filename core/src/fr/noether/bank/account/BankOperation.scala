package fr.noether.bank.account

import fr.noether.bank.account.OperationType.OperationType

sealed trait BankOperation {
  val apply: Amount => Amount
  val operationType: OperationType
  val operationDate: OperationDate
  val amount: Amount
}

case class Deposit(amount: Amount, operationDate: OperationDate) extends BankOperation {
  override val apply: Amount => Amount = x => x.add(amount)
  override val operationType: OperationType = OperationType.DEPOSIT
}

case class Withdrawal(amount: Amount, operationDate: OperationDate) extends BankOperation {
  override val apply: Amount => Amount = x => x.remove(amount)
  override val operationType: OperationType = OperationType.WITHDRAWAL
}