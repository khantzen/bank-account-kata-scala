package fr.noether.bank.account

sealed trait BankOperation {
  val apply: Amount => Amount
}

case class Deposit(amount: Amount) extends BankOperation {
  override val apply: Amount => Amount = x => x.add(amount)
}

case class Withdrawal(amount: Amount, operationDate: OperationDate) extends BankOperation {
  override val apply: Amount => Amount = x => x.remove(amount)
}