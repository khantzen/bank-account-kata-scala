package fr.noether.bank

import fr.noether.bank.account.{Amount, BankAccount}
import fr.noether.bank.operation.OperationDate

object Demo {

  def main(args: Array[String]): Unit = {
    val bankAccount = BankAccount.startsWith(Amount.of(2000))
      .deposit(Amount.of(3000), OperationDate.now())
      .withdraw(Amount.of(3500), OperationDate.from("2015-03-14 14:30:25"))
      .deposit(Amount.of(750), OperationDate.from("2020-12-13 14:35:25"))
      .deposit(Amount.of(7000.32), OperationDate.now())


    val bankReport = bankAccount.report()
    println(bankReport)
  }

}
