package fr.noether.bank.account

import org.scalatest.GivenWhenThen
import org.scalatest.funspec.AnyFunSpec

class BankAccountDeposit
  extends AnyFunSpec
    with GivenWhenThen {

  describe("Bank account should accept deposit") {
    it("Bank account with a balance of 1251.27 receiving a deposit of 232.14 should have a balance of 1483.40") {
      Given("A bank account starting at 1251.27")
      var bankAccount = BankAccount.startsWith(Amount.of(1251.27))
      When("A deposit of 232.14 is made")
      bankAccount = bankAccount.deposit(Amount.of(232.14))
      Then("Account balance should be at 1483.40")
      assert(bankAccount.total() == Amount.of(1483.40))
    }
  }
}
