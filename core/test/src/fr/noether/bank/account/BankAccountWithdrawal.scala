package fr.noether.bank.account

import org.scalatest.GivenWhenThen
import org.scalatest.funspec.AnyFunSpec

class BankAccountWithdrawal
  extends AnyFunSpec
    with GivenWhenThen {

  describe("Bank account should accept withdrawal") {
    it ("Bank account with a balance of 1251.27 receiving a withdraw of 232.14 should end with a balance of 1019.13") {
      Given("A bank account starting at 1251.27")
      var bankAccount = BankAccount.startsWith(Amount.of(1251.27))
      When("A withdraw of 232.14 is made")
      bankAccount = bankAccount.withdraw(Amount.of(232.14))
      Then("Account balance should be at 1019.13")
      assert(bankAccount.total() == Amount.of(1019.13))
    }

    it ("Bank account with a balance of 2014.25 receiving a withdraw of 25.26 should end with a balance of 1988.99") {
      Given("A bank account starting at 2014.25")
      var bankAccount = BankAccount.startsWith(Amount.of(2014.25))
      When("A withdraw of 25.26 is made")
      bankAccount = bankAccount.withdraw(Amount.of(25.26))
      Then("Account balance should be at 1019.13")
      assert(bankAccount.total() == Amount.of(1988.99))
    }
  }

  describe("Withdrawals should be registered in the account historic") {
    it("Freshly created Bank account should not be empty after receiving a withdrawal") {
      Given("A freshly created bank account")
      var bankAccount = BankAccount.startsWith(Amount.of(100))
      When("A deposit of 100 is made")
      bankAccount = bankAccount.withdraw(Amount.of(100))
      Then("Historic should not be empty")
      assert(!bankAccount.historicIsEmpty)
    }

    it("Bank account should contains a withdraw having been made in its historic") {
      Given("A bank account")
      var bankAccount = BankAccount.freshAccount()
      When("A deposit of 100 is made")
      bankAccount = bankAccount.withdraw(Amount.of(100))
      Then("Historic should contains this operation")
      assert(bankAccount.historic.contains(Withdrawal(Amount.of(100))))
    }

    it("When multiple deposit are made they should appears in the bank account historic") {
      Given("A bank account")
      var bankAccount = BankAccount.freshAccount()
      When("Three withdraws of 100, 150, 200 are made")
      bankAccount = bankAccount.withdraw(Amount.of(100))
      bankAccount = bankAccount.withdraw(Amount.of(150))
      bankAccount = bankAccount.withdraw(Amount.of(200))
      Then("Historic should contains these operation")
      assert(bankAccount.historic.contains(Withdrawal(Amount.of(100))))
      assert(bankAccount.historic.contains(Withdrawal(Amount.of(150))))
      assert(bankAccount.historic.contains(Withdrawal(Amount.of(200))))
    }
  }
}
