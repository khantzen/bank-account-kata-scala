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
}
