package fr.noether.bank.account

import org.scalatest.GivenWhenThen
import org.scalatest.funspec.AnyFunSpec

class AccountInitialization extends AnyFunSpec with GivenWhenThen {

  describe("An account should start with an initiated amount") {
    it("Account with 0 should start at 0") {
      Given("A fresh Account")
        val bankAccount = BankAccount.freshAccount()
      Then("This account amount should be 0")
        assert(bankAccount.amount == Amount.ZERO)
    }
  }

}
