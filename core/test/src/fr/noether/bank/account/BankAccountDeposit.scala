package fr.noether.bank.account

import fr.noether.bank.account.operation.{Deposit, OperationDate}
import org.scalatest.GivenWhenThen
import org.scalatest.funspec.AnyFunSpec

class BankAccountDeposit
  extends AnyFunSpec
    with GivenWhenThen {

  describe("Bank account should accept deposit") {
    it("Bank account with a balance of 1251.27 receiving a deposit of 232.14 should end with a balance of 1483.40") {
      Given("A bank account starting at 1251.27")
      var bankAccount = BankAccount.startsWith(Amount.of(1251.27))
      When("A deposit of 232.14 is made")
      bankAccount = bankAccount.deposit(Amount.of(232.14), OperationDate.now())
      Then("Account balance should be at 1483.40")
      assert(bankAccount.total() == Amount.of(1483.41))
    }

    it("Bank account with a balance of 7586.21 receiving a deposit of 120.21 should end with a balance of 7706.42") {
      Given("A bank account of 7586.21")
      var bankAccount = BankAccount.startsWith(Amount.of(7586.21))
      When("A deposit of 120.21 is made")
      bankAccount = bankAccount.deposit(Amount.of(120.21), OperationDate.now())
      Then("Account balance should be at 7706.42")
      assert(bankAccount.total() == Amount.of(7706.42))
    }
  }

  describe("Deposits should be registered in the account historic") {
    it("Freshly created Bank account should not be empty after receiving a deposit") {
      Given("A freshly created bank account")
      var bankAccount = BankAccount.startsWith(Amount.of(100))
      When("A deposit of 100 is made")
      bankAccount = bankAccount.deposit(Amount.of(100), OperationDate.now())
      Then("Historic should not be empty")
      assert(!bankAccount.historicIsEmpty)
    }

    it("Bank account should contains a deposit having been made in its historic") {
      Given("A bank account")
      var bankAccount = BankAccount.freshAccount()
      When("A deposit of 100 is made")
      bankAccount = bankAccount.deposit(Amount.of(100), OperationDate.from("2020-12-02 14:55:23"))
      Then("Historic should contains this operation")
      assert(bankAccount.historic.contains(Deposit(Amount.of(100), OperationDate.from("2020-12-02 14:55:23"))))
    }

    it("When multiple deposit are made they should appears in the bank account historic") {
      Given("A bank account")
      var bankAccount = BankAccount.freshAccount()
      When("Three deposit of 100, 150, 200 are made")
      bankAccount = bankAccount.deposit(Amount.of(100), OperationDate.from("2019-07-21 14:32:45"))
      bankAccount = bankAccount.deposit(Amount.of(150), OperationDate.from("2019-07-25 14:33:45"))
      bankAccount = bankAccount.deposit(Amount.of(200), OperationDate.from("2019-07-27 14:37:45"))
      Then("Historic should contains this operation")
      assert(bankAccount.historic.contains(operation.Deposit(Amount.of(100), OperationDate.from("2019-07-21 14:32:45"))))
      assert(bankAccount.historic.contains(operation.Deposit(Amount.of(150), OperationDate.from("2019-07-25 14:33:45"))))
      assert(bankAccount.historic.contains(operation.Deposit(Amount.of(200), OperationDate.from("2019-07-27 14:37:45"))))
    }
  }

}
